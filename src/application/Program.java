package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {

		// Stream é uma solução para processar sequencias de dados de forma:
		// Declarativa ( Interação interna escondida do programador)
		// Parallel-friendly ( imutável -> Thread safe )
		// Sem efeitos colaterais
		// Sob demanda ( Lazy evaluation)

		// Acesso sequencial ( Não há índices)

		// Single-use: Só pode ser usada uma vez

		// Pipeline: Operações em streams retornam novas strams, então é possível criar
		// uma cadeia de operações ( Fluxo de processamento )

		// Criando uma lista do tipo Integer, e ja iniciando ela com o Arrays.asList()
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

		// Uma stream pode ter 0 ou mais operações intermediárias, mas tem que ter pelo
		// menos 1 operação terminal.
		// No caso desse exemplo a operação terminal está no no System.out.println:
		// toArray, que converte a stream para um vetor, a operação intermediária é o map
		// que aplica uma função para cada elemento da stream, no caso: a cada elemento
		// multiplique ele por 10.
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));

		// Stream.of: Permite colocar os elementos diretamente na stream
		Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
		System.out.println(Arrays.toString(st2.toArray()));

		// Quem é o primeiro elemento da minha stream? e qual a função de iteração dos
		// próximos elementos?
		// nesse exemplo:
		// Minha stream inicia com 0, a cada elemento adicione o elemento +2, com limite
		// de 10.
		Stream<Integer> st3 = Stream.iterate(0, x -> x + 2).limit(10);
		System.out.println(Arrays.toString(st3.toArray()));

		Stream<Long> st4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] }).map(p -> p[0]).limit(10);
		System.out.println(Arrays.toString(st4.toArray()));
	}
}
