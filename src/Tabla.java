import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class Tabla extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5760001288256613295L;
	private JTextField txtUsuario;
	private JTable table;
	private JScrollPane scrollPane;
	static DefaultTableModel model;
	Object[] columnas = {"Usuario", "Nombre", "Apellido", "Num. Telefono", "Correo", "Contraseña"};
	private JLabel lb2, lb3, lb4, lb5, lb6;
	private JTextField txtNombre, txtApellido, txtNumTel, txtCorreo, txtContra;
	private JButton btn1, btn2, btn3, btn4, btn5;
	private JButton btn6;
	
	Tabla(){
		setTitle("Gestor de Registros");
		getContentPane().setBackground(Color.BLUE);
		
		JLabel lb1 = new JLabel("Usuario");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setBounds(10, 11, 93, 35);
		getContentPane().add(lb1);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setBounds(80, 19, 162, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 653, 402);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnas);
		table.setModel(model);
		model = eventos.getAll(model);
		scrollPane.setViewportView(table);
		
		lb2 = new JLabel("Nombre");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setBounds(10, 37, 93, 35);
		getContentPane().add(lb2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(80, 46, 162, 20);
		getContentPane().add(txtNombre);
		
		lb3 = new JLabel("Apellido");
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb3.setBounds(10, 67, 93, 35);
		getContentPane().add(lb3);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(80, 76, 162, 20);
		getContentPane().add(txtApellido);
		setSize(714, 600);
		
		getContentPane().setLayout(null);
		
		lb4 = new JLabel("Num. Tel.");
		lb4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb4.setBounds(283, 11, 93, 35);
		getContentPane().add(lb4);
		
		txtNumTel = new JTextField();
		txtNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNumTel.setColumns(10);
		txtNumTel.setBounds(353, 19, 217, 20);
		getContentPane().add(txtNumTel);
		
		lb5 = new JLabel("Correo");
		lb5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb5.setBounds(283, 37, 93, 35);
		getContentPane().add(lb5);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(353, 46, 217, 20);
		getContentPane().add(txtCorreo);
		
		lb6 = new JLabel("Contra\u00F1a");
		lb6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb6.setBounds(283, 67, 93, 35);
		getContentPane().add(lb6);
		
		txtContra = new JTextField();
		txtContra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtContra.setColumns(10);
		txtContra.setBounds(353, 76, 217, 20);
		getContentPane().add(txtContra);
		
		btn1 = new JButton("Agregar");
		btn1.addActionListener(this);
		btn1.setBounds(14, 113, 107, 24);
		getContentPane().add(btn1);
		
		btn2 = new JButton("Editar");
		btn2.addActionListener(this);
		btn2.setBounds(135, 114, 107, 24);
		getContentPane().add(btn2);
		
		btn3 = new JButton("Eliminar");
		btn3.addActionListener(this);
		btn3.setBounds(252, 114, 107, 24);
		getContentPane().add(btn3);
		
		btn4 = new JButton("Buscar");
		btn4.addActionListener(this);
		btn4.setBounds(369, 114, 107, 24);
		getContentPane().add(btn4);
		
		btn5 = new JButton("Cerrar Seccion");
		btn5.addActionListener(this);
		btn5.setBounds(581, 11, 107, 24);
		getContentPane().add(btn5);
		
		btn6 = new JButton("Actualizar");
		btn6.addActionListener(this);
		btn6.setBounds(487, 113, 107, 24);
		getContentPane().add(btn6);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void actionPerformed(ActionEvent e) {
		if (btn1 == e.getSource()) {
			String user = txtUsuario.getText();
			String nomb = eventos.capitalize(txtNombre.getText());
			String ape = eventos.capitalize(txtApellido.getText());
			String tel = txtNumTel.getText();
			String email = txtCorreo.getText();
			String contra = txtContra.getText();
			boolean vef;
			
			vef = eventos.registro(user, nomb, ape, tel, email, contra, contra);
			
			if (vef == true) {
				model = new DefaultTableModel();
				model.setColumnIdentifiers(columnas);
				table.setModel(model);
				model = eventos.getAll(model);
			}
		}
		if (btn2 == e.getSource()) {
			UpdateUser inter = new UpdateUser();
			inter.setVisible(true);
			
			
		}
		if (btn3 == e.getSource()) {
			String user = txtUsuario.getText();
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnas);
			table.setModel(model);
			user = "Usuario = \"" + user + "\" ";
			boolean v = eventos.eliminar(model, user);
			if (v == true) {
				model = eventos.getAll(model);
			}
		}
		if (btn4 == e.getSource()) {
			String user = txtUsuario.getText();
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnas);
			table.setModel(model);
			user = "Usuario = \"" + user + "\" ";
			model = eventos.getWhere(model, user);
		}
		
		if (btn5 == e.getSource()) {
			Interfaz1 inter = new Interfaz1();
			inter.setVisible(true);
			this.dispose();
		}
		
		if (btn6 == e.getSource()) {
			model = new DefaultTableModel();
			model.setColumnIdentifiers(columnas);
			table.setModel(model);
			model = eventos.getAll(model);
		}
	}
}
