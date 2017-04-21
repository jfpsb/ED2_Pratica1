package algoritmos.sort.merge;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

public class MergeSort {
	private int[] numbers;
	private int[] helper;
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;
	private int number;

	public void chamaMergeSort(int[] vetor, OrdenacaoDados ordenacao) {
		number = vetor.length;
		this.helper = new int[number];
		this.numbers = new int[vetor.length];

		System.arraycopy(vetor, 0, numbers, 0, vetor.length);

		long tempoInicial = System.currentTimeMillis();

		mergesort(0, number - 1, ordenacao);

		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		ordenacao.setNumeroAtribuicoes(numeroAtribuicoes);
		ordenacao.setNumeroComparacoes(numeroComparacoes);

		Imprimir.ImprimeResultado(Long.valueOf(tempoFinal).doubleValue(), numbers, ordenacao);
	}

	private void mergesort(int low, int high, OrdenacaoDados ordenacao) {
		// check if low is smaller than high, if not then the array is sorted
		System.out.println("Ordenando vetor. Aguarde.");
		if (low < high) {
			numeroComparacoes++;
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle, ordenacao);
			// Sort the right side of the array
			mergesort(middle + 1, high, ordenacao);
			// Combine them both
			merge(low, middle, high, ordenacao);
		}
	}

	private void merge(int low, int middle, int high, OrdenacaoDados ordenacao) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			numeroComparacoes++;
			helper[i] = numbers[i];
		}

		numeroComparacoes++;

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			numeroComparacoes += 2;
			if (ordenacao.getOrdem() == 'c') {
				if (helper[i] <= helper[j]) {
					numeroComparacoes++;
					numbers[k] = helper[i];
					i++;
				} else {
					numbers[k] = helper[j];
					j++;
				}
			} else {
				if (helper[i] >= helper[j]) {
					numeroComparacoes++;
					numbers[k] = helper[i];
					i++;
				} else {
					numbers[k] = helper[j];
					j++;
				}
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numeroComparacoes++;
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
}