# Exercício 1 - Gerador de Observações

## Código Atual

O que identifiquei de pontos a melhorar no código atual foram:
- Validações que poderiam estar em métodos privados.
- Nomes de variáveis não são claros.
- Formatação de Strings, que ocorre em diversos pontos diferentes do código.

## Implementação

### Nova funcionalidade
Por desconhecer a estrutura além desta classe, julguei que a melhor implementação, sem interferir no comportamento
existente, seria a fazer a sobrecarga do método público `geraObservacao`, recebendo um `TreeMap <Integer, Double>`
como parâmetro. Como é uma classe que gera observações a partir de dados recebidos, acredito que os valores monetários também
seriam passados para a classe.

### Melhorias no código existente
- Implementação de testes.
- Maior clareza nos nomes de variáveis.
- Isolamento de validações em métodos privados.
- Melhoria na formatação de Strings.


# Exercício 2 - Cálculo de Composições

## Implementação

Neste exercício, percebi que o JSON trazia o valor unitário em branco quando uma composição era item de uma outra composição
(composição pai).

Diante desta situação, implementei o pattern Composite, devido a árvore de composições (Composição > Composição > Insumo).
Foi criada uma interface geral para a composição para que as classes de composição e insumo a implementassem. 

Foi necessário estudo para a implementação, já que foi a primeira vez que me deparei com esta necessidade.

https://refactoring.guru/pt-br/design-patterns/composite/java/example