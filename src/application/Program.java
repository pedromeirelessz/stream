package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		// Stream � uma solu��o para processar sequencias de dados de forma:
		// Declarativa ( Intera��o interna escondida do programador)
		// Parallel-friendly ( imut�vel -> Thread safe )
		// Sem efeitos colaterais
		// Sob demanda ( Lazy evaluation)

		// Acesso sequencial ( N�o h� �ndices)

		// Single-use: S� pode ser usada uma vez

		// Pipeline: Opera��es em streams retornam novas strams, ent�o � poss�vel criar
		// uma cadeia de opera��es ( Fluxo de processamento )

		// Criando uma lista do tipo Integer, e ja iniciando ela com o Arrays.asList()
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		// Uma stream pode ter 0 ou mais opera��es intermedi�rias, mas tem que ter pelo
		// menos 1 opera��o terminal.
		// No caso desse exemplo a opera��o terminal est� no no System.out.println:
		// toArray, que converte a stream para um vetor, a opera��o intermedi�ria � o map
		// que aplica uma fun��o para cada elemento da stream, no caso: a cada elemento
		// multiplique ele por 10.
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));

		// Stream.of: Permite colocar os elementos diretamente na stream
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));

		// Quem � o primeiro elemento da minha stream? e qual a fun��o de itera��o dos
		// pr�ximos elementos?
		// nesse exemplo:
		// Minha stream inicia com 0, a cada elemento adicione o elemento +2, com limite
		// de 10.
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2).limit(10);
		System.out.println(Arrays.toString(st3.toArray()));

		Stream<Long> st4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] }).map(p -> p[0]).limit(10);
		System.out.println(Arrays.toString(st4.toArray()));
	}
}
