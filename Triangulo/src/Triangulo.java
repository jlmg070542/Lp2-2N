
// Programa calcula a hipotenusa de um triangul rectangulo, a partir das dimens�es dos catetos.
class Triangulo {
public static void main (String [] args){
double cateto1, cateto2, hipotenusa;
System.out.print ("Introduza a dimens�o do Cateto 1:");
cateto1 = Keyboard.readDouble();
System.out.print ("Introduza a dimens�o do Cateto 2:");
cateto2 = Keyboard.readDouble();
hipotenusa = Math.sqrt (cateto1+cateto2*cateto2);
System.out.print ("Hipotenusa = " + hipotenusa);
}
}

