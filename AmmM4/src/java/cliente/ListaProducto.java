
package cliente;

import java.sql.*;
import java.util.ArrayList;

public class ListaProducto {
    
     private static ListaProducto objeto = null;
     
         String connectionString; 
    
     
    synchronized public static ListaProducto getProductos () {
        if (objeto == null) {
            objeto = new ListaProducto();
        }
        return objeto;
   
    }    
private ListaProducto() {
        
}

    
    public Producto getProducto(int id){
       try{
           
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
         
            String query = "select * from producto "
            + "where id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(query);
           
            stmt.setInt(1, id);
         
            ResultSet res = stmt.executeQuery();
            if(res.next()){
                Producto current = new Producto();
                current.setId(res.getInt("id"));
                current.setNombre(res.getString("nombre"));
                current.setDescripcion(res.getString("descripcion"));
                current.setImagen(res.getString("foto"));
                current.setDisponibilidad(res.getInt("disponibilidad"));
                current.setPrecio(res.getFloat("precio"));
                current.setIdVendedor(res.getInt("id_vendedores"));
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Producto> getListaProducto(){
                ArrayList<Producto> listaProductos = new ArrayList<>();
        try{
            
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            Statement stmt = conn.createStatement();
            String query = "select * from " + "producto";
            ResultSet set = stmt.executeQuery(query);

            while(set.next()){
                Producto current = new Producto();
                current.setId(set.getInt("id"));
                current.setNombre(set.getString("nombre"));
                current.setDescripcion(set.getString("descripcion"));
                current.setImagen(set.getString("foto"));
                current.setDisponibilidad(set.getInt("disponibilidad"));
                current.setPrecio(set.getFloat("precio"));
                current.setIdVendedor(set.getInt("id_vendedores"));
                listaProductos.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaProductos;
    
    }
    
    public ArrayList<Producto> getProductoPorUser(int id){
    ArrayList<Producto> listaProductosUser = new ArrayList<>();
        try{
           
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            
            String query = "select * from producto "
            + "where id_vendedores = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                Producto current = new Producto();
                current.setId(set.getInt("id"));
                current.setNombre(set.getString("nombre"));
                current.setDescripcion(set.getString("descripcion"));
                current.setImagen(set.getString("foto"));
                current.setDisponibilidad(set.getInt("disponibilidad"));
                current.setPrecio(set.getFloat("precio"));
                current.setIdVendedor(set.getInt("id_vendedores"));
                listaProductosUser.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaProductosUser;
    }
    
    
     public Boolean insertarProducto(Producto producto){
        try{
            
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
           
            Statement stmt = conn.createStatement();
          
            String query = "insert into producto (id, nombre, descripcion, "
                    + "foto, disponibilidad, precio, id_vendedores) "
                    + "values (default, '" 
                    + producto.getNombre() +"' , '"
                    + producto.getDescripcion() + "' , '"
                    + producto.getImagen() + "' , "
                    + producto.getDisponibilidad() + " , "
                    + producto.getPrecio() + " , "
                    + producto.getIdVendedor() + ")";
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
     
     public Boolean modificarProducto(Producto producto){
        try{
           
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
        
            Statement stmt = conn.createStatement();
           
            String query = "update producto set "
                    + "nombre = '" + producto.getNombre() 
                    + "' , descripcion = '" + producto.getDescripcion()
                    + "' , foto = '" + producto.getImagen()
                    + "' , disponibilidad = " + producto.getDisponibilidad()
                    + " , precio = " + producto.getPrecio()
                    + " where id = "+ producto.getId();
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
         public Boolean eliminarProducto(int id){
        try{

            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
     
            Statement stmt = conn.createStatement();
            String query = "delete from producto where id = " + id;
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public Boolean quitar(int idProducto){
        try{
           
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");
            PreparedStatement borrar=null;
            String query= "update producto set disponibilidad = disponibilidad - 1 where id = ?";
            try{
                conn.setAutoCommit(false);
                borrar = conn.prepareStatement(query);
                borrar.setInt(1, idProducto);
                borrar.executeUpdate();
                conn.commit();  
                               } catch (SQLException e ){
                e.printStackTrace();
                if (conn != null) {
                    try{
                        conn.rollback();
                        return false;
                    }catch (SQLException excep ){
                        excep.printStackTrace();
                    }
                }
            }finally{
                if (borrar != null){
                    borrar.close();
                }
                conn.setAutoCommit(true);
            }
            conn.close();        
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
         
             public Boolean transaccion(int idProducto, int idCliente, int idVendedor, double costo) {
        try{
           
            Connection conn = DriverManager.getConnection(connectionString, "sango", "sango");

            PreparedStatement transaccionProducto = null;
            PreparedStatement transaccionCliente = null;
            PreparedStatement transaccionVendedor = null;

            String querytransaccionProducto = "update producto set disponibilidad = disponibilidad - 1 where id = ?";
            String querytransaccionCliente = "update cliente set saldo = saldo - ? where id = ?";
            String querytransaccionVendedor = "update vendedores set saldo = saldo + ? where id = ?";

            try{
                conn.setAutoCommit(false);
                transaccionProducto = conn.prepareStatement(querytransaccionProducto);
                transaccionCliente = conn.prepareStatement(querytransaccionCliente);
                transaccionVendedor = conn.prepareStatement(querytransaccionVendedor);

                transaccionProducto.setInt(1, idProducto);
                transaccionProducto.executeUpdate();

                transaccionCliente.setDouble(1, costo);
                transaccionCliente.setInt(2, idCliente);
                transaccionCliente.executeUpdate();

                transaccionVendedor.setDouble(1, costo);
                transaccionVendedor.setInt(2, idVendedor);
                transaccionVendedor.executeUpdate();
                conn.commit();            
            } catch (SQLException e ){
                e.printStackTrace();
                if (conn != null) {
                    try{
                        conn.rollback();
                        return false;
                    }catch (SQLException excep ){
                        excep.printStackTrace();
                    }
                }
            }finally{
                if (transaccionProducto != null){
                    transaccionProducto.close();
                }
                if (transaccionCliente != null){
                    transaccionCliente.close();
                }
                if (transaccionVendedor != null){
                    transaccionVendedor.close();
                }
                conn.setAutoCommit(true);
            }
            conn.close();        
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
         
        public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
}