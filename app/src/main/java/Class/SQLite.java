package Class;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Maxi on 15/08/2016.
 */
public class SQLite extends SQLiteOpenHelper {
    //region PRIVADOS
    //Ruta a la localizacion de la BDD
    private static String BDD_RUTA = "/data/data/com.example.tallerandroid.automotora/databases/";
    //C:\Users\Maxi\Documents\ProgramasTaller\Automotora_mia
    //Nombre de la BDD para asceder a la misma
    private static String BDD_NOMBRE = "automotora";
    private SQLiteDatabase miBdd;
    private final Context miContexto;

    //Elemento para acceder a los Datos
    protected Cursor c;
    //endregion

    public SQLite(Context contexto) {
        super(contexto, BDD_NOMBRE,null, 1);
        this.miContexto = contexto;
        try {
            this.crearDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //region crearDataBase()
    public void crearDataBase() throws IOException{
        boolean dbExist = comprobarBaseDatos();
        if(dbExist == false){
            this.getWritableDatabase();
            try {
                copiarBaseDatos();
            }catch (IOException e){
                throw new Error("Error al copiar la base de datos");
            }
        }
    }
    //endregion
    //region comprobarBaseDatos() -- Compruebo si existe la base de datos
    private boolean comprobarBaseDatos(){
        SQLiteDatabase checkDB = null;
        try {
            String myPath = BDD_RUTA + BDD_NOMBRE;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch (SQLiteException e){
            //no existe
        }
        if(checkDB != null){
            checkDB.close();
            return true;
        }
        return false;
    }
    //endregion
    //region  copiarBaseDatos() Copia la base de datos desde Assets a la Ruta indicada en el Telefono
    private void copiarBaseDatos() throws IOException{
        InputStream myInput = miContexto.getAssets().open(BDD_NOMBRE);
        String outFileName = BDD_RUTA + BDD_NOMBRE;
        OutputStream myOutPut = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutPut.write(buffer, 0 , length);
        }
        myOutPut.flush();
        myOutPut.close();
        myInput.close();
    }
    //endregion
    //region abrirBaseDatos() Abre la Base de Datos para la Lectura de Tublas o Tablas
    public void abrirBaseDatos()throws IOException{
        String myPath = BDD_RUTA + BDD_NOMBRE;
        // Abrimos la BD para leer y escribir en la misma
        this.miBdd = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    //endregion
    //region close() -- Cierra conexion con la base de Datos
    @Override
    public synchronized void close(){
        if(miBdd != null){
            miBdd.close();
        }
        super.close();
    }
    //endregion
    //region onCreate() - -  onUpgrade() -- Sin Utilizar
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //endregion
    //region seleccionar()
    public void seleccionar(String sql) throws IOException {
        this.abrirBaseDatos();
        try {
            //Cargamos en el Cursor lo que retorna la consulta
            this.c = this.miBdd.rawQuery(sql,null);
            this.c.moveToFirst();
        }catch (SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
    }
    //endregion
    //region ejecutarSentencia() --  Ejecutar la sentencia
        /*Se Implementa para no desarrollar este codigo  en cada clase
         en la que se desea ejecutar una sentencia de la BDD*/
    public void ejecutarSentencia(String sql) throws IOException {
        this.abrirBaseDatos();
        try {
            //ejecutamos la sentencia
            this.miBdd.execSQL(sql);
        }catch (SQLException e){
            System.err.println("SQLExeption:" + e.getMessage());
        }
        this.miBdd.close();
    }


    //endregion

}
