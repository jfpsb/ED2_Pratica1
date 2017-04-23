package algoritmos.sort.insertion;

import algoritmos.dados.OrdenacaoDados;
import auxiliar.Imprimir;

public class InsertionSort {
	private static long numeroComparacoes;
	private static long numeroAtribuicoes;

	public void ChamaInsertionSort(int[] vetor, OrdenacaoDados ordenacao) {
		numeroAtribuicoes = 0;
		numeroComparacoes = 0;
		
		int []vetorAOrdenar = new int[vetor.length];
		
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

	private static void SortAsc(int[] vetor) {
		int i, j, chave;

		System.out.println("Ordenando vetor. Aguarde.");

		for (i = 1; i < vetor.length; i++) {
			chave = vetor[i];

			j = i;

			numeroAtribuicoes += 2;

			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}

			while (j > 0 && vetor[j - 1] > chave) {
				vetor[j] = vetor[j - 1];
				j--;

				numeroComparacoes += 2;
				numeroAtribuicoes += 2;
			}
			
			numeroComparacoes += 2;

			vetor[j] = chave;
			numeroAtribuicoes++;
		}
	}

	private static void SortDesc(int[] vetor) {
		int i, j, chave;

		System.out.println("Ordenando vetor. Aguarde.");

		for (i = 1; i < vetor.length; i++) {
			chave = vetor[i];

			j = i;

			numeroAtribuicoes += 2;

			if (i % 100000 == 0) {
				System.out.println("Ainda ordenando...");
			}

			while (j > 0 && vetor[j - 1] < chave) {
				vetor[j] = vetor[j - 1];
				j--;

				numeroComparacoes += 2;
				numeroAtribuicoes += 2;
			}

			vetor[j] = chave;
			numeroAtribuicoes++;
		}
	}
}
