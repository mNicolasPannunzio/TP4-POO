
/**
 * La clase Cliente recibe el DNI, nombre y apellido, y saldo de un cliente.
 * Permite mostrar los datos y ademas modificar el saldo del cliente, Cambiando o agregando otro importe.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 14/08/25
 */
public class Cliente
{
    //Variables de Instancia
    private int nroDNI;
    private String apellido;
    private String nombre;
    private double saldo;
    
    /**
     * Metodo constructor que recible todos los atributos como parametros
     */
    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe){
      setNroDNI(p_dni);
      setApellido(p_apellido);
      setNombre(p_nombre);
      setSaldo(p_importe);
    }
    
    
     //Setters
    private void setNroDNI(int p_dni){
        this.nroDNI = p_dni;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setSaldo(double p_importe){
        this.saldo = p_importe;
    }
    
     //Getters
    public int getNroDNI(){
        return this.nroDNI;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    /**
     * muestra en pantalla el nombre completo del cliente, junto con su dni y su Saldo
     */
    public void mostrar(){
        System.out.println("-Cliente-");
        System.out.println("Nombre y Apellido: "+ this.nomYApe() +" ("+ this.getNroDNI() +")");
        System.out.println("Saldo: $"+ this.getSaldo());
    }
    
    /**
     * Cambia el valor actual de Saldo por p_importe y devuelve su nuevo valor
     * @param Un doble que sera el valor que se asignara a saldo
     * @return devuelve el nuevo valor de saldo
     */
    public double nuevoSaldo(double p_importe){
        this.setSaldo(p_importe);
        return this.getSaldo();
    }
    
    /**
     * Asigna a saldo la suma entre valor del parametro y el valor actual de saldo. Luego devuelve el nuevo valor de saldo
     * @param un doble cuyo valor se agregara al saldo actual
     * @return devuelve la Suma del saldo actual + el parametro p_importe
     */
    public double agregaSaldo(double p_importe){
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }
    
    /**
     * Devuelve un String que contiene el apellido y seguido de un espacio el nombre.
     * @return Devuelve el apellido y seguido de un espacio el nombre.
     */
    public String apeYNom(){
        return this.getApellido() +" "+ this.getNombre();
    }
    
    /**
     * Devuelve un String que contiene el nombre y seguido de un espacio el apellido.
     * @return devuelve el nombre y seguido de un espacio el apellido
     */
    public String nomYApe(){
        return this.getNombre() +" "+ this.getApellido();
    }
}