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

import CapaLogica.Gestor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaCancelarCita extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdExpediente;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaCancelarCita frame = new PantallaCancelarCita();
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
	public PantallaCancelarCita() {
		setTitle("Cancelar Cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 258);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdExpediente = new JTextArea();
		txtrIdExpediente.setBackground(Color.GRAY);
		txtrIdExpediente.setEditable(false);
		txtrIdExpediente.setText("ID Expediente");
		txtrIdExpediente.setBounds(10, 11, 119, 20);
		contentPane.add(txtrIdExpediente);
		
		txtIdExpediente = new JTextField();
		txtIdExpediente.setBounds(167, 12, 239, 20);
		contentPane.add(txtIdExpediente);
		txtIdExpediente.setColumns(10);
		
		JButton btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCita_mouseClicked(e);
			}
		});
		btnCancelarCita.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCancelarCita.setBounds(10, 89, 159, 35);
		contentPane.add(btnCancelarCita);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(167, 151, 113, 33);
		contentPane.add(btnVolver);
		
		JButton btnAnularCita = new JButton("Anular Cita");
		btnAnularCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnularCita_mouseClicked(e);
			}
		});
		btnAnularCita.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAnularCita.setBounds(259, 90, 147, 33);
		contentPane.add(btnAnularCita);
		
		gestor = new Gestor();
	}
	
	public void btnCancelarCita_mouseClicked(ActionEvent e){
		String idExpediente;
		
		try{
			idExpediente =	txtIdExpediente.getText();
			gestor.cancelarCita(idExpediente);
			JOptionPane.showMessageDialog(this,"La cita ha sido cancelada","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}
	
	public void btnAnularCita_mouseClicked(ActionEvent e){
		String idExpediente;
		try{
			idExpediente =	txtIdExpediente.getText();
			gestor.anularCita(idExpediente);
			JOptionPane.showMessageDialog(this,"La cita ha sido anulada","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
