import com.sun.java_cup.internal.runtime.Scanner;

public class Inventario {
	class invetario {

		public String inventario[][] = new String[2][4];

		// 1 - arma;
		// 2 - tesouro;
		// 3 - armadura;

		public void criaInventario() {
			inventario[1][1] = "Faca";
			inventario[1][2] = "Cura";
			inventario[1][3] = "";
		}

		public String listaarma() {
			String aux = inventario[1][1];
			return aux;
		}

		public String listatesouro() {
			String aux = inventario[1][2];
			return aux;
		}

		public String listaarmadura() {
			String aux = inventario[1][3];
			return aux;
		}

		public String getarma(String a) {
			Scanner entra = new Scanner(System.in);
			String aux = "";
			if (inventario[1][1].equals("")) {
				inventario[1][1] = a;
			} else {
				aux += "Voce esta carregando " + inventario[1][1] + "\n";
				aux += "Deseja trocar por " + a + "? \n";
				aux += "Digite: S -> Sim; N-> Nao \n";
				System.out.println(aux);
				aux = ((Object) entra).next();
				if (aux.equals("S")) {
					inventario[1][1] = a;
				}
			}
			return inventario[1][1];
		}
	}

	public void criaInventario() {

	}

	public String listatesouro() {

		return null;
	}

	public String listaarma() {
	
		return null;
	}

	public void getarma(String string) {
		
		
	}

	public String listaarmadura() {
		// TODO Auto-generated method stub
		return null;
	}

	public void getarmadura(String string) {
		// TODO Auto-generated method stub
		
	}

	public void gettesouro(String string) {
		// TODO Auto-generated method stub
		
	}

}
