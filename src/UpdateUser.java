import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateUser extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3461831707384553999L;
	
	private JTextField txtUserNew;
	private JLabel lb2, lb3, lb4, lb5, lb6;
	private JTextField txtNombre, txtApellido, txtNumTel, txtCorreo, txtContra;
	private JButton btn1, btn2;
	private JTextField txtUsuario;
	private JLabel lb1_1;
	UpdateUser(){
		setTitle("Gestor de Registros");
		getContentPane().setBackground(Color.BLUE);
		
		JLabel lb1 = new JLabel("Usuario");
		lb1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1.setBounds(10, 11, 93, 35);
		getContentPane().add(lb1);
		
		txtUserNew = new JTextField();
		txtUserNew.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUserNew.setBounds(109, 45, 152, 20);
		getContentPane().add(txtUserNew);
		txtUserNew.setColumns(10);
		
		
		lb2 = new JLabel("Nombre");
		lb2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb2.setBounds(10, 68, 93, 35);
		getContentPane().add(lb2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNombre.setColumns(10);
		txtNombre.setBounds(99, 76, 162, 20);
		getContentPane().add(txtNombre);
		
		lb3 = new JLabel("Apellido");
		lb3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb3.setBounds(10, 99, 93, 35);
		getContentPane().add(lb3);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtApellido.setColumns(10);
		txtApellido.setBounds(99, 107, 162, 20);
		getContentPane().add(txtApellido);
		setSize(589, 194);
		
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
		
		btn1 = new JButton("Actualizar");
		btn1.addActionListener(this);
		btn1.setBounds(293, 113, 107, 24);
		getContentPane().add(btn1);
		
		btn2 = new JButton("Cancelar");
		btn2.addActionListener(this);
		btn2.setBounds(444, 113, 107, 24);
		getContentPane().add(btn2);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(99, 19, 162, 20);
		getContentPane().add(txtUsuario);
		
		lb1_1 = new JLabel("Nuevo Usuario");
		lb1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lb1_1.setBounds(10, 37, 119, 35);
		getContentPane().add(lb1_1);
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
			DefaultTableModel model = Tabla.model;
			String userO = txtUsuario.getText();
			String user = txtUserNew.getText();
			String nomb = eventos.capitalize(txtNombre.getText());
			String ape = eventos.capitalize(txtApellido.getText());
			String tel = txtNumTel.getText();
			String email = txtCorreo.getText();
			String contra = txtContra.getText();
			eventos.update(model, userO, user, nomb, ape, tel, email, contra);
			JOptionPane.showMessageDialog(null, "Registro actualizado");
			this.dispose();
			}
		
		if (btn1 == e.getSource()) {
			this.dispose();
		}
	}
}