package saga;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ControleFornecedor {
	
	private Comparator<Fornecedor> estrategiaDeOrdenacao;
	
	private HashMap<String, Fornecedor> fornecedores;

	public ControleFornecedor() {
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
	
}

	

