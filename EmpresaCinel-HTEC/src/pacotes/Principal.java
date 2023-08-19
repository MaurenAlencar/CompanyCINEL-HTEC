package pacotes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\Captura de tela 2023-01-16 181812.jpg"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				Clientes atualizaClientes = new Clientes();
				atualizaClientes.AtualizaCliente();
				
				Vendedores atualizaVendedores = new Vendedores();
				atualizaVendedores.AtualizaVendedor();
				
				Produtos atualizaProduto = new Produtos();
				atualizaProduto.AtualizaProduto();
				
				GuardarTransações atualiza = new GuardarTransações ();
				atualiza.AtualizaTransação();
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				JOptionPane.showMessageDialog(null, "Saia no Menu Ficheiro !", "Empresa CINEL-HTEC", JOptionPane.ERROR_MESSAGE);
			}
		});
		setTitle("Empresa Cinel - HTEC");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 351, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 335, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ficheiro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Sair");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\sair.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja sair e Salvar as alterções?","Aviso",JOptionPane.YES_NO_OPTION);
				
				if(resposta==0) {
					
					Clientes guardarCliente = new Clientes();
					guardarCliente.GuardarDadosFicheiro();
					
					Vendedores guardarVendedores = new Vendedores();
					guardarVendedores.GuardarDadosFicheiro();
					
					Produtos guardarProduto = new Produtos();
					guardarProduto.GuardarDadosFicheiro();
					
					GuardarTransações guardar = new GuardarTransações ();
					guardar.GuardarDadosFicheiro();
					
					JOptionPane.showMessageDialog(null, "Até breve !");
					
					System.exit(EXIT_ON_CLOSE);
				}
				else {
					
					int op = JOptionPane.showConfirmDialog(null, "Prentende não salvar as alterções e sair?","Aviso",JOptionPane.YES_NO_OPTION);
					
					if(op==0) {
						
						int sair=JOptionPane.showConfirmDialog(null, "Tem certeza que deja sair sem salvar as alterções?","Aviso",JOptionPane.YES_NO_OPTION);
						if(sair==0) {
							JOptionPane.showMessageDialog(null, "Até breve !");
							
							System.exit(EXIT_ON_CLOSE);
						}
						
					}
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Suporte");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Suporte open = new Suporte();
				open.setVisible(true);
				
			}
		});
		mntmNewMenuItem_15.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-technical-support-20.png"));
		mnNewMenu.add(mntmNewMenuItem_15);
		
		JMenu mnNewMenu_4 = new JMenu("Transações");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Adicionar Nova Transação");
		mntmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-transaction-list-20 (1).png"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Transações open = new Transações();
				open.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_5 = new JMenu("Listas");
		mnNewMenu_5.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\transacoes.png"));
		mnNewMenu_4.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listar Vendedor");
		mntmNewMenuItem_8.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-list-20.png"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaVendedor open = new ListaVendedor ();
				open.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Listar Produto");
		mntmNewMenuItem_9.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\historico-de-transacoes (1).png"));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaProdutos open = new ListaProdutos();
				open.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Listar entre Datas");
		mntmNewMenuItem_12.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-calendar-20.png"));
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaData open = new ListaData();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Adicionar");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\cliente.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdicionarCliente open = new AdicionarCliente();
				open.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Atualizar");
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\atualizar.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AtualizaClientes open = new AtualizaClientes();
				open.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Vendedores");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Adicionar");
		mntmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-sale-20.png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdicionarVendedor open = new AdicionarVendedor();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Remover");
		mntmNewMenuItem_7.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-salesman-20.png"));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoverVendedor open = new RemoverVendedor();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Pesquisa Por Datas");
		mntmNewMenuItem_10.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-calendar-20 (1).png"));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaVendedor open = new PesquisaVendedor();
				open.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_3 = new JMenu("Produtos");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Adicionar");
		mntmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-add-list-20.png"));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdicionarProdutos open = new AdicionarProdutos();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Remover");
		mntmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-remove-data-20 (1).png"));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RemoverProduto open = new RemoverProduto();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Pesquisa Por Datas");
		mntmNewMenuItem_11.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-calendar-20.png"));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaProduto open = new PesquisaProduto();
				open.setVisible(true);
				
			}
		});
		
		JMenu mnNewMenu_6 = new JMenu("Stock");
		mnNewMenu_6.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-sell-stock-20.png"));
		mnNewMenu_3.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Consultar");
		mntmNewMenuItem_13.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-search-in-list-20.png"));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaEstoque open = new ConsultaEstoque();
				open.setVisible(true);
				
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Atualizar");
		mntmNewMenuItem_14.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\icons8-refresh-30.png"));
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarEstoque open = new AtualizarEstoque();
				open.setVisible(true);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_14);
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\imagens_icones\\gestor0.jpg"));
		lblNewLabel.setBounds(0, 22, 335, 246);
		contentPane.add(lblNewLabel);
	}
}
