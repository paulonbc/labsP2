package lab3;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		System.out.println("(C)adastrar Contato" + System.lineSeparator() + "(L)istar Contato" + System.lineSeparator() + 
				"(E)xibir Contato" + System.lineSeparator() + "(S)air" + System.lineSeparator());
		Scanner sc = new Scanner(System.in);
		System.out.println("Opção >");
		String opcao = sc.nextLine(); 
		Agenda novaAgenda = new Agenda();
		
		if(opcao.equals("C")) {
			System.out.print("Posição: ");
			int posicao = sc.nextInt();
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = sc.nextLine();
			System.out.print("Telefone: ");
			String telefone = sc.nextLine();
			
			novaAgenda.cadastraContato(posicao, nome, sobrenome, telefone);		
		}
		if(opcao.equals("L")) {
			novaAgenda.listaContatos();
			
		}
		
		if(opcao.equals("E")) {
			System.out.print("Contato> ");
			int posicao = sc.nextInt();
			novaAgenda.exibirContato(posicao);
		}
		if(opcao.equals("S")) {
			System.exit(0);
		}
	}

}
