package CapaPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import CapaLogica.Gestor;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegistrarVeterinario {

	private JFrame frmRegistrarVeterinario;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private JTextField txtEspecialidad;
	private JTextField txtTelefono;
	Gestor gestor;

	

	/**
	 * Create the application.
	 */
	public PantallaRegistrarVeterinario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarVeterinario = new JFrame();
		frmRegistrarVeterinario.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmRegistrarVeterinario.setBackground(Color.WHITE);
		frmRegistrarVeterinario.setTitle("Registrar Veterinario");
		frmRegistrarVeterinario.setBounds(100, 100, 450, 300);
		frmRegistrarVeterinario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarVeterinario.getContentPane().setLayout(null);
		frmRegistrarVeterinario.setVisible(true);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(10, 22, 96, 14);
		frmRegistrarVeterinario.getContentPane().add(lblIdentificacion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 53, 96, 14);
		frmRegistrarVeterinario.getContentPane().add(lblNombre);
		
		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(10, 84, 85, 14);
		frmRegistrarVeterinario.getContentPane().add(lblEspecialidad);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 122, 85, 14);
		frmRegistrarVeterinario.getContentPane().add(lblTelefono);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(102, 19, 210, 20);
		frmRegistrarVeterinario.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(102, 50, 210, 20);
		frmRegistrarVeterinario.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEspecialidad = new JTextField();
		txtEspecialidad.setBounds(102, 81, 210, 20);
		frmRegistrarVeterinario.getContentPane().add(txtEspecialidad);
		txtEspecialidad.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(102, 119, 213, 20);
		frmRegistrarVeterinario.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor= new Gestor();
				String identificacion, nombre, especialidad,telefono;
				
				try{
					identificacion = txtIdentificacion.getText();
					nombre = txtNombre.getText();
					especialidad = txtEspecialidad.getText();
					telefono = txtTelefono.getText();
					gestor.RegistrarVeterinario(identificacion, nombre, especialidad, telefono);
					JOptionPane.showMessageDialog(null,"El veterinario ha sido registrado", "Informacion",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnRegistrar.setBounds(102, 193, 89, 23);
		frmRegistrarVeterinario.getContentPane().add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrarVeterinario.setVisible(false);
			}
		});
		btnVolver.setBounds(220, 193, 89, 23);
		frmRegistrarVeterinario.getContentPane().add(btnVolver);
	}
}
