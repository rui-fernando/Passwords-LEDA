import Estruturas_de_dados.ListaEncadeada;

public class Algoritmos_ordencao_length {

        // InsertionSort
        public static ListaEncadeada<Dados_password> insertionSort(ListaEncadeada<Dados_password> lista) {
            //Copia da lista de entrada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
    
            for (int i = 0; i < lista.tamanho(); i++) {
                Dados_password aux = lista.buscar(i);
                int j = i - 1;
                while (j >= 0 && lista_ordenada.buscar(j).getLength() < aux.getLength()) {
                    j--;
                }
                if (j == i - 1) {
                    lista_ordenada.adicionar(aux);
                } else {
                    lista_ordenada.adicionar(j + 1, aux);
                }
            }
    
            return lista_ordenada;
        }

        // Bubble Sort
        public static ListaEncadeada<Dados_password> bubbleSort(ListaEncadeada<Dados_password> lista) {
            //Copia da lista de entrada
            ListaEncadeada<Dados_password> lista_ordenada = copiarLista(lista);
            
            boolean passo;
            for (int i = 0; i < lista_ordenada.tamanho() - 1; i++) {
                passo = false;
                for (int j = 0; j < lista_ordenada.tamanho() - 1 - i; j++) {
                    if (lista_ordenada.buscar(j).getLength() < lista_ordenada.buscar(j + 1).getLength()) {   
                        Dados_password aux = lista_ordenada.buscar(j);
                        lista_ordenada.set(j, lista_ordenada.buscar(j + 1));
                        lista_ordenada.set(j + 1, aux);
                        passo = true;
                    }
                }
                if (!passo) break;
            }
    
            return lista_ordenada;
        }
    
        // Selection Sort
        public static ListaEncadeada<Dados_password> selectionSort(ListaEncadeada<Dados_password> lista) {
            //Copia da lista de entrada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
            for (int i = 0; i < lista.tamanho(); i++) {
                lista_ordenada.adicionar(lista.buscar(i));
            }
    
            for (int i = 0; i < lista_ordenada.tamanho() - 1; i++) {
                int k = i;
                for (int j = i + 1; j < lista_ordenada.tamanho(); j++) {
                    if (lista_ordenada.buscar(j).getLength() > lista_ordenada.buscar(k).getLength()) { // Ordenação em ordem decrescente
                        k = j;
                    }
                }
                Dados_password aux = lista_ordenada.buscar(k);
                lista_ordenada.set(k, lista_ordenada.buscar(i));
                lista_ordenada.set(i, aux);
            }
    
            return lista_ordenada;
        }
    
        // Heap Sort
        public static ListaEncadeada<Dados_password> heapSort(ListaEncadeada<Dados_password> lista) {
            
            //Converte de lista encadeada para array
            Dados_password[] array = new Dados_password[lista.tamanho()];
            for (int i = 0; i < lista.tamanho(); i++) {
                array[i] = lista.buscar(i);
            }
    
            heapSort(array);
    
            // Converte o array de volta para Lista Encadeada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
                for (Dados_password item : array) {
                    lista_ordenada.adicionar(item);
                }
        
                return lista_ordenada;
        }
    
        private static void heapSort(Dados_password[] array) {
            int n = array.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(array, n, i);
            }
            for (int i = n - 1; i > 0; i--) {
                Dados_password aux = array[0];
                array[0] = array[i];
                array[i] = aux;
                heapify(array, i, 0);
            }
        }
    
        private static void heapify(Dados_password[] array, int n, int i) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
    
            if (left < n && array[left].getLength() < array[smallest].getLength()) {
                smallest = left;
            }
    
            if (right < n && array[right].getLength() < array[smallest].getLength()) {
                smallest = right;
            }
    
            if (smallest != i) {
                Dados_password swap = array[i];
                array[i] = array[smallest];
                array[smallest] = swap;
    
                heapify(array, n, smallest);
            }
        }
    
        // Merge Sort
        public static ListaEncadeada<Dados_password> mergeSort(ListaEncadeada<Dados_password> lista) {
            // Se a lista tiver menos de 2 elementos, está ordenada
            if (lista.tamanho() < 2) {
                return copiarLista(lista);
            }
    
            int j = lista.tamanho() / 2;
            ListaEncadeada<Dados_password> left = new ListaEncadeada<>();
            ListaEncadeada<Dados_password> right = new ListaEncadeada<>();
            
            for (int i = 0; i < j; i++) {
                left.adicionar(lista.buscar(i));
            }
            for (int i = j; i < lista.tamanho(); i++) {
                right.adicionar(lista.buscar(i));
            }
    
            return merge(mergeSort(left), mergeSort(right));
        }
    
        private static ListaEncadeada<Dados_password> merge(ListaEncadeada<Dados_password> left, ListaEncadeada<Dados_password> right) {
            ListaEncadeada<Dados_password> merged = new ListaEncadeada<>();
            int ind_left = 0;
            int ind_right = 0;
    
            while (ind_left < left.tamanho() && ind_right < right.tamanho()) {
                if (left.buscar(ind_left).getLength() >= right.buscar(ind_right).getLength()) { // Para ordem decrescente
                    merged.adicionar(left.buscar(ind_left));
                    ind_left++;
                } else {
                    merged.adicionar(right.buscar(ind_right));
                    ind_right++;
                }
            }
    
            // Adicionar os elementos restantes
            while (ind_left < left.tamanho()) {
                merged.adicionar(left.buscar(ind_left));
                ind_left++;
            }
            while (ind_right < right.tamanho()) {
                merged.adicionar(right.buscar(ind_right));
                ind_right++;
            }
    
            return merged;
        }
    
        // Quick Sort
        public static ListaEncadeada<Dados_password> quickSort(ListaEncadeada<Dados_password> lista) {
            //Converte de lista encadeada para array
            Dados_password[] array = new Dados_password[lista.tamanho()];
            for (int i = 0; i < lista.tamanho(); i++) {
                array[i] = lista.buscar(i);
            }
    
            quickSort(array, 0, array.length - 1);
    
            // Converte o array de volta para Lista Encadeada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
            for (Dados_password item : array) {
                lista_ordenada.adicionar(item);
            }
        
        return lista_ordenada;
        }
    
        private static void quickSort(Dados_password[] array, int p, int r) {
            if (p < r) {
                int pi = partition(array, p, r);
                quickSort(array, p, pi - 1);
                quickSort(array, pi + 1, r);
            }
        }
    
        private static int partition(Dados_password[] array, int p, int r) {
            Dados_password pivot = array[r];
            int i = (p - 1);
            for (int j = p; j < r; j++) {
                if (array[j].getLength() >= pivot.getLength()) { // Para ordem decrescente
                    i++;
                    Dados_password aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
            Dados_password aux = array[i + 1];
            array[i + 1] = array[r];
            array[r] = aux;
            return i + 1;
        }

        // QuickSort mediana de tres
        public static ListaEncadeada<Dados_password> quickSortMedianaDeTres(ListaEncadeada<Dados_password> lista) {
            //Converte de lista encadeada para array
            Dados_password[] array = new Dados_password[lista.tamanho()];
            for (int i = 0; i < lista.tamanho(); i++) {
                array[i] = lista.buscar(i);
            }
    
            quickSortMedianaDeTres(array, 0, array.length - 1);
    
            // Converte o array de volta para Lista Encadeada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
            for (Dados_password item : array) {
                lista_ordenada.adicionar(item);
            }
    
            return lista_ordenada;
        }
    
        private static void quickSortMedianaDeTres(Dados_password[] array, int low, int high) {
            if (low < high) {
                int pi = partitionMedianaDeTres(array, low, high);
                quickSortMedianaDeTres(array, low, pi - 1);
                quickSortMedianaDeTres(array, pi + 1, high);
            }
        }
    
        private static int partitionMedianaDeTres(Dados_password[] array, int low, int high) {
            int mid = low + (high - low) / 2;
            int k = medianaTres(array, low, mid, high);
    
            Dados_password aux = array[k];
            array[k] = array[high];
            array[high] = aux;
    
            Dados_password pivot = array[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (array[j].getLength() > pivot.getLength()) { // Para ordem decrescente
                    i++;
                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
            aux = array[i + 1];
            array[i + 1] = array[high];
            array[high] = aux;
            return i + 1;
        }
    
        private static int medianaTres(Dados_password[] array, int a, int b, int c) {
            int aux_01 = array[a].getLength();
            int aux_02 = array[b].getLength();
            int aux_03 = array[c].getLength();
    
            if ((aux_01 - aux_02) * (aux_03 - aux_01) >= 0) return a;
            else if ((aux_02 - aux_01) * (aux_03 - aux_02) >= 0) return b;
            else return c;
        }

        // countingSort
        public static ListaEncadeada<Dados_password>  countingSort(ListaEncadeada<Dados_password>  lista) {
            //Converte de lista encadeada para array
            Dados_password[] array = new Dados_password[lista.tamanho()];
            for (int i = 0; i < lista.tamanho(); i++) {
                array[i] = lista.buscar(i);
            }
    
            countingSort(array);
    
            // Converte o array de volta para Lista Encadeada
            ListaEncadeada<Dados_password> lista_ordenada = new ListaEncadeada<>();
            for (Dados_password item : array) {
                lista_ordenada.adicionar(item);
            }
    
            return lista_ordenada;
        }
    
        public static void countingSort(Dados_password[] array) {
            int max = 0;
            for (Dados_password k : array) {
                if (k.getLength() > max) {
                    max = k.getLength();
                }
            }
            int[] contador = new int[max + 1];
    
            for (Dados_password k : array) {
                contador[k.getLength()]++;
            }
    
            for (int i = 1; i < contador.length; i++) {
                contador[i] += contador[i - 1];
            }
    
            Dados_password[] saida = new Dados_password[array.length];
            for (int i = array.length - 1; i >= 0; i--) {
                Dados_password j = array[i];
                saida[contador[j.getLength()] - 1] = j;
                contador[j.getLength()]--;
            }
    
            for (int i = 0; i < array.length / 2; i++) {
                Dados_password aux = saida[i];
                saida[i] = saida[array.length - i - 1];
                saida[array.length - i - 1] = aux;
            }
    
            System.arraycopy(saida, 0, array, 0, array.length);
        }

        private static ListaEncadeada<Dados_password> copiarLista(ListaEncadeada<Dados_password> original) {
            
            ListaEncadeada<Dados_password> copia = new ListaEncadeada<>();
            for (int i = 0; i < original.tamanho(); i++) {
                copia.adicionar(original.buscar(i));
            }
            return copia;
        }
}
