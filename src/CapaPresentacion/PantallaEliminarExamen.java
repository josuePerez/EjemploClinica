package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TreeMap;
import CapaLogica.Gestor;
import java.awt.Color;

public class PantallaEliminarExamen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextArea txtrIdConsulta;
	private JTextField txtIdConsulta;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaEliminarExamen frame = new PantallaEliminarExamen();
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
	public PantallaEliminarExamen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNombreDelExamen = new JTextArea();
		txtrNombreDelExamen.setBackground(Color.GRAY);
		txtrNombreDelExamen.setEditable(false);
		txtrNombreDelExamen.setText("Nombre del Examen");
		txtrNombreDelExamen.setBounds(10, 11, 154, 20);
		contentPane.add(txtrNombreDelExamen);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(174, 12, 247, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtrIdConsulta = new JTextArea();
		txtrIdConsulta.setBackground(Color.GRAY);
		txtrIdConsulta.setText("ID consulta");
		txtrIdConsulta.setBounds(10, 60, 120, 20);
		contentPane.add(txtrIdConsulta);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(174, 61, 154, 20);
		contentPane.add(txtIdConsulta);
		txtIdConsulta.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminar_mouseClicked(e);
			
			}
		});
		btnEliminar.setBounds(41, 158, 91, 23);
		contentPane.add(btnEliminar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setBounds(249, 158, 91, 23);
		contentPane.add(btnVolver);
	}
	/**
	 *
	 *
	 */	
	public void btnEliminar_mouseClicked(ActionEvent e){
		gestor = new Gestor();
		String nombreExamen;
		String idConsulta;
		String seleccion = null;
		
		try {
			nombreExamen = txtNombre.getText();
			idConsulta = txtIdConsulta.getText();
			if( JOptionPane.showConfirmDialog(this,"Desea borrar?", seleccion, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
				gestor.eliminarExamen(nombreExamen,idConsulta);
			}
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);	
		}
	}
	/**
	 *
	 *
	 */	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}
}
