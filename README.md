📚 Backend - Sistema de Gerenciamento de Notas e Frequência

Este é o backend da aplicação para gerenciamento de notas e frequência dos alunos do professor Carlos.

 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA (Hibernate)
- REST API

 ▶️ Como Executar

1. Certifique-se de ter o Java 17 instalado.
2. Navegue até o diretório `backend`.
3. Rode o projeto com o Spring Boot (via IDE ou comando Maven):
   ```bash
   ./mvnw spring-boot:run
   ```
4. O backend será iniciado na porta `8080` por padrão.

 📦 Endpoints Disponíveis

- `GET /alunos` — Lista todos os alunos.
- `POST /alunos` — Cadastra um novo aluno.
- `GET /alunos/estatisticas` — Retorna as estatísticas da turma.

 📌 Premissas

- Cada aluno possui 5 notas, uma para cada disciplina.
- A frequência é representada em percentual (0 a 100).
- Não há autenticação implementada.

 🧠 Decisões de Projeto
 - Foi utilizado Spring Boot para facilitar a criação da API REST.
- O modelo de aluno armazena as notas em uma lista.
- As estatísticas são calculadas dinamicamente.

 ℹ️ Informações Adicionais

O backend armazena os dados em memória (sem banco de dados) para fins de simplicidade.
