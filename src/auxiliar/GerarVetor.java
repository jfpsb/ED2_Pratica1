package auxiliar;

import java.util.Random;

import algoritmos.dados.OrdenacaoDados;

public class GerarVetor {
	public <T> int[] gerarVetorAleatorio(OrdenacaoDados ordenacao) {
		Random random = new Random();
		int[] vetor = new int[ordenacao.getElementos()];

		double tamanhoPorcentagem = ordenacao.getElementos() * (ordenacao.getPorcentagem() / 100);

		int aux = random.nextInt(10);

		if (tamanhoPorcentagem == ordenacao.getElementos()) {
			for (int i = 0; i < ordenacao.getElementos(); i++) {
				vetor[i] = aux + i;
			}
		} else {
			if (ordenacao.getInicioFimOrdenados() == 'i') {
				// Elementos até o valor da porcentagem informada são ordenados
				// no início
				for (int i = 0; i < Math.floor(tamanhoPorcentagem); i++) {
					vetor[i] = aux + i;
				}

				for (double i = Math.floor(tamanhoPorcentagem); i < ordenacao.getElementos(); i++) {
					vetor[(int) i] = random.nextInt(2500);
				}
			} else {
				// Elementos até o valor da porcentagem informada são ordenados
				// no final
				for (int i = 0; i < tamanhoPorcentagem; i++) {
					vetor[i] = random.nextInt(2500);
				}

				for (double i = Math.floor(tamanhoPorcentagem); i < ordenacao.getElementos(); i++) {
					vetor[(int) i] = (int) (aux + i);
				}
			}
		}

		return vetor;
	}
}
