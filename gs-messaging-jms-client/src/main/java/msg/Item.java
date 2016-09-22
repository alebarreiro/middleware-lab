package msg;

/**
 * Created by alejandrobarreiro on 21/9/16.
 */
public class Item {

    public String nombre;
    public int categoria;

    public Item() {}

    public Item(int categoria, String nombre) {
        this.categoria = categoria;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
