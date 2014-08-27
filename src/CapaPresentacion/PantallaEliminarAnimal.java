package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import CapaLogica.Gestor;

public class PantallaEliminarAnimal extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtIdAnimal;
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
	public PantallaEliminarAnimal() {
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
		txtrNombreDelExamen.setText("ID Animal");
		txtrNombreDelExamen.setBounds(10, 11, 154, 20);
		contentPane.add(txtrNombreDelExamen);
		
		txtIdAnimal = new JTextField();
		txtIdAnimal.setBounds(174, 12, 247, 20);
		contentPane.add(txtIdAnimal);
		txtIdAnimal.setColumns(10);
		
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
		String idAnimal;
		String seleccion = null;
		
		try {
			idAnimal = txtIdAnimal.getText();
			if( JOptionPane.showConfirmDialog(this,"Desea borrar?", seleccion, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
				gestor.eliminarAnimal(idAnimal);
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
