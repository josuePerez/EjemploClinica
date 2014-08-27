package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		setTitle("Clinica Veterinaria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrarVeterinario = new JButton("Registrar Veterinario");
		btnRegistrarVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaRegistrarVeterinario p;
				p = new PantallaRegistrarVeterinario ();
			}
		});
		btnRegistrarVeterinario.setBounds(183, 79, 162, 23);
		contentPane.add(btnRegistrarVeterinario);
		
		JButton btnRegistrarDueoDel = new JButton("Registrar due\u00F1o del animal");
		btnRegistrarDueoDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarDueño(e);
			}
		});
		btnRegistrarDueoDel.setBounds(30, 203, 162, 23);
		contentPane.add(btnRegistrarDueoDel);
		
		JButton btnRegistrarAnimal = new JButton("Registrar Animal");
		btnRegistrarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarAnimal(e);
			}
		});
		btnRegistrarAnimal.setBounds(183, 168, 162, 23);
		contentPane.add(btnRegistrarAnimal);
		
		JButton btnRegistrarConsultas = new JButton("Registrar Consultas");
		btnRegistrarConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarConsul(e);
			}
		});
		btnRegistrarConsultas.setBounds(183, 392, 162, 23);
		contentPane.add(btnRegistrarConsultas);
		
		JButton btnRegistrarMedicinas = new JButton("Registrar Medicinas");
		btnRegistrarMedicinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarMedicina(e);
			}
		});
		btnRegistrarMedicinas.setBounds(357, 417, 162, 23);
		contentPane.add(btnRegistrarMedicinas);
		
		JButton btnConsultarVeterinario = new JButton("Consultar Veterinario");
		btnConsultarVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarVeterinario_mouseClicked(e);
			}
		});
		btnConsultarVeterinario.setBounds(10, 115, 162, 23);
		contentPane.add(btnConsultarVeterinario);
		
		JButton btnConsultarVeterinarioCon = new JButton("Consultar Veterinario con ID");
		btnConsultarVeterinarioCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultarVeterinarioCon_mouseClicked(e);
			}
		});
		btnConsultarVeterinarioCon.setBounds(314, 115, 194, 23);
		contentPane.add(btnConsultarVeterinarioCon);
		
		JButton btnConsultarExpedienteCon = new JButton("Consultar Expediente con Id paciente");
		btnConsultarExpedienteCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsulExpedienteIdPaciente(e);
			}
		});
		btnConsultarExpedienteCon.setBounds(0, 314, 251, 23);
		contentPane.add(btnConsultarExpedienteCon);
		
		JButton btnConsultarExpedienteCond = new JButton("Consultar Expediente cond Id expediente");
		btnConsultarExpedienteCond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsulPorIdExpediente(e);
			}
		});
		btnConsultarExpedienteCond.setBounds(271, 314, 290, 23);
		contentPane.add(btnConsultarExpedienteCond);
		
		JButton btnRegistrarExamenes = new JButton("Registrar examenes");
		btnRegistrarExamenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrarExamenes(e);
			}
		});
		btnRegistrarExamenes.setBounds(10, 417, 162, 23);
		contentPane.add(btnRegistrarExamenes);
		
		JButton btnBuscarConsultasDe = new JButton("Buscar consultas de un animal");
		btnBuscarConsultasDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsulAnimal(e);
			}
		});
		btnBuscarConsultasDe.setBounds(165, 235, 212, 23);
		contentPane.add(btnBuscarConsultasDe);
		
		JTextArea txtrBienvenidoALa = new JTextArea();
		txtrBienvenidoALa.setFont(new Font("Monospaced", Font.PLAIN, 21));
		txtrBienvenidoALa.setBackground(Color.GRAY);
		txtrBienvenidoALa.setEditable(false);
		txtrBienvenidoALa.setText("Bienvenido a la Clinica Veterinaria.");
		txtrBienvenidoALa.setBounds(10, 0, 459, 37);
		contentPane.add(txtrBienvenidoALa);
		
		JTextArea txtrVeterinario = new JTextArea();
		txtrVeterinario.setEditable(false);
		txtrVeterinario.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrVeterinario.setBackground(Color.GRAY);
		txtrVeterinario.setText("Veterinario");
		txtrVeterinario.setBounds(194, 48, 151, 20);
		contentPane.add(txtrVeterinario);
		
		JTextArea txtrAnimal = new JTextArea();
		txtrAnimal.setEditable(false);
		txtrAnimal.setBackground(Color.GRAY);
		txtrAnimal.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrAnimal.setText("Animal");
		txtrAnimal.setBounds(226, 137, 76, 20);
		contentPane.add(txtrAnimal);
		
		JTextArea txtrExpediente = new JTextArea();
		txtrExpediente.setEditable(false);
		txtrExpediente.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrExpediente.setBackground(Color.GRAY);
		txtrExpediente.setText("Expediente");
		txtrExpediente.setBounds(206, 269, 108, 25);
		contentPane.add(txtrExpediente);
		
		JTextArea txtrConsulta = new JTextArea();
		txtrConsulta.setEditable(false);
		txtrConsulta.setBackground(Color.GRAY);
		txtrConsulta.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrConsulta.setText("Consulta");
		txtrConsulta.setBounds(213, 354, 89, 20);
		contentPane.add(txtrConsulta);
		
		JTextArea txtrCitas = new JTextArea();
		txtrCitas.setFont(new Font("Monospaced", Font.PLAIN, 17));
		txtrCitas.setBackground(Color.GRAY);
		txtrCitas.setEditable(false);
		txtrCitas.setText("Citas");
		txtrCitas.setBounds(226, 449, 95, 20);
		contentPane.add(txtrCitas);
		
		JButton btnConsultarCitas = new JButton("Consultar Citas");
		btnConsultarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaCitasVeterinario p = new PantallaCitasVeterinario();
				p.setVisible(true);
			}
		});
		btnConsultarCitas.setBounds(30, 498, 136, 23);
		contentPane.add(btnConsultarCitas);
		
		JButton btnAnim = new JButton("Consultar animales de un veterinario");
		btnAnim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaConsulAnimVet p = new PantallaConsulAnimVet();
				p.setVisible(true);
			}
		});
		btnAnim.setBounds(326, 203, 235, 23);
		contentPane.add(btnAnim);
		
		JButton btnRegistrarCitas = new JButton("Administrar Citas");
		btnRegistrarCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaRegisCita p = new PantallaRegisCita();
				p.setVisible(true);
			}
		});
		btnRegistrarCitas.setBounds(194, 498, 134, 23);
		contentPane.add(btnRegistrarCitas);
	}
	/**
	 *
	 *
	 */	
	public void btnConsulAnimal(ActionEvent e){
		PantallaConsulConsultas p;
		p = new PantallaConsulConsultas();

	}
	/**
	 *
	 *
	 */	
	public void btnConsulExpedienteIdPaciente(ActionEvent e){
		PantallaConsulPorIdPaciente p;
		p = new PantallaConsulPorIdPaciente ();
	}
	/**
	 *
	 *
	 */	
	public void btnConsulPorIdExpediente(ActionEvent e){
		PantallaConsultarPorIdExpediente p;
		p = new PantallaConsultarPorIdExpediente();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarConsul(ActionEvent e){
		PantallaRegisConsulta p;
		p = new PantallaRegisConsulta();
		p.setVisible(true);
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarExamenes(ActionEvent e){
		PantallaRegisExamen p;
		p = new PantallaRegisExamen();
		p.setVisible(true);
	}
	/**
	 *
	 *
	 */	
	public void btnConsultarVeterinario_mouseClicked(ActionEvent e){
		PantallaConsultarVeterinario p;
		p = new PantallaConsultarVeterinario();
		
	}
	/**
	 *
	 *
	 */	
	public void btnConsultarVeterinarioCon_mouseClicked(ActionEvent e){
		PantallaConsultarVeterinarioID p;
		p = new PantallaConsultarVeterinarioID();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarAnimal(ActionEvent e){
		PantallaRegistrarAnimal p;
		p = new PantallaRegistrarAnimal();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarDueño(ActionEvent e){
		RegistrarDuennoAnimal p;
		p = new RegistrarDuennoAnimal();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrarMedicina(ActionEvent e){
		PantallaRegistrarMedicina p;
		p = new PantallaRegistrarMedicina();
	}
}
