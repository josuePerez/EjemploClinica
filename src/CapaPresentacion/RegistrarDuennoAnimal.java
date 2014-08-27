package CapaPresentacion;


import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import CapaLogica.Gestor;

public class RegistrarDuennoAnimal {

	private JFrame frmRegistrarDueoDel;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
    Gestor gestor;
	/**
	 * Create the application.
	 */
	public RegistrarDuennoAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarDueoDel = new JFrame();
		frmRegistrarDueoDel.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmRegistrarDueoDel.getContentPane().setLayout(null);
		
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frmRegistrarDueoDel.getContentPane().add(label);
		
		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n");
		lblIdentificacion.setBounds(24, 31, 86, 14);
		frmRegistrarDueoDel.getContentPane().add(lblIdentificacion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(24, 68, 65, 14);
		frmRegistrarDueoDel.getContentPane().add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(24, 109, 65, 14);
		frmRegistrarDueoDel.getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 142, 65, 14);
		frmRegistrarDueoDel.getContentPane().add(lblTelefono);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(134, 28, 190, 20);
		frmRegistrarDueoDel.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(134, 65, 190, 20);
		frmRegistrarDueoDel.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(134, 106, 190, 20);
		frmRegistrarDueoDel.getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(134, 139, 190, 20);
		frmRegistrarDueoDel.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor=new Gestor();
				String identificacion,nombre,direccion,telefono;
				
				try{
					identificacion = txtIdentificacion.getText();
					nombre = txtNombre.getText();
					direccion = txtDireccion.getText();
					telefono = txtTelefono.getText();
					gestor.RegistrarDuenno(identificacion, nombre, direccion, telefono);
					JOptionPane.showMessageDialog(null,"El duenno ha sido registrado","Informacion",JOptionPane.INFORMATION_MESSAGE);	
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
		btnRegistrar.setBounds(97, 191, 89, 23);
		frmRegistrarDueoDel.getContentPane().add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrarDueoDel.setVisible(false);
			}
		});
		btnVolver.setBounds(219, 191, 89, 23);
		frmRegistrarDueoDel.getContentPane().add(btnVolver);
		frmRegistrarDueoDel.setTitle("Registrar Due\u00F1o del Animal");
		frmRegistrarDueoDel.setBounds(100, 100, 450, 300);
		frmRegistrarDueoDel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarDueoDel.setVisible(true);
		
		
		
	}
	
	
	
	
}
