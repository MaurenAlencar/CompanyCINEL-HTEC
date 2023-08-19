package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class PesquisaVendedor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaVendedor frame = new PesquisaVendedor();
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
	public PesquisaVendedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\exigem.png"));
		setType(Type.POPUP);
		
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
		setTitle("Pesquisa Vendedor entre Datas´");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1052, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblVendedores.setBounds(215, 56, 148, 26);
		contentPane.add(lblVendedores);
		
		
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBounds(364, 59, 367, 25);
		contentPane.add(comboBox);
		
		JLabel lblDataIncio = new JLabel("Data Início");
		lblDataIncio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataIncio.setBounds(117, 20, 148, 26);
		contentPane.add(lblDataIncio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataFim.setBounds(589, 20, 148, 26);
		contentPane.add(lblDataFim);
		
		JDateChooser dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(226, 20, 161, 26);
		contentPane.add(dateChooserInicio);
		
		JDateChooser dateChooserFim = new JDateChooser();
		dateChooserFim.setBounds(680, 20, 180, 26);
		contentPane.add(dateChooserFim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 180, 996, 264);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tabela = new DefaultTableModel ();
		String [] colunas ={"Data","Código do Produto","Designação do Produto", "Preço Unitario do Produto","Quantidade Vendida", "Valor à Pagar", "Nif do Cliente"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooserInicio.getDate() == null || dateChooserFim.getDate()== null || comboBox.getSelectedIndex() == 0)	{
					
					JOptionPane.showMessageDialog(null, "As duas datas são de preenchimento obrigatório ! \n O vendedor é de preenchimento obrigatório!!", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
					
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
												
						String nomeVendedor = comboBox.getSelectedItem().toString();
						
						int verifica=0;
						
						GuardarTransações aux = new GuardarTransações();
						
						SimpleDateFormat dataFicheiro = new SimpleDateFormat("dd/MM/yyyy");
						
						
						
						
						for (int i =0; i< aux.novaTransação.size();i++) {
							
							
							linha = aux.novaTransação.get(i).split(separador);
							
							// novo array para excluir o nome do Vendedor
							novaLinha[0]=linha[0];
							novaLinha[1]= linha[2];
							novaLinha[2]=linha[3];
							novaLinha[3]=linha[4];
							novaLinha[4]=linha[5];
							novaLinha[5]=linha[6];
							novaLinha[6]=linha[7];							
							
							try {
							
									Date dataComparar = dataFicheiro.parse(linha[0]);
									
									
									if(dateChooserInicio.getDate().compareTo(dataComparar)<=0 &&  dateChooserFim.getDate().compareTo(dataComparar)>=0 && (nomeVendedor.equals(linha [1]))){
									
										
										//JOptionPane.showMessageDialog(null, novaLinha);
										verifica=1;
										tabela.addRow(novaLinha);
										
									} 
									
										
									
							}catch(Exception e1) {
								
								JOptionPane.showMessageDialog(null, "Algo correu mal!");
							}
							
							
						}
						
						//verifica se há transaçoes do Vendedor
						if(verifica==1) {
						}
						else {
							JOptionPane.showMessageDialog(null, "Não existe transações desse Vendedor !", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
						}
						comboBox.setSelectedIndex(0);
						
						
					}
					else {
						
						JOptionPane.showMessageDialog(null,"A data final deve ser maior ou igual à data inicial !");
					}
				}	
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setForeground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(370, 117, 321, 41);
		contentPane.add(btnNewButton);
	}
}
