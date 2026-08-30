# Passwords-LEDA

Projeto acadêmico em Java para análise e classificação de força de senhas a partir de um dataset (CSV) com senhas e metadados. Desenvolvido como parte da disciplina de Laboratório de Estrutura de Dados Avançada (LEDA).

## 📋 Sobre o projeto

O projeto processa um arquivo CSV com senhas, classificando cada uma de acordo com sua robustez (com base em critérios como comprimento e diversidade de caracteres), reformatando datas para o padrão brasileiro e, por fim, filtrando apenas as senhas consideradas mais seguras. O pipeline é dividido em três etapas independentes, cada uma implementada em uma classe Java.

## ⚙️ Pipeline de processamento

O projeto funciona em três etapas sequenciais, cada uma lendo o resultado da etapa anterior:

### 1. Classificação de senhas (`ClassicacaoDeSenhas`)
- Lê `files/passwords.csv`.
- Classifica cada senha com base no comprimento e na diversidade de tipos de caractere (minúsculas, maiúsculas, dígitos, caracteres especiais), atribuindo uma categoria: `Muito ruim`, `Ruim`, `Fraca`, `Boa` ou `Muito Boa`.
- Gera `files/password_classifier.csv`.

### 2. Transformação de datas (`TransformacoesDeDatas`)
- Lê `files/password_classifier.csv`.
- Converte as datas do formato original para o padrão brasileiro (`dd/MM/yyyy`).
- Gera `files/passwords_formated_data.csv`.

### 3. Filtragem categórica (`FiltrarSenhaCategoricamente`)
- Lê `files/passwords_formated_data.csv`.
- Filtra apenas as senhas classificadas como `Boa` ou `Muito Boa`.
- Gera `files/passwords_classifier.csv`.

## 🛠️ Tecnologias utilizadas

- **Java** (com suporte a módulos — `module-info.java`)
- Manipulação de arquivos via `BufferedReader`/`BufferedWriter`
- `java.time` para tratamento de datas

## 📁 Estrutura do projeto

```
Passwords-LEDA/
├── src/
│   ├── module-info.java
│   └── passwords/
│       ├── ClassicacaoDeSenhas.java          # Etapa 1: classificação
│       ├── TransformacoesDeDatas.java        # Etapa 2: formatação de datas
│       └── FiltrarSenhaCategoricamente.java  # Etapa 3: filtragem
├── bin/                                       # Arquivos compilados
└── files/                                     # Dados de entrada e saída (CSV)
```

## ▶️ Como executar

### Pré-requisitos
- JDK instalado

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/rui-fernando/Passwords-LEDA.git
   cd Passwords-LEDA
   ```
2. Certifique-se de que o arquivo de entrada `passwords.csv` está na pasta `files/`.
3. Compile e execute as classes na ordem do pipeline:
   ```bash
   javac -d bin src/passwords/*.java
   java -cp bin passwords.ClassicacaoDeSenhas
   java -cp bin passwords.TransformacoesDeDatas
   java -cp bin passwords.FiltrarSenhaCategoricamente
   ```
4. Os arquivos de saída serão gerados na pasta `files/`, conforme cada etapa.

## 📌 Nota

Este projeto tem fins exclusivamente educacionais, para prática de manipulação de arquivos, estruturas de dados e processamento de dados em Java. O dataset utilizado é de uso acadêmico comum em exercícios de classificação de força de senhas.

## 👤 Autor

Desenvolvido por [Rui Fernando](https://github.com/rui-fernando), estudante de Ciência da Computação na Universidade Estadual da Paraíba (UEPB).
