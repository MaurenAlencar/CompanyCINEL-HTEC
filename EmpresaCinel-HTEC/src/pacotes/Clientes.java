package pacotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Clientes {
	
	static ArrayList<String> novoCliente = new ArrayList<String>();

	public Clientes() {
		// TODO Auto-generated constructor stub
	}

	
	public void AdicionarCliente (String dados) {
		
		novoCliente.add(dados);
		
	}
	public void AtualizaDadosCliente(int i,String dados) {
		
		novoCliente.set(i, dados);
		
	}

	public void AtualizaCliente() {
		
		try {
		
			
			FileReader fr = new FileReader ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\clientes.txt");
			
			BufferedReader ler = new BufferedReader (fr);
			
			while (ler.read() != -1) {
				
				String linha = ler.readLine();
				novoCliente.add(linha);
				
				
			}
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !");
		}
		
	}
	
	public void RemoverCliente ( int posicao) {
		
		
		novoCliente.remove(posicao-1);
		
		
	}
	
	public void GuardarDadosFicheiro() {
		
		try {
			
			File ficheiro = new File ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\clientes.txt");
			
			if(ficheiro.exists()) {
				
				FileWriter fw = new FileWriter(ficheiro);
				
				BufferedWriter write = new BufferedWriter (fw);
				
				for(int i =0; i<novoCliente.size();i++) {
					
					
					write.write(" " + novoCliente.get(i));
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
