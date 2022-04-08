import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Interfaz1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 54167449215537863L;
	
	private JLabel eti1, eti2, eti3;
	private JTextField txtUsuario; 
	private JPasswordField txtContra;
	private JButton boton1, boton2;
	private JPanel panel;
	
	Interfaz1(){
		setBackground(new Color(192, 192, 192));
		setTitle("Gestror de Registros");
		
		eti1= new JLabel("Login");
		eti1.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		eti1.setBounds(40, 30, 200, 20);
		
		eti2= new JLabel("Usuario ");
		eti2.setBounds(40, 80, 120, 20);
		
		eti3= new JLabel("Contraña ");
		eti3.setBounds(40, 120, 120, 20);
		
		txtUsuario = new JTextField ();
		txtUsuario.setBounds(100, 80, 120, 20);
		
		txtContra = new JPasswordField ();
		txtContra.setBounds(100, 120, 120, 20);
		
		boton1 = new JButton ("Login");
		boton1.addActionListener(this);
		boton1.setBounds(160, 180, 80, 20);
		
		boton2 = new JButton ("Registrarse");
		boton2.addActionListener(this);
		boton2.setBounds(250, 180, 110, 20);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setLayout(null);
		
		panel.add(eti1);
		panel.add(eti2);
		panel.add(eti3);
		panel.add(txtUsuario);
		panel.add(txtContra);
		panel.add(boton1);
		panel.add(boton2);
		
		getContentPane().add(panel);
		setSize(400, 300);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz1 inter = new Interfaz1();
					inter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (boton1 == e.getSource()) {
			boolean v = true;
			String user = txtUsuario.getText();
			String contra = txtContra.getText();
			
			v = eventos.login(user, contra);
			if (v == true) {
				Tabla inter = new Tabla();
				inter.setVisible(true);
				this.dispose();
			}
		}
		
		if (boton2 == e.getSource()) {
			Registro1 reg = new Registro1();
			reg.setVisible(true);
			this.dispose();
		}
		
	}
}
