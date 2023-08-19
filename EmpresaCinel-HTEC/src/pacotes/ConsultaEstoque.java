package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ConsultaEstoque extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEstoque frame = new ConsultaEstoque();
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
	public ConsultaEstoque() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\historico-de-transacoes.png"));
		setTitle("Consulta Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 915, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 880, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel tabela = new DefaultTableModel ();
		String [] colunas ={"Código","Quantidade", "Valor","Designação do Produto"};
		tabela.setColumnIdentifiers(colunas);
		table.setModel(tabela);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Consultar Estoque");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabela.setRowCount(0);
				
				Produtos aux = new Produtos ();
				
				String separador = ";";
				
				String [] linha ;
				
				
				
				for(int i=0; i<aux.novoProduto.size(); i++) {
					
					
					linha = aux.novoProduto.get(i).split(separador);
												
					
						tabela.addRow(linha);

					
				}
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 64));
		btnNewButton.setForeground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 28));
		btnNewButton.setBounds(141, 284, 536, 41);
		contentPane.add(btnNewButton);
	}

}
