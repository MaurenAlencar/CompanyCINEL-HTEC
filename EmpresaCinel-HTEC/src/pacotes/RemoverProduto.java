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

public class RemoverProduto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoverProduto frame = new RemoverProduto();
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
	public RemoverProduto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		
		JComboBox comboBox = new JComboBox();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				//inserir a designação do Produto
				comboBox.removeAllItems();
				comboBox.addItem("Escolha um Produto");
				
				Produtos insereCodigo= new Produtos();
				String separador= ";";
				String [] linhaDadosProdutos ;
				
				for( int i=0; i<insereCodigo.novoProduto.size();i++) {
					
					linhaDadosProdutos =insereCodigo.novoProduto.get(i).split(separador);
					comboBox.addItem(linhaDadosProdutos[3]);
				}
				
				
			}
		});
		setTitle("Remover Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(253, 64, 97));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRemoverProduto = new JLabel("Remover Produto");
		lblRemoverProduto.setForeground(new Color(255, 255, 255));
		lblRemoverProduto.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRemoverProduto.setBounds(109, 32, 169, 38);
		contentPane.add(lblRemoverProduto);
		
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(84, 82, 221, 31);
		contentPane.add(comboBox);
		
		JButton btnRemoverProduto = new JButton("Remover Produto");
		btnRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedIndex()==0) {
					
					 JOptionPane.showMessageDialog(null, " Selecione o Produto a remover !!");
					
				}
				else {
					
					Produtos remover = new Produtos();
					int posicao= comboBox.getSelectedIndex();
					
					remover.RemoverProduto(posicao);
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso !!");
					
		
					comboBox.addItem("Escolha um Produto");
					
					Produtos insereProdutos= new Produtos();
					
					
					for (int i=0; i<insereProdutos.novoProduto.size();i++) {
						
						
						comboBox.addItem(insereProdutos.novoProduto.get(i));
						
						
					}
				
					
				}
				
				
			}
		});
		btnRemoverProduto.setForeground(Color.WHITE);
		btnRemoverProduto.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRemoverProduto.setBackground(new Color(128, 0, 0));
		btnRemoverProduto.setBounds(88, 150, 209, 38);
		contentPane.add(btnRemoverProduto);
	}

}
