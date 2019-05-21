package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLite{
    private Connection conn;
    private String bd;
    
    public SQLite(){
    }

    public boolean conectar(){
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:base.db");
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
    
    public int insertar(int colID, String colNombre, String colApellido){
        try{
            PreparedStatement st = conn.prepareStatement("INSERT INTO alumnos(ID,Nombre,Apellido) VALUES("+ colID + ",'" + colNombre + "','" + colApellido + "')");
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public int modificar(Object colID, Object colNombre, Object colApellido){
        try{
            PreparedStatement st = conn.prepareStatement("UPDATE alumnos SET Nombre='" + colNombre + "',Apellido='" + colApellido + "' WHERE ID=" + colID);
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
    
    public ResultSet mostrar(){
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM alumnos");
            return st.executeQuery();
        }catch(SQLException e){
            return null;
        }
    }
    
    public int eliminar(Object colID){
        try{
            PreparedStatement st = conn.prepareStatement("DELETE FROM alumnos WHERE id=" + colID);
            return st.executeUpdate();
        }catch(SQLException e){
            return -1;
        }
    }
}