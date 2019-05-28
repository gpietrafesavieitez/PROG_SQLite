package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLite{
    private Connection conn;
    private String bd, table;
    
    public SQLite(){
    }
    
    public SQLite(String bd){
        this.bd = bd;
    }
    
    public SQLite(String bd, String table){
        this.bd = bd;
        this.table = table;
    }

    public boolean conectar(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:" + bd);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean desconectar(){
        try{
            conn.close();
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public int insertar(String colNombre, String colApellido){
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO " + table + "(nombre,apellido) VALUES('" + colNombre + "','" + colApellido + "')");
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public int modificar(Object colID, Object colNombre, Object colApellido){
        try{
            PreparedStatement st = conn.prepareStatement("UPDATE " + table + " SET nombre='" + colNombre + "',apellido='" + colApellido + "' WHERE ID=" + colID);
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public ResultSet mostrar(){
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM " + table);
            return st.executeQuery();
        }catch(SQLException e){
            return null;
        }
    }
    
    public int eliminar(Object colID){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM " + table + " WHERE id=" + colID);
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
}