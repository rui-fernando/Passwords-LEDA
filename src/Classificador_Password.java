import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Estruturas_de_dados.Fila;

public class Classificador_Password {

    public static void main(String[] args) {
        String arquivo_entrada = "dados_entrada/passwords.csv";
        String arquivo_saida = "dados_saida/password_classifier.csv";
        
        Fila<String> fila = new Fila<>();

        try (BufferedReader entrada = new BufferedReader(new FileReader(arquivo_entrada));
             BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivo_saida))) {

            String linha = entrada.readLine(); // Lê o cabeçalho e o ignora
            if (linha != null) {
                escrever.write(linha + ",class"); // Adiciona a coluna 'class'
                escrever.newLine();
            }

            while ((linha = entrada.readLine()) != null) {
                fila.adicionar(linha);
            }

            while (!fila.estaVazia()) {
                linha = fila.remover();
                String[] fields = linha.split(","); // Divide pela vírgula
                if (fields.length > 1) {
                    String password = fields[1];
                    String classificacao = classifica(password);
                    escrever.write(linha + "," + classificacao);
                    escrever.newLine(); // Escreve uma nova linha
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String classifica(String password) {
        char[] password_array = password.toCharArray(); // Converte em array
        int tamanho = password_array.length;
        boolean letra_minuscula = false;
        boolean letra_maiuscula = false;
        boolean numero = false;
        boolean especial = false;
        int aux = 0;

        for (char ch : password_array) {
            if (ch >= 'a' && ch <= 'z') {
                letra_minuscula = true;
            }
            if (ch >= 'A' && ch <= 'Z') {
                letra_maiuscula = true;
            }
            if (ch >= '0' && ch <= '9') {
                numero = true;
            }
            if (!(ch >= '0' && ch <= '9') && !(ch >= 'A' && ch <= 'Z') && !(ch >= 'a' && ch <= 'z')) {
                especial = true;
            }
        }

        if (letra_maiuscula || letra_minuscula) {
            aux++;
        }

        if (numero) {
            aux++;
        }
        if (especial) {
            aux++;
        }

        if (tamanho < 5 && aux == 1)
            return "Muito Ruim";
        if (tamanho <= 5 && aux == 1)
            return "Ruim";
        if (tamanho <= 6 && aux == 2)
            return "Fraca";
        if (tamanho <= 7 && aux == 3)
            return "Boa";
        if (tamanho > 8 && aux >= 3)
            return "Muito Boa";

        return "Sem Classificacao";
    }
}