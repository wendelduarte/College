package colecaoPontos;

import javax.naming.SizeLimitExceededException;

public class ListaPonto {

	private Ponto pontos[];
	private int validos;
	
	public ListaPonto(int n) {
		this.pontos = new Ponto[n];
		this.validos = 0;
	}
	
	public Ponto[] getPontos() {
		return pontos;
	}
	 /**
	  * Adiciona um ponto no final da lista
	  * @param ponto
	  * @return
	  * @throws SizeLimitExceededException
	  */
	public int addFinal(Ponto ponto) throws SizeLimitExceededException {
		if(validos == pontos.length) //verifica se a lista não está cheia
			throw new SizeLimitExceededException("Não há espaço na coleção");
		int posicao = primeiraPosicaoVazia();
		pontos[posicao] = ponto;
		validos++;
		return posicao;
	}
	
	/**
	 * Adiciona um ponto em uma determinada posicao
	 * @param ponto
	 * @param posicao
	 * @return
	 * @throws SizeLimitExceededException
	 */
	public int addPosicaoEspecifica(Ponto ponto, int posicao) throws SizeLimitExceededException {
		validaPosicao(posicao);
		if(validos == pontos.length) 
			throw new SizeLimitExceededException("Não há espaço na coleção");
		
		int primeiraPosicaoVazia = primeiraPosicaoVazia();
		
		//Se a posição escolida para adicionar o ponto for deixar buracos adiciona na próxima posicação válida 
		
		if(pontos[posicao] != null) {
			deslocaDireita(posicao);
			pontos[posicao] = ponto;
			validos++;
			return posicao;
		} else {
			pontos[primeiraPosicaoVazia] = ponto;
			validos++;
			return primeiraPosicaoVazia;
		}
	}
	
	/**
	 * Retona o indice da primeira ocorrencia de um ponto passado como parametro
	 * @param ponto
	 * @return indice caso o ponto esteja na coleção ou -1 caso não esteja
	 */
	public int retornaIndiceOcorrencia(Ponto ponto) {
		for(int i = 0; i<pontos.length; i++) {
			if(pontos[i] != null && ponto.isEquals(pontos[i]) ) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Dada uma determinada posição remove o item dessa posição 
	 * @param posicao
	 */
	public void remove(int posicao) {
		validaPosicao(posicao);
		if(pontos[posicao] == null)
			throw new NullPointerException("Não há nenhum valor nesta posição");
		deslocaEsquerda(posicao);
		validos--;
	}
	
	/**
	 * Calcula a distancia entre cada ponto da coleção
	 * @return retorna a maior distância entre os pontos
	 */
	public Double calculaDistancia() {
		if(validos < 2)
			throw new IllegalStateException("Não há pontos o suficiente para calcular.");
		
		Double distancia = 0.0;
		Double aux = 0.0;
		for(int i = 0; i<pontos.length; i++) {
			for(int j = 0; j<pontos.length; j++) {
				if(pontos[i] != null && pontos[j] != null) {
					aux = pontos[i].distance(pontos[j]);
					distancia = (aux > distancia) ? aux : distancia;
				}
			}
		}
		return distancia;
	}
	
	/**
	 * Dado um raio e um ponto calcula quais pontos estão dentro da circunferência
	 * @param raio
	 * @param ponto
	 * @return lista de pontos com todos os pontos presentes na circunferência
	 * @throws SizeLimitExceededException
	 */
	public ListaPonto pontoContidoCircunferencia(double raio, Ponto ponto) throws SizeLimitExceededException {
		ListaPonto pontosNaCircunferencia = new ListaPonto(pontos.length);
		for (Ponto p: pontos) {
			if(p != null && p.distance(ponto) < raio) {
				pontosNaCircunferencia.addFinal(p);
			}
		}
		return pontosNaCircunferencia;
	}
	
	/**
	 * Desloca todo o vetor ponto para esquerda a partir da posicao informada
	 * @param posicao
	 */
	public void deslocaEsquerda(int posicao) {
		for(int i = posicao; i<pontos.length-1; i++) {
			pontos[i] = pontos[i+1];
		}
	}
	
	/**
	 * Desloca todo o vetor ponto para direita a partir da posicao informada
	 * @param posicao
	 */
	public void deslocaDireita(int posicao) {
		for(int i = pontos.length-1; i>=posicao; i--) {
			if(pontos[i] != null) {
				pontos[i+1] = pontos[i];
			}
		}
	}
	
	/**
	 * Retorna o indice da primeira posição vazia
	 * @return indice da primeira posição vazia
	 */
	public int primeiraPosicaoVazia() {
		int i = 0;
		while(pontos[i] != null) {
			i++;
		}
		return i;
	}
	
	/**
	 * Verifica se é uma posição valida
	 * @param posicao
	 */
	public void validaPosicao(int posicao) {
		if(posicao > pontos.length-1 || posicao < 0) {
			throw new IndexOutOfBoundsException("Posição invalida!");
		}
	}
	
	/**
	 * Imprime o vetor de pontos somente onde há pontos
	 */
	public void imprimeLista() {
		for (Ponto p : pontos) {
			if(p != null)
				System.out.println(p);
		}
	}
}