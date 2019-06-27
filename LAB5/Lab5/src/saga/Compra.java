package saga;

import java.util.Date;

public class Compra {
	private Date data;
	private String identificacaoDoProduto;
	private double precoDaCompra;
	
	public Compra(Date data, String identificacaoDoProduto, double precoDaCompra) {
		super();
		this.data = data;
		this.identificacaoDoProduto = identificacaoDoProduto;
		this.precoDaCompra = precoDaCompra;
	}

	public Date getData() {
		return data;
	}
	
	public String getIdentificacaoDoProduto() {
		return identificacaoDoProduto;
	}
	
	public double getPrecoDaCompra() {
		return precoDaCompra;
	}
	
	

}
