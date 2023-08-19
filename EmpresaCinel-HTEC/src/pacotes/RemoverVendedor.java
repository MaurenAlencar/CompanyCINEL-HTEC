package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class RemoverVendedor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverVendedor frame = new RemoverVendedor();
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
	public RemoverVendedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		
		
		JComboBox comboBox = new JComboBox();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				//inserir nome Vendedor
				comboBox.removeAllItems();
				comboBox.addItem("Escolha um Vendedor");
				
				Vendedores insereVendedor= new Vendedores();
				String separador = ";";
				
				String [] linhaDadosVendedores ;
				
				for (int i=0; i<insereVendedor.novoVendedor.size();i++) {
					
					linhaDadosVendedores =insereVendedor.novoVendedor.get(i).split(separador);
					comboBox.addItem(linhaDadosVendedores[1]);
				
				}
				
			}
		});
		setTitle("Remover Vendedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 64, 97));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverVendedor = new JLabel("Remover Vendedor");
		lblRemoverVendedor.setForeground(new Color(255, 255, 255));
		lblRemoverVendedor.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRemoverVendedor.setBounds(76, 28, 169, 38);
		contentPane.add(lblRemoverVendedor);
		
		
		
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(48, 76, 221, 31);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Remover Vendedor");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				if (comboBox.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, " Selecione o Vendedor a remover !!");
					
					
				}
				else {
					Vendedores remover = new Vendedores();
					int posicao= comboBox.getSelectedIndex();
					
					remover.RemoverVendedor(posicao);
					JOptionPane.showMessageDialog(null, "Vendedor removido com sucesso !!");
					
		
					comboBox.addItem("Escolha um Vendedor");
					
					Vendedores insereVendedor= new Vendedores();
					
					
					for (int i=0; i<insereVendedor.novoVendedor.size();i++) {
						
						
						comboBox.addItem(insereVendedor.novoVendedor.get(i));
						
						
					}
					 
				}
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(52, 144, 209, 38);
		contentPane.add(btnNewButton);
	}
}
