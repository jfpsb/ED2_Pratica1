package algoritmos.sort.selection;

public class SelectionSort {
	public int[] SortThroughSelection(int[] vetor) {
		int i, j, menorIndex, temp;
		int vetorResposta[] = vetor;
		
		for(i = 0; i < vetor.length - 1; i++) {
			menorIndex = i;
			
			for(j = i + 1; j < vetor.length; j++) {
				if(vetorResposta[j] < vetor[menorIndex])
					menorIndex = j;
			}
			
			if(menorIndex != i) {
				temp = vetorResposta[menorIndex];
				vetorResposta[menorIndex] = vetor[i];
				vetorResposta[i] = temp;
			}				
		}
		
		return vetorResposta;
	}
}
