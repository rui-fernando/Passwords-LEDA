package passwords;

import java.io.*;

public class ClassicacaoDeSenhas {

	public static void main(String[] args) {
		
		String arquivoOriginal = "files/passwords.csv";
		String arquivo2 = "files/password_classifier.csv";
		
		
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo2))) {
	
	        	String linha;
	        	int linhaAtual = 0;
	        	
	        	bw.write("position,password,length,class,data\n");
	        	
	        	linha = br.readLine();
	        	while((linha = br.readLine()) != null) {
	        		
	        		String[] colunas = linha.split(",");
	        		if(colunas.length < 4) {
	        			
	        			System.err.println("Linha ignorada (formato inválido): " + linha);
	        			continue;
	        		}
	        		
	        		String senha = colunas[1];
	        		int tamanho;
	        		
	                try {
	                    tamanho = senha.length();
	
	                    
	                } catch (NumberFormatException e) {
	                    System.err.println("Erro ao ler tamanho da senha: " + linha);
	                    continue; // Pula esta linha
	                }
	        		
	                int i = linhaAtual;
	                
	        		String classificacao = classificarSenha(senha, tamanho);
	        		String data = colunas[3];
	        		
	        		bw.write(i + "," + senha + "," + tamanho + "," + classificacao + "," + data + "\n");
	        		
	        		linhaAtual++;
	        		
	        	}
	        	System.out.println("Classificação de senhas concluída com sucesso. Arquivo gerado: " + arquivo2);
	        	System.out.println(linhaAtual);
           } catch (IOException e) {
               e.printStackTrace();
           }
	}

	public static String classificarSenha(String senha, int tamanho) {
		
		boolean minuscula = false;
		boolean maiuscula = false;
		boolean digito = false;
		boolean caracterEspecial = false;
		
		for (char i : senha.toCharArray()) {
			
			if (Character.isLowerCase(i)) {minuscula = true;}
			else if (Character.isUpperCase(i)) {maiuscula = true;}
			else if (Character.isDigit(i)) {digito = true;}
			else {caracterEspecial = true;}
		}
		
		int totaltiposDeChar = (minuscula ? 1:0) + (maiuscula ? 1:0) + (digito ? 1:0) + (caracterEspecial ? 1:0);
		
		if (tamanho < 5 && totaltiposDeChar == 1) {return "Muito ruim";}
		if (tamanho <=5 && totaltiposDeChar == 1) {return "Ruim";}
		if (tamanho <= 6 && totaltiposDeChar == 2) {return "Fraca";}
		if (tamanho <= 7 && totaltiposDeChar >= 3) {return "Boa";}
		if (tamanho > 8 && totaltiposDeChar == 4) {return "Muito Boa";}
		
		return "Sem Classificacao";
	}
}