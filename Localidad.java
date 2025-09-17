
/**
 * Clase que contiene el nombre y la provincia de una localidad.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio 
 * @version 25/08/25
 */
public class Localidad
{
    //Variables de instancia
    private String nombre;
    private String provincia;
    
    /**
     * Constructor que recibe todos los atributos como parametros
     */
    public Localidad(String p_nombre, String p_provincia){
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }
    
    //Setters ------------------------------
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setProvincia(String p_provincia){
        this.provincia = p_provincia;
    }
    
    //Getters ------------------------------
    public String getNombre(){
        return this.nombre;
    }
    
    public String getProvincia(){
        return this.provincia;
    }
    
    /**
     * Concatena y devuelve una cadena con el nombre y la provincia
     * @return nombre y provincia concatenados
     */
    public String mostrar(){
        return "Localidad: "+ this.getNombre() +"\tProvincia: "+ this.getProvincia();
    }
}