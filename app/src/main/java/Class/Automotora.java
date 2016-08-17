package Class;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
/**
 * Created by Maxi on 28/07/2016.
 */

public class Automotora {
    private static ArrayList<Auto> LosAutos = new ArrayList<>();

    public static ArrayList<Auto> getLosAutos() {
        return LosAutos;
    }

    public static void setLosAutos(ArrayList<Auto> losAutos) {
        LosAutos = losAutos;
    }
    public boolean AgregarMarca(Context elContexto, Marca pMarca) throws IOException {
        MarcaPERS Persistencia = new MarcaPERS(elContexto);
        boolean existe = Persistencia.existeMarca(pMarca.get_nombre());
        if(!existe){
            try{
                Persistencia.guardarMarca(pMarca);
                return true;
            }catch (Exception e){
                throw e;

            }
        }
        else
        {
            return false;
        }

    }
    public boolean AgregarAuto(Auto pAuto){
        try{
            LosAutos.add(pAuto);
            return true;
        }catch (Exception e){
            throw e;

        }
    }
    public ArrayList<Marca> TraerMarcas(Context elContexto) throws IOException {
        ArrayList<Marca> retornoMarcas = new ArrayList<>();
        MarcaPERS Persistencia = new MarcaPERS(elContexto);
        retornoMarcas = Persistencia.lasMarcas();
        return retornoMarcas;
    }
}
