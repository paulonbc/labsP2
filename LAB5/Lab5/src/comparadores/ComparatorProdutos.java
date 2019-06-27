package comparadores;

import java.util.Comparator;

import saga.Produto;

public class ComparatorProdutos implements Comparator<Produto>{

	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}