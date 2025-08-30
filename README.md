# Projeto de Classificação e Ordenação de Senhas

##  Funcionamento do Projeto

Este projeto realiza a **classificação**, **transformação** e **ordenação** de senhas a partir de um arquivo CSV com dados brutos. O fluxo é dividido em etapas, detalhadas abaixo.

---

## Pré-requisitos

- Certifique-se de que o arquivo `passwords.csv` está localizado na pasta `dadosEntrada/`.

---

##  Etapa 1 – Classificação de Senhas

Execute a classe `ClassificadorPassword`. Ela irá:

- Ler o arquivo `passwords.csv`.
- Gerar o arquivo `password_classifier.csv` na pasta `dadosSaida/`, com todas as senhas e suas respectivas classificações:
  - **Muito Ruim**
  - **Ruim**
  - **Fraca**
  - **Boa**
  - **Muito Boa**

---

##  Etapa 2 – Transformação dos Dados

Execute a classe `transformacao`. Esta etapa realiza:

- Geração do arquivo `passwords_formated_data.csv` com datas no formato brasileiro (`dd/MM/yyyy`);
- Geração do arquivo `passwords_classifier.csv`, contendo apenas as senhas **"Boa"** e **"Muito Boa"**, com datas formatadas corretamente.

---

##  Etapa 3 – Ordenação das Senhas

###  Por Comprimento da Senha
Execute a classe `Main_length`.  
Ordena as senhas pelo **tamanho**, nos cenários:

- Melhor caso (já ordenado)
- Caso médio (embaralhado)
- Pior caso (invertido)

Com os algoritmos:

- Insertion Sort
- Heap Sort
- Merge Sort
- Counting Sort
- Selection Sort
- Quick Sort
- Quick Sort com Mediana de Três
- Bubble Sort

---

###  Por Data Completa

Execute a classe `Main_data` (localizada em `src/`).  
Ordena as senhas por **data completa**, utilizando os mesmos algoritmos e cenários.

---

###  Por Mês da Data

Execute a classe `Main_month`.  
Ordena as senhas pelo **mês da data**, nos três cenários, com os mesmos algoritmos.

---

##  Saída dos Resultados

Todos os arquivos gerados nas etapas acima são salvos na pasta `dadosSaida/`.

---

##  Arquivos Suporte

- `leitor_entrada`: Lê os dados do arquivo CSV.
- `Dados_password`: Modela e estrutura os dados para uso interno nas ordenações e análises.

---
