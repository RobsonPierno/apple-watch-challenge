# apple-watch-challenge
Desafio proposto pela Avenue Code para comemorar o dia do Programador.

## Descrição:  
There are three boxes, and only one of them contains the long-awaited Apple Watch, which you can win if you guess which one it is.

The boxes are shuffled, and as soon as you choose one of them, the program will show you a different one - which will be empty (the program knows where the reward is!). As a player, it is up to you to change your initial choice. Do you keep your original guess or change the box you chose?

Your task is to write a program that simulates the above-mentioned problem and a function that proves which would be the best choice, change your guess or not!

## Como Testar:  
- Basta executar a classe AppleWatchChallengeApplicationTests.java.  
- Nela existe uma varivável chamada numberOfIterations que define a quantidade de iterações que deverão ser executadas de cada cenário (um onde sempre será subtituído a caixa selecionada pela outra caixa disponível, e o outro onde essa troca nunca é feita).  
- A quantidade de vezes em que resultar em o jogo terminar e a caixa escolhida for a premiada, o contador do respectivo cenário aumentará mais 1.  
- No final é apresentado 3 mensagens: quantidade de vitórias em cada cenário; melhor opção; percentual de acertos ao escolher a melhor opção.

## Observação:  
As linhas de comentários foram comentadas pois, em testes com muitas interações, exibir todas as mensagem faz com que o precesso demore mais, mas caso for feito um teste com menos iterações, as mensagens podem ser descomentadas para visualizar o resultado de cada partida.
