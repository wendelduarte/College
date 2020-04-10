public class Polinomio {
	
	private double[] termos;
	private int grau;
	
	public Polinomio(int grau, double[] termos) {
		this.grau = grau-1;
		this.termos = termos;
	}
	
	public Polinomio(int grau) {
		this.grau = grau;
		this.termos = new double[grau+1];
	}
	
	public String verificaSinal(double valor, int exp, boolean primeiroItem) {
		String sinal = "";
		if(valor >= 0 && !primeiroItem)
			sinal = " + ";
		else
			sinal = " ";
		return sinal + valor + "x^" + exp;
	}
	
	public void mostra() {
		System.out.print("P(X) =");
		for(int i = grau; i >= 0; i--) {
			System.out.print(verificaSinal(termos[i], i, (i == termos.length-1)));
		}
		System.out.println();
	}
	
	public Double calculaPolinomio(int x) {
		Double soma = 0.0;
		for(int i = 0; i < this.termos.length; i++) {
			soma += this.termos[i]*Math.pow(x, i);
		}
		return soma;
	}
	
	public Polinomio soma(Polinomio polinomio) {
		int grauPolinomioSomado = this.grau > polinomio.grau ? this.grau : polinomio.grau;
		Polinomio polinomioSomado = new Polinomio(grauPolinomioSomado);
		for(int i = 0; i < this.termos.length; i++)
			polinomioSomado.termos[i] += this.termos[i];
		
		for(int i = 0; i < polinomio.termos.length; i++) {
			polinomioSomado.termos[i] += polinomio.termos[i];
		}
		return polinomioSomado;
	}
	
	public Polinomio multiplica(Polinomio polinomio) {
		int grauPolinomioMultiplicado = this.grau + polinomio.grau;
		Polinomio polinomioMultiplicado = new Polinomio(grauPolinomioMultiplicado);
		for(int i = 0; i<this.termos.length; i++) {
			for(int j = 0; j<polinomio.termos.length; j++) {
				polinomioMultiplicado.termos[i+j] += this.termos[i]*polinomio.termos[j];
			}
		}
		return polinomioMultiplicado;
	}
	
	@Override
	public String toString() {
		String polinomio = "P(X) =";
		for(int i = grau; i >= 0; i--) {
			polinomio += verificaSinal(termos[i], i, (i == termos.length-1));
		}
		return polinomio;
	}
	
}