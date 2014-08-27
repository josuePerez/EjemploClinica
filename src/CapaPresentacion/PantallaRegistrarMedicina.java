package CapaPresentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import CapaLogica.Gestor;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JEditorPane;

public class PantallaRegistrarMedicina {

	private JFrame frmRegistrarMedicina;
	private JTextField txtNombre;
	private JTextField txtDosis;
	private JTextField txtNumDia;
	private JTextField txtIdConsulta;
	Gestor gestor;
	private JTextField txtFechaInicio;
	private JTextField txtFechaFinal;
	private JTextField txtPrecauciones;


	/**
	 * Create the application.
	 */
	public PantallaRegistrarMedicina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarMedicina = new JFrame();
		frmRegistrarMedicina.getContentPane().setBackground(Color.GRAY);
		frmRegistrarMedicina.setTitle("Registrar Medicina");
		frmRegistrarMedicina.setBackground(SystemColor.inactiveCaption);
		frmRegistrarMedicina.setBounds(100, 100, 450, 466);
		frmRegistrarMedicina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarMedicina.getContentPane().setLayout(null);
		frmRegistrarMedicina.setVisible(true);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 23, 89, 14);
		frmRegistrarMedicina.getContentPane().add(lblNombre);
		
		JLabel lblDosis = new JLabel("Dosis");
		lblDosis.setBounds(10, 58, 89, 14);
		frmRegistrarMedicina.getContentPane().add(lblDosis);
		
		JLabel lblNumeroDeDias = new JLabel("Numero de dias");
		lblNumeroDeDias.setBounds(10, 83, 111, 14);
		frmRegistrarMedicina.getContentPane().add(lblNumeroDeDias);
		
		JLabel lblIdconsulta = new JLabel("IdConsulta");
		lblIdconsulta.setBounds(10, 118, 89, 14);
		frmRegistrarMedicina.getContentPane().add(lblIdconsulta);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(109, 20, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDosis = new JTextField();
		txtDosis.setBounds(109, 55, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtDosis);
		txtDosis.setColumns(10);
		
		txtNumDia = new JTextField();
		txtNumDia.setBounds(109, 80, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtNumDia);
		txtNumDia.setColumns(10);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(109, 115, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtIdConsulta);
		txtIdConsulta.setColumns(10);
		
		JButton btnRegistar = new JButton("Registar");
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor= new Gestor();
				String nombre, dosis,numDias, idConsulta, fechaInicio, fechaFinal, precauciones;
				
				try{
					nombre = txtNombre.getText();
					dosis = txtDosis.getText();
					numDias = txtNumDia.getText();
					idConsulta = txtIdConsulta.getText();
					fechaInicio = txtFechaInicio.getText();
					fechaFinal = txtFechaFinal.getText();
					precauciones = txtPrecauciones.getText();
					gestor.RegistrarMedicina(nombre, dosis, numDias, idConsulta,fechaInicio, fechaFinal, precauciones);
					JOptionPane.showMessageDialog(null,"La medicina ha sido registrada", "Informacion",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnRegistar.setBounds(44, 381, 89, 23);
		frmRegistrarMedicina.getContentPane().add(btnRegistar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistrarMedicina.setVisible(false);
			}
		});
		btnVolver.setBounds(260, 381, 89, 23);
		frmRegistrarMedicina.getContentPane().add(btnVolver);
		
		JTextArea txtrFechaInicioTratamiento = new JTextArea();
		txtrFechaInicioTratamiento.setEditable(false);
		txtrFechaInicioTratamiento.setBackground(Color.GRAY);
		txtrFechaInicioTratamiento.setText("Fecha Inicio tratamiento");
		txtrFechaInicioTratamiento.setBounds(10, 167, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtrFechaInicioTratamiento);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(225, 168, 207, 20);
		frmRegistrarMedicina.getContentPane().add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		JTextArea txtrFechaFinalTratamiento = new JTextArea();
		txtrFechaFinalTratamiento.setBackground(Color.GRAY);
		txtrFechaFinalTratamiento.setEditable(false);
		txtrFechaFinalTratamiento.setText("Fecha final tratamiento");
		txtrFechaFinalTratamiento.setBounds(10, 214, 192, 20);
		frmRegistrarMedicina.getContentPane().add(txtrFechaFinalTratamiento);
		
		txtFechaFinal = new JTextField();
		txtFechaFinal.setBounds(225, 215, 207, 20);
		frmRegistrarMedicina.getContentPane().add(txtFechaFinal);
		txtFechaFinal.setColumns(10);
		
		JTextArea txtrPrecauciones = new JTextArea();
		txtrPrecauciones.setBackground(Color.GRAY);
		txtrPrecauciones.setEditable(false);
		txtrPrecauciones.setText("Precauciones");
		txtrPrecauciones.setBounds(10, 257, 111, 20);
		frmRegistrarMedicina.getContentPane().add(txtrPrecauciones);
		
		txtPrecauciones = new JTextField();
		txtPrecauciones.setBounds(10, 284, 422, 70);
		frmRegistrarMedicina.getContentPane().add(txtPrecauciones);
		txtPrecauciones.setColumns(10);
	}
}
