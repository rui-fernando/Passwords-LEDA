# Passwords-LEDA — branch `tadswithalgoritms`

> Esta é a branch mais completa do projeto **Passwords-LEDA**. Para as demais etapas, veja o [README principal](https://github.com/rui-fernando/Passwords-LEDA/blob/transformations/README.md) (branch `transformations`).

Versão do projeto que combina **Tipos Abstratos de Dados (TADs) implementados do zero** com **algoritmos de ordenação clássicos**, aplicados aos dados de senhas, incluindo análise de desempenho em diferentes cenários.

## 📋 Sobre esta branch

Além de classificar e organizar os dados de senhas, esta etapa do projeto implementa estruturas de dados fundamentais manualmente (sem usar as classes prontas do Java) e aplica oito algoritmos de ordenação diferentes sobre os dados, comparando o desempenho de cada um em melhor, médio e pior caso.

## 🗂️ Estruturas de dados implementadas

- **`Pilha<T>`** (Stack) — genérica, baseada em `Nodo` encadeado, com operações de `push`, `pop`, `isEmpty`.
- **`Fila<T>`** (Queue) — genérica, baseada em `Nodo` encadeado.
- **`ListaEncadeada`** — lista simplesmente encadeada.
- **`Nodo<T>`** — classe de apoio usada pelas estruturas acima.

## ⚙️ Algoritmos de ordenação implementados

| Algoritmo | Arquivo |
|---|---|
| Bubble Sort | `Algoritmos_ordencao_*.java` |
| Selection Sort | `Algoritmos_ordencao_*.java` |
| Insertion Sort | `Algoritmos_ordencao_*.java` |
| Merge Sort | `Algoritmos_ordencao_*.java` |
| Quick Sort | `Algoritmos_ordencao_*.java` |
| Quick Sort (mediana de três) | `Algoritmos_ordencao_*.java` |
| Heap Sort | `Algoritmos_ordencao_*.java` |
| Counting Sort | `Algoritmos_ordencao_*.java` |

Cada algoritmo é aplicado sobre três critérios de ordenação diferentes: **data**, **mês** e **comprimento da senha** (arquivos `Algoritmos_ordencao_data.java`, `Algoritmos_ordencao_month.java` e `Algoritmos_ordencao_length.java`).

## 📊 Análise de desempenho

O projeto executa cada algoritmo em três cenários — **melhor caso**, **caso médio** e **pior caso** — para cada critério de ordenação, exportando os resultados individualmente em arquivos CSV na pasta `dados_saida/`. Isso permite comparar na prática a eficiência teórica de cada algoritmo (ex: O(n²) dos algoritmos simples vs. O(n log n) de Merge/Quick/Heap Sort) com o tempo real de execução sobre os dados.

Exemplos de arquivos gerados:
- `passwords_data_mergeSort_piorCaso.csv`
- `passwords_length_quickSort_melhorCaso.csv`
- `passwords_month_heapSort_medioCaso.csv`

## 🛠️ Tecnologias utilizadas

- **Java**
- Estruturas de dados genéricas implementadas manualmente
- Algoritmos de ordenação e análise de complexidade (Big O)

## 📁 Estrutura do projeto

```
Passwords-LEDA/ (branch tadswithalgoritms)
├── src/
│   ├── Classificador_Password.java
│   ├── Transformacoes.java
│   ├── Leitor_entrada.java
│   ├── Dados_password.java
│   ├── Main_ordenacao.java              # Executa a ordenação para os 3 critérios
│   ├── Main_data.java
│   ├── Main_length.java
│   ├── Main_month.java
│   ├── Algoritmos_ordencao_data.java
│   ├── Algoritmos_ordencao_length.java
│   ├── Algoritmos_ordencao_month.java
│   └── Estruturas_de_dados/
│       ├── Nodo.java
│       ├── Pilha.java
│       ├── Fila.java
│       └── ListaEncadeada.java
├── dados_entrada/                        # CSV de entrada
└── dados_saida/                          # Resultados de cada algoritmo/cenário (CSV)
```

## ▶️ Como executar

### Pré-requisitos
- JDK instalado

### Passos

1. Clone o repositório e mude para esta branch:
   ```bash
   git clone https://github.com/rui-fernando/Passwords-LEDA.git
   cd Passwords-LEDA
   git checkout tadswithalgoritms
   ```
2. Certifique-se de que o arquivo de entrada `passwords.csv` está na pasta `dados_entrada/`.
3. Compile o projeto:
   ```bash
   javac -d out src/*.java src/Estruturas_de_dados/*.java
   ```
4. Execute a classe principal de ordenação:
   ```bash
   java -cp out Main_ordenacao
   ```
5. Os resultados de cada algoritmo/cenário serão gerados na pasta `dados_saida/`.

## 📌 Nota

Este projeto tem fins exclusivamente educacionais, para prática de estruturas de dados, algoritmos de ordenação e análise de complexidade em Java. O dataset utilizado é de uso acadêmico comum em exercícios de classificação de força de senhas.

## 👤 Autor

Desenvolvido por [Rui Fernando](https://github.com/rui-fernando), estudante de Ciência da Computação na Universidade Estadual da Paraíba (UEPB).
