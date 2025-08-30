import java.io.*;
import java.util.Random;

import Estruturas_de_dados.Fila;
import Estruturas_de_dados.ListaEncadeada;
import Estruturas_de_dados.Pilha;

public class Main_data {
    public static void main(String[] args) throws IOException {
        // Carrega dados
        ListaEncadeada<Dados_password> entrada = Leitor_entrada.readCSV("dados_saida/passwords_formated_data.csv");

        prepara_cenarios(entrada, "data");
    }

    private static void prepara_cenarios(ListaEncadeada<Dados_password> entrada, String type) throws IOException {
        
        ListaEncadeada<Dados_password> melhorCaso = copiarLista(entrada);
        algoritmo_ordena(melhorCaso);
        salvar(melhorCaso, "dados_saida/passwords_melhorCaso_entrada_data.csv");
        ListaEncadeada<Dados_password> medioCaso = copiarLista(entrada);
        mistura_lista(medioCaso, new Random());
        salvar(medioCaso, "dados_saida/passwords_medioCaso_entrada_data.csv");
        ListaEncadeada<Dados_password> piorCaso = copiarLista(melhorCaso);
        inverter_lista(piorCaso);
        salvar(piorCaso, "dados_saida/passwords_piorCaso_entrada_data.csv");

        //Para insertionSort
        // Ordena melhor caso
        ordenar(melhorCaso, type, "insertionSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "insertionSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "insertionSort", "medioCaso");

        //Para Bubblesoft
        // Ordena melhor caso
        ordenar(melhorCaso, type, "bubbleSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "bubbleSort", "piorCaso");

        // Embaralha a lista para caso medio
        ordenar(medioCaso, type, "bubbleSort", "medioCaso");

        //Para selection
        // Ordena melhor caso
        ordenar(melhorCaso, type, "selectionSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "selectionSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "selectionSort", "medioCaso");


        //Para quickSort
        // Ordena melhor caso 
        ordenar(melhorCaso, type, "quickSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "quickSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "quickSort", "medioCaso");


        //Para quickSort Mediana de tres
        // Ordena melhor caso
        ordenar(melhorCaso, type, "quickSortMedianaDeTres", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "quickSortMedianaDeTres", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "quickSortMedianaDeTres", "medioCaso");


        //Para heap
        // Ordena melhor caso
        ordenar(melhorCaso, type, "heapSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "heapSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "heapSort", "medioCaso");

        
        //Para Merge
        // Ordena melhor caso
        ordenar(melhorCaso, type, "mergeSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "mergeSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "mergeSort", "medioCaso");

        //Para CountingSort
        // Ordena melhor
        ordenar(melhorCaso, type, "countingSort", "melhorCaso");

        // Reverte a lista para pior caso
        ordenar(piorCaso, type, "countingSort", "piorCaso");

        // Embaralha a lista para caso médio
        ordenar(medioCaso, type, "countingSort", "medioCaso");

        salvar(melhorCaso, "dados_saida/passwords_melhorCaso_saida_data.csv");
        salvar(medioCaso, "dados_saida/passwords_medioCaso_saida_data.csv");
        salvar(piorCaso, "dados_saida/passwords_piorCaso_saida_data.csv");
    }

    private static void ordenar(ListaEncadeada<Dados_password> entrada, String type, String metodo_ordencao, String cenario) throws IOException {
        
        switch (metodo_ordencao) {
            case "insertionSort":

                    long startTime = System.nanoTime(); // Inicia tempo
                
                    ListaEncadeada<Dados_password> insertionSort_ordenado = Algoritmos_ordencao_data.insertionSort(entrada);
                
                    long endTime = System.nanoTime(); // Finaliza tempo
                    long duration = endTime - startTime;
                    System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                    salvar(insertionSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");
                
            break;

            case "bubbleSort":
                
                    startTime = System.nanoTime();

                    ListaEncadeada<Dados_password> bubbleSort_ordenado = Algoritmos_ordencao_data.bubbleSort(entrada);
              
                    endTime = System.nanoTime(); 
                    duration = endTime - startTime;
                    System.out.println("Tempo de execução para " + cenario+ " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                    salvar(bubbleSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");
                
            break;

            case "selectionSort":
                
                    startTime = System.nanoTime();
                    
                    ListaEncadeada<Dados_password> selectionSort_ordenado = Algoritmos_ordencao_data.selectionSort(entrada);

                    endTime = System.nanoTime(); 
                    duration = endTime - startTime;
                    System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                    salvar(selectionSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");
        
            break;

            case "quickSort":
                
                startTime = System.nanoTime();
                
                ListaEncadeada<Dados_password> quickSort_ordenado = Algoritmos_ordencao_data.quickSort(entrada);

                endTime = System.nanoTime(); 
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                salvar(quickSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");

            break;

            case "quickSortMedianaDeTres":
                
                startTime = System.nanoTime();
                
                ListaEncadeada<Dados_password> quickSortMedianaDeTres_ordenado = Algoritmos_ordencao_data.quickSortMedianaDeTres(entrada);

                endTime = System.nanoTime(); 
                duration = endTime - startTime;
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                salvar(quickSortMedianaDeTres_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");

            break;

            case "heapSort":
                
                    startTime = System.nanoTime();
                    
                    ListaEncadeada<Dados_password> heapSort_ordenado = Algoritmos_ordencao_data.heapSort(entrada);

                    endTime = System.nanoTime(); 
                    duration = endTime - startTime;
                    System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                    salvar(heapSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");

            case "mergeSort":
                
                    startTime = System.nanoTime();
                    
                    ListaEncadeada<Dados_password> mergeSort_ordenado= Algoritmos_ordencao_data.mergeSort(entrada);

                    endTime = System.nanoTime(); 
                    duration = endTime - startTime;
                    System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                    salvar(mergeSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");

            break;

            case "countingSort":
                
            startTime = System.nanoTime(); 
            
                ListaEncadeada<Dados_password> countingSort_ordenado = Algoritmos_ordencao_data.countingSort(entrada);

                endTime = System.nanoTime(); 
                duration = endTime - startTime; 
                System.out.println("Tempo de execução para " + cenario + " do " + metodo_ordencao +  " do " + type + ": " + duration + " nanosegundos");
                salvar(countingSort_ordenado, "dados_saida/" + "passwords_" + type + "_" + metodo_ordencao + "_" + cenario + ".csv");

            break;
            

            default:
                System.out.println("Método de ordenação não suportado: " + metodo_ordencao);
                return; 
        }
    
    }
    
    public static void inverter_lista(ListaEncadeada<Dados_password> lista) {
        Pilha<Dados_password> pilha = new Pilha<>();

        while (!lista.estaVazia()) {
            pilha.push(lista.remover(0));
        }

        while (!pilha.isEmpty()) {
            lista.adicionar(pilha.pop());
        }
    }

    public static void mistura_lista(ListaEncadeada<Dados_password> lista, Random rnd) {
        Fila<Dados_password> mistura= new Fila<>();
        
        while (!lista.estaVazia()) {
            mistura.adicionar(lista.remover(0));
        }
        
        while (!mistura.estaVazia()) {
            int mudanca = rnd.nextInt(lista.tamanho() + 1);
            Dados_password elemento = mistura.remover();
            lista.adicionar(mudanca, elemento);
        }
    }

    private static void salvar(ListaEncadeada<Dados_password> lista, String nomeArquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(",Password,Length,Date,Classification\n");
            for (int i = 0; i < lista.tamanho(); i++) {
                Dados_password entrada = lista.buscar(i);
                writer.write(entrada.getIndex() + "," + entrada.getPassword() + "," + entrada.getLength() + "," + entrada.getFormattedDate() + "," + entrada.getClassification() + "\n");
            }
        }
    }

    public static void algoritmo_ordena(ListaEncadeada<Dados_password> lista) {

        for (int i = 1; i < lista.tamanho(); i++) {
            Dados_password aux = lista.buscar(i);
            int j = i - 1;

            while (j >= 0 && lista.buscar(j).getDate().isAfter(aux.getDate())) {
                lista.set(j + 1, lista.buscar(j));
                j = j - 1;
            }
            lista.set(j + 1, aux);
        }
    }

    private static ListaEncadeada<Dados_password> copiarLista(ListaEncadeada<Dados_password> original) {
        ListaEncadeada<Dados_password> copia = new ListaEncadeada<>();
        for (int i = 0; i < original.tamanho(); i++) {
            copia.adicionar(original.buscar(i));
        }
        return copia;
    }

    
}  