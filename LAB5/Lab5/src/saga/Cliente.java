package saga;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nome;
	private String email;
	private String cpf;
	private String localizacao;
	private List<Compra> compras;
	
	public Cliente(String nome, String email, String cpf, String localizacao) {
		super();
		if(nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(email.equals(null) || email.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(cpf.trim().equals("") || cpf.equals(null)) {
			throw new NullPointerException("Erro no cadastro do cliente: cpf invalido.");
		}
		if(localizacao.equals(null) || localizacao.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		
		this.compras = new ArrayList<>();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public void editaCliente(String novoNome, String novoEmail, String novoLocalizacao) {
		this.nome = novoNome;
		this.email = novoEmail;
		this.localizacao = novoLocalizacao;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  nome + " - "  + localizacao + " - " + email;
	}
	
}
