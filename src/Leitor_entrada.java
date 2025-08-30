import java.io.*;
import java.util.Arrays;

public class Leitor_entrada {

    public static Dados_password[] readCSV(String entrada){

        Dados_password[] entrada_02 = new Dados_password[10000000]; // tamanho inicial
        int index = 0;

        try (BufferedReader aux_leitura = new BufferedReader(new FileReader(entrada))){
            aux_leitura.readLine(); // pula o cabeçalho

            String linha_array;
            while ((linha_array = aux_leitura.readLine()) != null){

                String[] data = linha_array.split(",");

                if(data.length >= 5){
                    try{
                        int length = Integer.parseInt(data[2].trim());

                        if(index == entrada_02.length){
                            entrada_02 = modifica_tamanho(entrada_02);
                        }

                        entrada_02[index] = new Dados_password(index, data[1],length, data[3], data[4]);
                        index++;
                    } catch (NumberFormatException e){
                        System.out.println(" ");
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return Arrays.copyOf(entrada_02 , index);
    }

    private static Dados_password[] modifica_tamanho(Dados_password[] original){
        Dados_password[] novo_Array = new Dados_password[original.length * 2];
        System.arraycopy(original, 0, novo_Array,0, original.length);
        return novo_Array;
    }

}
