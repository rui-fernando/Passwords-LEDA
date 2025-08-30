import java.io.*;
import java.util.Random;

public class Main_data {
    public static void main(String[] args) throws IOException {
        // Carrega dados
        Dados_password[] entrada = Leitor_entrada.readCSV("dadosSaida/passwords_formated_data.csv");

        prepara_cenarios(entrada, "data");
    }

    private static void prepara_cenarios(Dados_password[] entrada, String type) throws IOException {

        Dados_password[] melhorCaso = entrada.clone();
        Dados_password[] piorCaso = entrada.clone();
        Dados_password[] medioCaso = entrada.clone();


        //Para insertionSort
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "insertionSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "insertionSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "insertionSort", "medioCaso");


        //Para Bubblesoft
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "bubbleSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "bubbleSort", "piorCaso");

        // Embaralha o array original para caso medio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "bubbleSort", "medioCaso");


        //Para selection
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "selectionSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "selectionSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "selectionSort", "medioCaso");


        //Para quickSort
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "quickSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "quickSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "quickSort", "medioCaso");


        //Para quickSort Mediana de tres
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "quickSortMedianaDeTres", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "quickSortMedianaDeTres", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "quickSortMedianaDeTres", "medioCaso");


        //Para heap
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "heapSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "heapSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "heapSort", "medioCaso");


        //Para Merge
        // Ordena melhor caso
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "mergeSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "mergeSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "mergeSort", "medioCaso");

        //Para CountingSort
        // Ordena melhor caso para ordenação decrescente
        Algoritmos_ordenacao_data.algoritmo_ordena(melhorCaso);
        ordenar(melhorCaso, type, "countingSort", "melhorCaso");

        // Reverte o array ordenado para pior caso
        inverter_array(melhorCaso);
        piorCaso = melhorCaso.clone();
        ordenar(piorCaso, type, "countingSort", "piorCaso");

        // Embaralha o array original para caso médio
        mistura_array(medioCaso, new Random());
        ordenar(medioCaso, type, "countingSort", "medioCaso");
    }

    private static void ordenar(Dados_password[] entrada, String type, String metodo_ordencao, String cenario) throws IOException {

        switch (metodo_ordencao) {
            case "insertionSort":

                long startTime = System.nanoTime(); // Inicia tempo

                Algoritmos_ordenacao_data.insertionSort(entrada);

                long endTime = System.nanoTime(); // Finaliza tempo
                long duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "bubbleSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.bubbleSort(entrada);


                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario+ " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "selectionSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.selectionSort(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "quickSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.quickSort(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "quickSortMedianaDeTres":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.quickSortMedianaDeTres(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "heapSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.heapSort(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

            case "mergeSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.mergeSort(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;

            case "countingSort":

                startTime = System.nanoTime();

                Algoritmos_ordenacao_data.countingSort(entrada);

                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");

                break;


            default:
                System.out.println("Método de ordenação não suportado: " + metodo_ordencao);
                return;
        }

        // Salva os dados já ordenados
        salvar(entrada, "dadosSaida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");
    }


    private static void inverter_array(Dados_password[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            Dados_password aux = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = aux;
        }
    }

    private static void mistura_array(Dados_password[] array, Random rnd) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            Dados_password aux = array[j];
            array[j] = array[i];
            array[i] = aux;
        }
    }

    private static void salvar(Dados_password[] array, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(",Password,Length,Date,Classification\n"); // Cabeçalho do CSV
            for (Dados_password entrada : array) {
                writer.write(entrada.getIndex() + "," + entrada.getPassword() + "," + entrada.getLength() + "," + entrada.getFormattedDate() + "," + entrada.getClassification() + "\n");
            }
        }
    }


}
