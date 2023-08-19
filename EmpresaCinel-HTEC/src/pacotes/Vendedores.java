package pacotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Vendedores {

	static ArrayList<String> novoVendedor = new ArrayList<String>();
	
	public Vendedores() {
		// TODO Auto-generated constructor stub
	}

	public void AdicionarVendedor (String dados) {
		
		novoVendedor.add(dados);
		
	}
	
	public void AtualizaQuantidade(int i,String dados) {
		
		novoVendedor.set(i, dados);
		
	}
	public void AtualizaVendedor() {
		
		try {
		
			
			FileReader fr = new FileReader ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\vendedores.txt");
			
			BufferedReader ler = new BufferedReader (fr);
			
			while (ler.read() != -1) {
				
				String linha = ler.readLine();
				novoVendedor.add(linha);
				
				
			}
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !");
		}
		
	}
	
	public void RemoverVendedor ( int posicao) {
		
		
		novoVendedor.remove(posicao-1);
		
		
	}
	
	public void GuardarDadosFicheiro() {
		
		try {
			
			File ficheiro = new File ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\vendedores.txt");
			
			if(ficheiro.exists()) {
				
				FileWriter fw = new FileWriter(ficheiro);
				
				BufferedWriter write = new BufferedWriter (fw);
				
				for(int i =0; i<novoVendedor.size();i++) {
					
					
					write.write(" " + novoVendedor.get(i));
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
