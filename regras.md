# Regras

1. Não usar getter e setters
   1.  Tell, Don't ask
2. Ter apenas um nível de indentação por método
3. Nunca use else
   1. Early returning 
   2. Fail fast
   3. Complexidade Ciclomática: métrica de complexidade com base em quantos elses há no código
4. Envolva os seus tipos primitivos (caso eles tenham comportamento)
5. Coleções de primeira classe
   1. Quando for uma linguagem dinamicamente tipada é interessante extrair uma propriedade que representa uma coleção para uma classe 
6. Tenha apenas 1 ponto (operador de acesso de objetos) por linha (instrução)
   1. lei de Demeter (não falar com estranhos)
   2. Exceção: fluent interface
7. Nunca abrevie
8. Mantenha suas classes (máx. 50 linhas) e pacote pequenos (máx. 10 classes)
9. Tenha no máximo 2 propriedades por classe (Não é necessário seguir a risca)

Object Calisthenics são exercícios de programação, formado por um conjunto de 9 regras criado por Jeff Bay no seu livro The ThoughtWorks Anthology