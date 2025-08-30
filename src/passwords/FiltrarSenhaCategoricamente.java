package passwords;

import java.io.*;

public class FiltrarSenhaCategoricamente {
	public static void main(String[] args) {
		
		String arquivo4 = "files/passwords_formated_data.csv";
		String arquivo5 = "files/passwords_classifier.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo4));
				BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo5))) {
				
				String linha;
				
				bw.write("position,password,length,class,data\n");
				
				linha = br.readLine();
				while ((linha = br.readLine()) != null) {
					
					String [] colunas = linha.split(",");
					
					if (colunas.length < 4) {
						
						System.err.println("Linha ignorada (formato inválido): " + linha);
						continue;
					}
					
					String posicao = colunas[0];
					String senha = colunas[1];
					String tamanho = colunas[2];
					String classificacao = colunas[3];
					String data = colunas[4];
					
					//String selecionaClassificacao = filtrarClassificacaoSenhas(classificacao);
					
					if (classificacao.equals("Muito Boa") || classificacao.equals("Boa")) {
						bw.write(posicao + "," + senha + "," + tamanho + "," + classificacao + "," + data + "\n");
					}
					
				}
				System.out.println("Transformações de datas concluídas com sucesso. Arquivo gerado: passwords_classifier.csv .");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
