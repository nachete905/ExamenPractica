package madrid.org;

import java.sql.Array;

public class Cartera implements OperacionesCartera{
    private String usuario;
    private int [] criptomonedas = new int[10];
    private int numCriptomonedas;

    public Cartera(String usuario, int[] criptomonedas, int numCriptomonedas) {
        this.usuario = usuario;
        this.criptomonedas = criptomonedas;
        this.numCriptomonedas = numCriptomonedas;
    }
    public Cartera() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario.equals("")){
            System.out.println("Rellene este campo");
        }else {
            this.usuario = usuario.toLowerCase().trim();
        }
    }

    public int[] getCriptomonedas() {
        return criptomonedas;
    }

    public void setCriptomonedas(int[] criptomonedas) {
        if (criptomonedas == null) {
            System.out.println("Este campo no puede estar vacío");
        }else {
            this.criptomonedas = new int[0];
        }
    }

    public int getNumCriptomonedas() {
        return numCriptomonedas;
    }

    public void setNumCriptomonedas(int numCriptomonedas) {
        this.numCriptomonedas = numCriptomonedas;
    }

    @Override
    public void addCriptoMoneda(Criptomoneda criptoMoneda) throws Exception {
        if (criptomonedas.length >= numCriptomonedas){
            throw new Exception("El array está completo");
        }
        int indice = -1;
        for (int i = 0; i <= criptomonedas.length;i++){
            if (criptomonedas[i] == 0){
                indice = i;
                break;
            }
        }
        if (indice != -1){
            criptomonedas[indice] = criptoMoneda.hashCode();//utilizo el hash code para obtener un entero de la cadena de criptoMoneda
        }else {
            throw new Exception("No hay espacio");
        }

    }

    @Override
    public void deleteCriptoMoneda(Criptomoneda criptoMoneda) {
        int indice = -1;
        for (int i = 0; i < criptomonedas.length;i++){
            if (criptomonedas[i] == 0){
                indice = i;
                break;
            }
            if (indice != 0){
                criptomonedas [indice] = 0;
            }
        }

    }

    @Override
    public double takeCriptoMoneda(String nombre, double cantidad) throws Exception {
        for (int i = 0; i < criptomonedas.length; i++){
            if (criptomonedas[i] == 0){
                throw new  Exception("Introduzca número de criptomonedas a extraer");
            }
            if (criptomonedas[i] == nombre.hashCode()){ //aqui se encuentra la criptomoneda
                criptomonedas[i] -= cantidad;//para restar cantidad al tamaño del array, por ejemplo si quito 2 criptomonedas, se resta para que se actualice el array
                return i;
            }else {
                throw new Exception("Introduzca número de criptomonedas a extraer");
            }
        }

        return -1;
    }

    @Override
    public int buscarCriptomoneda(String nombre) {
        for (int i = 0; i < criptomonedas.length; i++){
            if (nombre.equals("")){
                System.err.println("No se ha introducido un nombre");
            }
            if (criptomonedas[i] == nombre.hashCode()){
                return i;
            }
        }
        return 0;
    }

    /*Métodos*/

}
