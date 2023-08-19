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

public class ListaVendedor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaVendedor frame = new ListaVendedor();
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
	public ListaVendedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-list-view-20.png"));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		DefaultTableModel tabela = new DefaultTableModel();
		
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
		setTitle("Lista de Vendedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1214, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVendedores = new JLabel("Vendedores");
		lblVendedores.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblVendedores.setBounds(249, 32, 148, 26);
		contentPane.add(lblVendedores);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedIndex() != 0) {
					
					tabela.setRowCount(0);
					
					
					String nomeVendedor = comboBox.getSelectedItem().toString();
					//JOptionPane.showMessageDialog(null, nomeVendedor);
					GuardarTransações aux = new GuardarTransações ();
					
					String separador = ";";
					
					String [] linha ;
					
					String [] novaLinha=new String[7];
					
					int verifica=0;
					
					
					for(int i=0; i<aux.novaTransação.size(); i++) {
						
						
						linha = aux.novaTransação.get(i).split(separador);
						
						// novo array para excluir o nome do Vendedor
						novaLinha[0]=linha[0];
						novaLinha[1]= linha[2];
						novaLinha[2]=linha[3];
						novaLinha[3]=linha[4];
						novaLinha[4]=linha[5];
						novaLinha[5]=linha[6];
						novaLinha[6]=linha[7];
						
						
						if (nomeVendedor.equals(linha [1])) {
							
							tabela.addRow(novaLinha);
							verifica=1;
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
				
				
			}
		});
		comboBox.setBounds(407, 32, 367, 25);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 1167, 262);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		String [] colunas = {"Data","Código do Produto","Designação do Produto", "Preço Unitario do Produto","Quantidade Vendida", "Valor à Pagar", "Nif do Cliente"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
	}
}
