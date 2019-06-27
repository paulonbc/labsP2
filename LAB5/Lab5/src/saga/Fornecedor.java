package saga;

import java.util.HashMap;
import java.util.List;

public class Fornecedor {
	
	private String nome;
	private String email;
	private String telefone;
	private HashMap<String,Produto> produtos;
	
	/**
	 * 
	 * @param nome NOME DE FORNECEDOR
	 * @param email EMAIL DE FORNECEDOR
	 * @param telefone TELEFONE DE FORNECEDOR
	 */
	
	public Fornecedor(String nome, String email, String telefone) {
		super();
		if(nome.equals(null) || nome.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email.equals(null) || email.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(telefone.equals(null) || telefone.trim().equals("")) {
			throw new NullPointerException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}

	/*
	 * Construtor de Fornecedor que recebe os parametros e inicia o Map "produtos". 
	 */
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/*
	 * Metodo resposável por criar um produto e adicioná-lo no Map produtos de um fornecedor.
	 */
	
	public void criaProduto(String nome, String descricao, double preco) {
		if(this.produtos.containsKey(nome) && this.produtos.get(nome).getDescricao().equals(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		Produto produto = new Produto(nome, preco, descricao);
		this.produtos.put(nome, produto);
	}
	
	
	
	public void editaFornecedor(String email, String telefone){
		this.email = email;
		this.telefone = telefone;
	}
	
	/*
	 * Metodo que edita um fornecedor, os únicos atributos editáveis são? e-mail e telefone.
	 */
	
	public String consultaProduto(String nome, String descricao) {
		if(nome.equals(null) || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		if(!this.produtos.containsKey(nome) && this.produtos.get(nome).getDescricao().equals(descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
			
		}
		return produtos.get(nome).toString();
	}
	
	/*
	 * Metodo que consulta um produto a partir de sua chave: nome + descricao
	 */
	
	public String todosProdutos() {
		String todos = "";
		for( Produto p : produtos.values()) {
			todos += p.toString() + " | ";
		}
		return todos;
	}

	public boolean existeProduto(String nome, String descricao) {
		if(this.produtos.containsKey(nome)) {
			this.produtos.get(nome).getDescricao().equals(descricao);
			return true;
		}
		return false;
	}
	
	public void editaProduto(String nome, String descricao, double novoPreco) {
		if(this.existeProduto(nome, descricao)) {
			this.produtos.get(nome).setPreco(novoPreco);
		}
	}
	
	public void removeProduto(String nome, String descricao) {
		if(!existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		produtos.remove(nome);
	}

	/**
	 * 
	 * @param fornecedor correspondente ao combo
	 * @param nome do combo 
	 * @param descricao do combo
	 * @param fator do combo
	 * @param produtos que compõem o combo
	 */
	
	public void adicionaCombo(String fornecedor, String nome, String descricao,double fator, List<Produto> produtos) {
		double preco = 0;
		for (Produto produto : produtos) {
			preco += produto.getPreco();
		}
		this.produtos.put(fornecedor, new Combo(nome, preco, descricao, fator, produtos));
	}
	
	/**
	 * 
	 * @param nome do Combo
	 * @param descricao do Combo
	 * @param fornecedor do Combo
	 * @param novofator do Combo
	 */
	
	public void editaCombo(String nome, String descricao, String fornecedor, double novofator) {
		((Combo) this.produtos.get(fornecedor)).setFator(novofator);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/*
	 * Representação textual de um fornecedor
	 */

	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
		
	}
}