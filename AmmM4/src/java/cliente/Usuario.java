
package cliente;

public class Usuario {
        protected int id;
    protected String nombre;
    protected String apellido;
    protected String username;
    protected String password;
    public Saldo saldo;
    
     
    public Usuario(){
        id = 0;
        nombre = "";
        apellido = "";
        username="";
        password="";
        saldo = new Saldo();
    }
    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo.getSaldo();
    }

    public void setSaldo(double saldo) {
        this.saldo.setSaldo(saldo);
    }
        public boolean sumar(double dinero) {
        return saldo.aumentaSaldo(dinero);
    }

    public boolean restar(double dinero) {
        return saldo.disminuyeSaldo(dinero);
    }
    
}
