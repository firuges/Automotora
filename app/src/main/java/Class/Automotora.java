package Class;

import java.util.ArrayList;

/**
 * Created by Maxi on 28/07/2016.
 */
public class Automotora {
    private static ArrayList<Auto> LosAutos = new ArrayList<>();
    private static ArrayList<Marca> LasMarcas = new ArrayList<>();

    public static ArrayList<Auto> getLosAutos() {
        return LosAutos;
    }

    public static void setLosAutos(ArrayList<Auto> losAutos) {
        LosAutos = losAutos;
    }

    public static ArrayList<Marca> getLasMarcas() {
        return LasMarcas;
    }

    public static void setLasMarcas(ArrayList<Marca> lasMarcas) {
        LasMarcas = lasMarcas;
    }
    public boolean AgregarMarca(Marca pMarca){
        try{
            LasMarcas.add(pMarca);
            return true;
        }catch (Exception e){
            throw e;

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
}
