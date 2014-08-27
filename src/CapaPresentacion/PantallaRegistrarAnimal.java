package CapaPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import CapaLogica.Gestor;
import javax.swing.JTextArea;
import java.awt.Color;

public class PantallaRegistrarAnimal {

	private JFrame frmRegistrarAnimal;
	private JTextField txtIdentificacion;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JTextField txtFechaNac;
	private JTextField txtIdResponsable;
	private JTextField txtEdad;
	Gestor gestor;
	private JTextField txtAnimalMadre;
	private JTextField txtAnimalPadre;

	/**
	 * Create the application.
	 */
	public PantallaRegistrarAnimal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarAnimal = new JFrame();
		frmRegistrarAnimal.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmRegistrarAnimal.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 0);
		frmRegistrarAnimal.getContentPane().add(label, BorderLayout.NORTH);
		
		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n");
		lblIdentificacion.setBounds(20, 35, 85, 14);
		frmRegistrarAnimal.getContentPane().add(lblIdentificacion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 70, 46, 14);
		frmRegistrarAnimal.getContentPane().add(lblNombre);
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setBounds(20, 109, 46, 14);
		frmRegistrarAnimal.getContentPane().add(lblRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(20, 144, 46, 14);
		frmRegistrarAnimal.getContentPane().add(lblEdad);
		
		JLabel lblFec = new JLabel("Fecha Nacimiento");
		lblFec.setBounds(20, 179, 85, 14);
		frmRegistrarAnimal.getContentPane().add(lblFec);
		
		JLabel lblIdResponsable = new JLabel("ld Responsable");
		lblIdResponsable.setBounds(20, 211, 85, 14);
		frmRegistrarAnimal.getContentPane().add(lblIdResponsable);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(123, 35, 202, 21);
		frmRegistrarAnimal.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(123, 67, 202, 20);
		frmRegistrarAnimal.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRaza = new JTextField();
		txtRaza.setBounds(123, 106, 202, 20);
		frmRegistrarAnimal.getContentPane().add(txtRaza);
		txtRaza.setColumns(10);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(123, 176, 202, 20);
		frmRegistrarAnimal.getContentPane().add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		txtIdResponsable = new JTextField();
		txtIdResponsable.setBounds(123, 208, 202, 20);
		frmRegistrarAnimal.getContentPane().add(txtIdResponsable);
		txtIdResponsable.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor=new Gestor();
				String identificacion,nombre,raza,edad,fechaNac,idResponsable, animalMadre, animalPadre;
				
				try{
					identificacion = txtIdentificacion.getText();
					nombre = txtNombre.getText();
					raza = txtRaza.getText();
					edad=txtEdad.getText();
					fechaNac = txtFechaNac.getText();
					idResponsable = txtIdResponsable.getText();
					animalMadre = txtAnimalMadre.getText();
					animalPadre = txtAnimalPadre.getText();
					if(txtAnimalMadre.getText() == null && txtAnimalPadre.getText() == null){
						gestor.RegistrarAnimal(identificacion, nombre, raza, edad, fechaNac, idResponsable);
					}else{
						gestor.RegistrarAnimal(identificacion, nombre, raza, edad, fechaNac, idResponsable, animalMadre, animalPadre);
					}
					JOptionPane.showMessageDialog(null,"El animal ha sido registrado","Informacion",JOptionPane.INFORMATION_MESSAGE);	
					JOptionPane.showMessageDialog(null, "Ahora debe registrar el expediente del animal");
					PantallaRegisExpediente p;
					p = new PantallaRegisExpediente ();
					p.setVisible(true);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);			
				}
			}
		});
		btnRegistrar.setBounds(20, 402, 89, 23);
		frmRegistrarAnimal.getContentPane().add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrarAnimal.setVisible(false);
			}
		});
		btnVolver.setBounds(317, 402, 89, 23);
		frmRegistrarAnimal.getContentPane().add(btnVolver);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(123, 141, 195, 20);
		frmRegistrarAnimal.getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		JTextArea txtrLlenarInfoSolo = new JTextArea();
		txtrLlenarInfoSolo.setBackground(Color.GRAY);
		txtrLlenarInfoSolo.setEditable(false);
		txtrLlenarInfoSolo.setText("Llenar Info solo si el animal tiene pedigri");
		txtrLlenarInfoSolo.setBounds(43, 238, 363, 20);
		frmRegistrarAnimal.getContentPane().add(txtrLlenarInfoSolo);
		
		JTextArea txtrNombreDelAnimal = new JTextArea();
		txtrNombreDelAnimal.setBackground(Color.GRAY);
		txtrNombreDelAnimal.setEditable(false);
		txtrNombreDelAnimal.setText("Nombre del animal madre");
		txtrNombreDelAnimal.setBounds(10, 280, 202, 20);
		frmRegistrarAnimal.getContentPane().add(txtrNombreDelAnimal);
		
		txtAnimalMadre = new JTextField();
		txtAnimalMadre.setBounds(211, 281, 223, 20);
		frmRegistrarAnimal.getContentPane().add(txtAnimalMadre);
		txtAnimalMadre.setColumns(10);
		
		JTextArea txtrNombreDelAnimal_1 = new JTextArea();
		txtrNombreDelAnimal_1.setBackground(Color.GRAY);
		txtrNombreDelAnimal_1.setEditable(false);
		txtrNombreDelAnimal_1.setText("Nombre del animal padre");
		txtrNombreDelAnimal_1.setBounds(10, 324, 186, 20);
		frmRegistrarAnimal.getContentPane().add(txtrNombreDelAnimal_1);
		
		txtAnimalPadre = new JTextField();
		txtAnimalPadre.setBounds(211, 325, 221, 20);
		frmRegistrarAnimal.getContentPane().add(txtAnimalPadre);
		txtAnimalPadre.setColumns(10);
		
		JButton btnEliminarAnimal = new JButton("Eliminar Animal");
		btnEliminarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaEliminarAnimal p = new PantallaEliminarAnimal();
				p.setVisible(true);
			}
		});
		btnEliminarAnimal.setBounds(154, 402, 124, 23);
		frmRegistrarAnimal.getContentPane().add(btnEliminarAnimal);
		frmRegistrarAnimal.setTitle("Registrar Animal");
		frmRegistrarAnimal.setBackground(SystemColor.activeCaption);
		frmRegistrarAnimal.setBounds(100, 100, 450, 493);
		frmRegistrarAnimal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarAnimal.setVisible(true);
		
	}
}
