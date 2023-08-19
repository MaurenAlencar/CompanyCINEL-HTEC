package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class AtualizaClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizaClientes frame = new AtualizaClientes();
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
	public AtualizaClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		
		JComboBox comboBox = new JComboBox();
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				comboBox.removeAllItems();
				
				
				comboBox.addItem("Escolha o Nif do Cliente");
				
				Clientes insereCliente= new Clientes();
				String separador = ";";
				
				String [] linhaDadosClientes ;
				
				
				for (int i=0; i<insereCliente.novoCliente.size();i++) {
					
					linhaDadosClientes =insereCliente.novoCliente.get(i).split(separador);
					comboBox.addItem(linhaDadosClientes[0]);
					
					
				}
			}
		});
		setType(Type.UTILITY);
		setTitle("Atualizar Dados Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 366, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NIF");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 34, 62, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNome.setBounds(10, 115, 62, 26);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(65, 120, 201, 19);
		contentPane.add(textFieldNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(10, 151, 62, 26);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(65, 156, 201, 19);
		contentPane.add(textFieldEmail);
		
		
		comboBox.setBounds(67, 38, 199, 21);
		contentPane.add(comboBox);
		
		JLabel lblDigiteOsDados = new JLabel("Digite os novos Dados do Cliente");
		lblDigiteOsDados.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDigiteOsDados.setBounds(39, 79, 259, 26);
		contentPane.add(lblDigiteOsDados);
		
		JButton btnNewButton = new JButton("Atualizar Dados do Cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String novoNome = textFieldNome.getText();
				String novoEmail= textFieldEmail.getText();
				String mensagem=""; //para concatenar os erros
				
				
				if(novoNome.equals("")) {
					
					mensagem+= "Preencha a novo Nome!";
				}	
				
				if(novoEmail.equals("")) {
					
					mensagem+= "Preencha o novo Email !";
				}
				if (comboBox.getSelectedIndex()==0) {
					
					mensagem+= "Preencha o Nif do Cliente que deseja atualizar o dados !";
					
				}
				if (comboBox.getSelectedIndex()==0 || novoNome.equals("") ||novoEmail.equals("") ){
					
				
				}				
				else {
					//atualiza o dados do Cliente conforme o nif selecionado e novos dados inseridos nos textField
					String [] linhaClienteEscolhido ;
					String separador =";";
					int novaQuantidade=0;
					
					Clientes clienteEscolhido= new Clientes();
						linhaClienteEscolhido =clienteEscolhido.novoCliente.get(comboBox.getSelectedIndex()-1).split(separador);
						
						String novoDado = linhaClienteEscolhido[0] + ";" + textFieldNome.getText()+ ";" + textFieldEmail.getText();
						clienteEscolhido.AtualizaDadosCliente(comboBox.getSelectedIndex()-1, novoDado);
						
						
						JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso ! !","Empresa CINEL-HTEC",JOptionPane.INFORMATION_MESSAGE);
						comboBox.setSelectedIndex(0);
						textFieldNome.setText("");
						textFieldEmail.setText("");
					
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
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(10, 199, 288, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblSelecioneONif = new JLabel("Selecione o Nif do Cliente");
		lblSelecioneONif.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSelecioneONif.setBounds(65, 10, 259, 26);
		contentPane.add(lblSelecioneONif);
	}
}
