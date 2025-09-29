public class Inverso {
   public static void main (String[] args){

    int numero = 177;
        int original = numero;
        int inverso = 0;

        while (numero > 0) {
            inverso = inverso * 10 + numero % 10;
            numero = numero / 10;
        }

        System.out.println("Número original: " + original);
        System.out.println("Número inverso: " + inverso);
    

   }
}
