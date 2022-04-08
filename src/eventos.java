import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class eventos {
	static MySQL con = new MySQL();
	static Connection cn = con.conectar();
	static ResultSet rs;
	
	public static boolean maxUser(String str) {
		int numC = str.length();
		
		if (numC > 25 || numC < 7) {
			return false;
		}else {
		return true;
		}
	}
	
	public static boolean maxNom(String str) {
		int numC = str.length();
		if (numC > 20 || numC < 3) {
			return false;
		}else {
		return true;
		}
	}
	
	public static boolean maxTel(String str) {
		int numC = str.length();
		if (numC > 13 || numC < 10) {
			return false;
		}else {
		return true;
		}
	}
	
	public static boolean maxEmail(String str) {
		int numC = str.length();
		if (numC > 40 || numC < 10) {
			return false;
		}else {
		return true;
		}
	}
	
	public static boolean maxContra(String str) {
		int numC = str.length();
		if (numC > 15 || numC < 7) {
			return false;
		}else {
		return true;
		}
	}
	
	public static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
		
	
	public static boolean registro(String user, String nomb, String ape, String tel, String email, String contra, String cContra) {
		boolean verif;
		boolean val = true;
		
		verif = maxUser(user);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario debe contener entre 7 y 25 caracteres.");
			val = false;
		}
		
		verif = maxNom(nomb);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "El nombre debe contener entre 3 y 20 caracteres.");
			val = false;
		}
		
		verif = maxNom(ape);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "El apellido debe contener entre 3 y 20 caracteres.");
			val = false;
		}
		
		verif = maxTel(tel);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "El numero de telefono debe contener entre 10 y 13 caracteres. (No colocar espacios o guiones)");
			val = false;
		}
		
		verif = eventos.maxEmail(email);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "La direccion de correo debe contener entre 10 y 40 caracteres.");
			val = false;
		}
		
		verif = maxContra(contra);
		if (verif == false) {
			JOptionPane.showMessageDialog(null, "La contraseña debe contener entre 7 y 15 caracteres.");
			val = false;
		}
		
		if (!email.contains("@")) {
			JOptionPane.showMessageDialog(null, "Introduzca una direccion de correo valida.");
			verif = false;
		}
		if (user.isEmpty() || nomb.isEmpty() || ape.isEmpty() || tel.isEmpty() || email.isEmpty() || contra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.");
			verif = false;
		}
		if (!contra.equals(cContra)) {
			JOptionPane.showMessageDialog(null, "La contraseña no coincide. Asegurece que ambos campos contengan la misma contraseña.");
			verif = false;
		}
		if (val == false) {
			verif = false;
		}
		else {
			try {
				PreparedStatement st = cn.prepareStatement("INSERT INTO usuarios (Usuario, Nombre, Apellido, Num_Telefono, Correo_Electronico, Contraseña)"
						+ " Values (\"" + user + "\", \"" + nomb + "\", \"" + ape + "\", \"" + tel + "\", \"" + email + "\", \"" + contra + "\")");
				MySQL.insert(st);
				JOptionPane.showMessageDialog(null, "Registro completo.");
				verif = true;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return verif;
	}
	public static boolean login(String user, String contra) {
		boolean verif;
		String[] v = {"", ""};
		try {
			PreparedStatement st = cn.prepareStatement("SELECT Usuario, Contraseña FROM usuarios WHERE Usuario = \"" + user + "\"");
	        try {
	            rs = st.executeQuery();
	            while (rs.next()) {
	                v[1] = rs.getString(1);
	                v[0] = rs.getString(2);
	            }
	        } catch (Exception a) {
	            a.printStackTrace();
	        }
	        
	        if (user.equals(v[1]) && contra.equals(v[0])) {
				verif = true;
	        }
	        else {
	        	verif = false;
	        }
			
		}catch (Exception a) {
			a.printStackTrace();
			verif =  false;
		}
		if (verif == true) {
			JOptionPane.showMessageDialog(null, "Acceso concedido");
			return true;
		} 
		else {
			JOptionPane.showMessageDialog(null, "El usuario o contraseña es incorrecto");
			return false;
		}
	}
	
	public static DefaultTableModel getAll(DefaultTableModel model) {
		try {
			PreparedStatement st = cn.prepareStatement("SELECT * FROM usuarios");
			rs = MySQL.select(st);
			while (rs.next()) {
				 model.addRow (new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public static DefaultTableModel getWhere(DefaultTableModel model, String user) {
		try {
			PreparedStatement st = cn.prepareStatement("SELECT * FROM usuarios WHERE " + user);
			rs = MySQL.select(st);
			while (rs.next()) {
				 model.addRow (new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public static boolean eliminar(DefaultTableModel model, String user) {
		boolean v;
		try {
			PreparedStatement st = cn.prepareStatement("DELETE FROM usuarios WHERE " + user);
			v = MySQL.eliminar(st);
		} catch (SQLException e) {
			e.printStackTrace();
			v=false;
		}
		return v;
	}
	
	public static boolean update(DefaultTableModel model, String user0, String user, String nomb, String ape, String tel, String email, String contra) {
		boolean v = true;
		try {
			PreparedStatement st;
		if (!user.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Usuario = \"" + user + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		} 
		
		if(!contra.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Contraseña = \"" + contra + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		}
		
		if (!email.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Correo_Electronico = \"" + email + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		}
		
		if (!tel.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Num_Telefono = \"" + tel + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		}
		
		if (!nomb.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Nombre = \"" + nomb + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		}
		
		if (!ape.equals("")) {
			st = cn.prepareStatement("UPDATE Usuarios SET Apellido = \"" + ape + "\" WHERE Usuario = \"" + user0 +"\"");
			v = MySQL.update(st);
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
}
