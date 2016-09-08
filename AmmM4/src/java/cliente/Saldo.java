
package cliente;

public class Saldo {
    
    private double saldo=0.0;
    
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean aumentaSaldo(double dinero){
        if (dinero > 0) {
            this.saldo = this.saldo + dinero;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean disminuyeSaldo(double dinero){
        if ((dinero > 0)&&(dinero <= this.saldo)){
            this.saldo = this.saldo - dinero;
            return true;
        }else{
            return false;
        }
        
    
    }




}
