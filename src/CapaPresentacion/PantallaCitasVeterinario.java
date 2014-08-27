package CapaPresentacion;

import java.awt.List;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import CapaLogica.Consulta;
import CapaLogica.Gestor;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class PantallaCitasVeterinario extends JPanel {

	private JFrame frmCitasVeterinario;
	Gestor gestor;
	Vector datosVeterinario;
	private JTextField txtIdVeterinario;

	

	/**
	 * Create the application.
	 */
	public PantallaCitasVeterinario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCitasVeterinario = new JFrame();
		frmCitasVeterinario.getContentPane().setBackground(Color.GRAY);
		frmCitasVeterinario.getContentPane().setLayout(null);
		frmCitasVeterinario.setVisible(true);
		
		final List listResul = new List();
		listResul.setBounds(36, 67, 375, 134);
		frmCitasVeterinario.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor = new Gestor();
				String idVeterinario;
				TreeMap infoVeterinario;
				try {
					idVeterinario = txtIdVeterinario.getText();
					datosVeterinario = gestor.consultarCitasVeterinario(idVeterinario);
					listResul.removeAll();
					for (int i=0; i<datosVeterinario.size(); i++) {
						infoVeterinario = ((TreeMap) datosVeterinario.get(i));
						listResul.add(""+infoVeterinario.get("fechaCita"));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					listResul.removeAll();
				}
			
			}
		});
		btnBuscar.setBounds(20, 212, 89, 23);
		frmCitasVeterinario.getContentPane().add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setBounds(123, 25, 46, 14);
		frmCitasVeterinario.getContentPane().add(label);
		
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
		frmCitasVeterinario.getContentPane().add(btnDetalles);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCitasVeterinario.setVisible(false);
			}
		});
		btnVolver.setBounds(307, 212, 91, 23);
		frmCitasVeterinario.getContentPane().add(btnVolver);
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setBounds(142, 10, 290, 20);
		frmCitasVeterinario.getContentPane().add(txtIdVeterinario);
		txtIdVeterinario.setColumns(10);
		
		JTextArea txtrIdVeterinario = new JTextArea();
		txtrIdVeterinario.setBackground(Color.GRAY);
		txtrIdVeterinario.setEditable(false);
		txtrIdVeterinario.setText("ID Veterinario");
		txtrIdVeterinario.setBounds(10, 10, 114, 20);
		frmCitasVeterinario.getContentPane().add(txtrIdVeterinario);
		frmCitasVeterinario.setBackground(SystemColor.inactiveCaption);
		frmCitasVeterinario.setTitle("Consultar Veterinario");
		frmCitasVeterinario.setBounds(100, 100, 450, 300);
		frmCitasVeterinario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
