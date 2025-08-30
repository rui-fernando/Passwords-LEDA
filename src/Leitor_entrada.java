import java.io.*;
import Estruturas_de_dados.Fila;
import Estruturas_de_dados.ListaEncadeada;

public class Leitor_entrada {
    public static ListaEncadeada<Dados_password> readCSV(String entrada) {
        ListaEncadeada<Dados_password> listaDados = new ListaEncadeada<>();
        Fila<String> filaLinhas = new Fila<>();

        // leitura do arquivo e coloca cada linha na fila
        try (BufferedReader aux_leitura = new BufferedReader(new FileReader(entrada))) {
            aux_leitura.readLine(); // Pular o cabeçalho
            String linha_array;
            while ((linha_array = aux_leitura.readLine()) != null) {
                filaLinhas.adicionar(linha_array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!filaLinhas.estaVazia()) {
            String linha = filaLinhas.remover();
            String[] data = linha.split(",");
            if (data.length >= 5) {
                try {
                    int length = Integer.parseInt(data[2].trim());
                    Dados_password novoDado = new Dados_password(listaDados.tamanho(), data[1], length, data[3], data[4]);
                    listaDados.adicionar(novoDado); // Adicionar ao final da lista
                } catch (NumberFormatException e) {
                }
            }
        }

        return listaDados;
    }
}