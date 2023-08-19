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

public class AdicionarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField Nif;
	private JTextField Nome;
	private JTextField Email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarCliente frame = new AdicionarCliente();
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
	public AdicionarCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		setTitle("Adicionar Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 29, 62, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNome.setBounds(10, 63, 62, 26);
		contentPane.add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(10, 99, 62, 26);
		contentPane.add(lblEmail);
		
		Nif = new JTextField();
		Nif.setBounds(65, 34, 201, 19);
		contentPane.add(Nif);
		Nif.setColumns(10);
		
		Nome = new JTextField();
		Nome.setBounds(65, 68, 201, 19);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(65, 99, 201, 19);
		contentPane.add(Email);
		Email.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nif = Nif.getText();
				String nome = Nome.getText();
				String email = Email.getText();
				String dados = nif + ";"+ nome + ";" + email;
				String mensagem=""; //para concatenar os erros
				
				int verifica=0; // verificar a existência do cliente
				
				if(nif.equals("")) {
					
					mensagem += " Preencha o Nif do Cliente !\n";
				}
				if(nome.equals("")) {
					
					mensagem += " Preencha o nome do Cliente !\n";
				}
				if(email.equals("")) {
					
					mensagem += " Preencha o email do Cliente !\n";
				}
				if(nif.length()>9) {
					
					mensagem += "O nif é inválido! \n Insira o nif com 9 dígitos !!\n";
				}
				if(nif.length()<9) {
					
					mensagem += "O nif é inválido! \n Insira o nif com 9 dígitos !!\n";
				}
				//verifica todas para salvar todas as informações
				if(nif.length()>9 ||nif.length()<9|| nif.equals("")|| nome.equals("") || email.equals("") ) {
					
				}
				else {
					
					Clientes novoClientes = new Clientes ();
					
					String separador = ";";
					
					String [] linha ;
					
					for( int i=0; i<novoClientes.novoCliente.size();i++) {
						
						linha =novoClientes.novoCliente.get(i).split(separador);
						
						
						if (nif.trim().equals(linha[0])) {
							
							verifica =1;
						}
					}
					
				
					if(verifica ==1) {
						JOptionPane.showMessageDialog(null, "O Cliente já existe! \n Insira um Cliente novo !!", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
						
					}
					
					else {
						
						novoClientes.AdicionarCliente(dados);
						Nome.setText("");
						Nif.setText("");
						Email.setText("");
						JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso !");
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
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(26, 159, 223, 21);
		contentPane.add(btnNewButton);
	}
}
