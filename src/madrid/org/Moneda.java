package madrid.org;

public abstract class Moneda {
    private String nombre;
    private int cantidad;
    private int valor;

    public Moneda(String nombre, int cantidad, int valor) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valor = valor;
    }
    public Moneda() {
        this.nombre = "";
        this.cantidad = 0;
        this.valor = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")){
            System.out.println("No has introducido un nombre, introdúzcalo");
        }else{ this.nombre = nombre.trim();}

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}
