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
    //Versión de la base de datos
    public static final int VERSION = 1;
    //Nombre de la tabla (puede haber tantas como necesitemos)
    public static final String NOMBRE_TABLA = "tbl_cat_acciones";
    //Campo 1
    public static final String ID = "int_AccionId_pk";
    //Campo 2 (también puede haber tantos campos como queramos)
    public static final String NOMBRE = "str_Accion";
 
    //Constructor
    public ProgenControlador(Context context) {
        //Aquí le pasamos el contexto, el nombre de la base de datos, el cursor que no lo necesitamos y la version de la base de datos.
        super(context, NOMBREBD, null, VERSION);
    }
 
    //Aquí crearemos la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        /*En la siguiente linea lo que estamos haciendo es crear la base de datos 
         * con una tabla llamada tablaprueba
         * dos campos uno llamado id que almacenará un número entero, que será clave primaria con autoincremento y que no podrá ser null
         * y otro campo llamado nombre que será de tipo texto  
         */
        db.execSQL("create table " + NOMBRE_TABLA + "(" + ID + " integer primary key autoincrement not null, " + NOMBRE + "text);");
        //dentro de los paréntesis también podría ir perfectamente "create table tablaprueba(id integer primary key autoincrement not null, nombre text);" esto y lo anterior es lo mismo
    }
 
    //Aquí se actualizará la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {    
    }

}
