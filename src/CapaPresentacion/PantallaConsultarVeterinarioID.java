package CapaPresentacion;

import java.awt.EventQueue;
import java.awt.List;

import CapaLogica.Gestor;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.util.TreeMap;


public class PantallaConsultarVeterinarioID {

	private JFrame frmConsultarVeterinarioId;
	private JTextField txtIdentificacion;
	Gestor gestor;

	/**
	 * Create the application.
	 */
	public PantallaConsultarVeterinarioID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarVeterinarioId = new JFrame();
		frmConsultarVeterinarioId.setTitle("Consultar Veterinario ID");
		frmConsultarVeterinarioId.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmConsultarVeterinarioId.setBounds(100, 100, 450, 300);
		frmConsultarVeterinarioId.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsultarVeterinarioId.getContentPane().setLayout(null);
		frmConsultarVeterinarioId.setVisible(true);
		
		JLabel lblIdentificacion = new JLabel("Identificacion");
		lblIdentificacion.setBounds(10, 21, 88, 14);
		frmConsultarVeterinarioId.getContentPane().add(lblIdentificacion);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setBounds(108, 18, 205, 20);
		frmConsultarVeterinarioId.getContentPane().add(txtIdentificacion);
		txtIdentificacion.setColumns(10);
		
		final List listResul = new List();
		listResul.setBounds(50, 65, 331, 140);
		frmConsultarVeterinarioId.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor= new Gestor();
				String identificacion; 
				TreeMap datosVet;
				try {
					identificacion = txtIdentificacion.getText();
					datosVet = gestor.ConsultarVeterinarioID(identificacion);
					listResul.removeAll();
					listResul.add(""+datosVet.get("identificacion")+" - "+datosVet.get("nombre")+" - "+datosVet.get("especialidad")+" - "+datosVet.get("telefono"));
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					listResul.removeAll();
					
					
				}
		      
			}
		});
		
		btnBuscar.setBounds(323, 17, 89, 23);
		frmConsultarVeterinarioId.getContentPane().add(btnBuscar);
		
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmConsultarVeterinarioId.setVisible(false);
			}
		});
		btnVolver.setBounds(60, 216, 89, 23);
		frmConsultarVeterinarioId.getContentPane().add(btnVolver);
		
	}
}
