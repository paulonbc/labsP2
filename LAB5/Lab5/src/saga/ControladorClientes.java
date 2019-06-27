package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ControladorClientes {
	public HashMap<String, Cliente> clientes;
	private Comparator<Cliente> estrategia;

	public ControladorClientes() {
		this.clientes = new HashMap<>();
	}
	
	public String adicionaCliente(String nome, String email, String localizacao, String cpf) {
		if(clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
			
		}
		Cliente clienteNovo = new Cliente(nome, email, cpf, localizacao);
		return clienteNovo.getCpf();

	}
	
	public void removeCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
	
	public void editaCliente(String cpf) {
		if(!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe." );
					}
		clientes.get(cpf).editaCliente(clientes.get(cpf).getNome(), clientes.get(cpf).getEmail(), clientes.get(cpf).getLocalizacao());
	}
	public void ordenaClientes() {
		this.estrategia = new ComparatorClientes();
		List<Cliente> lista = new ArrayList<Cliente>(clientes.values());
		Collections.sort(lista, estrategia);
	}
	
	public String mostraClientesOrdenados() {
		String t = "";
		for( Cliente c : clientes.values()) {
			t += clientes.toString() + " | ";
		}
		return t;
		
	}
}

