
/**
 * La clase Laboratorio recibe Nombre, domicilio, telefono, la compra minima y el dia de entrega.
 * Permite mostrar estos datos y ademas modificar la compra minima y el dia de entrega.
 * 
 * @author Pannunzio M. Nicolas - Quintana R. J. Antonio
 * @version 14/08/25
 */
public class Laboratorio
{
    //Variables de instancia
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega;
    
    /**
     * Metodo contructor que recibe todos los parametros.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMin);
        this.setDiaEntrega(p_diaEnt);
    }
    
    /**
     * Constructor sobrecargado, no recibe la compra minima ni el dia de entrega.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(0);
        this.setDiaEntrega(0);
    }
    
    // setters ----------------------------------------

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setDomicilio(String p_domicilio){
        this.domicilio = p_domicilio;
    }
    
    private void setTelefono(String p_telefono){
        this.telefono = p_telefono;
    }
    
    private void setCompraMinima(int p_compraMin){
        this.compraMinima = p_compraMin;
    }
    
    private void setDiaEntrega(int p_diaEnt){
        this.diaEntrega = p_diaEnt;
    }
    
    // Getters ----------------------------------------
    public String getNombre(){
        return this.nombre;
    }
    
    public String getDomicilio(){
        return this.domicilio;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public int getCompraMinima(){
        return this.compraMinima;
    }
    
    public int getDiaEntrega(){
        return this.diaEntrega;
    }
    
    /**
     * Modifica el estado de la compra minima
     */
    public void nuevaCompraMinima(int p_compraMin){
        this.setCompraMinima(p_compraMin);
    }
    
    /**
     * Modifica el estado del dia de entrega
     */
    public void nuevoDiaEntrega(int p_diaEnt){
        this.setDiaEntrega(p_diaEnt);
    }
    
    /**
     * Concatena y devuelve los datos del laboratorio en un String.
     * @return Devuelve el nombre del laboratorio seguido del domicilio y el telefono.
     */
    public String mostrar(){
        return "Laboratorio: "+ this.getNombre() +"\n"+"Domicilio: "+ this.getDomicilio() +" - Telefono: "+ this.getTelefono();
    }
}