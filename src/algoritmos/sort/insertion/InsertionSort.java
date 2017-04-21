package algoritmos.sort.insertion;

public class InsertionSort {
	private static long numeroComparacoes = 0;
	private static long numeroAtribuicoes = 0;

	public void ChamaInsertionSort(int[] vetor, char inicioOuFim, int porcentagem, char ordem) {
		long tempoInicial = System.currentTimeMillis();

		if (ordem == 'c') {
			SortAsc(vetor);
		} else {
			SortDesc(vetor);
		}

		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		ImprimeDados(Long.valueOf(tempoFinal).doubleValue(), vetor, inicioOuFim, porcentagem, ordem);
	}

	private static void ImprimeDados(double tempoTotal, int vetor[], char inicioOuFim, int porcentagem, char ordem) {
		System.out.println("Algoritmo executado: Insertion Sort");
		System.out.println("Quantidade de elementos em vetor: " + vetor.length);
		System.out.println("Ordenação " + ((ordem == 'c') ? "ascendente" : "descendente"));
		System.out.println(
				porcentagem + "% " + ((inicioOuFim == 'i') ? "iniciais" : "finais") + " do vetor já ordenados");
		System.out.println("A ordenação durou um tempo total de: " + (tempoTotal / 1000) + " segundo(s)");
		System.out.println("O número de comparações executadas foi: " + numeroComparacoes);
		System.out.println("O número de atribuições foi: " + numeroAtribuicoes);
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
