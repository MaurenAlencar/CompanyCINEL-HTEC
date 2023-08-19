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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListaData extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaData frame = new ListaData();
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
	public ListaData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-calendar-20.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1500, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataIncio = new JLabel("Data Início");
		lblDataIncio.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataIncio.setBounds(273, 30, 148, 26);
		contentPane.add(lblDataIncio);
		
		JDateChooser dateChooserInicio = new JDateChooser();
		dateChooserInicio.setBounds(382, 30, 161, 26);
		contentPane.add(dateChooserInicio);
		
		JLabel lblDataFim = new JLabel("Data Fim");
		lblDataFim.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDataFim.setBounds(842, 30, 148, 26);
		contentPane.add(lblDataFim);
		
		JDateChooser dateChooserFim = new JDateChooser();
		dateChooserFim.setBounds(933, 30, 180, 26);
		contentPane.add(dateChooserFim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 127, 1442, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tabela = new DefaultTableModel ();
		String [] colunas ={"Data","Nome do Vendedor","Código do Produto","Designação do Produto", "Preço Unitario do Produto","Quantidade Vendida", "Valor à Pagar", "Nif do Cliente"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooserInicio.getDate() == null || dateChooserFim.getDate()== null )	{
					
					JOptionPane.showMessageDialog(null, "As duas datas são de preenchimento obrigatório ! ", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
					
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
						
						
						GuardarTransações aux = new GuardarTransações();
						
						SimpleDateFormat dataFicheiro = new SimpleDateFormat("dd/MM/yyyy");
						
						
						
						
						for (int i =0; i< aux.novaTransação.size();i++) {
							
							
							linha = aux.novaTransação.get(i).split(separador);
							
						
						
							try {
							
									Date dataComparar = dataFicheiro.parse(linha[0]);
									
									
									if(dateChooserInicio.getDate().compareTo(dataComparar)<=0 &&  dateChooserFim.getDate().compareTo(dataComparar)>=0){
									
										
										//JOptionPane.showMessageDialog(null, novaLinha);
										
										tabela.addRow(linha);
										
									} 
									
										
									
							}catch(Exception e1) {
								
								JOptionPane.showMessageDialog(null, "Algo correu mal!");
							}
							
							
						}
						
						
						
					}
					else {
						
						JOptionPane.showMessageDialog(null,"A data final deve ser maior ou igual à data inicial !");
					}
				}	
			}
		});
		btnNewButton.setForeground(new Color(255, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setBounds(539, 76, 321, 41);
		contentPane.add(btnNewButton);
	}
}
