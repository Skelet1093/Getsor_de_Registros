import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Registro1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2855875191097008688L;
	private JPasswordField txtConfiContra, txtContra;
	private JTextField txtCorreo,txtTelNum, txtApellido, txtNombre,txtUsuario;
	private JButton boton1, btnAtras;

	Registro1(){
		getContentPane().setBackground(Color.BLUE);
		setTitle("Gestor de Registros");
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel Title = new JLabel("Registro");
		Title.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		Title.setBounds(37, 11, 140, 24);
		getContentPane().add(Title);
		
		JLabel lb1 = new JLabel(" Usuario");
		lb1.setBounds(37, 46, 60, 24);
		getContentPane().add(lb1);
		
		JLabel lb2 = new JLabel("Nombre");
		lb2.setBounds(37, 68, 60, 24);
		getContentPane().add(lb2);
		
		JLabel lb3 = new JLabel("Apellido");
		lb3.setBounds(37, 91, 60, 24);
		getContentPane().add(lb3);
		
		JLabel lb4 = new JLabel("Numero de telefono");
		lb4.setBounds(37, 115, 122, 24);
		getContentPane().add(lb4);
		
		JLabel lb5 = new JLabel("Correo Electronico");
		lb5.setBounds(37, 142, 122, 24);
		getContentPane().add(lb5);
		
		JLabel lb6 = new JLabel("Contrase\u00F1a");
		lb6.setBounds(37, 177, 75, 14);
		getContentPane().add(lb6);
		
		JLabel lb7 = new JLabel("Confirmar contrase\u00F1a");
		lb7.setBounds(37, 202, 140, 14);
		getContentPane().add(lb7);
		
		txtConfiContra = new JPasswordField();
		txtConfiContra.setBounds(151, 199, 202, 20);
		getContentPane().add(txtConfiContra);
		txtConfiContra.setColumns(10);
		
		txtContra = new JPasswordField();
		txtContra.setColumns(10);
		txtContra.setBounds(151, 174, 202, 20);
		getContentPane().add(txtContra);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(151, 144, 202, 20);
		getContentPane().add(txtCorreo);
		
		txtTelNum = new JTextField();
		txtTelNum.setColumns(10);
		txtTelNum.setBounds(151, 117, 202, 20);
		getContentPane().add(txtTelNum);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(151, 93, 202, 20);
		getContentPane().add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(151, 70, 202, 20);
		getContentPane().add(txtNombre);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(151, 48, 202, 20);
		getContentPane().add(txtUsuario);
		
		boton1 = new JButton("Registrar");
		boton1.addActionListener(this);
		boton1.setBounds(96, 243, 104, 23);
		getContentPane().add(boton1);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(this);
		btnAtras.setBounds(211, 243, 104, 23);
		getContentPane().add(btnAtras);;
		
		new JPanel();
		setSize(476, 391);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro1 frame = new Registro1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (boton1 == e.getSource()) {
			String user = txtUsuario.getText();
			String nomb = eventos.capitalize(txtNombre.getText());
			String ape = eventos.capitalize(txtApellido.getText());
			String tel = txtTelNum.getText();
			String email = txtCorreo.getText();
			String contra = txtContra.getText();
			String cContra = txtConfiContra.getText();
			boolean vef;
			
			vef = eventos.registro(user, nomb, ape, tel, email, contra, cContra);
			
			if (vef == true) {
				Interfaz1 inter = new Interfaz1();
				inter.setVisible(true);
				this.dispose();
			}
		}
		if (btnAtras == e.getSource()) {
			Interfaz1 inter = new Interfaz1();
			inter.setVisible(true);
			this.dispose();
		}
		
	}
}
