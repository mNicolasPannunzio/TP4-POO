
import java.util.*;

/**
 * La Clase Persona recibe los datos (DNI, Nombre, Apellido y Año de nacimiento)
 * Calcula la edad de la persona y muestra los resultados.
 * 
 * @author Pannunzio M. Nicolas - Quintana R. J. Antonio
 * @version 14/08/25
 */

public class Persona
{
    //Variables de instancia
    private int nroDni;
    private String nombre;
    private String apellido;
    private Calendar fechaNacimiento;
    
    /**
     * Metodo constructor que recibe todos los atributos como parametro  y un int en lugar
     * de Calendar.
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio){
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnio(p_anio);
    }

    /**
     * Metodo constructor que recibe todos los atributos como parametro.
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha){
        this.setDNI(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }
    
    //Setters ------------------------------
    private void setDNI(int p_dni){
        this.nroDni = p_dni;
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    private void setFechaNacimiento(Calendar p_fecha){
        this.fechaNacimiento = p_fecha;
    }
    private void setAnio(int p_anio){
        Calendar fechaAux = new GregorianCalendar(p_anio, 0, 1); //asignar primer dia del p_anio
        this.fechaNacimiento = fechaAux;
    }
    
    //Getters ------------------------------
    public int getDNI(){
        return this.nroDni;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public Calendar getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    /**
     * Calcula la edad de la persona utilizando la clase Calendar
     * @return Devuelve el resultado de restar el año actual menos el año de nacimiento de la persona.
     */
    public int edad(){
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        //Variable temporal anioHoy
        int edad = anioHoy - this.getFechaNacimiento().get(Calendar.YEAR);
        //Variable temporal edad
        return edad;
    }
    
    /**
     * String con Nombre/s , seguido de un espacio apellido/s
     * @return Devuelve el Nombre y seguido de un espacio el apellido.
     */
    public String nomYApe(){
        return this.getNombre() +" "+ this.getApellido();
    }
    
    /**
     * String con  apellido/s y seguido de un espacio nombre/s
     * @return Devuelve el apellido y seguido de un espacio el nombre.
     */
    public String apeYNom(){
        return this.getApellido() +" "+ this.getNombre();
    }
    
    /**
     * Muestra en pantalla Nombre y apellido, DNI y la edad de la persona.
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: "+ this.nomYApe());
        System.out.println("DNI: "+ this.getDNI() +"\tEdad: "+ this.edad() +" años");
    }
    
    /**
     * Usando la clase Calendar verifica si la fecha actual coincide con la fecha de nacimiento de persona
     * @return TRUE si dia y mes actual coinciden con los de la fecha de nacimiento
     */
    public boolean esCumpleaños(){
        Calendar fechaHoy = new GregorianCalendar();
        if( (fechaHoy.get(Calendar.MONTH) == this.getFechaNacimiento().get(Calendar.MONTH)) &&
            (fechaHoy.get(Calendar.DAY_OF_MONTH) == this.getFechaNacimiento().get(Calendar.DAY_OF_MONTH)) ){
            
                return true;
            }else{
                return false;
            }
    }
    
}








































