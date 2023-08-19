package pacotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Produtos {

	static ArrayList<String> novoProduto = new ArrayList<String>();
	
	public Produtos() {
		// TODO Auto-generated constructor stub
	}

	public void AdicionarProduto (String dados) {
		
		novoProduto.add(dados);
		
	}
	public void AtualizaEstoque(int i,String dados) {
		
		novoProduto.set(i, dados);
		
	}
	
	public void AtualizaProduto() {
		
		try {
		
			
			FileReader fr = new FileReader ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\produtos.txt");
			
			BufferedReader ler = new BufferedReader (fr);
			
			while (ler.read() != -1) {
				
				String linha = ler.readLine();
				novoProduto.add(linha);
				
				
			}
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !");
		}
		
	}
	
	public void RemoverProduto ( int posicao) {
		
		
		novoProduto.remove(posicao-1);
		
		
	}
	
	public void GuardarDadosFicheiro() {
		
		try {
			
			File ficheiro = new File ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\produtos.txt");
			
			if(ficheiro.exists()) {
				
				FileWriter fw = new FileWriter(ficheiro);
				
				BufferedWriter write = new BufferedWriter (fw);
				
				for(int i =0; i<novoProduto.size();i++) {
					
					
					write.write(" " + novoProduto.get(i));
					write.newLine();
				}
			
				write.close();
				fw.close();
				
				
				
			}
			else {
				
				JOptionPane.showMessageDialog(null, "Contacte o Suporte !");
			}
			
			
			
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !!");
		}
		
		
	}
	
	
	
	
	
}
