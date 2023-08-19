package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class AdicionarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField Codigo;
	private JTextField Valor;
	private JTextField Designação;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdicionarProdutos frame = new AdicionarProdutos();
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
	public AdicionarProdutos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		setTitle("Adicionar Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigo = new JLabel("Código");
		lblCdigo.setForeground(new Color(255, 255, 255));
		lblCdigo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCdigo.setBounds(10, 21, 62, 26);
		contentPane.add(lblCdigo);
		
		Codigo = new JTextField();
		Codigo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Codigo.setColumns(10);
		Codigo.setBounds(100, 26, 201, 19);
		contentPane.add(Codigo);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(new Color(255, 255, 255));
		lblQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuantidade.setBounds(10, 57, 80, 26);
		contentPane.add(lblQuantidade);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		spinner.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spinner.setBounds(100, 62, 74, 20);
		contentPane.add(spinner);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblValor.setBounds(10, 93, 62, 26);
		contentPane.add(lblValor);
		
		Valor = new JTextField();
		Valor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Valor.setColumns(10);
		MaskFormatter novoValor = null;
		try {
			
			novoValor = new MaskFormatter ("####.#");
			 
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !");
		}
		Valor.setText("0000.0");
		Valor.setBounds(100, 98, 80, 19);
		contentPane.add(Valor);
		
		JLabel lblDesignao = new JLabel("Designação");
		lblDesignao.setForeground(new Color(255, 255, 255));
		lblDesignao.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDesignao.setBounds(10, 131, 80, 26);
		contentPane.add(lblDesignao);
		
		Designação = new JTextField();
		Designação.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Designação.setColumns(10);
		Designação.setBounds(100, 136, 201, 19);
		contentPane.add(Designação);
		
		JButton btnNewButton = new JButton("Adicionar Produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String codigo = Codigo.getText();
				String quantidade = spinner.getValue().toString(); //Quantidade.getText();
				String valor = Valor.getText();
				String designacao = Designação.getText();
				String dados = codigo + ";"+ quantidade + ";" + valor + ";" + designacao;
				String mensagem=""; //para concatenar os erros
				
				int verifica=0; // verificar a existência do produto
				
				
				if(codigo.equals("")) {
					
					 mensagem += " Preencha o código do Produto\n";
				}
				if (Integer.parseInt(spinner.getValue().toString())== 0) {
					
					 mensagem += " Adicione a quantidade Produto\n";
					
				}
				if (valor.equals("0000.0 €")) {
					
					mensagem += " Preencha o valor do Produto\n";
				}
				if(designacao.equals("")) {
					
					mensagem += " Preencha a designação do Produto\n";
				}
				
				if(codigo.equals("")|| Integer.parseInt(spinner.getValue().toString())== 0 || valor.equals("0000.0 €") || designacao.equals("") ) {
					
					
				}
				else {
					
					Produtos novoProduto = new Produtos ();
					
					String separador = ";";
					
					String [] linha ;
					
					for( int i=0; i<novoProduto.novoProduto.size();i++) {
						
						linha =novoProduto.novoProduto.get(i).split(separador);
						if (codigo.equals(linha[0])) {
							
							verifica =1;
						}
					}
					if(verifica ==1) {
						JOptionPane.showMessageDialog(null, "O produto já existe! \n Insira um novo produto !!", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						novoProduto.AdicionarProduto(dados);
						Codigo.setText("");
						spinner.setValue(0);
						Valor.setText("");
						Designação.setText("");
						JOptionPane.showMessageDialog(null, "Produto inserido com sucesso !");
						
						
					}
					
				}
				
				if(mensagem.equals("")) {
					
				}
				else {
					
					JOptionPane.showMessageDialog(null, mensagem, "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 192));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(28, 190, 264, 33);
		contentPane.add(btnNewButton);
		
		
	}
}
