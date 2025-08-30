public class Algoritmos_ordenacao_length {

    // Bubble Sort
    public static void bubbleSort(Dados_password[] array) {

        boolean passo;
        for (int i = 0; i < array.length - 1; i++) {
            passo = false;

            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].getLength() < array[j + 1].getLength()) {
                    Dados_password aux= array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    passo = true;
                }
            }
            if (!passo) break;
        }
    }

    // Selection Sort
    public static void selectionSort(Dados_password[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getLength() > array[k].getLength()) {
                    k = j;
                }
            }
            Dados_password aux = array[k];
            array[k] = array[i];
            array[i] = aux;
        }
    }

    // Heap Sort
    public static void heapSort(Dados_password[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {

            Dados_password aux = array[0];
            array[0] = array[i];
            array[i] = aux;
            heapify(array, i, 0);
        }
    }

    private static void heapify(Dados_password[] array, int n, int i) {
        int tamanho = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left].getLength() > array[tamanho].getLength())
            tamanho = left;

        if (right < n && array[right].getLength() > array[tamanho].getLength())
            tamanho = right;

        if (tamanho != i) {
            Dados_password aux = array[i];
            array[i] = array[tamanho];
            array[tamanho] = aux;

            heapify(array, n, tamanho);
        }
    }

    // Merge Sort
    public static void mergeSort(Dados_password[] array) {
        if (array.length < 2)
            return;

        int j = array.length / 2;
        Dados_password[] left = new Dados_password[j];
        Dados_password[] right = new Dados_password[array.length - j];

        for (int i = 0; i < j; i++)
            left[i] = array[i];
        for (int i = j; i < array.length; i++)
            right[i - j] = array[i];

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(Dados_password[] array, Dados_password[] left, Dados_password[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].getLength() >= right[j].getLength()) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Quick Sort
    public static void quickSort(Dados_password[] array) {
        quickSort(array, 0, array.length - 1);
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

            if (array[j].getLength() >= pivot.getLength()) {
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
    public static void quickSortMedianaDeTres(Dados_password[] array) {
        quickSortMedianaDeTres(array, 0, array.length - 1);
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

        Dados_password aux  = array[k];
        array[k] = array[high];
        array[high] = aux ;

        Dados_password pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].getLength() > pivot.getLength()) {
                i++;

                aux  = array[i];
                array[i] = array[j];
                array[j] = aux ;
            }
        }
        aux = array[i + 1];
        array[i + 1] = array[high];
        array[high] = aux ;
        return i + 1;
    }

    private static int medianaTres(Dados_password[] array, int a, int b, int c) {
        int aux_01 = array[a].getLength();
        int aux_02  = array[b].getLength();
        int aux_03  = array[c].getLength();

        if ((aux_01  - aux_02) * (aux_03 - aux_01 ) >= 0) return a;
        else if ((aux_02 - aux_01 ) * (aux_03 - aux_02) >= 0) return b;
        else return c;
    }

    // insertionSort
    public static void insertionSort(Dados_password[] array) {
        for (int i = 1; i < array.length; i++) {
            Dados_password aux = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].getLength() < aux.getLength()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }


    // countingSort
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


    // Metodo para ordenar e criar o melhor caso por length em ordem decrescente
    public static void algoritmo_ordena(Dados_password[] array) {

        for (int i = 1; i < array.length; i++) {
            Dados_password aux = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].getLength() < aux.getLength()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }

}