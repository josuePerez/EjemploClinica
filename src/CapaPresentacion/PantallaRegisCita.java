package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import CapaLogica.Gestor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegisCita extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdExpediente;
	private JTextField txtIdVeterinario;
	private JTextField txtFecha;
	private JTextField txtDescrip;
	private JTextField txtIdConsulta;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegisCita frame = new PantallaRegisCita();
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
	public PantallaRegisCita() {
		setTitle("Administrar Citas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 465);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdExpediente = new JTextArea();
		txtrIdExpediente.setEditable(false);
		txtrIdExpediente.setBackground(Color.GRAY);
		txtrIdExpediente.setText("ID Expediente");
		txtrIdExpediente.setBounds(10, 23, 106, 20);
		contentPane.add(txtrIdExpediente);
		
		txtIdExpediente = new JTextField();
		txtIdExpediente.setBounds(196, 24, 201, 20);
		contentPane.add(txtIdExpediente);
		txtIdExpediente.setColumns(10);
		
		JTextArea txtrIdVeterinario = new JTextArea();
		txtrIdVeterinario.setEditable(false);
		txtrIdVeterinario.setBackground(Color.GRAY);
		txtrIdVeterinario.setText("ID Veterinario");
		txtrIdVeterinario.setBounds(10, 65, 123, 20);
		contentPane.add(txtrIdVeterinario);
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setBounds(196, 66, 201, 20);
		contentPane.add(txtIdVeterinario);
		txtIdVeterinario.setColumns(10);
		
		JTextArea txtrFecha = new JTextArea();
		txtrFecha.setEditable(false);
		txtrFecha.setBackground(Color.GRAY);
		txtrFecha.setText("Fecha");
		txtrFecha.setBounds(10, 114, 106, 20);
		contentPane.add(txtrFecha);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(196, 115, 201, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JTextArea txtrDescrip = new JTextArea();
		txtrDescrip.setBackground(Color.GRAY);
		txtrDescrip.setEditable(false);
		txtrDescrip.setText("Descripcion");
		txtrDescrip.setBounds(10, 160, 123, 20);
		contentPane.add(txtrDescrip);
		
		txtDescrip = new JTextField();
		txtDescrip.setBounds(196, 161, 201, 20);
		contentPane.add(txtDescrip);
		txtDescrip.setColumns(10);
		
		JTextArea txtrIdConsulta = new JTextArea();
		txtrIdConsulta.setEditable(false);
		txtrIdConsulta.setBackground(Color.GRAY);
		txtrIdConsulta.setText("ID Consulta");
		txtrIdConsulta.setBounds(10, 209, 123, 20);
		contentPane.add(txtrIdConsulta);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(196, 210, 201, 20);
		contentPane.add(txtIdConsulta);
		txtIdConsulta.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegistrar.setBounds(10, 258, 134, 51);
		contentPane.add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(263, 361, 134, 51);
		contentPane.add(btnVolver);
		
		JButton btnCancelarCita = new JButton("Cancelar Cita");
		btnCancelarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelarCita_mouseCLicked(e);
			}
		});
		btnCancelarCita.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCancelarCita.setBounds(246, 258, 173, 51);
		contentPane.add(btnCancelarCita);
		
		JButton btnAnularCita = new JButton("Anular Cita");
		btnAnularCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnularCita_mouseClicked(e);
			}
		});
		btnAnularCita.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAnularCita.setBounds(64, 361, 139, 51);
		contentPane.add(btnAnularCita);
		
		gestor = new Gestor();
	}
	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		String idExpediente, idVeterinario, fecha, descrip;
		
		try{
			idExpediente =	txtIdExpediente.getText();
			idVeterinario = txtIdVeterinario.getText();
			fecha = txtFecha.getText();
			descrip = txtDescrip.getText();
			gestor.registrarCita(fecha,descrip, idExpediente, idVeterinario);
			JOptionPane.showMessageDialog(this,"La cita ha sido agregada","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}
	
	public void btnCancelarCita_mouseCLicked(ActionEvent e){
		PantallaCancelarCita p = new PantallaCancelarCita();
		p.setVisible(true);
	}
	
	public void btnAnularCita_mouseClicked(ActionEvent e){
		PantallaCancelarCita p = new PantallaCancelarCita();
		p.setVisible(true);
	}
}
