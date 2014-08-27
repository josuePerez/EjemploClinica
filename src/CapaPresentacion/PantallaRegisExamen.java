package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import CapaLogica.Gestor;
import java.awt.SystemColor;

public class PantallaRegisExamen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSolicitud;
	private JTextField txtRealizado;
	private JTextField txtDescrip;
	Gestor gestor;
	private JTextField txtConsulta;
	private JTextArea txtrIdConsulta;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnVolver;
	private JTextField txtIdExamen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegisExamen frame = new PantallaRegisExamen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaRegisExamen() {
		setBackground(SystemColor.desktop);
		setTitle("Registrar examen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 584);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNombreDelExamen = new JTextArea();
		txtrNombreDelExamen.setBackground(Color.GRAY);
		txtrNombreDelExamen.setEditable(false);
		txtrNombreDelExamen.setText("Nombre del examen");
		txtrNombreDelExamen.setBounds(10, 55, 148, 20);
		contentPane.add(txtrNombreDelExamen);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(177, 56, 255, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea txtrFechaDeSolicitud = new JTextArea();
		txtrFechaDeSolicitud.setBackground(Color.GRAY);
		txtrFechaDeSolicitud.setEditable(false);
		txtrFechaDeSolicitud.setText("Fecha de solicitud");
		txtrFechaDeSolicitud.setBounds(10, 103, 148, 20);
		contentPane.add(txtrFechaDeSolicitud);
		
		txtSolicitud = new JTextField();
		txtSolicitud.setBounds(177, 104, 255, 20);
		contentPane.add(txtSolicitud);
		txtSolicitud.setColumns(10);
		
		JTextArea txtrFechaRealizado = new JTextArea();
		txtrFechaRealizado.setEditable(false);
		txtrFechaRealizado.setBackground(Color.GRAY);
		txtrFechaRealizado.setText("Fecha realizado");
		txtrFechaRealizado.setBounds(10, 255, 148, 20);
		contentPane.add(txtrFechaRealizado);
		
		txtRealizado = new JTextField();
		txtRealizado.setBounds(177, 256, 255, 20);
		contentPane.add(txtRealizado);
		txtRealizado.setColumns(10);
		
		JTextArea txtrDescripcin = new JTextArea();
		txtrDescripcin.setEditable(false);
		txtrDescripcin.setBackground(Color.GRAY);
		txtrDescripcin.setText("Descripci\u00F3n");
		txtrDescripcin.setBounds(10, 145, 148, 20);
		contentPane.add(txtrDescripcin);
		
		txtDescrip = new JTextField();
		txtDescrip.setBounds(10, 176, 422, 56);
		contentPane.add(txtDescrip);
		txtDescrip.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar ");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRegistrar_mouseClicked(arg0);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegistrar.setBounds(10, 353, 133, 43);
		contentPane.add(btnRegistrar);
		
		txtConsulta = new JTextField();
		txtConsulta.setBounds(177, 287, 255, 20);
		contentPane.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		txtrIdConsulta = new JTextArea();
		txtrIdConsulta.setBackground(Color.GRAY);
		txtrIdConsulta.setEditable(false);
		txtrIdConsulta.setText("Id Consulta");
		txtrIdConsulta.setBounds(10, 286, 148, 20);
		contentPane.add(txtrIdConsulta);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificar_mouseClicked(e);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnModificar.setBounds(177, 353, 133, 43);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminar_mouseClicked(e);
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnEliminar.setBounds(334, 353, 116, 43);
		contentPane.add(btnEliminar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(260, 407, 116, 48);
		contentPane.add(btnVolver);
		
		JButton btnRegistrarResultado = new JButton("Registrar resultado");
		btnRegistrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarResultado_mouseClicked(e);
			}
		});
		btnRegistrarResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRegistrarResultado.setBounds(38, 409, 167, 48);
		contentPane.add(btnRegistrarResultado);
		
		JTextArea txtrIdExamen = new JTextArea();
		txtrIdExamen.setBackground(Color.GRAY);
		txtrIdExamen.setEditable(false);
		txtrIdExamen.setText("ID Examen");
		txtrIdExamen.setBounds(10, 11, 148, 20);
		contentPane.add(txtrIdExamen);
		
		txtIdExamen = new JTextField();
		txtIdExamen.setBounds(177, 12, 255, 20);
		contentPane.add(txtIdExamen);
		txtIdExamen.setColumns(10);
		
		gestor = new Gestor();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		String id,nombre, fechaSoli, fechaRealiz, descrip, idConsulta;

		try {
			id = txtIdExamen.getText();
			nombre = txtNombre.getText();
			fechaSoli = txtSolicitud.getText();
			fechaRealiz = txtRealizado.getText();
			descrip = txtDescrip.getText();
			idConsulta = txtConsulta.getText();
			gestor.registrarExamen(id, nombre, fechaSoli, fechaRealiz, descrip, idConsulta);
			JOptionPane.showMessageDialog(this,"El examen ha sido agregado","Informacion",JOptionPane.INFORMATION_MESSAGE);			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);			
		}
		
	}
	/**
	 *
	 *
	 */	
	public void btnModificar_mouseClicked(ActionEvent e){
		PantallaModificarExamen p;
		p = new PantallaModificarExamen();
		p.setVisible(true);
	}
	/**
	 *
	 *
	 */	
	public void btnEliminar_mouseClicked(ActionEvent e){
		PantallaEliminarExamen p;
		p = new PantallaEliminarExamen();
		p.setVisible(true);
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarResultado_mouseClicked(ActionEvent e){
		PantallaRegistrarResul p;
		p = new PantallaRegistrarResul();
		p.setVisible(true);
	}
	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}	
}
