package algoritmos.sort.insertion;

public class InsertionSort {
	public int[] SortThroughInsertion(int[] vetor) {
		int i, j, chave;
		int vetorResposta[] = vetor;

		for (i = 1; i < vetorResposta.length; i++) {
			chave = vetorResposta[i];

			j = i;

			while (j > 0 && vetorResposta[j - 1] > chave) {
				vetorResposta[j] = vetorResposta[j - 1];
				j--;
			}

			vetorResposta[j] = chave;
		}

		return vetorResposta;
	}
}
