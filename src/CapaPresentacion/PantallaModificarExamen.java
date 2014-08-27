package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.JOptionPane;
import java.awt.SystemColor;

public class PantallaModificarExamen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtFechaRealiz;
	Gestor gestor;
	private JTextField txtIdConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaModificarExamen frame = new PantallaModificarExamen();
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
	public PantallaModificarExamen() {
		setTitle("Modificar examen");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrNombre = new JTextArea();
		txtrNombre.setBackground(Color.GRAY);
		txtrNombre.setEditable(false);
		txtrNombre.setText("Nombre");
		txtrNombre.setBounds(10, 11, 80, 20);
		contentPane.add(txtrNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(156, 12, 228, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea txtrFechaRealizacion = new JTextArea();
		txtrFechaRealizacion.setEditable(false);
		txtrFechaRealizacion.setBackground(Color.GRAY);
		txtrFechaRealizacion.setText("Fecha Realizacion");
		txtrFechaRealizacion.setBounds(10, 58, 149, 20);
		contentPane.add(txtrFechaRealizacion);
		
		txtFechaRealiz = new JTextField();
		txtFechaRealiz.setBounds(192, 59, 206, 20);
		contentPane.add(txtFechaRealiz);
		txtFechaRealiz.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificar_mouseClicked(e);
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnModificar.setBounds(81, 164, 127, 58);
		contentPane.add(btnModificar);
		
		JTextArea txtrIdconsulta = new JTextArea();
		txtrIdconsulta.setEditable(false);
		txtrIdconsulta.setBackground(Color.GRAY);
		txtrIdconsulta.setText("IdConsulta");
		txtrIdconsulta.setBounds(10, 108, 96, 20);
		contentPane.add(txtrIdconsulta);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(164, 109, 220, 20);
		contentPane.add(txtIdConsulta);
		txtIdConsulta.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(261, 164, 123, 58);
		contentPane.add(btnVolver);
		
		gestor = new Gestor();
	}
	/**
	 *
	 *
	 */	
	public void btnModificar_mouseClicked(ActionEvent e){
		String nombre, fechaRealiz, idConsulta;
		try{
			nombre = txtNombre.getText();
			fechaRealiz =txtFechaRealiz.getText();
			idConsulta = txtIdConsulta.getText();
			gestor.modificarExamen(nombre, fechaRealiz, idConsulta);
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
