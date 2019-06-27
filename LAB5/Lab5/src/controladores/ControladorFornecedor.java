package controladores;

import java.util.List;

import comparadores.ComparatorFornecedor;
import saga.Fornecedor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ControladorFornecedor {
	
	private Comparator<Fornecedor> estrategiaDeOrdenacao;
	
	private HashMap<String, Fornecedor> fornecedores;

	public ControladorFornecedor() {
		this.fornecedores = new HashMap<>();
	}
	
	public String criaFornecedor(String nome, String email, String telefone) {
		Fornecedor novoFornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(novoFornecedor.getNome(), novoFornecedor);
		return novoFornecedor.getNome();
	}
	
	public void removeFornecedor(String nome) {
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("O fornecedor não está cadastrado");
		}
		fornecedores.remove(nome);	
	}
	
	public void editaFornecedor(String nome) {
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("O fornecedor não está cadastrado");
		}
		fornecedores.get(nome).editaFornecedor(fornecedores.get(nome).getEmail(), fornecedores.get(nome).getTelefone());
	}
	
	public String consultaProdutosDeFornecedor(String nome) {
		if(!fornecedores.containsKey(nome)) {
			throw new IllegalArgumentException("O fornecedor não está cadastrado");
		}
		return fornecedores.get(nome).todosProdutos();
		
	}
	public String consultaProdutosDeTodosFornecedores() {
		String t = "";
		for (Fornecedor f : fornecedores.values()) {
			t +=  f.todosProdutos() + " | ";
		}
		return t;
	}

	public void ordenaFornecedores() {
		this.estrategiaDeOrdenacao = new ComparatorFornecedor();
		List<Fornecedor> list = new ArrayList<Fornecedor>(fornecedores.values());
		Collections.sort(list, estrategiaDeOrdenacao);
		
	}
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if(fornecedor.equals(null) || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo");
		}
		if(!this.fornecedores.containsKey(fornecedor)){
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if(this.fornecedores.containsKey(fornecedor)){
			throw new IllegalArgumentException( "Erro no cadastro de produto: produto ja existe.");
		}
		if(nome.equals(null) || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao.equals(null) || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
			
		}
		if(preco<0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
		fornecedores.get(fornecedor).criaProduto(nome, descricao, preco);
			
	}
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		}
		if(nome.equals(null) || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		if(descricao.equals(null) || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		if(!this.fornecedores.get(fornecedor).existeProduto(nome, descricao)){
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		return this.fornecedores.get(fornecedor).consultaProduto(nome, descricao);
	}
	public void removeProduto(String fornecedor, String nome, String descricao) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if(fornecedor.equals(null) || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(nome.equals(null) || nome.trim().isEmpty()){
			throw new IllegalArgumentException( "Erro na remocao de produto: nome nao pode ser vazio ou nulo." );
		}
		if(descricao.equals(null) || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula." );
		}
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		if(!this.fornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		if(fornecedor.equals(null) || fornecedor.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(nome.equals(null) || nome.trim().isEmpty()){
			throw new IllegalArgumentException( "Erro na edicao de produto: nome nao pode ser vazio ou nulo." );
		}
		if(descricao.equals(null) || descricao.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula." );
		}
		if(novoPreco < 0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
		
		fornecedores.get(fornecedor).editaProduto(nome, descricao, novoPreco);
	}
	
}
