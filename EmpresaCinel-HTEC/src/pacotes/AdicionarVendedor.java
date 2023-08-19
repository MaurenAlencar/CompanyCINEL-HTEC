package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdicionarVendedor extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	private JTextField Nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarVendedor frame = new AdicionarVendedor();
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
	public AdicionarVendedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		setTitle("Adicionar Vendendores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 255);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblId.setBounds(10, 28, 62, 26);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setColumns(10);
		Id.setBounds(65, 33, 201, 19);
		contentPane.add(Id);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNome.setBounds(10, 64, 62, 26);
		contentPane.add(lblNome);
		
		Nome = new JTextField();
		Nome.setColumns(10);
		Nome.setBounds(65, 69, 201, 19);
		contentPane.add(Nome);
		
		JButton btnNewButton = new JButton("Adicionar Vendedor");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String id = Id.getText();
				String nome = Nome.getText();
				
				String dados = id + ";"+ nome;
				
				String mensagem=""; //para concatenar os erros
				
				int verifica=0; // verificar a existência do vendedor
				
				
				if(nome.equals("")) {
					
					mensagem += " Preencha o nome do Vendedor !\n";
				}
				if (id.equals("")) {
					
					mensagem += " Preencha o Id do Vendedor !\n";
				}
				if(nome.equals("")||id.equals("")) {
					
				}
				else {
					
					Vendedores novoVendedor = new Vendedores ();
					String separador = ";";
					
					String [] linha ;
					
					for( int i=0; i<novoVendedor.novoVendedor.size();i++) {
						
						linha =novoVendedor.novoVendedor.get(i).split(separador);
						if (id.equals(linha[0])) {
							
							verifica =1;
						}
					}
					if(verifica ==1) {
						JOptionPane.showMessageDialog(null, "O Vendedor já existe! \n Insira um Vendedor novo !!", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						
						
						novoVendedor.AdicionarVendedor(dados);
						Nome.setText("");
						Id.setText("");
						
						JOptionPane.showMessageDialog(null, "Vendedor inserido com sucesso !");
					}
					
					
				}
				
				
				//verifica se existe mensagens de erro
				if(mensagem.equals("")) {
					
				}
				//imprimi as mensagens
				else {
					
					JOptionPane.showMessageDialog(null, mensagem, "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(33, 134, 233, 37);
		contentPane.add(btnNewButton);
	}

}
