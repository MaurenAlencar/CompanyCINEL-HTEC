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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class ListaProdutos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProdutos frame = new ListaProdutos();
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
	public ListaProdutos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-list-view-20 (1).png"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
		DefaultTableModel tabela = new DefaultTableModel();
		
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
		setTitle("Lista de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1094, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblProdutos.setBounds(182, 10, 90, 26);
		contentPane.add(lblProdutos);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex() != 0) {
					
					
					tabela.setRowCount(0);
					
					
					String nomeProduto = comboBox.getSelectedItem().toString();
					
					GuardarTransações aux = new GuardarTransações ();
					
					String separador = ";";
					
					String [] linha ;
					String [] novaLinha=new String[7];
					
					int verifica=0;
					
					
					for(int i=0; i<aux.novaTransação.size(); i++) {
						
						
						linha = aux.novaTransação.get(i).split(separador);
						// novo array para excluir o nome do Produto
						novaLinha[0]=linha[0];
						novaLinha[1]= linha[1];
						novaLinha[2]=linha[2];
						novaLinha[3]=linha[4];
						novaLinha[4]=linha[5];
						novaLinha[5]=linha[6];
						novaLinha[6]=linha[7];							
						
						
						if (nomeProduto.equals(linha [3])) {
							
							tabela.addRow(novaLinha);
							verifica=1;
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
				
				
			}
		});
		comboBox.setBounds(297, 14, 343, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 62, 1034, 238);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String [] colunas = {"Data","Nome Vendedor","Código do Produto", "Preço Unitario do Produto","Quantidade Vendida", "Valor à Pagar", "Nif do Cliente"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
	}
}
