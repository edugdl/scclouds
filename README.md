# 1 - Fibonacci
- Criar uma função em sua linguagem preferida. A função deve receber um numero N >= 0 (deve validar o input para a função), e retornar o valor correspondente desse número na sequencia fibonnaci. EX. fib(0) =0; fib(1) = 1; fib(2) = 1; fib(3) = 2; fib(5) = 5; fib(6) = 8.
- Criar uma função recursiva que resolva fibonacci
- Criar uma função linear que resolva fibonnaci

A sequência de Fibonacci se baseia no enésimo termo da sequência ser a soma de seus dois anteriores (F(n) = F(n-1) + F(n-2)). 

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

Na solução recursiva, o processo é mais simples. Se queremos o termo 0 ou 1, seu valor é automaticamente retornado. Caso contrário, retornamos a soma da solução recursiva de n-1 + solução recursiva de n-2. Assim, chegamos na mesma resposta.

Já na solução linear, primeiramente, se queremos o termo 0 ou 1, retornamos seu valor. Caso contrário, adotei uma estratégia de criar duas variáveis, onde 
em uma seria guardado o valor anterior *(F(n-1), que posteriormente se tornará F(n-2))*, e em outra o valor atual *(F(n), que posteriormente se tornará F(n-1))*. Para gerar o próximo termo, é nessário a criação de uma variável temporária. 
Nela será guardado o valor atual, o valor atual será a soma dele mesmo com o valor anterior (F(n) = F(n-1) + F(n-2)), e o valor anterior será igual à variável temporária (F(n-1)). Assim, após todas as iterações é possível achar o termo da sequência. 

# 2 - Números primos
- Criar uma função em sua linguagem preferida. A função deve receber um numero N > 1 (validar o input), e retornar todos os números primos até o numero N. EX. p(2) = [2]; p(3) = [2, 3]; p(10) = [2, 3, 5, 7];
- Criar uma função recursiva que resolva p
- Criar uma função linear que resolva p

Um número primo se define por ser divisível somnte por 1 e por ele mesmo.

2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97...

Antes de comentar sobre as soluções em geral, gostaria de explicar a divisibilidade de um número e lógica utilizada no método de limite de verificações.

Um número qualquer pode ser escrito como infinitas multiplicações de dois números no conjunto dos reais (n•m; n,m e R). Por exemplo, o primeiro número primo, 2, pode ser escrito como 1•2, 3•0.66666..., 1000 * 0,002, entre outras infinitas combinações.
Porém o que define ele ser primo, é que existe um único par de multiplicações entre dois números naturais que resultam nele mesmo (n•m; n,m e N) = (1•n, n•1). Dessa maneira, ao invés de testar a divisibilidade por todos os números anteriores, é
necessário verificarmos somente a parte "baixa" do produto. Pensando mais afundo sobre o assunto, podemos definir um número limite, onde a partir dele, não precisariamos testar mais nenhum outro número. Vamos usar como teste o número 49. Seus 
únicos divisores são 1, 7 e 49. Se testarmos qualquer número acima de 7, como 8 por exemplo, seu par seria 49/8 = 6,125, ou seja, conforme vamos crescendo os divisores, seus respectivos pares já foram testados, ou não são naturais. Dessa forma, 
o maior par possível é sua raíz quadrada * raíz quadrada. Assim, qualquer teste de divisores após sua raíz, não é necessário. A fim de reduzir ainda mais os divisores, podemos eliminar os números não primos. Todo número não primo pode ser formado pelo produto
de um número primo * um número natural. Dessa forma, só é necessário testar a divisão com números primos menores ou iguais a sua raíz quadrada.

Em ambas soluções, foi criada uma lista para armazenar todos os primos calculados. Após isso, foram iterados todos os números de 2 até n, para testar sua divisibilidade. Se em algum momento o divisor fosse maior que a raíz, o número é primo.
Na solução recursiva, começamos dividindo por n. Caso seja, não é primo, caso contrário,  chama a função e define o divisor como n+1. Na solução linear, foi criado uma estrutura de repetição iterando por todos os primos. Caso o número seja divisível
por um primo, não é primo, caso contrário, é primo.

Como esperado, em ambos desafios a solução linear obteve um tempo de execução muito superior em larga escala. Quando comparada as soluções dos primos, a solução recursiva demora aproximadamente 340x mais do que a linear, quando input = 10 milhões.
