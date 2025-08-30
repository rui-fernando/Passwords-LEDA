package passwords;

import java.io.*;
//...
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TransformacoesDeDatas {
	public static void main(String[] args) {
		
		String arquivo2 = "files/password_classifier.csv";
		String arquivo3 = "files/passwords_formated_data.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo2));
				BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo3))) {
			
				String linha;	
				
				bw.write("position,password,length,class,data\n");
				linha = br.readLine();	
				while ((linha = br.readLine()) != null) {
					String[] colunas = linha.split(",");
					
					if (colunas.length < 4) {
						System.err.println("Linha ignorada: formato inválido!" + linha);
						continue;
					}
					
					String posicao = colunas[0];
					String senha = colunas[1];
					String tamanho = colunas[2];
					String classificacao = colunas[3];
					String dataoriginal = colunas[4];
					
					
					String dataformatada = formatarData(dataoriginal);
					bw.write(posicao + "," + senha + "," + tamanho + "," + classificacao + "," + dataformatada + "\n");
					
					
				}
				System.out.println("Transformações de datas concluídas com sucesso. Arquivo gerado: passwords_formated_data.csv.");
			
			} catch (IOException e) {
			
				e.printStackTrace();
			}
							
	}
    
	public static String formatarData(String dataOriginal) {
        if (dataOriginal == null || dataOriginal.isEmpty()) {
            return "Data inválida"; // Retorna um aviso se a data estiver vazia
        }

        try {
            //String dataoriginal = "2016-12-18 03:21:51";

            // Definir o formato original da data
            DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Definir o novo formato desejado
            DateTimeFormatter formatoDesejado = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            // Converter a string para LocalDateTime
            LocalDateTime data = LocalDateTime.parse(dataOriginal, formatoOriginal);

            // Formatar para o novo padrão
            String dataFormatada = data.format(formatoDesejado);

            return dataFormatada;
        } catch (DateTimeParseException e) {
            return "Erro ao converter data"; // Caso a data esteja em formato inesperado
        }
    }
}
