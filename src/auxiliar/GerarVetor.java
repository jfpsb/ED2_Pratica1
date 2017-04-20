package auxiliar;

import java.util.Random;

public class GerarVetor {
	public int[] gerarVetorAleatorio(int tamanho, char posicao, int porcentagem) {
		Random random = new Random();
		int[] vetor = new int[tamanho];
		int tamanhoPorcentagem = tamanho * (porcentagem / 100);

		int aux = random.nextInt(20);

		if (tamanhoPorcentagem == tamanho) {
			for (int i = 0; i < tamanho; i++) {
				vetor[i] = aux + i;
			}
		} else {
			if (posicao == 'I') {
				// Elementos até o valor da porcentagem informada são ordenados no início
				for (int i = 0; i < tamanhoPorcentagem; i++) {
					vetor[i] = aux + i;
				}

				for (int i = tamanhoPorcentagem; i < tamanho; i++) {
					vetor[i] = random.nextInt(50);
				}
			} else {
				// Elementos até o valor da porcentagem informada são ordenados no final
				for (int i = 0; i < tamanhoPorcentagem; i++) {
					vetor[i] = random.nextInt(50);
				}

				for (int i = tamanhoPorcentagem; i < tamanho; i++) {
					vetor[i] = aux + i;
				}
			}
		}

		return vetor;
	}
}
