package cliente;

import java.sql.*;
import java.util.ArrayList;

public class Usuarios {
    
    private static Usuarios usuario;
    String connectionString; 
    
    
    public static Usuarios getObjeto() {
        if (usuario == null) {
            usuario = new Usuarios();
        }
        return usuario;
    }
    
    private Usuarios(){
    }
    
      
    public Usuario getVendedor(int id){
        try{

            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
      
            
            String query = "select * from vendedores where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            
         
            if(res.next()){
                Vendedores current = new Vendedores();
                current.setId(res.getInt("id"));
                current.setNombre(res.getString("nombre"));
                current.setApellido(res.getString("apellido"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getFloat("saldo"));
                current.setFeedback(res.getInt("feedback"));
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
        public Usuario getCliente(int id){
       try{
            
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            String query = "select * from cliente "
            + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
           
             
            if(res.next()){
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNombre(res.getString("nombre"));
                current.setApellido(res.getString("apellido"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getFloat("saldo"));
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
        
        public ArrayList<Cliente> getListaCliente(){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        try{
            
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "cliente";
            ResultSet set = stmt.executeQuery(query);
            
             
            while(set.next()){
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setNombre(set.getString("nombre"));
                current.setApellido(set.getString("apellido"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getFloat("saldo"));
                listaClientes.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaClientes;
    }
        
    public ArrayList<Vendedores> getListaVendedor(){
            ArrayList<Vendedores> listaVendedores = new ArrayList<Vendedores>();
             try{
            
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            Statement stmt = conn.createStatement();
            String query = "select * from vendedores "
            + "where id = ?";
            ResultSet set = stmt.executeQuery(query);
            
            
            while(set.next()){
                Vendedores current = new Vendedores();
                current.setId(set.getInt("id"));
                current.setNombre(set.getString("nombre"));
                current.setApellido(set.getString("apellido"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getFloat("saldo"));
                current.setFeedback(set.getInt("feedback"));
                listaVendedores.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaVendedores;
    }
            
        public Usuario getUsuario(String username, String password){
        try
        {
            Connection conn = DriverManager.getConnection(connectionString,"sango", "sango");

            String query = "select * from cliente where "
                    + "password = ? and username = ?";
            
             PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNombre(set.getString("nombre"));
                cliente.setApellido(set.getString("apellido"));
                cliente.setUsername(set.getString("username"));
                cliente.setPassword(set.getString("password"));
                cliente.setSaldo(set.getFloat("saldo"));
                stmt.close();
                conn.close();
                return cliente;
            }
            
            
        
            query = "select * from vendedores where "
                    + "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
       
            stmt.setString(1, password);
            stmt.setString(2, username);
         
            set = stmt.executeQuery();
            
            if(set.next())
            {
                Vendedores vendedor = new Vendedores();
                vendedor.setId(set.getInt("id"));
                vendedor.setNombre(set.getString("nombre"));
                vendedor.setApellido(set.getString("apellido"));
                vendedor.setUsername(set.getString("username"));
                vendedor.setPassword(set.getString("password"));
                vendedor.setSaldo(set.getFloat("saldo"));
                vendedor.setFeedback(set.getInt("feedback"));
                
                stmt.close();
                conn.close();
                
                return vendedor;
            }
            
           
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}