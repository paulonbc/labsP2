package lab3;

import java.util.Arrays;

public class Agenda {
	
	public Contato[] contatos;

	/*
	 * Construtor da classe Agenda, que precisa apenas iniciar o array contatos de Contato
	 */
	
	public Agenda() {
		this.contatos = new Contato[100];
	}

	/*
	 * Método responsável por cadastrar os contatos no array "contatos", que tem os atributos: posicao, nome, sobrenome e telefone
	 */
	
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato contato = new Contato(nome, sobrenome, telefone);
		
		if (posicao <= 0 || posicao > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA!");
		}
		contatos[posicao-1] = contato;
		return "CADASTRO REALIZADO!";
	}		

	
	/*
	 * Método exibirContato que recebe uma posicao e exibe o contato daquela posicao-1.
	 */
	
	public String exibirContato(int posicao) {
		return contatos[posicao-1].toString();
	}
	/*
	 * Método listaContatos que lista todos os contatos presentes no array de contatos que forem diferentes de null.
	 */
	
	public String listaContatos() {
		
		String lista = "";
		
		for(int i = 0; i<100; i++) {
			if(!(contatos[i] == null)) {
				lista += i+1 + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + System.lineSeparator();
				
			}
		}
		return lista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}
	
}
	



	


