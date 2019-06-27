package saga;

import java.util.Comparator;

public class ComparatorFornecedor implements Comparator<Fornecedor>{

	@Override
	public int compare(Fornecedor o1, Fornecedor o2) {
		return o1.getNome().compareTo(o2.getNome());
		
	}


}
