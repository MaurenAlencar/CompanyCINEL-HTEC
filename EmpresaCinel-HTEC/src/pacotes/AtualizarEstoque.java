package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Toolkit;

public class AtualizarEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblCdigoDoProduto;
	private JComboBox comboBox;
	private JLabel lblQuantidade;
	private JTextField textFieldQuantidade;
	private JTextField textFieldValor;
	private JTextField textFieldDesig;
	private JLabel lblDigiteOsNovos;
	private JLabel lblSelecioneOCdigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarEstoque frame = new AtualizarEstoque();
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
	public AtualizarEstoque() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-refresh-50.png"));
		

		DefaultTableModel tabela = new DefaultTableModel ();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				tabela.setRowCount(0);
				
				Produtos aux = new Produtos ();
				
				String separador = ";";
				
				String [] linha ;
				
				
				
				for(int i=0; i<aux.novoProduto.size(); i++) {
					
					
					linha = aux.novoProduto.get(i).split(separador);
							
						tabela.addRow(linha);

				}
				
				//inserir o código do Produto
				comboBox.removeAllItems();
				comboBox.addItem("Escolha um Produto");
				
				Produtos insereCodigo= new Produtos();
				String [] linhaDadosProdutos ;
				
				for( int i=0; i<insereCodigo.novoProduto.size();i++) {
					
					linhaDadosProdutos =insereCodigo.novoProduto.get(i).split(separador);
					comboBox.addItem(linhaDadosProdutos[0]);
				}
				
				
			}
		});
		setTitle("Atualizar Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 925, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 880, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String [] colunas ={"Código","Quantidade", "Valor","Designação do Produto"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("Atualizar Estoque");
		btnNewButton.setBackground(new Color(64, 0, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String novaQuantidade = textFieldQuantidade.getText();
				String novoValor= textFieldValor.getText();
				String novaDesig = textFieldDesig.getText();
				String mensagem=""; //para concatenar os erros
				
				if(novaQuantidade.equals("")) {
					
					mensagem+= "Preencha a nova quantidade !";
				}
				if(novoValor.equals("")) {
					
					mensagem+= "Preencha a novo Valor!";
				}	
				
				if(novaDesig.equals("")) {
					
					mensagem+= "Preencha a nova Designação !";
				}
				if (comboBox.getSelectedIndex()==0) {
					
					mensagem+= "Preencha o Código do Produto que deseja atualizar o dados !";
					
				}
				if (comboBox.getSelectedIndex()==0 || novaQuantidade.equals("") ||novoValor.equals("") ||novaDesig.equals("") ){
					
				
				}
				
				else {
					
					//atualiza dados do estoque
					String [] linhaProdutoEscolhido ;
					String separador=";";
					
					Produtos codigoEscolhido= new Produtos();
					
						linhaProdutoEscolhido =codigoEscolhido.novoProduto.get(comboBox.getSelectedIndex()-1).split(separador);
						
							String novoDado = linhaProdutoEscolhido[0] + ";" + novaQuantidade + ";" + novoValor +";" + novaDesig;
							codigoEscolhido.AtualizaEstoque(comboBox.getSelectedIndex()-1, novoDado);
							
							JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso ! !","Empresa CINEL-HTEC",JOptionPane.INFORMATION_MESSAGE);
							comboBox.setSelectedIndex(0);
							textFieldQuantidade.setText("");
							textFieldValor.setText("");
							textFieldDesig.setText("");
				
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
		btnNewButton.setBounds(193, 449, 517, 47);
		contentPane.add(btnNewButton);
		
		lblCdigoDoProduto = new JLabel("Código do Produto");
		lblCdigoDoProduto.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCdigoDoProduto.setBounds(30, 298, 135, 26);
		contentPane.add(lblCdigoDoProduto);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setBounds(175, 301, 212, 21);
		contentPane.add(comboBox);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuantidade.setBounds(28, 386, 98, 26);
		contentPane.add(lblQuantidade);
		
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textFieldQuantidade.setBounds(136, 389, 119, 19);
		contentPane.add(textFieldQuantidade);
		textFieldQuantidade.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblValor.setBounds(302, 386, 62, 26);
		contentPane.add(lblValor);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(350, 391, 119, 19);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		JLabel lblDesignao = new JLabel("Designação");
		lblDesignao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDesignao.setBounds(511, 386, 98, 26);
		contentPane.add(lblDesignao);
		
		textFieldDesig = new JTextField();
		textFieldDesig.setFont(new Font("Times New Roman", Font.BOLD, 10));
		textFieldDesig.setBounds(598, 391, 288, 19);
		contentPane.add(textFieldDesig);
		textFieldDesig.setColumns(10);
		
		lblDigiteOsNovos = new JLabel("Digite os novos Dados do Produto");
		lblDigiteOsNovos.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDigiteOsNovos.setBounds(243, 333, 366, 26);
		contentPane.add(lblDigiteOsNovos);
		
		lblSelecioneOCdigo = new JLabel("Selecione o Código do Produto");
		lblSelecioneOCdigo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSelecioneOCdigo.setBounds(162, 270, 259, 26);
		contentPane.add(lblSelecioneOCdigo);
		
	}
}
