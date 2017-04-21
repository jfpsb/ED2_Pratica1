package algoritmos.sort.counting;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

public class CountingSort {
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;
	
	public void ChamaCountingSort(int[] array, OrdenacaoDados ordenacao) {
		long tempoInicial = System.currentTimeMillis();
		int[] vetorAOrdenar = new int[array.length], counts, resultadoMaxMin;
		int max, min;

		resultadoMaxMin = RetornaMaxMin(array);

		max = resultadoMaxMin[0];
		min = resultadoMaxMin[1];

		counts = PreparaVetorContagem(array, max, min);

		if (ordenacao.getOrdem() == 'c') {
			SortAsc(array, counts, vetorAOrdenar, min);
		} else {
			SortDesc(array, counts, vetorAOrdenar, min);
		}

		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		
		ordenacao.setNumeroAtribuicoes(numeroAtribuicoes);
		ordenacao.setNumeroComparacoes(numeroComparacoes);

		Imprimir.ImprimeResultado(Long.valueOf(tempoFinal).doubleValue(), vetorAOrdenar, ordenacao);
	}

	/**
	 * Retorna o maior e menor elementos do vetor.
	 * 
	 * @param array
	 *            Vetor a ser ordenado
	 * @return Vetor com max e min
	 */
	private static int[] RetornaMaxMin(int[] array) {
		int[] resultado = new int[2];

		int min = array[0];
		int max = array[0];
		
		numeroAtribuicoes += 2;
		
		for (int i = 1; i < array.length; i++) {
			numeroComparacoes++;
			if (array[i] < min) {
				min = array[i];
				numeroAtribuicoes++;
				numeroComparacoes++;
			} else if (array[i] > max) {
				max = array[i];
				numeroAtribuicoes++;
				numeroComparacoes++;
			}
		}

		resultado[0] = max;
		resultado[1] = min;

		return resultado;
	}

	/**
	 * Cria o vetor que vai guardar a contagem dos elementos de array e realiza
	 * a soma dos valores
	 * 
	 * @param array
	 *            Vetor a ser ordenado
	 * @param max
	 *            Maior elemento do vetor
	 * @param min
	 *            Menor elemento do vetor
	 * @return Retorna o vetor com os valores
	 */
	public static int[] PreparaVetorContagem(int[] array, int max, int min) {
		// Para diminuir o uso de memória o vetor de contagem tem o tamanho
		// igual ao valor do maior elemento do vetor menos o menor elemento + 1
		int[] counts = new int[max - min + 1];

		// Realiza a contagem
		for (int i = 0; i < array.length; i++) {
			counts[array[i] - min]++;
			numeroAtribuicoes++;
			numeroComparacoes++;
		}

		// Soma dos valores dos indexes
		for (int i = 1; i < counts.length; i++) {
			counts[i] = counts[i] + counts[i - 1];
			numeroAtribuicoes++;
			numeroComparacoes++;
		}

		return counts;
	}

	/**
	 * Realiza Counting Sort em ordem ascendete
	 * 
	 * @param array
	 *            Vetor a ser ordenado
	 * @param counts
	 *            Vetor que contém a contagem
	 * @param aux
	 *            Vetor auxiliar que conterá o vetor resultado
	 * @param min
	 *            Menor elemento de vetor
	 */
	private static void SortAsc(int[] array, int[] counts, int[] aux, int min) {
		System.out.println("Ordenando vetor. Aguarde.");
		
		for (int i = 0; i < array.length; i++) {
			int temp = counts[array[i] - min] - 1;
			aux[temp] = array[i];
			counts[array[i] - min]--;
			
			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}
			
			numeroAtribuicoes += 3;
			numeroComparacoes++;
		}
	}

	/**
	 * Realiza Counting Sort em ordem decrescente
	 * 
	 * @param array
	 *            Vetor a ser ordenado
	 * @param counts
	 *            Vetor que contém a contagem
	 * @param aux
	 *            Vetor auxiliar que conterá o vetor resultado
	 * @param min
	 *            Menor elemento de vetor
	 */
	private static void SortDesc(int[] array, int[] counts, int[] aux, int min) {
		System.out.println("Ordenando vetor. Aguarde.");
		
		for (int i = 0; i < array.length; i++) {
			int temp = Math.abs(counts[array[i] - min] - array.length);
			aux[temp] = array[i];
			counts[array[i] - min]--;
			
			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}
			
			numeroAtribuicoes += 3;
			numeroComparacoes++;
		}
	}
}
