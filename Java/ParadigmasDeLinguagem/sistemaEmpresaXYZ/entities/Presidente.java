/*

Entrega de trabalho - Sistema Empresa XYZ

Nós,

Wendel Sergio Duarte Junior

Roger Thencera Rojas

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos à equipe e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/
package sistemaEmpresaXYZ.entities;

public class Presidente extends Colaborador{
	
	private double adicionalWhisky;
	private double adicionalHelicoptero;
	private double adicionalAdicional;

	public Presidente(int id, String nome, int departamento, double salario) {
		super(id, nome, departamento, salario, 0.05);
		this.adicionalWhisky = 0.9;
		this.adicionalHelicoptero = 0.7;
		this.adicionalAdicional = 3.8;
	}

	@Override
	public void setAdicional(double novoPercentual) {
		adicionalWhisky = adicionalWhisky * (1 + novoPercentual);
		adicionalHelicoptero = adicionalHelicoptero * (1 + novoPercentual);
		adicionalAdicional = adicionalAdicional * (1 + novoPercentual);
	}

	@Override
	public boolean hasAdicional() {
		return true;
	}
	
	@Override
	public double pagamento() {
		//Calcula o salário líquido
		return (salario * ((1 - previdencia) + this.adicionalWhisky + this.adicionalHelicoptero
				+ this.adicionalAdicional));
	}
}
