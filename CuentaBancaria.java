
/**
 * Clase que permite depositar y extraer saldo
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio  
 * @version 24/08/25
 */
public class CuentaBancaria
{
    //Variables de instancia
    private int nroCuenta;
    private double saldo;
    private Persona titular;
    
    /**
     * Constructor que no recible saldo como parametro (Lo inicializa en 0).
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular){
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0);
        this.setTitular(p_titular);
    }
    
    /**
     * Constructor que recibe todos los atributos como parametros
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo){
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setTitular(p_titular);
    }
    
    //Setters
    private void setNroCuenta(int p_nroCuenta){
        this.nroCuenta = p_nroCuenta;
    }
    
    private void setSaldo(double p_saldo){
        this.saldo = p_saldo;
    }
    
    private void setTitular(Persona p_titular){
        this.titular = p_titular;
    }
    
    //Getters
    public int getNroCuenta(){
        return this.nroCuenta;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public Persona getTitular(){
        return this.titular;
    }
    
    /**
     * Permite agregar importe al saldo actual
     * @param importe que se sumara al saldo actual
     * @return el nuevo saldo.
     */
    public double depositar(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    
    /**
     * Permite extraer un importe del saldo.
     * @param Cantidad que se restara del saldo.
     * @return El nuevo saldo.
     */
    public double extraer(double p_importe){
        this.setSaldo(this.getSaldo() - p_importe);
        return this.getSaldo();
    }
    
    /**
     * Muestra el estado de los atributos
     */
    public void mostrar(){
        System.out.println("\n- Cuenta Bancaria - \nTitular: "+ this.getTitular().nomYApe() +" ("+//Sigue en la sig linea
                           this.getTitular().edad() +" años) \nSaldo: "+ this.getSaldo());
    }
    
    /**
     * Concatena y devuelve los estados de los atributos
     * @return NroCuenta + titular + saldo.
     */
    public String toString(){
        return this.getNroCuenta() +"\t"+ this.getTitular().nomYApe() +"\t"+ this.getSaldo();
    }
}