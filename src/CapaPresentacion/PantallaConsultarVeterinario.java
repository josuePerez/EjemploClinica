package CapaPresentacion;

import java.awt.EventQueue;

import CapaLogica.Consulta;
import CapaLogica.Gestor;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.List;
import java.util.TreeMap;
import java.util.Vector;

public class PantallaConsultarVeterinario {

	private JFrame frmConsultarVeterinario;
	Gestor gestor;
	Vector datosVeterinario;

	

	/**
	 * Create the application.
	 */
	public PantallaConsultarVeterinario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsultarVeterinario = new JFrame();
		frmConsultarVeterinario.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmConsultarVeterinario.getContentPane().setLayout(null);
		frmConsultarVeterinario.setVisible(true);
		
		final List listResul = new List();
		listResul.setBounds(36, 67, 375, 134);
		frmConsultarVeterinario.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor = new Gestor();
				TreeMap infoVeterinario;
				try {
					datosVeterinario = gestor.ConsultarVeterinario();
					listResul.removeAll();
					for (int i=0; i<datosVeterinario.size(); i++) {
						infoVeterinario = ((TreeMap) datosVeterinario.get(i));
						listResul.add(""+infoVeterinario.get("nombre"));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					listResul.removeAll();
				}
			
			}
		});
		btnBuscar.setBounds(20, 212, 89, 23);
		frmConsultarVeterinario.getContentPane().add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setBounds(123, 25, 46, 14);
		frmConsultarVeterinario.getContentPane().add(label);
		
		JButton btnDetalles = new JButton("Detalles");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion;
				String idAnimal;
				TreeMap infoVeterinario;
				Consulta consulta = null;

				try {
					seleccion = listResul.getSelectedIndex();
					infoVeterinario = (TreeMap) datosVeterinario.get(seleccion);
					listResul.removeAll();
					listResul.add((String) infoVeterinario.get("identificacion")+" - "+
					(String) infoVeterinario.get("nombre")+" - " + (String) infoVeterinario.get("especialidad")+" - "+
					(String) infoVeterinario.get("telefono"));
				}
				catch (java.lang.RuntimeException er) {
					JOptionPane.showMessageDialog(null, "Selecciones una opcion de la lista");	
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");	
				}	
			}
		});
		btnDetalles.setBounds(160, 212, 91, 23);
		frmConsultarVeterinario.getContentPane().add(btnDetalles);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConsultarVeterinario.setVisible(false);
			}
		});
		btnVolver.setBounds(307, 212, 91, 23);
		frmConsultarVeterinario.getContentPane().add(btnVolver);
		frmConsultarVeterinario.setBackground(SystemColor.inactiveCaption);
		frmConsultarVeterinario.setTitle("Consultar Veterinario");
		frmConsultarVeterinario.setBounds(100, 100, 450, 300);
		frmConsultarVeterinario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
