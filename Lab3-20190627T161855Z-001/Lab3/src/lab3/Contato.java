package lab3;

public class Contato {
	private String nome;
	private String sobrenome;
	private String numero;

	public Contato(String nome, String sobrenome, String numero) {
		if (nome == null) {
			throw new IllegalArgumentException("O nome é invalido");
		}
		if (nome.trim().equals("")) {
			throw new IllegalArgumentException("O nome é inválido");

		}
		if (sobrenome == null) {
			throw new IllegalArgumentException("O sobrenome é inválido");
		}
		if (sobrenome.trim().equals("")) {
			throw new IllegalArgumentException("O sobrenome é inválido");
		}
		if (numero == null) {
			throw new IllegalArgumentException("O número não pode ser vazio");
		}
		if (numero.trim().equals("")) {
			throw new IllegalArgumentException("O número não pode ser vazio");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numero = numero;
		
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
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
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return (nome + " " + sobrenome + " - " + numero);
	}
}
