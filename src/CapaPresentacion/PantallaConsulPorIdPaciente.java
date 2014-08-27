package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import CapaLogica.Animal;
import CapaLogica.Gestor;
import javax.swing.JList;
import CapaLogica.Expediente;
import java.util.*;
import java.awt.SystemColor;

public class PantallaConsulPorIdPaciente {

	private JFrame frmPantallaConsultarPorIdPaciente;
	private JTextField txtIdentificacion;
	Gestor gestor;

	/**
	 * Create the application.
	 */
	public PantallaConsulPorIdPaciente() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaConsultarPorIdPaciente = new JFrame();
		frmPantallaConsultarPorIdPaciente.setTitle("Consultar Expediente por ID Paciente");
		frmPantallaConsultarPorIdPaciente.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmPantallaConsultarPorIdPaciente.setBounds(100, 100, 450, 300);
		frmPantallaConsultarPorIdPaciente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPantallaConsultarPorIdPaciente.getContentPane().setLayout(null);
		frmPantallaConsultarPorIdPaciente.setVisible(true);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(10, 21, 88, 14);
		frmPantallaConsultarPorIdPaciente.getContentPane().add(lblIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(108, 18, 205, 20);
		frmPantallaConsultarPorIdPaciente.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		final List listResul = new List();
		listResul.setBounds(50, 65, 331, 140);
		frmPantallaConsultarPorIdPaciente.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor= new Gestor();
				String identificacion; 
				TreeMap datosExp;
				TreeMap datosAnim;
				try {
					identificacion = txtIdentificacion.getText();
					datosExp = gestor.buscarExpedientePorIDPaciente(identificacion);
					listResul.removeAll();
					listResul.add(""+datosExp.get("identificacion")+" - "+datosExp.get("fechaApertura"));
					Animal animal;
					datosAnim = gestor.buscarAnimalID(identificacion);
					listResul.add("" + datosAnim.get("identificacion")+" - "+datosAnim.get("nombre")+" - "+datosAnim.get("raza")+" - "+
					datosAnim.get("edad")+ " - " +datosAnim.get("fechaNac")+" - "+datosAnim.get("Fk_idResponsable"));
					
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					listResul.removeAll();
				}
		      
			}
		});
		
		btnBuscar.setBounds(323, 17, 89, 23);
		frmPantallaConsultarPorIdPaciente.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPantallaConsultarPorIdPaciente.setVisible(false);
			}
		});
		btnVolver.setBounds(60, 216, 89, 23);
		frmPantallaConsultarPorIdPaciente.getContentPane().add(btnVolver);
		
	}
}
