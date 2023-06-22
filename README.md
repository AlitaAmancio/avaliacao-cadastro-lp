#  Sistema de Cadastro (Avaliação LP)

Projeto que conclui a matéria "Linguagem de Programação" do segundo semestre da Fatec SJC.

## Sobre o Desafio

O desafio proposto foi desenvolver um aplicação desktop, na linguagem Java e utilizando o banco de dados relacional MySQL, que possibilitasse ao usuário Criar (CREATE), Buscar (READ), Atualizar (UPDATE) e Deletar (DELETE) cadastros. Além do CRUD completo deveria existir um método que calculasse o IMC (Índice de Massa Corporal) de cada uma dessas pessoas, oferecendo a opção de salvar os registros na área de trabalho. 

## Sobre a Aplicação

Caso tenha interesse em testá-la é essencial alterar as váriaveis de ambiente após clonar o repositório em sua máquina, garantindo a conexão com seu banco de dados e o caminho correto para a impressão do relatório IMC. O código que deve ser inserido no MySQL para a criação da Database encontra-se dentro do próprio arquivo, mais específicamente dentro do package "resources" sob o nome "script.sql". A aplicação cumpre os requisitos propostos possuindo integração com o DB e três telas funcionais para interação com o usuário (excluindo a inicial, que atualmente funciona como Placeholder), resumidamente possuem as seguintes características:

*Obs: Todos os dados cadastrados são fictícios e não correspondem a nenhuma pessoa real.*

**Tela de Visualização:**
Tela para qual somos redirecionados logo após a tela placeholder, apresentando em uma tabela todos os clientes atualmente cadastrados. Quando um registro é selecionado torna-se possível acessar as opções de "Atualizar Dados" ou "Calcular IMC". A tela também conta com uma barra de busca que encontra os clientes pelo nome (ou caractere que faça parte dos nomes) e os botões "Novo Cliente" e "Deslogar", o primeiro leva para a página de cadastro e o segundo "desloga" da aplicação, trazendo de volta para a tela placeholder.

![TelaVisualização](https://github.com/AlitaAmancio/avaliacao-cadastro-lp/assets/89790349/a6d9af99-e0ea-46be-a46a-0808a9ba1e56)

**Tela de Cadastro:**
Ao clicar no botão "Novo Cliente" em qualquer uma das páginas, somos redirecionados para a tela de cadastro. Essa página apresenta em uma tabela todos os clientes atualmente cadastrados (não sendo possível sua seleção), conta tambem com a barra de busca, os botões "Deslogar" e "Visão Geral" (que leva para a página de visualização) e os campos para a inserção de novas informações. Esses campos de texto possuem "Masks", uma formatação fixa que facilita na hora de inserir as informações no DB e realizar o cálculo necessário do IMC. O botão "Limpar" limpa os campos de texto e o "Salvar" salva o novo cliente no DB caso ainda não haja cadastro para o cpf informado.

![TelaCadastro](https://github.com/AlitaAmancio/avaliacao-cadastro-lp/assets/89790349/dd6961e0-d0b0-4363-82c9-95f6096b8f86)

**Tela de Cliente:**
Essa tela é acessada exclusivamente pelo botão "Atualizar Dados" ou pela barra de busca, possuindo uma tabela que faz o display de uma única linha (row). Caso existam multiplos resultados para a busca o título muda para refletir a quantidade encontrada, o número e nome do registro selecionado. Além de poder atualizar os dados essa tela também conta com o botão "Calcular IMC" e os que redirecionam para as outras páginas.

![TelaCliente](https://github.com/AlitaAmancio/avaliacao-cadastro-lp/assets/89790349/d0234e16-f91d-428e-bb26-b3dede134045)

## Tecnologias Utilizadas

* [Java](https://dev.java/) — Linguagem de Programação.
* [Apache NetBeans](https://netbeans.apache.org/) — IDE.
* [MySQL](https://www.mysql.com/) — DB relacional.

## Implementações para o Futuro

Mesmo com o projeto já entregue pretendo testar algumas outras funcionalidades, portanto é possível que hajam atualizações futuras nesse repositório, principalmente no que diz respeito a FrontEnd.


## Aprendizados e Comentários Finais

Essa simples aplicação foi meu primeiro projeto individual onde tive a oportunidade de pensar e desenvolver cada um dos detalhes, desde a integração com o DB até as interfaces em si, Front e BackEnd, isso em uma linguagem cujo meu primeiro contato foi através dessa disciplina. Considerando as circunstâncias meu objetivo não foi necessáriamente buscar as melhores decisões estéticas, ou mesmo escrever o código mais "clean" (coisas que virão com mais estudo e prática), mas aproveitei dessa liberdade para descobrir e experimentar as diversas possibilidades que o Swing me oferecia, desenvolvendo um grande interesse pela linguagem durante o processo. Algumas dessas descobertas permaneceram no produto final, como o uso de Masks e outras opções de formatação de dados, já outras não permaneceram até o fim, como o uso do "Card Layout", ferramenta em que baseei todo projeto num primeiro protótipo. Além dessas questões, durante o desenvolvimento, experimentei principalmente com códigos customizados, eventos e interações entre os elementos visíveis e não visíveis na tela, alterando e interligando o comportamento dos diferentes botões, tabelas e avisos do sistema, mas ainda garantindo coerencia e facilidade de visualização e compreensão. Por fim gostaria de agradecer à professora de LP e a faculdade em si pela proposta e o incentivo ao estudo!

