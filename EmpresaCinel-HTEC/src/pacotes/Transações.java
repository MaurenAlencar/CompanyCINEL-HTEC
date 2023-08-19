package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class Transações extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNif;
	private JTextField textFieldValorPagar;
	private JTextField textFieldDesig;
	private JTextField textFieldPreco;
	int aux=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transações frame = new Transações();
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
	public Transações() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\pagamento-online.png"));
		
		JComboBox comboBoxVendedor = new JComboBox();
		JComboBox comboBoxCodigo = new JComboBox();
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				//verifica a quantidade inserida
				//preenche o preço conforme a quantidade inserida ou "alterada"
				String [] linhaProdutoEscolhido ;
				String separador=";";
				int quantidadeInserida= Integer.parseInt(spinner.getValue().toString());
				int novaQuantidade=0;
				
				Produtos codigoEscolhido= new Produtos();
				
					linhaProdutoEscolhido =codigoEscolhido.novoProduto.get(comboBoxCodigo.getSelectedIndex()-1).split(separador);
					if(quantidadeInserida<=(Integer.parseInt(linhaProdutoEscolhido[1]))) {
						aux=1;
						
					}
					else {
						aux=2;
					}
					Double valorPagar = quantidadeInserida * Double.parseDouble(linhaProdutoEscolhido[2]);
					textFieldValorPagar.setText(valorPagar.toString());
					
				//JOptionPane.showMessageDialog(null, quantidadeInserida);
				//JOptionPane.showMessageDialog(null, linhaProdutoEscolhido[1]);
				
			}
		});
		
		comboBoxCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				//verifica qual o código inserido, para depois preencher os textField
				
				String produtoEscolhido= comboBoxCodigo.getSelectedItem().toString();
				String [] linhaDadosProdutos ;
				String separador = ";";
				int quantidadeInserida= Integer.parseInt(spinner.getValue().toString());
				
				Produtos codigoEscolhido= new Produtos();
									
				for( int i=0; i<codigoEscolhido.novoProduto.size();i++) {
					
					linhaDadosProdutos =codigoEscolhido.novoProduto.get(i).split(separador);
					if (produtoEscolhido.equals(linhaDadosProdutos[0])) {
						
						textFieldDesig.setText(linhaDadosProdutos[3]);
						textFieldPreco.setText(linhaDadosProdutos[2]);
					}
				
				}
				
			}
		});
		
			
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				//inserir nome Vendedor
				comboBoxVendedor.removeAllItems();
				comboBoxVendedor.addItem("Escolha um Vendedor");
				
				Vendedores insereVendedor= new Vendedores();
				String separador = ";";
				
				String [] linhaDadosVendedores ;
				
				for (int i=0; i<insereVendedor.novoVendedor.size();i++) {
					
					linhaDadosVendedores =insereVendedor.novoVendedor.get(i).split(separador);
					comboBoxVendedor.addItem(linhaDadosVendedores[1]);
				
				}
				
				
				//inserir o Código
				comboBoxCodigo.removeAllItems();
				comboBoxCodigo.addItem("Escolha o Código do Produto");
				
				Produtos insereCodigo= new Produtos();
				String [] linhaDadosProdutos ;
				
				for( int i=0; i<insereCodigo.novoProduto.size();i++) {
					
					linhaDadosProdutos =insereCodigo.novoProduto.get(i).split(separador);
					comboBoxCodigo.addItem(linhaDadosProdutos[0]);
				}
				
			
				
			}
		});
		setTitle("Transações");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(181, 225, 207));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataDaTransao = new JLabel("Data da Transação");
		lblDataDaTransao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDataDaTransao.setBounds(10, 24, 146, 26);
		contentPane.add(lblDataDaTransao);
		
		JLabel lblNomeDoVendedor = new JLabel("Nome do Vendedor");
		lblNomeDoVendedor.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNomeDoVendedor.setBounds(10, 60, 146, 26);
		contentPane.add(lblNomeDoVendedor);
		
		JLabel lblCdigoDoProduto = new JLabel("Código do Produto");
		lblCdigoDoProduto.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCdigoDoProduto.setBounds(10, 102, 146, 26);
		contentPane.add(lblCdigoDoProduto);
		
		JLabel lblDesignaoDoProduto = new JLabel("Designação do Produto");
		lblDesignaoDoProduto.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDesignaoDoProduto.setBounds(10, 142, 164, 26);
		contentPane.add(lblDesignaoDoProduto);
		
		JLabel lblPreoUnitrioDo = new JLabel("Preço Unitário do Produto");
		lblPreoUnitrioDo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPreoUnitrioDo.setBounds(10, 188, 185, 26);
		contentPane.add(lblPreoUnitrioDo);
		
		JLabel lblQauntidadeVendida = new JLabel("Quantidade Vendida");
		lblQauntidadeVendida.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQauntidadeVendida.setBounds(10, 239, 146, 26);
		contentPane.add(lblQauntidadeVendida);
		
		JLabel lblValorPagar = new JLabel("Valor à pagar");
		lblValorPagar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblValorPagar.setBounds(10, 285, 146, 26);
		contentPane.add(lblValorPagar);
		
		JLabel lblNif = new JLabel("NIF");
		lblNif.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNif.setBounds(10, 322, 62, 26);
		contentPane.add(lblNif);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(225, 31, 217, 19);
		contentPane.add(dateChooser);
		
		
		comboBoxVendedor.setBounds(225, 64, 217, 21);
		contentPane.add(comboBoxVendedor);
		
		
		comboBoxCodigo.setBounds(225, 106, 217, 21);
		contentPane.add(comboBoxCodigo);
		
		textFieldNif = new JTextField();
		textFieldNif.setBounds(225, 327, 217, 19);
		contentPane.add(textFieldNif);
		textFieldNif.setColumns(10);
		
		
		spinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spinner.setBounds(225, 244, 125, 20);
		contentPane.add(spinner);
		
		textFieldValorPagar = new JTextField();
		textFieldValorPagar.setBounds(225, 290, 217, 19);
		contentPane.add(textFieldValorPagar);
		textFieldValorPagar.setColumns(10);
		
		textFieldDesig = new JTextField();
		textFieldDesig.setBounds(225, 147, 217, 19);
		contentPane.add(textFieldDesig);
		textFieldDesig.setColumns(10);
		
		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(225, 193, 217, 19);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);
		
		JButton btnNewButton = new JButton("Guardar Transação");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nif= textFieldNif.getText();
				String mensagem ="";
				int verifica=0;
				
				Clientes novoClientes = new Clientes ();
				
				String separador = ";";
				
				String [] linha ;
				
				for( int i=0; i<novoClientes.novoCliente.size();i++) {
					
					linha =novoClientes.novoCliente.get(i).split(separador);
					
					
					if (nif.trim().equals(linha[0])) {
						
						verifica =1;
					}
				
				}
				
				//Verifica se os campos estão preenchidos e guarda na mensagem
				if(dateChooser.getDate() == null) {
					
					mensagem += "Insira uma Data !\n";
				}
				if (comboBoxVendedor.getSelectedIndex()==0) {
					mensagem+= "Preencha o nome do Vendedor !\n";
				}
				if(comboBoxCodigo.getSelectedIndex()==0) {
					mensagem+= "Preencha o Código do Produto !\n";
				}
				if(Integer.parseInt(spinner.getValue().toString())==0) {
					mensagem += "Prencha a quantidade pretendida !\n";
					
				}
				if(nif.equals("")) {
					
					mensagem += " Preencha o Nif do Cliente !\n";
				}
				if(nif.length()>9) {
					
					mensagem += "O nif é inválido! \n Insira o nif com 9 dígitos !!\n";
				}
				if(nif.length()<9) {
					
					mensagem += "O nif é inválido! \n Insira o nif com 9 dígitos !!\n";
				}
				
				if(verifica!=1) {
					
					mensagem += "O cliente não existe! \n";
					
				}
					
				if(aux==2) {
					
					mensagem += "Não existe quantidade suficiente para realizar a transação ! \n Tente uma quantidade menor ou outro Produto!!\n";
				}
				
				//verifica se todos os campos estão preenchidos para então guardar os dados
				if(aux==2 || verifica!=1|| dateChooser.getDate() == null|| comboBoxVendedor.getSelectedIndex()==0 ||  comboBoxCodigo.getSelectedIndex()==0 || Integer.parseInt(spinner.getValue().toString())==0 || nif.length()>9 || nif.equals("") || nif.length()<9){
					
				}
				else {
					
					//atualiza a quantidade
					String [] linhaProdutoEscolhido ;
					int quantidadeInserida= Integer.parseInt(spinner.getValue().toString());
					int novaQuantidade=0;
					
					Produtos codigoEscolhido= new Produtos();
					
						linhaProdutoEscolhido =codigoEscolhido.novoProduto.get(comboBoxCodigo.getSelectedIndex()-1).split(separador);
						if(quantidadeInserida<=(Integer.parseInt(linhaProdutoEscolhido[1]))) {
							novaQuantidade= Integer.parseInt(linhaProdutoEscolhido[1]) - quantidadeInserida;
							String novoDado = linhaProdutoEscolhido[0] + ";" + novaQuantidade + ";" + linhaProdutoEscolhido[2] +";" + linhaProdutoEscolhido[3];
							codigoEscolhido.AtualizaEstoque(comboBoxCodigo.getSelectedIndex()-1, novoDado);
						}
						
							
					
					SimpleDateFormat data = new SimpleDateFormat ("dd/MM/yyyy");
					
					
					String dataFormatada = data.format(dateChooser.getDate());
					
					String dados = dataFormatada + ";"+ comboBoxVendedor.getSelectedItem()+ ";"  +comboBoxCodigo.getSelectedItem() + ";" + textFieldDesig.getText() +";" + textFieldPreco.getText()+ ";"+ Integer.parseInt(spinner.getValue().toString()) + ";" + textFieldValorPagar.getText()+ ";" +textFieldNif.getText();
					
					
					GuardarTransações enviaDados = new GuardarTransações ();
					enviaDados.AdicionarTransação(dados);
					JOptionPane.showMessageDialog(null,"Dados Guardados com sucesso ! " );
				
					comboBoxVendedor.setSelectedIndex(0);
					comboBoxCodigo.setSelectedIndex(0);
					textFieldDesig.setText("");
					textFieldPreco.setText("");
					textFieldValorPagar.setText("");
					textFieldNif.setText("");
					//spinner.setValue(0);
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
		btnNewButton.setBackground(new Color(0, 128, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnNewButton.setBounds(26, 388, 439, 51);
		contentPane.add(btnNewButton);
		
		
		
		
	}
}
