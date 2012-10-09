/**
 * 
 */
package com.progen.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author sinner_universe
 *
 */
public class ProgenControlador extends SQLiteOpenHelper {

	//Nombre de la base de datos
    public static final String NOMBREBD = "progenDB.db3";
    //Versi�n de la base de datos
    public static final int VERSION = 1;
    //Nombre de la tabla (puede haber tantas como necesitemos)
    public static final String NOMBRE_TABLA = "tbl_cat_acciones";
    //Campo 1
    public static final String ID = "int_AccionId_pk";
    //Campo 2 (tambi�n puede haber tantos campos como queramos)
    public static final String NOMBRE = "str_Accion";
 
    //Constructor
    public ProgenControlador(Context context) {
        //Aqu� le pasamos el contexto, el nombre de la base de datos, el cursor que no lo necesitamos y la version de la base de datos.
        super(context, NOMBREBD, null, VERSION);
    }
 
    //Aqu� crearemos la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*En la siguiente linea lo que estamos haciendo es crear la base de datos 
         * con una tabla llamada tablaprueba
         * dos campos uno llamado id que almacenar� un n�mero entero, que ser� clave primaria con autoincremento y que no podr� ser null
         * y otro campo llamado nombre que ser� de tipo texto  
         */
        db.execSQL("create table " + NOMBRE_TABLA + "(" + ID + " integer primary key autoincrement not null, " + NOMBRE + "text);");
        //dentro de los par�ntesis tambi�n podr�a ir perfectamente "create table tablaprueba(id integer primary key autoincrement not null, nombre text);" esto y lo anterior es lo mismo
    }
 
    //Aqu� se actualizar� la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    
    }

}
