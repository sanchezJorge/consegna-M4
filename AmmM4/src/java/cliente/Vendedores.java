
package cliente;

import java.util.ArrayList;

public class Vendedores extends Usuario{
   private ArrayList<Producto> productoEnVenta = new ArrayList<Producto>(); 
   public int feedback;
   
    public Vendedores(){
        super();
    }
        public ArrayList<Producto> getProductoEnVenta() {
        return productoEnVenta;
    }
            public void setProductoEnVenta(ArrayList<Producto> venta) {
        this.productoEnVenta = venta;
    }
                public int getFeedback() {
        return feedback;
    }

    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }
}
