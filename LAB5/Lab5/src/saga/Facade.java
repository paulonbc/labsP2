package saga;

import controladores.ControladorClientes;
import controladores.ControladorFornecedor;

public class Facade {
	
	private ControladorClientes controladorClientes;
	private ControladorFornecedor controladorFornecedor;

	public Facade() {
		this.controladorClientes = new ControladorClientes();
		this.controladorFornecedor = new ControladorFornecedor();

	}

	public static void main(String[] args) {
		
	}
	
	public String adicionaCliente(String nome, String email, String localizacao, String cpf) {
		return controladorClientes.adicionaCliente(nome, email, localizacao, cpf);
		
	}
	public String exibeCliente(String cpf) {
		return controladorClientes.exibeCliente(cpf);
		
	}
	public void removeCliente(String cpf) {
		controladorClientes.removeCliente(cpf);
	}
	
	public void editaCliente(String cpf, String novoNome, String novoEmail, String novoLocalizacao) {
		controladorClientes.editaCliente(cpf, novoLocalizacao, novoLocalizacao, novoLocalizacao);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controladorFornecedor.criaFornecedor(nome, email, telefone);
	}
	
	public void editaFornecedor(String nome) {
		controladorFornecedor.editaFornecedor(nome);
	}
	
	public void removeFornecedor(String nome) {
		controladorFornecedor.removeFornecedor(nome);
	}
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		controladorFornecedor.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return controladorFornecedor.exibeProduto(fornecedor, nome, descricao);
	}
	public void removeProduto(String fornecedor, String nome, String descricao) {
		controladorFornecedor.removeProduto(fornecedor, nome, descricao);;
	}
	public void editaProduto(String fornecedor, String nome, String descricao, double novoPreco) {
		controladorFornecedor.editaProduto(fornecedor, nome, descricao, novoPreco);
	}
}

