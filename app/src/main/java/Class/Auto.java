package Class;

import java.io.Serializable;

/**
 * Created by Maxi on 28/07/2016.
 */
public class Auto implements Serializable {
    private Marca _Marca;
    private String _modelo;
    private int _cantPuertas;
    private String _matricula;
    private int _año;


    public Marca get_Marca() {
        return _Marca;
    }

    public void set_Marca(Marca _Marca) {
        this._Marca = _Marca;
    }

    public String get_modelo() {
        return _modelo;
    }

    public void set_modelo(String _modelo) {
        this._modelo = _modelo;
    }

    public int get_cantPuertas() {
        return _cantPuertas;
    }

    public void set_cantPuertas(int _cantPuertas) {
        this._cantPuertas = _cantPuertas;
    }

    public String get_matricula() {
        return _matricula;
    }

    public void set_matricula(String _matricula) {
        this._matricula = _matricula;
    }

    public int get_año() {
        return _año;
    }

    public void set_año(int _año) {
        this._año = _año;
    }
    public Auto unAuto(String pMatricula, String pModelo, int pAño, int pCantPuertas, Marca pMarca){
        Auto elAuto = new Auto();
        elAuto.set_año(pAño);
        elAuto.set_cantPuertas(pCantPuertas);
        elAuto.set_Marca(pMarca);
        elAuto.set_matricula(pMatricula);
        elAuto.set_modelo(pModelo);
        return  elAuto;
    }

    @Override
    public String toString() {
        return _matricula;
    }
}
