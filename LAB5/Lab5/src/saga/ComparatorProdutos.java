package saga;

import java.util.Comparator;

public class ComparatorProdutos implements Comparator<Produto>{

	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getChaveProduto().compareTo(o2.getChaveProduto());
	}

}
