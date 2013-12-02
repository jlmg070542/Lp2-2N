import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc;

		String celula;
		String dados;
		List l = new List();
		ListLists list = new ListLists();
		while (true) {

			System.out.println("Digite a celula que deseja inserir:");
			sc = new Scanner(System.in);
			celula = sc.next();

			if (celula == "fim")
				System.exit(0);

			System.out.println(celula + " :");
			sc = new Scanner(System.in);
			dados = sc.next();
			list.insere(dados, celula);
			list.printAllLists();

		}

	}
}
