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

public class Funcionario extends Colaborador{

	private double adicional;

	public Funcionario(int id, String nome, int departamento, double salario, double adicional) {
		super(id, nome, departamento, salario, 0.05);
		this.adicional = adicional; // adicional caso o funcionário seja por exemplo chefe.
	}

	
	public void setAdicional(double novoPercentual) {
		if(adicional == 0)//caso o funcionario tenha 0 de percentual e receba o aumento, assim não tem o problema de multiplicar por zero e acabar sem aumento
			adicional = novoPercentual;
		else
			adicional = adicional * (1 + novoPercentual);
	}

	@Override
	public boolean hasAdicional() {
		return true;
	}
	
	@Override
	public double pagamento(){
		// Calcula o salário líquido
		return(salario*((1-previdencia)+ adicional));
	}
}
