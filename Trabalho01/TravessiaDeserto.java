import java.util.Scanner;

public class TravessiaDeserto {

	private int pos;
	private int fuel;
	private int[] mapa;
	public static final int MAXFUEL = 6;
	public static final int TAM_MAPA = 10;
	private Scanner sc = new Scanner(System.in);
	public static final int ERRO = 1;
	public static final int ajuda = 0;
	public static final int carregar = 1;
	public static final int descarregar = 2;
	public static final int voltar = 3;
	public static final int avancar = 4;

	public static void main(String[] args) {
		(new TravessiaDeserto()).run(args);

	}

	public void run(String[] args) {

		inicializaJogo();

		do {
			printStatus();
			int cmd = getCommand();
			processCommand(cmd);

		}

		while (!isGameOver());
		displayEndMessage();

	}

	public void inicializaJogo() {
		fuel = MAXFUEL;
		pos = 0;
		mapa = new int[TAM_MAPA];

	}

	public void displayEndMessage() {

		if (isWinner()) { // codigo que pode ser modificado
			System.out.println("Ganhou.");
		} else
			System.out.println("Perdeu");
	}

	public boolean isGameOver() {
		if (isWinner()) // codigo escrito duas vezes
			return true;
		if (fuel == 0 && mapa[pos] == 0)
			return true;
		return false;
	}

	public boolean isWinner() {

		return pos == mapa.length;
	}

	public void printStatus() {
		System.out.println("Você esta na posição" + pos);
		System.out.println(String.format("Você tem %d combustivel", "fuel"));
		System.out.print("Commando ('help' peço ajuda:");

	}

	public int getCommand() {
		String cmd = sc.next().toLowerCase();
		if (cmd.equals("avancar")) {
			return avancar;

		}
		return fuel;

	}

	private void processCommand(int cmd) {
		switch (cmd) {
		case ajuda:
			ajuda();
			break;
		case voltar:
			voltar();
			break;
		case avancar:
			avancar();
			break;
		case descarregar:
			descarregar();
			break;
		case carregar:
			descarregar();
			break;
		default:
			System.err.println("Comando invalido");
		}
	}

	public void ajuda() {
		System.out.println("avancar voltar carregar descarregar ajuda");

	}

	public void avancar() {
		if (fuel > 0) {
			fuel--;
			pos++;
		}

	}

	public void voltar() {
		if (fuel > 0 && pos > 0) {
			fuel--;
			pos--;
		}
		if (pos == 0) {
			fuel = MAXFUEL;
		}
	}

	public void carregar() {
		if (fuel < MAXFUEL && mapa[pos] > 0) {
			mapa[pos]--;
			fuel++;
		}
	}

	public void descarregar() {
		if (fuel > 0) {
			mapa[pos]++;
			fuel--;

		}
	}
}
