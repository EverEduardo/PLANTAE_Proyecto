package com.uv.pruebas_plantae;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class dbUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "BDUsuario";
    String tabla = "create table if not exists usuario(id integer primary key autoincrement, nombre text, telefono text, usuario text, correo text, contraseña text)";

    public dbUsuario(Context c){
        this.c=c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertUsuario(Usuario u){
        if(buscar(u.getUsuario())==0){
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("telefono", u.getTelefono());
            cv.put("usuario", u.getUsuario());
            cv.put("correo", u.getCorreo());
            cv.put("contraseña", u.getContraseña());
            return (sql.insert("usuario", null, cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=selectUsuarios();
        for (Usuario us:lista) {
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public  ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                Usuario u = new Usuario();
                u.setIdUsuario(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setTelefono(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setCorreo(cr.getString(4));
                u.setContraseña(cr.getString(5));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    //Metodo para validar el usuario y la contraseña
    public int login(String u, String c){
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(3).equals(u)&&cr.getString(5).equals(c)){
                    a++;
                }
            }while (cr.moveToNext());
        }return a;
    }

    //Metodo para obtener los datos del usuario que incio sesión
    public Usuario getUsuario(String u, String c){
        lista = selectUsuarios();
        for (Usuario us:lista) {
            if(us.getUsuario().equals(u)&&us.getContraseña().equals(c)){
                return us;
            }
        }return null;
    }

    //Metodo para obtener los datos del usuario que incio sesión utilizando el idUsuario
    public Usuario getUsuarioById(int id){
        lista = selectUsuarios();
        for (Usuario us:lista) {
            if(us.getIdUsuario()==id){
                return us;
            }
        }return null;
    }
}
