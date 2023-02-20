# Projeto de Cartões

Este projeto foi desenvolvido para gerenciar informações de cartões de crédito e seus clientes.

## Funcionalidades

O projeto possui as seguintes funcionalidades:

- Cadastro de novos cartões utilizando o método `@PostMapping`
- Consulta de cartões por renda utilizando o método `@GetMapping(params = "renda")`
- Consulta de cartões por CPF do cliente utilizando o método `@GetMapping(params = "cpf")`

## Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- Java
- Spring Boot
- Banco de dados PostgreSQL

## Como executar o projeto

Para executar o projeto, siga as instruções abaixo:

1. Faça o clone do repositório para o seu computador.
2. Importe o projeto em sua IDE preferida.
3. Execute o arquivo `CartoesApplication.java`.
4. Acesse o endereço `http://localhost:8080` em seu navegador.

## Descrição dos métodos

### cadastro

Método responsável por cadastrar novos cartões no sistema. O método espera um objeto do tipo `CartaoRequestDto` no corpo da requisição, que é convertido para um objeto `Cartao` e salvo no banco de dados utilizando o método `cartaoService.save()`. O método retorna uma resposta com o status HTTP 201 (Created).

Exemplo de requisição:

```http
POST /cartoes
{
  "numero": "1234567890123456",
  "dataValidade": "2024-12-01",
  "clienteId": 1
}

