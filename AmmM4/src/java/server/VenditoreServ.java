package server;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cliente.*;

@WebServlet(name = "VenditoreServ", urlPatterns = {"/vendedores.html"})
public class VenditoreServ extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        

        HttpSession sesion = request.getSession(false);
        if ((sesion.getAttribute("loggedId")!="true")||(sesion.getAttribute("userType") == "cliente")){
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        
        ListaProducto productos = ListaProducto.getProductos();
        int idUsuario = (int) sesion.getAttribute("idUsuario");
        ArrayList<Producto> listaProductos;
        int numProducto;

        
        int idProductoBorrar;
        if(request.getParameter("idProductoBorrar") != null 
                && !(request.getParameter("idProductoBorrar").isEmpty())){
                    
            idProductoBorrar = Integer.parseInt(request.getParameter("idProductoBorrar"));
                

            if("Elimina".equals(request.getParameter("Elimina"))){
                Producto producto = productos.getProducto(idProductoBorrar);
                boolean ok=productos.quitar(idProductoBorrar);
                if(producto.getDisponibilidad()==1){
                    productos.eliminarProducto(idProductoBorrar);
                }
                    request.setAttribute("eliminado", true);
                    request.getRequestDispatcher("eliminar.jsp").forward(request, response);
            }
            else{
                if("Cancelare".equals(request.getParameter("Cancelare"))){
                    listaProductos = productos.getProductoPorUser(idUsuario);
                    numProducto = listaProductos.size();
                    sesion.setAttribute("producto", listaProductos);
                    request.setAttribute("producto", listaProductos);
                    request.setAttribute("numProducto", numProducto);
                    request.setAttribute("idProductoBorrar", null);
                    request.setAttribute("idProductoCambiar", null);
                    request.setAttribute("Eliminar", null);
                    request.getRequestDispatcher("vendedores.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("producto", productos.getProducto(idProductoBorrar));
                    request.setAttribute("eliminado", false);
                    request.getRequestDispatcher("eliminar.jsp").forward(request, response);
                }
            }
        }
        
        int idProductoCambiar;
        if(request.getParameter("idProductoCambiar") != null 
                && !(request.getParameter("idProductoCambiar").isEmpty())){
            idProductoCambiar = Integer.parseInt(request.getParameter("idProductoCambiar"));
            request.setAttribute("producto", productos.getProducto(idProductoCambiar));
            request.setAttribute("modificado", false);
            request.getRequestDispatcher("modificar.jsp").forward(request, response);
        }
        
        if("Cambiar".equals(request.getParameter("Cambiar"))){ 
           
            Producto productoN = new Producto();
            productoN.setId(Integer.parseInt(request.getParameter("idProductoCambiar")));
            productoN.setNombre(request.getParameter("nombre"));
            productoN.setImagen(request.getParameter("img"));
            productoN.setDescripcion(request.getParameter("descripcion"));
            productoN.setDisponibilidad(Integer.parseInt(request.getParameter("cantidad")));
            productoN.setPrecio(Double.parseDouble(request.getParameter("precio")));
            productos.modificarProducto(productoN);
            request.setAttribute("modificado", true);
                  
            request.getRequestDispatcher("modificar.jsp").forward(request, response);
        }
        
        
        
        
        
        if(request.getParameter("Insertar") != null){
            String nombre= request.getParameter("nombre");
            String foto= request.getParameter("img");
            String descripcion= request.getParameter("descripcion");
            String precio= request.getParameter("precio");
            String cantidad= request.getParameter("cantidad");
            
            
            if(nombre.equals("") || foto.equals("") || descripcion.equals("") || precio.equals("") || cantidad.equals("")){
                request.setAttribute("error", true);
                request.getRequestDispatcher("confirmacionVendedor.jsp").forward(request,response);
            }
            else{
            request.setAttribute("error", false);
            request.setAttribute("nombre",request.getParameter("nombre"));
            request.setAttribute("img",request.getParameter("img"));
            request.setAttribute("descripcion",request.getParameter("descripcion"));
            request.setAttribute("precio",request.getParameter("precio"));
            request.setAttribute("cantidad",request.getParameter("cantidad"));
            request.setAttribute("insertado", true);
            request.getRequestDispatcher("confirmacionVendedor.jsp").forward(request, response);
        }
            
        }
        
        if(request.getParameter("Entrar") != null){
            if("true".equals(request.getParameter("Entrar"))){
                Producto productoA = new Producto();
                productoA.setNombre(request.getParameter("nombre"));
                productoA.setImagen(request.getParameter("foto"));
                productoA.setDescripcion(request.getParameter("descripcion"));
                productoA.setPrecio(Integer.parseInt(request.getParameter("precio")));
                productoA.setDisponibilidad(Integer.parseInt(request.getParameter("cantidad")));
                productoA.setIdVendedor(idUsuario);
                productos.insertarProducto(productoA);
                request.setAttribute("insertado", true);
                request.getRequestDispatcher("vendedores.jsp").forward(request, response);
            }
        else
                if("false".equals(request.getParameter("Entrar"))){
                    listaProductos = productos.getProductoPorUser(idUsuario);
                    numProducto = listaProductos.size();
                    sesion.setAttribute("producto", listaProductos);
                    request.setAttribute("producto", listaProductos);
                    request.setAttribute("numProducto", numProducto);
                    request.setAttribute("idProductoBorrar", null);
                    request.setAttribute("idProductoCambiar", null);
                    request.setAttribute("insertado", false);
                    request.setAttribute("Eliminar", null);
                    request.getRequestDispatcher("vendedores.jsp").forward(request, response);      
            }
        }
        
        
        listaProductos = productos.getProductoPorUser(idUsuario);
        numProducto = listaProductos.size();

        sesion.setAttribute("productos", listaProductos);
        request.setAttribute("productos", listaProductos);
        request.setAttribute("numProducto", numProducto);
        request.setAttribute("idProductoBorrar", null);
        request.setAttribute("idProductoCambiar", null);
        request.setAttribute("insertado", false);
       
        request.setAttribute("Elimina", null);
        request.setAttribute("Cambiar", null);
        request.getRequestDispatcher("vendedores.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
