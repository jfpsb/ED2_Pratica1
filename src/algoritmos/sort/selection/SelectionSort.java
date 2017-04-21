package algoritmos.sort.selection;

public class SelectionSort {
	public int[] SortThroughSelection(int[] vetor, boolean asc) {
		int i, j, index, temp;
		int vetorResposta[] = vetor;

		for (i = 0; i < vetor.length - 1; i++) {
			index = i;

			for (j = i + 1; j < vetor.length; j++) {
				if (asc) {
					if (vetorResposta[j] < vetor[index])
						index = j;
				} else {
					if (vetorResposta[j] > vetor[index])
						index = j;
				}
			}

			if (index != i) {
				temp = vetorResposta[index];
				vetorResposta[index] = vetor[i];
				vetorResposta[i] = temp;
			}
		}

		return vetorResposta;
	}
}
