package com.uv.pruebas_plantae;

public class Usuario {
    int idUsuario;
    String nombre, telefono, usuario, correo, contraseña;

    public Usuario(){

    }

    public Usuario(String nombre, String telefono, String usuario, String correo, String contraseña) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public boolean isNull(){
        if(nombre.equals("")||telefono.equals("")||usuario.equals("")||correo.equals("")||contraseña.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario='" + usuario + '\'' +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
