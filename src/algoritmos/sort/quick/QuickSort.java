package algoritmos.sort.quick;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

public class QuickSort {
	private int[] numbers;
	private int number;
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;

	public void chamaQuickSort(int[] vetor, OrdenacaoDados ordenacao) {
		numeroAtribuicoes = 0;
		numeroComparacoes = 0;
		
		// check for empty or null array
		if (vetor == null || vetor.length == 0) {
			return;
		}
		
		System.out.println("Ordenando vetor. Aguarde.");

		number = vetor.length;
		this.numbers = new int[vetor.length];

		System.arraycopy(vetor, 0, numbers, 0, vetor.length);

		long tempoInicial = System.currentTimeMillis();

		quicksort(0, number - 1, ordenacao);

		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		ordenacao.setNumeroAtribuicoes(numeroAtribuicoes);
		ordenacao.setNumeroComparacoes(numeroComparacoes);

		Imprimir.ImprimeResultado(Long.valueOf(tempoFinal).doubleValue(), numbers, ordenacao);
	}

	private void quicksort(int low, int high, OrdenacaoDados ordenacao) {
		int i = low, j = high, pivot;

		if (ordenacao.getPivo() == 'p') {
			pivot = numbers[low];
			numeroComparacoes++;
			numeroAtribuicoes++;
		} else if (ordenacao.getPivo() == 'u') {
			numeroComparacoes++;
			numeroAtribuicoes++;
			pivot = numbers[high];
		} else {
			pivot = numbers[low + (high - low) / 2];
			numeroAtribuicoes++;
		}

		// Divide into two lists
		while (i <= j) {
			if (ordenacao.getOrdem() == 'c') {
				numeroComparacoes++;
				while (numbers[i] < pivot) {
					i++;
					numeroComparacoes++;
					numeroAtribuicoes++;
				}

				while (numbers[j] > pivot) {
					j--;
					numeroComparacoes++;
					numeroAtribuicoes++;
				}
			} else {
				while (numbers[i] > pivot) {
					i++;
					numeroComparacoes++;
					numeroAtribuicoes++;
				}

				while (numbers[j] < pivot) {
					j--;
					numeroComparacoes++;
					numeroAtribuicoes++;
				}
			}

			// If we have found a value in the left list which is larger than
			// the pivot element and if we have found a value in the right list
			// which is smaller than the pivot element then we exchange the
			// values.
			// As we are done we can increase i and j
			if (i <= j) {
				numeroComparacoes++;
				exchange(i, j);
				i++;
				j--;
				numeroAtribuicoes += 2;
			}
		}
		
		// Recursion
		if (low < j) {
			numeroComparacoes++;
			quicksort(low, j, ordenacao);
		}
		if (i < high) {
			numeroComparacoes++;
			quicksort(i, high, ordenacao);
		}
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;

		numeroAtribuicoes += 3;
	}
}