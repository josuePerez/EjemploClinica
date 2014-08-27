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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegisItem extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdItem;
	private JTextField txtIdResul;
	private JTextField txtNombre;
	private JTextField txtValor;
	private JTextField txtUnidadMed;
	private JTextField txtLimiteInfe;
	private JTextField txtLimiteSup;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegisItem frame = new PantallaRegisItem();
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
	public PantallaRegisItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdentificacion = new JTextArea();
		txtrIdentificacion.setBackground(Color.GRAY);
		txtrIdentificacion.setEditable(false);
		txtrIdentificacion.setText("Identificacion");
		txtrIdentificacion.setBounds(10, 11, 130, 20);
		contentPane.add(txtrIdentificacion);
		
		txtIdItem = new JTextField();
		txtIdItem.setBounds(150, 12, 216, 20);
		contentPane.add(txtIdItem);
		txtIdItem.setColumns(10);
		
		JTextArea txtrIdResultado = new JTextArea();
		txtrIdResultado.setBackground(Color.GRAY);
		txtrIdResultado.setEditable(false);
		txtrIdResultado.setText("ID Resultado");
		txtrIdResultado.setBounds(10, 52, 130, 20);
		contentPane.add(txtrIdResultado);
		
		txtIdResul = new JTextField();
		txtIdResul.setBounds(150, 53, 216, 20);
		contentPane.add(txtIdResul);
		txtIdResul.setColumns(10);
		
		JTextArea txtrNombreItem = new JTextArea();
		txtrNombreItem.setBackground(Color.GRAY);
		txtrNombreItem.setEditable(false);
		txtrNombreItem.setText("Nombre item");
		txtrNombreItem.setBounds(10, 92, 116, 20);
		contentPane.add(txtrNombreItem);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, 93, 216, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JTextArea txtrValor = new JTextArea();
		txtrValor.setBackground(Color.GRAY);
		txtrValor.setEditable(false);
		txtrValor.setText("Valor");
		txtrValor.setBounds(10, 133, 91, 20);
		contentPane.add(txtrValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(150, 134, 216, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JTextArea txtrUnidadMedicion = new JTextArea();
		txtrUnidadMedicion.setBackground(Color.GRAY);
		txtrUnidadMedicion.setEditable(false);
		txtrUnidadMedicion.setText("Unidad Medicion");
		txtrUnidadMedicion.setBounds(10, 177, 122, 20);
		contentPane.add(txtrUnidadMedicion);
		
		txtUnidadMed = new JTextField();
		txtUnidadMed.setBounds(150, 178, 216, 20);
		contentPane.add(txtUnidadMed);
		txtUnidadMed.setColumns(10);
		
		JTextArea txtrLimiteInferior = new JTextArea();
		txtrLimiteInferior.setBackground(Color.GRAY);
		txtrLimiteInferior.setEditable(false);
		txtrLimiteInferior.setText("Limite Inferior ");
		txtrLimiteInferior.setBounds(10, 222, 122, 20);
		contentPane.add(txtrLimiteInferior);
		
		txtLimiteInfe = new JTextField();
		txtLimiteInfe.setBounds(150, 223, 216, 20);
		contentPane.add(txtLimiteInfe);
		txtLimiteInfe.setColumns(10);
		
		JTextArea txtrLimiteSuperior = new JTextArea();
		txtrLimiteSuperior.setBackground(Color.GRAY);
		txtrLimiteSuperior.setEnabled(true);
		txtrLimiteSuperior.setEditable(false);
		txtrLimiteSuperior.setText("Limite Superior");
		txtrLimiteSuperior.setBounds(10, 265, 130, 20);
		contentPane.add(txtrLimiteSuperior);
		
		txtLimiteSup = new JTextField();
		txtLimiteSup.setBounds(150, 266, 216, 20);
		contentPane.add(txtLimiteSup);
		txtLimiteSup.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setBounds(49, 334, 91, 44);
		contentPane.add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setBounds(257, 334, 91, 44);
		contentPane.add(btnVolver);
	}
	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		gestor = new Gestor();
		String pid, pidResul,  pnombre,  pvalor,  punidadMedm;
		double plimiteInfe, plimiteSup;

		try {
			pid = txtIdItem.getText();
			pidResul = txtIdResul.getText();
			pnombre = txtNombre.getText();
			pvalor = txtValor.getText();
			punidadMedm = txtUnidadMed.getText();
			plimiteInfe = Double.parseDouble(txtLimiteInfe.getText());
			plimiteSup = Double.parseDouble(txtLimiteSup.getText());
			gestor.RegistrarItem(pid, pidResul,  pnombre,  pvalor,  punidadMedm,plimiteInfe, plimiteSup);
			JOptionPane.showMessageDialog(this,"El item ha sido agregado","Informacion",JOptionPane.INFORMATION_MESSAGE);			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}
}
