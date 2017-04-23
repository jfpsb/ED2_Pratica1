package algoritmos.sort.selection;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

public class SelectionSort {
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;

	public void chamaSelectionSort(int[] vetor, OrdenacaoDados ordenacao) {
		numeroAtribuicoes = 0;
		numeroComparacoes = 0;

		int[] vetorAOrdenar = new int[vetor.length];

		System.arraycopy(vetor, 0, vetorAOrdenar, 0, vetor.length);

		long tempoInicial = System.currentTimeMillis();

		if (ordenacao.getOrdem() == 'c') {
			SortAsc(vetorAOrdenar);
		} else {
			SortDesc(vetorAOrdenar);
		}

		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		ordenacao.setNumeroAtribuicoes(numeroAtribuicoes);
		ordenacao.setNumeroComparacoes(numeroComparacoes);

		Imprimir.ImprimeResultado(Long.valueOf(tempoFinal).doubleValue(), vetorAOrdenar, ordenacao);
	}

	private static int[] SortAsc(int[] vetor) {
		int i, j, index, temp;

		System.out.println("Ordenando vetor. Aguarde.");

		for (i = 0; i < vetor.length - 1; i++) {
			index = i;
			numeroAtribuicoes++;

			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}

			for (j = i + 1; j < vetor.length; j++) {
				numeroComparacoes++;
				if (vetor[j] < vetor[index]) {
					index = j;
					numeroAtribuicoes++;
					numeroComparacoes++;
				}
			}

			numeroComparacoes++;

			if (index != i) {
				temp = vetor[index];
				vetor[index] = vetor[i];
				vetor[i] = temp;
				numeroComparacoes++;
				numeroAtribuicoes += 3;
			}
		}

		return vetor;
	}

	private static void SortDesc(int[] vetor) {
		int i, j, index, temp;

		System.out.println("Ordenando vetor. Aguarde.");

		for (i = 0; i < vetor.length - 1; i++) {
			index = i;
			numeroAtribuicoes++;

			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}

			for (j = i + 1; j < vetor.length; j++) {
				numeroComparacoes++;
				if (vetor[j] > vetor[index]) {
					index = j;
					numeroAtribuicoes++;
				}
			}

			numeroComparacoes++;

			if (index != i) {
				temp = vetor[index];
				vetor[index] = vetor[i];
				vetor[i] = temp;

				numeroComparacoes++;
				numeroAtribuicoes += 3;
			}
		}
	}
}
