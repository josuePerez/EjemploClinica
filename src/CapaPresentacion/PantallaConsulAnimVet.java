package CapaPresentacion;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CapaLogica.Consulta;
import CapaLogica.Gestor;

public class PantallaConsulAnimVet extends JPanel {
	
	private JFrame frmAnimalesVeterinario;
	Gestor gestor;
	private JTextField txtIdVeterinario;
	Vector datosVeterinario;
	/**
	 * Create the panel.
	 */
	public PantallaConsulAnimVet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAnimalesVeterinario = new JFrame();
		frmAnimalesVeterinario.getContentPane().setBackground(Color.GRAY);
		frmAnimalesVeterinario.getContentPane().setLayout(null);
		frmAnimalesVeterinario.setVisible(true);
		
		final List listResul = new List();
		listResul.setBounds(36, 67, 375, 134);
		frmAnimalesVeterinario.getContentPane().add(listResul);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor = new Gestor();
				String idVeterinario;
				TreeMap infoAnimales;
				try {
					idVeterinario = txtIdVeterinario.getText();
					JOptionPane.showMessageDialog(null, txtIdVeterinario.getText());
					datosVeterinario = gestor.consultarAnimalesVeterinario(idVeterinario);
					listResul.removeAll();
					for (int i=0; i<datosVeterinario.size(); i++) {
						infoAnimales = ((TreeMap) datosVeterinario.get(i));
						listResul.add(""+infoAnimales.get("nombre")+ " - "+infoAnimales.get("identificacion")+" - "+
								(String) infoAnimales.get("raza")+" - " + (String) infoAnimales.get("edad")+" - "+
								(String) infoAnimales.get("fechaNac")+" - "+
								(String) infoAnimales.get("Fk_idResponsable"));
					}
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
					listResul.removeAll();
				}
			
			}
		});
		btnBuscar.setBounds(20, 212, 89, 23);
		frmAnimalesVeterinario.getContentPane().add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setBounds(123, 25, 46, 14);
		frmAnimalesVeterinario.getContentPane().add(label);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAnimalesVeterinario.setVisible(false);
			}
		});
		btnVolver.setBounds(307, 212, 91, 23);
		frmAnimalesVeterinario.getContentPane().add(btnVolver);
		
		JTextArea txtrIdVeterinario = new JTextArea();
		txtrIdVeterinario.setBackground(Color.GRAY);
		txtrIdVeterinario.setEditable(false);
		txtrIdVeterinario.setText("ID Veterinario");
		txtrIdVeterinario.setBounds(10, 10, 114, 20);
		frmAnimalesVeterinario.getContentPane().add(txtrIdVeterinario);
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setBounds(143, 11, 268, 20);
		frmAnimalesVeterinario.getContentPane().add(txtIdVeterinario);
		txtIdVeterinario.setColumns(10);
		frmAnimalesVeterinario.setBackground(SystemColor.inactiveCaption);
		frmAnimalesVeterinario.setTitle("Consultar Veterinario");
		frmAnimalesVeterinario.setBounds(100, 100, 450, 300);
		frmAnimalesVeterinario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
