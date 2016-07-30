package Class;

import java.io.Serializable;

/**
 * Created by Maxi on 28/07/2016.
 */
public class Marca implements Serializable{
    private String _nombre;
    private String _origen;

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_origen() {
        return _origen;
    }

    public void set_origen(String _origen) {
        this._origen = _origen;
    }
    public Marca unaMarca(String pNombre, String pOrigen){
        Marca LaMarca = new Marca();
        LaMarca.set_nombre(pNombre);
        LaMarca.set_origen(pOrigen);
        return LaMarca;
    }

    @Override
    public String toString() {
        return _nombre + " Origen: "+ _origen;
    }
}
