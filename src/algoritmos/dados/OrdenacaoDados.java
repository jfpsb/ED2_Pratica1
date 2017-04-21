package algoritmos.dados;

public class OrdenacaoDados {	
	private String nome;
	private char pivo = 0;
	private int elementos;
	private char inicioFimOrdenados;
	private double porcentagem;
	private char ordem;
	private long numeroComparacoes;
	private long numeroAtribuicoes;
	
	public char getPivo() {
		return pivo;
	}

	public void setPivo(char pivo) {
		this.pivo = pivo;
	}
	
	public long getNumeroComparacoes() {
		return numeroComparacoes;
	}

	public void setNumeroComparacoes(long numeroComparacoes) {
		this.numeroComparacoes = numeroComparacoes;
	}

	public long getNumeroAtribuicoes() {
		return numeroAtribuicoes;
	}

	public void setNumeroAtribuicoes(long numeroAtribuicoes) {
		this.numeroAtribuicoes = numeroAtribuicoes;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}

	public OrdenacaoDados(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getElementos() {
		return elementos;
	}
	public void setElementos(int elementos) {
		this.elementos = elementos;
	}
	public char getInicioFimOrdenados() {
		return inicioFimOrdenados;
	}
	public void setInicioFimOrdenados(char inicioFimOrdenados) {
		this.inicioFimOrdenados = inicioFimOrdenados;
	}
	public double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(int porcentagem) {
		this.porcentagem = porcentagem;
	}
	public char getOrdem() {
		return ordem;
	}
	public void setOrdem(char ordem) {
		this.ordem = ordem;
	}
}
