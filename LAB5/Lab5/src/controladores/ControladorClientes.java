package controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import comparadores.ComparatorClientes;
import saga.Cliente;

public class ControladorClientes {
	
	/*
	 * Classe responsável por gerenciar todas as ações de Cliente que guarda um Mapa do tipo Cliente
	 */
	
	public HashMap<String, Cliente> clientes;
	private Comparator<Cliente> estrategia;
	

	public ControladorClientes() {
		this.clientes = new HashMap<>();
	}
	
	public String adicionaCliente(String nome, String email, String localizacao, String cpf) {
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		
		}
		if(clientes.get(cpf).getNome().equals(null) ||clientes.get(cpf).getNome().trim().equals("") ) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(clientes.get(cpf).getEmail().equals(null) ||clientes.get(cpf).getEmail().trim().equals("") ) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(clientes.get(cpf).getLocalizacao().equals(null) ||clientes.get(cpf).getLocalizacao().trim().equals("") ) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		if(clientes.get(cpf).getCpf().equals(null) ||clientes.get(cpf).getCpf().trim().equals("") ) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		Cliente clienteNovo = new Cliente(nome, email, cpf, localizacao);
		return clienteNovo.getCpf();

	}
	public String exibeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).toString();
	}
	
	public void removeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
	
	public void editaCliente(String cpf, String novoNome, String novoEmail, String novoLocalizacao) {
		
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe." );
					}
		
		if(clientes.get(cpf).getNome().equals(null) ||clientes.get(cpf).getNome().trim().equals("") ) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(clientes.get(cpf).getEmail().equals(null) ||clientes.get(cpf).getEmail().trim().equals("") ) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(clientes.get(cpf).getLocalizacao().equals(null) ||clientes.get(cpf).getLocalizacao().trim().equals("") ) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		if(novoNome.equals(null) || novoEmail.equals(null) || novoLocalizacao.equals(null)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		if(novoNome.trim().equals("") || novoEmail.trim().equals("") || novoLocalizacao.trim().equals("")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		
		clientes.get(cpf).editaCliente(novoNome, novoEmail, novoLocalizacao);
		}
		
	public void ordenaClientes() {
		this.estrategia = new ComparatorClientes();
		List<Cliente> lista = new ArrayList<Cliente>(clientes.values());
		Collections.sort(lista, estrategia);
	}
	
	public String mostraClientesOrdenados() {
		String t = "";
		for( Cliente c : clientes.values()) {
			t += c.toString() + " | ";
		}
		return t;
	}
}

