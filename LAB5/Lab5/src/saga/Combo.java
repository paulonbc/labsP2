package saga;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Produto{
	
	/*
	 * Classe que extende a classe produto, Combo tem um parametro a mais: Fator e diferença no calculo do preço
	 */
	
	private double fator;
	private List<Produto> produtos;
	
	
	public Combo(String nome, double preco, String descricao, double fator, List<Produto> produtos) {
		super(nome, preco, descricao);
		this.fator = fator;
		this.produtos = new ArrayList<>();
	}

	/*
	 * Construtor de combo que usa parametros da classe Produto 
	 */
	
	public double getFator() {
		return fator;
	}

	public void setFator(double fator) {
		this.fator = fator;
	}
	
	/*
	 * Métodos get e set que possibilitam pegar e editar o valor de fator.
	 */

}