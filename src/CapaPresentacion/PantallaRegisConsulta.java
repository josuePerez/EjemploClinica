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

public class PantallaRegisConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdVeterinario;
	private JTextField txtIdExpediente;
	private JTextField txtFechaConsul;
	Gestor gestor;
	private JTextArea txtDescrip;
	private JTextField txtIdConsulta;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtLongEspal;
	private JTextField txtLongPecho;
	private JTextField txtDiaCuello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegisConsulta frame = new PantallaRegisConsulta();
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
	public PantallaRegisConsulta() {
		setTitle("Registrar Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdVeterinario = new JTextArea();
		txtrIdVeterinario.setBackground(Color.GRAY);
		txtrIdVeterinario.setEditable(false);
		txtrIdVeterinario.setText("ID Veterinario");
		txtrIdVeterinario.setBounds(10, 11, 123, 20);
		contentPane.add(txtrIdVeterinario);
		
		txtIdVeterinario = new JTextField();
		txtIdVeterinario.setBounds(218, 12, 172, 20);
		contentPane.add(txtIdVeterinario);
		txtIdVeterinario.setColumns(10);
		
		JTextArea txtrIdExpediente = new JTextArea();
		txtrIdExpediente.setBackground(Color.GRAY);
		txtrIdExpediente.setEditable(false);
		txtrIdExpediente.setText("ID Expediente");
		txtrIdExpediente.setBounds(10, 55, 123, 20);
		contentPane.add(txtrIdExpediente);
		
		txtIdExpediente = new JTextField();
		txtIdExpediente.setBounds(218, 56, 172, 20);
		contentPane.add(txtIdExpediente);
		txtIdExpediente.setColumns(10);
		
		JTextArea txtrFechaConsulta = new JTextArea();
		txtrFechaConsulta.setBackground(Color.GRAY);
		txtrFechaConsulta.setEditable(false);
		txtrFechaConsulta.setText("Fecha Consulta");
		txtrFechaConsulta.setBounds(10, 125, 123, 20);
		contentPane.add(txtrFechaConsulta);
		
		txtFechaConsul = new JTextField();
		txtFechaConsul.setBounds(218, 126, 172, 20);
		contentPane.add(txtFechaConsul);
		txtFechaConsul.setColumns(10);
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setBackground(Color.GRAY);
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setText("Descripcion");
		txtrDescripcion.setBounds(10, 338, 123, 20);
		contentPane.add(txtrDescripcion);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnRegistrar.setBounds(10, 570, 172, 62);
		contentPane.add(btnRegistrar);
		
		txtDescrip = new JTextArea();
		txtDescrip.setBounds(10, 392, 422, 123);
		contentPane.add(txtDescrip);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVolver.setBounds(268, 570, 111, 62);
		contentPane.add(btnVolver);
		
		JTextArea txtrIdConsulta = new JTextArea();
		txtrIdConsulta.setEditable(false);
		txtrIdConsulta.setBackground(Color.GRAY);
		txtrIdConsulta.setText("ID Consulta");
		txtrIdConsulta.setBounds(10, 96, 111, 20);
		contentPane.add(txtrIdConsulta);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(218, 95, 172, 20);
		contentPane.add(txtIdConsulta);
		txtIdConsulta.setColumns(10);
		
		JTextArea txtrPeso = new JTextArea();
		txtrPeso.setBackground(Color.GRAY);
		txtrPeso.setText("Peso");
		txtrPeso.setBounds(10, 156, 59, 20);
		contentPane.add(txtrPeso);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(218, 157, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JTextArea txtrAltura = new JTextArea();
		txtrAltura.setBackground(Color.GRAY);
		txtrAltura.setText("Altura");
		txtrAltura.setBounds(10, 187, 59, 20);
		contentPane.add(txtrAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(218, 188, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JTextArea txtrLongitudDelPecho = new JTextArea();
		txtrLongitudDelPecho.setBackground(Color.GRAY);
		txtrLongitudDelPecho.setText("Longitud de la espalda");
		txtrLongitudDelPecho.setBounds(10, 218, 178, 20);
		contentPane.add(txtrLongitudDelPecho);
		
		txtLongEspal = new JTextField();
		txtLongEspal.setBounds(218, 219, 123, 20);
		contentPane.add(txtLongEspal);
		txtLongEspal.setColumns(10);
		
		JTextArea txtrLongitudDelPecho_1 = new JTextArea();
		txtrLongitudDelPecho_1.setBackground(Color.GRAY);
		txtrLongitudDelPecho_1.setText("Longitud del pecho");
		txtrLongitudDelPecho_1.setBounds(10, 249, 146, 20);
		contentPane.add(txtrLongitudDelPecho_1);
		
		txtLongPecho = new JTextField();
		txtLongPecho.setBounds(218, 250, 86, 20);
		contentPane.add(txtLongPecho);
		txtLongPecho.setColumns(10);
		
		JTextArea txtrDiametroDelCuello = new JTextArea();
		txtrDiametroDelCuello.setBackground(Color.GRAY);
		txtrDiametroDelCuello.setText("Diametro del cuello");
		txtrDiametroDelCuello.setBounds(10, 280, 154, 20);
		contentPane.add(txtrDiametroDelCuello);
		
		txtDiaCuello = new JTextField();
		txtDiaCuello.setBounds(218, 281, 86, 20);
		contentPane.add(txtDiaCuello);
		txtDiaCuello.setColumns(10);
		
		gestor = new Gestor();
	}
	/**
	 *
	 *
	 */	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		String idConsulta, idVeterinario, idExpediente, fechaConsul, descrip, peso, longEspal, longPecho, diaCuello, altura;

		try {
			idConsulta = txtIdConsulta.getText();
			idVeterinario = txtIdVeterinario.getText();
			idExpediente = txtIdExpediente.getText();
			fechaConsul = txtFechaConsul.getText();
			descrip = txtDescrip.getText();
			peso = txtPeso.getText();
			altura = txtAltura.getText();
			longEspal = txtLongEspal.getText();
			longPecho = txtLongPecho.getText();
			diaCuello = txtDiaCuello.getText();
			
			gestor.registrarConsulta(idConsulta, idVeterinario, fechaConsul, descrip, idExpediente, peso,altura, longEspal, longPecho,diaCuello );
			JOptionPane.showMessageDialog(this,"La consulta ha sido agregada","Informacion",JOptionPane.INFORMATION_MESSAGE);			
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
