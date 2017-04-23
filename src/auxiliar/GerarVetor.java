package auxiliar;

import java.util.ArrayList;
import java.util.Collections;

import algoritmos.dados.OrdenacaoDados;

public class GerarVetor {
	public <T> int[] gerarVetorAleatorio(OrdenacaoDados ordenacao) {
		int[] vetor = new int[ordenacao.getElementos()];
		ArrayList<Integer> lista;

		double tamanhoPorcentagem = ordenacao.getElementos() * (ordenacao.getPorcentagem() / 100);

		// Gera vetor totalmente desordenado sem repetições
		if (tamanhoPorcentagem == 0) {
			lista = new ArrayList<Integer>();

			for (int i = 0; i < ordenacao.getElementos(); i++) {
				lista.add(i);
			}

			Collections.shuffle(lista);

			for (int i = 0; i < ordenacao.getElementos(); i++) {
				vetor[ i] = lista.get(i);
			}
		} else if (tamanhoPorcentagem == ordenacao.getElementos()) {
			// Gera vetor totalmente ordenado sem repetições
			for (int i = 0; i < ordenacao.getElementos(); i++) {
				vetor[i] = i;
			}
		} else {
			// Gera vetor inicialmente ordenado baseado em porcentagem informada pelo usuário
			lista = new ArrayList<Integer>();
			double pisoPorcentagem = Math.floor(tamanhoPorcentagem);

			for (int i = 0; i < pisoPorcentagem; i++) {
				vetor[i] = i;
			}

			for (int i = (int) pisoPorcentagem; i < ordenacao.getElementos(); i++) {
				lista.add(i);
			}

			Collections.shuffle(lista);

			for (int i = (int) pisoPorcentagem; i < ordenacao.getElementos(); i++) {
				vetor[i] = lista.get((int) (i - pisoPorcentagem));
			}
		}

		return vetor;
	}
}
