package madrid.org;

public class Criptomoneda extends Moneda{
   private String algoritmoHash;


    public Criptomoneda(String nombre, int cantidad, int valor, String algoritmoHash) {
        super(nombre, cantidad, valor);
        this.algoritmoHash = algoritmoHash;
    }



    public Criptomoneda(String algoritmoHash) {
        this.algoritmoHash = algoritmoHash;
    }
    public Criptomoneda(){

    }

     public void setAlgoritmoHash(String algoritmoHash) {
        if (algoritmoHash.equals("")){
            System.out.println("Este campo no puede ser nulo");
        }else {
            this.algoritmoHash = algoritmoHash.toUpperCase().trim();

        }
    }


}
