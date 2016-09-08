
package server;

import java.io.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cliente.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {
    
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";

@Override 
    public void init(){
        
        String dbConnection ="jdbc:derby:"+this.getServletContext().getRealPath("/")+ DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuarios.getObjeto().setConnectionString(dbConnection);
        ListaProducto.getProductos().setConnectionString(dbConnection);
    }
    
    
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion = request.getSession(false);

        if (sesion.getAttribute("loggedId")=="true"){      
            if (sesion.getAttribute("userType") == "vendedores"){
                request.getRequestDispatcher("vendedores.html").forward(request, response);
            }else{
                ListaProducto lista = ListaProducto.getProductos();
                ArrayList<Producto> listaProducto = lista.getListaProducto();
                request.setAttribute("Producto", listaProducto);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        }
       
        if(request.getParameter("Login") != null){
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
             

            if (username != null && password != null){
                Usuario usuario = Usuarios.getObjeto().getUsuario(username, password);
                if(usuario != null){
                        sesion.setAttribute("loggedId", "true");
                        sesion.setAttribute("idUsuario", usuario.getId());
                        if(usuario instanceof Vendedores){
                            request.setAttribute("vendedores", usuario);
                            sesion.setAttribute("vendedores", usuario);
                            sesion.setAttribute("userType", "vendedores");
                            request.getRequestDispatcher("vendedores.html").forward(request, response);
                        }else{
                            request.setAttribute("cliente", usuario);
                            sesion.setAttribute("cliente", usuario);
                            sesion.setAttribute("userType", "cliente");
                            request.getRequestDispatcher("cliente.html").forward(request, response);
                        }
                    }
                }
                    
       
     
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
