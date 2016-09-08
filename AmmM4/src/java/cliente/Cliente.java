
package cliente;

import java.util.ArrayList;

public class Cliente extends Usuario{
    
    private ArrayList<Producto> productoAdquirido = new ArrayList<Producto>();
    
    public Cliente(){
        super();
    }
    public ArrayList<Producto> getProductoAdquirido() {
        return productoAdquirido;
    }
    
     public void setProductoAdquirido(ArrayList<Producto> productoAdquirido) {
        this.productoAdquirido = productoAdquirido;
    }
    
    
}
