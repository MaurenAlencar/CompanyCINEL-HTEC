package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class PesquisaProduto extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaProduto frame = new PesquisaProduto();
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
	public PesquisaProduto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-search-20.png"));
		
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
		setTitle("Pesquisa Produtos entre Datas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1050, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataIncio = new JLabel("Data Início");
		lblDataIncio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataIncio.setBounds(88, 23, 148, 26);
		contentPane.add(lblDataIncio);
		
		JDateChooser dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(197, 23, 161, 26);
		contentPane.add(dateChooserInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataFim.setBounds(560, 23, 148, 26);
		contentPane.add(lblDataFim);
		
		JDateChooser dateChooserFim = new JDateChooser();
		dateChooserFim.setBounds(651, 23, 180, 26);
		contentPane.add(dateChooserFim);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblProdutos.setBounds(186, 59, 148, 26);
		contentPane.add(lblProdutos);
		
		
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(335, 62, 367, 25);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(UIManager.getBorder("TextArea.border"));
		scrollPane.setBounds(33, 178, 993, 285);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tabela = new DefaultTableModel ();
		String [] colunas ={"Data","Nome Vendedor","Código do Produto", "Preço Unitario do Produto","Quantidade Vendida", "Valor à Pagar", "Nif do Cliente"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooserInicio.getDate() == null || dateChooserFim.getDate()== null || comboBox.getSelectedIndex() == 0)	{
					
					JOptionPane.showMessageDialog(null, "As duas datas são de preenchimento obrigatório ! \n A designação do Produto é de preenchimento obrigatório!!", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
					
				}
				else {
					
					if (dateChooserInicio.getDate().compareTo(dateChooserFim.getDate())==-1) {
						
						tabela.setRowCount(0);
						
						String dataInicio , dataFim;
						
						SimpleDateFormat dataIniFormatada = new SimpleDateFormat("dd/MM/yyyy");
						
						SimpleDateFormat dataFimFormatada = new SimpleDateFormat("dd/MM/yyyy");
						
						dataInicio=dataIniFormatada.format(dateChooserInicio.getDate());
						
						dataFim=dataFimFormatada.format(dateChooserFim.getDate());
						
						String separador = ";";
						String [] linha;
						String [] novaLinha=new String[7];
						String nomeProduto = comboBox.getSelectedItem().toString();
						int verifica=0;
						
						GuardarTransações aux = new GuardarTransações();
						
						SimpleDateFormat dataFicheiro = new SimpleDateFormat("dd/MM/yyyy");
						
						
						
						
						for (int i =0; i< aux.novaTransação.size();i++) {
							
							linha = aux.novaTransação.get(i).split(separador);
							
							// novo array para excluir o nome do Produto
							novaLinha[0]=linha[0];
							novaLinha[1]= linha[1];
							novaLinha[2]=linha[2];
							novaLinha[3]=linha[4];
							novaLinha[4]=linha[5];
							novaLinha[5]=linha[6];
							novaLinha[6]=linha[7];							
							
							try {
							
									Date dataComparar = dataFicheiro.parse(linha[0]);
									
									
									if(dateChooserInicio.getDate().compareTo(dataComparar)<=0 &&  dateChooserFim.getDate().compareTo(dataComparar)>=0 && (nomeProduto.equals(linha [3]))){
									
										
										//JOptionPane.showMessageDialog(null, novaLinha);
										verifica=1;
										tabela.addRow(novaLinha);
										
									} 
									
										
									
							}catch(Exception e1) {
								
								JOptionPane.showMessageDialog(null, "Algo correu mal!");
							}
							
							
						}
						//verifica se há transaçoes do Produto
						if(verifica==1) {
						}
						else {
							JOptionPane.showMessageDialog(null, "Não existe transações desse Produto !", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
						}
						comboBox.setSelectedIndex(0);
						
						
					}
					else {
						
						JOptionPane.showMessageDialog(null,"A data final deve ser maior ou igual à data inicial !");
					}
				}	
				
			}
		});
		btnNewButton.setForeground(new Color(128, 255, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(341, 120, 321, 41);
		contentPane.add(btnNewButton);
		
		
	}
}
