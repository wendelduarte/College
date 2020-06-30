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

public class Empresa {
	
	private Colaborador[] colaboradores = new Colaborador[100]; //já inicia o vetor direto com 100 posicoes
	
	/**
	 * Adicona um novo colaborador (Funcionario, Estagiario ou Presidente) na última posição do vetor
	 * @param colaborador - Funcionario, Estagiario ou Presidente
	 * @return true caso não tenha problemas ao adicionar um colaborador e false caso contrário
	 */
	public boolean addColaboradores(Colaborador colaborador) {
		for(int i = 0; i<colaboradores.length; i++) {
			if(colaboradores[i] == null) {
				colaboradores[i] = colaborador;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Recebe o id de um colaborador e verifica se ele existe, caso exista chama o método para 
	 * calcular seu pagamento
	 * @param id do colaborador
	 * @return valor do pagamento do colaborador ou -1.0 caso usuário não exista.
	 */
	public double calculaPagamentoColaborador(int id) {
		for(int i = 0; i<colaboradores.length; i++) {
			if(colaboradores[i] != null && colaboradores[i].getId() == id) { // verifica se tem um colaborador na posição do vetor e se o colaborador atual tem o mesmo id recebido por parâmetro
				return colaboradores[i].pagamento();
			}
		}
		return -1.0;
	}
	
	/**
	 * Aumenta os adicionais dos colaboradores que possuem algum tipo de adicional;
	 * @param percentual
	 * @return true caso aumente com sucesso ou false caso não dê certo
	 */
	public boolean aumentaAdicional(int percentual) {
		boolean flag = false;
		for(Colaborador colaborador : colaboradores) {
			if(colaborador != null && colaborador.hasAdicional()) {
				colaborador.setAdicional(percentual/100.0);
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	 * Retorna o toString da empresa - mostra os usuários
	 */
	public String relatorioColaboradores() {
		return toString();
	}
	
	@Override
	public String toString() {
		String toString = "";
		for(Colaborador colaborador : colaboradores) {
			if(colaborador != null)
				toString += colaborador.toString() + "\n";
		}
		return toString;
	}
	
	
}
