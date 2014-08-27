package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TreeMap;

import javax.swing.JList;

import CapaLogica.Animal;
import CapaLogica.Expediente;
import CapaLogica.Gestor;
import CapaLogica.MultiAnimal;

import java.awt.Font;
import java.awt.SystemColor;

public class PantallaConsultarPorIdExpediente {

	private JFrame frmPantallaConsultarPorIdExpediente;
	private JTextField txtIdentificacion;
	Gestor gestor;

	/**
	 * Create the application.
	 */
	public PantallaConsultarPorIdExpediente() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPantallaConsultarPorIdExpediente = new JFrame();
		frmPantallaConsultarPorIdExpediente.setTitle("Consultar Expediente por ID");
		frmPantallaConsultarPorIdExpediente.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmPantallaConsultarPorIdExpediente.setBounds(100, 100, 450, 300);
		frmPantallaConsultarPorIdExpediente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPantallaConsultarPorIdExpediente.getContentPane().setLayout(null);
		frmPantallaConsultarPorIdExpediente.setVisible(true);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(10, 21, 88, 14);
		frmPantallaConsultarPorIdExpediente.getContentPane().add(lblIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(108, 18, 205, 20);
		frmPantallaConsultarPorIdExpediente.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		final List listResul = new List();
		listResul.setBounds(50, 65, 331, 140);
		frmPantallaConsultarPorIdExpediente.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor= new Gestor();
				String identificacion; 
				TreeMap datosExp;
				TreeMap datosAnim;
				try {
					identificacion = txtIdentificacion.getText();
					datosExp = gestor.buscarExpedientePorIDExpediente(identificacion);
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
		frmPantallaConsultarPorIdExpediente.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPantallaConsultarPorIdExpediente.setVisible(false);
			}
		});
		btnVolver.setBounds(60, 216, 89, 23);
		frmPantallaConsultarPorIdExpediente.getContentPane().add(btnVolver);
		
	}
}
