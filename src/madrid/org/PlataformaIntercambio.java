package madrid.org;

import java.util.ArrayList;
import java.util.List;

public class PlataformaIntercambio implements OperacionesPlataforma{
   private String nombre;
   private List<Cartera> carteras;

    public PlataformaIntercambio(String nombre, List<Cartera> carteras) {
        this.nombre = nombre;
        this.carteras = carteras;
    }
    public PlataformaIntercambio() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.equals("")){
            System.out.println("Rellene este campo");
        }else {
            this.nombre = nombre.toLowerCase().trim();
        }
    }

    public List<Cartera> getCarteras() {
        return carteras;
    }

    public void setCarteras(List<Cartera> carteras) {
        if (carteras != null){
            this.carteras = carteras;
        }else {this.carteras = new ArrayList<>();}

    }

    @Override
    public Cartera buscarCarteraRecursiva(String usuario, int index) {
        if (index >= 0 && index < carteras.size()) {
            Cartera cartera = carteras.get(index);
            if (cartera.getUsuario().equals(usuario)) {
                return cartera;
            } else {
                return buscarCarteraRecursiva(usuario, index + 1);
            }
        }
        return null;
    }

    @Override
    public boolean addMonedaCartera(String usuario, Criptomoneda cripto) {
        Cartera cartera = new Cartera();
        for (int i = 0; i < carteras.size(); i++) {
            if (cartera.getUsuario().equals(usuario)) {

                try {
                    cartera.addCriptoMoneda(cripto);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


            }
        }
        return false;
    }

    @Override
    public void addCartera(Cartera cartera) throws Exception {
        Cartera c = new Cartera();
        for (int i = 0; i < carteras.size(); i++) {
            if (c.getUsuario().equals(cartera.getUsuario())) {
                throw new Exception("El usuario de la cartera ya existe");
            }
        }
        carteras.add(cartera);
    }

    @Override
    public void deleteCartera(Cartera cartera) throws Exception {
        if (carteras.remove(cartera)) {
            System.out.println("Cartera eliminada correctamente");
        } else {
            throw new Exception("No se encontró la cartera para eliminar");
        }
    }
}
