package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

import CapaLogica.Expediente;
import CapaLogica.Gestor;
import CapaLogica.MultiExamen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TreeMap;
import java.util.Vector;
import CapaLogica.Consulta;
import CapaLogica.Examen;
import java.awt.SystemColor;

public class PantallaConsulConsultas {


	private JFrame frmConsulConsultas;
	private JTextField txtIdentificacion;
	Gestor gestor;
	Vector datosConsultas;
	private JTextField txtFecha;
	private JTextField txtId1;

	/**
	 * Create the application.
	 */
	public PantallaConsulConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsulConsultas = new JFrame();
		frmConsulConsultas.setTitle("Buscar consultas de un animal");
		frmConsulConsultas.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmConsulConsultas.setBounds(100, 100, 652, 423);
		frmConsulConsultas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsulConsultas.getContentPane().setLayout(null);
		frmConsulConsultas.setVisible(true);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(10, 21, 88, 14);
		frmConsulConsultas.getContentPane().add(lblIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(108, 18, 205, 20);
		frmConsulConsultas.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		final List listResul = new List();
		listResul.setBounds(10, 199, 147, 140);
		frmConsulConsultas.getContentPane().add(listResul);
		
		final List listExamen = new List();
		listExamen.setBounds(175, 199, 193, 140);
		frmConsulConsultas.getContentPane().add(listExamen);
		
		final List listMedicina = new List();
		listMedicina.setBounds(374, 199, 163, 140);
		frmConsulConsultas.getContentPane().add(listMedicina);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor = new Gestor();
				TreeMap infoConsulta;
				String idExpediente;
				Vector datosExamen;
				idExpediente = txtIdentificacion.getText();
				try{
					datosConsultas = gestor.buscarConsultas(idExpediente);
					listResul.removeAll();
					for (int i=0; i<datosConsultas.size(); i++) {
						infoConsulta = ((TreeMap) datosConsultas.get(i));
						listResul.add(""+infoConsulta.get("fecha")+" - " +infoConsulta.get("FK_idExpediente"));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, this,idExpediente, JOptionPane.ERROR_MESSAGE, null);		
					listResul.removeAll();
				}

			}
		});
		
		btnBuscar.setBounds(323, 17, 89, 23);
		frmConsulConsultas.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmConsulConsultas.setVisible(false);
			}
		});
		btnVolver.setBounds(9, 362, 89, 23);
		frmConsulConsultas.getContentPane().add(btnVolver);
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion;
				String idExpediente;
				TreeMap infoConsulta, infoExamen, infoMedicina;
				Consulta consulta = null;
				Vector datosExamen = new Vector();
				Vector datosMedicina = new Vector();
				idExpediente = txtIdentificacion.getText();

				try {
					seleccion = listResul.getSelectedIndex();
					infoConsulta = (TreeMap) datosConsultas.get(seleccion);
					listResul.removeAll();
					listResul.add((String) infoConsulta.get("Fk_idVeterinario")+" - "+
					(String) infoConsulta.get("fecha")+" - " + (String) infoConsulta.get("descrip")+" - "+
					(String) infoConsulta.get("FK_idExpediente"));
					datosExamen = gestor.buscarExamenes("77");
					for (int i=0; i<datosExamen.size(); i++) {
						infoExamen = ((TreeMap) datosExamen.get(i));
						listExamen.add((String) infoExamen.get("nombre")+" - "+
									   (String) infoExamen.get("fechSolicitud")+" - "+
									   (String) infoExamen.get("fechRealizacion")+" - "+
									   (String) infoExamen.get("descrip"));
					}
					datosMedicina = gestor.buscarMedicinas("77");
					for (int i=0; i<datosMedicina.size(); i++) {
						infoMedicina = ((TreeMap) datosMedicina.get(i));
						listMedicina.add((String) infoMedicina.get("nombre")+" - "+
									   	 (String) infoMedicina.get("dosis")+" - "+
									   	 (String) infoMedicina.get("numDias")+" - "+
									   	 (String) infoMedicina.get("FK_idConsulta"));
					}
					
				}
				catch (java.lang.RuntimeException er) {
					JOptionPane.showMessageDialog(null, "Selecciones una opcion de la lista");	
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");	
				}	
			}
		});
		btnDetalles.setBounds(543, 261, 91, 23);
		frmConsulConsultas.getContentPane().add(btnDetalles);
		
		JTextArea txtrFecha = new JTextArea();
		txtrFecha.setBackground(Color.GRAY);
		txtrFecha.setEditable(false);
		txtrFecha.setText("Fecha");
		txtrFecha.setBounds(10, 103, 55, 20);
		frmConsulConsultas.getContentPane().add(txtrFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(22, 134, 108, 20);
		frmConsulConsultas.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gestor = new Gestor();
				TreeMap infoConsulta;
				String fecha, idExpediente;
				Vector datosExamen;
				fecha = txtFecha.getText();
				idExpediente = txtId1.getText();
				try{
					datosConsultas = gestor.buscarConsultasPorFecha(fecha, idExpediente);
					
					listResul.removeAll();
					for (int i=0; i<datosConsultas.size(); i++) {
						infoConsulta = ((TreeMap) datosConsultas.get(i));
						listResul.add(""+infoConsulta.get("fecha")+" - " +infoConsulta.get("FK_idExpediente"));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, this,fecha, JOptionPane.ERROR_MESSAGE, null);		
					listResul.removeAll();
				}
			}
		});
		btnBuscar_1.setBounds(323, 133, 91, 23);
		frmConsulConsultas.getContentPane().add(btnBuscar_1);
		
		JTextArea txtrIdentificacion = new JTextArea();
		txtrIdentificacion.setBackground(Color.GRAY);
		txtrIdentificacion.setEditable(false);
		txtrIdentificacion.setText("Identificacion");
		txtrIdentificacion.setBounds(140, 103, 121, 20);
		frmConsulConsultas.getContentPane().add(txtrIdentificacion);
		
		txtId1 = new JTextField();
		txtId1.setBounds(140, 134, 125, 20);
		frmConsulConsultas.getContentPane().add(txtId1);
		txtId1.setColumns(10);
		
		JTextArea txtrBuscarPorFecha = new JTextArea();
		txtrBuscarPorFecha.setEditable(false);
		txtrBuscarPorFecha.setBackground(Color.GRAY);
		txtrBuscarPorFecha.setText("Buscar Por fecha de consulta");
		txtrBuscarPorFecha.setBounds(75, 67, 266, 20);
		frmConsulConsultas.getContentPane().add(txtrBuscarPorFecha);
	}
}
