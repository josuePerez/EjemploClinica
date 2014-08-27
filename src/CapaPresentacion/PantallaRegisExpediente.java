package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import CapaLogica.Gestor;
import java.awt.SystemColor;

public class PantallaRegisExpediente extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdAnimal;
	private JTextField txtFecha;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegisExpediente frame = new PantallaRegisExpediente();
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
	public PantallaRegisExpediente() {
		setTitle("Registrar Ezpediente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdAnimal = new JTextArea();
		txtrIdAnimal.setBackground(Color.GRAY);
		txtrIdAnimal.setEditable(false);
		txtrIdAnimal.setText("ID Animal");
		txtrIdAnimal.setBounds(10, 11, 83, 20);
		contentPane.add(txtrIdAnimal);
		
		txtIdAnimal = new JTextField();
		txtIdAnimal.setBounds(137, 12, 295, 20);
		contentPane.add(txtIdAnimal);
		txtIdAnimal.setColumns(10);
		
		JTextArea txtrFechaApertura = new JTextArea();
		txtrFechaApertura.setBackground(Color.GRAY);
		txtrFechaApertura.setEditable(false);
		txtrFechaApertura.setText("Fecha Apertura");
		txtrFechaApertura.setBounds(10, 57, 114, 20);
		contentPane.add(txtrFechaApertura);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(153, 58, 279, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegistrar.setBounds(10, 137, 183, 69);
		contentPane.add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(235, 137, 128, 69);
		contentPane.add(btnVolver);
		
		gestor = new Gestor();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		String idAnimal, fecha;

		try {
			idAnimal = txtIdAnimal.getText();
			fecha = txtFecha.getText();
			gestor.registrarExpediente(idAnimal ,fecha);
			JOptionPane.showMessageDialog(this,"El expediente ha sido agregado","Informacion",JOptionPane.INFORMATION_MESSAGE);			
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
