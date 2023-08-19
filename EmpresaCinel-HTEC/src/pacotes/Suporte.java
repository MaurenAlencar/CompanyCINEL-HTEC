package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suporte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suporte frame = new Suporte();
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
	public Suporte() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-technical-support-20.png"));
		setTitle("Suporte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(33, 46, 98, 26);
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblEmail);
		
		JLabel lblMaurencinelpt = new JLabel("maurenrenata@icloud.com");
		lblMaurencinelpt.setBounds(101, 46, 193, 26);
		lblMaurencinelpt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblMaurencinelpt);
		
		JLabel lblTlm = new JLabel("Tlm:");
		lblTlm.setBounds(33, 71, 98, 26);
		lblTlm.setForeground(Color.WHITE);
		lblTlm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblTlm);
		
		JLabel lblMaurencinelpt_1 = new JLabel("+351 1111-1111");
		lblMaurencinelpt_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMaurencinelpt_1.setBounds(101, 71, 136, 26);
		contentPane.add(lblMaurencinelpt_1);
		
		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setForeground(Color.WHITE);
		lblContactos.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContactos.setBounds(10, 10, 98, 26);
		contentPane.add(lblContactos);
		
		
	}

}
