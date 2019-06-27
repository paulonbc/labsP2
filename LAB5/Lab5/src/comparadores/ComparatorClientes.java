package comparadores;

import java.util.Comparator;

import saga.Cliente;

public class ComparatorClientes implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
