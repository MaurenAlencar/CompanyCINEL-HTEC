package pacotes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GuardarTransações {

	static ArrayList<String> novaTransação = new ArrayList<String>();
	
	public GuardarTransações() {
		// TODO Auto-generated constructor stub
	}
	
	public void AdicionarTransação (String dados) {
		
		
		novaTransação.add(dados);
		
		
	}

	public void AtualizaTransação() {
		
		try {
		
			
			FileReader fr = new FileReader ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\transações.txt");
			
			BufferedReader ler = new BufferedReader (fr);
			
			while (ler.read() != -1) {
				
				
				String linha = ler.readLine();
				
				novaTransação.add(linha);
				
				
				
			}
			
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "Algo correu mal !");
		}
		
	}
	
	
	public void GuardarDadosFicheiro() {
		
		try {
			
			File ficheiro = new File ("C:\\Users\\pc\\eclipse-workspace\\EmpresaCinel-HTEC\\transações.txt");
			
			if(ficheiro.exists()) {
				
				FileWriter fw = new FileWriter(ficheiro);
				
				BufferedWriter write = new BufferedWriter (fw);
				
				for(int i =0; i<novaTransação.size();i++) {
					
					
		
					write.write(" " + novaTransação.get(i));
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
