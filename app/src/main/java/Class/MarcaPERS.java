package Class;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by Maxi on 15/08/2016.
 */
public class MarcaPERS extends SQLite {
    public MarcaPERS(Context contexto) {
        super(contexto);
    }
    public void guardarMarca(Marca m) throws IOException {
        this.ejecutarSentencia("INSERT INTO marca (mNombre, mOrigen) " +
                "VALUES ('" + m.get_nombre() + "', '" + m.get_origen() + "')");
    }
    public boolean existeMarca(String nombre) throws IOException {
        boolean existe = false;
        //Lo retornado  se asigna al cursor que se encuentra en SQLite
        this.seleccionar("SELECT *  FROM marca " +
                "WHERE mNombre = '" + nombre + "'");
        while (this.c.isAfterLast() == false){
            existe = true;
            this.c.moveToNext();
        }
        this.c.close();
        return existe;
    }
    public ArrayList<Marca> lasMarcas() throws IOException {
        ArrayList<Marca> lasMarcasGuardadas = new ArrayList<>();
        Marca marca;
        //Lo retornado  se asigna al cursor que se encuentra en SQLite
        this.seleccionar("SELECT *  FROM marca ORDER BY mNombre");
        //Recorremos el cursor y agregamos cada elemento  a un arraylist
        while (c.isAfterLast() == false){
            marca = new Marca();
            marca.set_id(c.getInt(0));
            marca.set_nombre(c.getString(1));
            marca.set_origen(c.getString(2));
            lasMarcasGuardadas.add(marca);
            this.c.moveToNext();
        }
        this.c.close();
        return lasMarcasGuardadas;
    }
}
