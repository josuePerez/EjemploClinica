package CapaPresentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import CapaLogica.Gestor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRegistrarResul extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdExamen;
	private JTextField txtLugar;
	private JTextField txtFechEntrega;
	private JTextField txtDescrip;
	Gestor gestor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaRegistrarResul frame = new PantallaRegistrarResul();
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
	public PantallaRegistrarResul() {
		setTitle("Registrar Resultado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrIdExaem = new JTextArea();
		txtrIdExaem.setBackground(Color.GRAY);
		txtrIdExaem.setEditable(false);
		txtrIdExaem.setText("ID examen");
		txtrIdExaem.setBounds(10, 11, 89, 20);
		contentPane.add(txtrIdExaem);
		
		txtIdExamen = new JTextField();
		txtIdExamen.setBounds(175, 12, 176, 20);
		contentPane.add(txtIdExamen);
		txtIdExamen.setColumns(10);
		
		JTextArea txtrRealizadoEn = new JTextArea();
		txtrRealizadoEn.setBackground(Color.GRAY);
		txtrRealizadoEn.setEditable(false);
		txtrRealizadoEn.setText("Realizado en");
		txtrRealizadoEn.setBounds(10, 53, 109, 20);
		contentPane.add(txtrRealizadoEn);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(175, 54, 176, 20);
		contentPane.add(txtLugar);
		txtLugar.setColumns(10);
		
		JTextArea txtrFechaDeEntrega = new JTextArea();
		txtrFechaDeEntrega.setBackground(Color.GRAY);
		txtrFechaDeEntrega.setEditable(false);
		txtrFechaDeEntrega.setText("Fecha de entrega");
		txtrFechaDeEntrega.setBounds(10, 92, 136, 20);
		contentPane.add(txtrFechaDeEntrega);
		
		txtFechEntrega = new JTextField();
		txtFechEntrega.setBounds(175, 93, 176, 20);
		contentPane.add(txtFechEntrega);
		txtFechEntrega.setColumns(10);
		
		JTextArea txtrDescrip = new JTextArea();
		txtrDescrip.setBackground(Color.GRAY);
		txtrDescrip.setEditable(false);
		txtrDescrip.setText("Descripcion");
		txtrDescrip.setBounds(10, 132, 89, 20);
		contentPane.add(txtrDescrip);
		
		txtDescrip = new JTextField();
		txtDescrip.setBounds(10, 164, 422, 62);
		contentPane.add(txtDescrip);
		txtDescrip.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistrar_mouseClicked(e);
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrar.setBounds(20, 237, 118, 47);
		contentPane.add(btnRegistrar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver_mouseClicked(e);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVolver.setBounds(311, 237, 109, 47);
		contentPane.add(btnVolver);
		
		JButton btnRegistrarItem = new JButton("Registrar Item");
		btnRegistrarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegisItem p = new PantallaRegisItem();
				p.setVisible(true);
			}
		});
		btnRegistrarItem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegistrarItem.setBounds(157, 285, 143, 47);
		contentPane.add(btnRegistrarItem);
		
		gestor  = new Gestor();
	}
	
	public void btnRegistrar_mouseClicked(ActionEvent e){
		String idExamen, lugar, fecha, descrip;
		
		try{
			idExamen =	txtIdExamen.getText();
			lugar = txtLugar.getText();
			fecha = txtFechEntrega.getText();
			descrip = txtDescrip.getText();
			gestor.registrarResul(idExamen,lugar,fecha,descrip);
			JOptionPane.showMessageDialog(this,"El resultado ha sido agregado","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(this,(String) ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void btnVolver_mouseClicked(ActionEvent e){
		this.setVisible(false);
	}

}
