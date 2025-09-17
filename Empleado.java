import java.util.*;
import java.util.GregorianCalendar;
/**
 * Clase que contiene como atributos los datos basicos de un empleado, 
 * calcula su antiguedad en la empresa, el sueldo neto, su aniversario
 * y permite mostrar sus datos en pantalla.
 *
 * @author Pannunzio M. Nicolas - Quintana Antonio 
 * @version 01/09/25
 */
public class Empleado
{
    private long cuil;
    private String nombre;
    private String apellido;
    private double sueldoBasico;
    private Calendar fechaIngreso;
    

    /**
     * Constructor de la clase Empleado que recibe un int en lugar de la fecha de ingreso Calendar
     */

    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, int p_anio){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setImporte(p_importe);
        this.setAnio(p_anio);
    }
    /**
     * Constructor que recibe todos los atributos de la clase Empleado.
     */
    public Empleado(long p_cuil, String p_apellido, String p_nombre, double p_importe, Calendar p_fecha){
        this.setCuil(p_cuil);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setImporte(p_importe);
        this.setFechaIngreso(p_fecha);
    }
    //Setters ----------------------------------------
    private void setCuil(long p_cuil){
        this.cuil = p_cuil;
    }
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    private void setImporte(double p_importe){
        this.sueldoBasico = p_importe;
    }
    private void setAnio(int p_anio){
        Calendar fechaAux = new GregorianCalendar(p_anio, 0, 1);
        //Setea en el primer dia del año ingresado
        this.setFechaIngreso(fechaAux);
    }
    private void setFechaIngreso(Calendar p_fecha){
        this.fechaIngreso = p_fecha;
    }
    //Getters----------------------------------------
    public long getCuil(){
        return this.cuil;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido ;
    }
    public double getImporte(){
        return this.sueldoBasico;
    }
    public int getAnio(){
        return this.getFechaIngreso().get(Calendar.YEAR);
    }
    public Calendar getFechaIngreso(){
        return this.fechaIngreso;
    }
    
    /**
     * Calcula la antiguedad del empleado en años.
     * @return retorna la antiguedad en años.
     */
    public int antiguedad() {
        Calendar hoy = Calendar.getInstance();
        Calendar ingreso = this.getFechaIngreso();
        if (ingreso != null) {
            int anios = hoy.get(Calendar.YEAR) - ingreso.get(Calendar.YEAR);
            // Si el aniversario aún no ocurrió este año, resta uno
            if (hoy.get(Calendar.MONTH) < ingreso.get(Calendar.MONTH) ||
                (hoy.get(Calendar.MONTH) == ingreso.get(Calendar.MONTH) &&
                 hoy.get(Calendar.DAY_OF_MONTH) < ingreso.get(Calendar.DAY_OF_MONTH))) {
                anios--;
            }
            return anios;
        }
        return 0;
    }
    
    /**
     * Calcula el descuento del empleado.
     * @return retorna el descuento.
     */
    private double descuento(){
        return this.getImporte()*0.02+1500;
    }

    /**
     * Calcula el adicional del empleado segun su antiguedad.
     * @return retorna el adicional.
     */
    private double adicional(){
        if(this.antiguedad() < 2){
            return this.getImporte()*0.02;
            
        }else if( this.antiguedad() >= 10 ){
            return this.getImporte()*0.06;
        }else{
            return this.getImporte()*0.04;
        }
    }
    /**
     * Calcula el sueldo neto sumando el adicional al sueldo basico y restando el descuento.
     * @return retorna el sueldo neto.
     */
    public double sueldoNeto(){
        return this.getImporte()+this.adicional()-this.descuento();
    }
    /**
     * Muestra una leyenda con los datos, antiguedad y sueldo neto del empleado.
     */
    public void mostrar(){
        System.out.println("Nombre y apellido: " + this.nomYape());
        System.out.print("CUIL: "+ this.getCuil());
        System.out.println("\tAntigüedad: "+this.antiguedad()+" años de servicio");
        System.out.println("Sueldo Neto: $"+this.sueldoNeto());
    }
    /**
     * Concatena en una linea el cuil + apeYNom() + sueldo neto.
     * @return retorna una linea con cuil, apellido, nombre y sueldo neto.
     */
    public String mostrarLinea(){
        return this.getCuil()+"   "+this.apeYnom()+"   …………… $ "+this.sueldoNeto();
    }
    /**
     * Concatena nombre y apellido con un espacio en medio.
     * @return nombre y apellido.
     */
    public String nomYape(){
        return (this.getNombre()+" "+this.getApellido());
    }
    /**
     * Concatena apellido y nombre con una coma en medio.
     * @return apellido y nombre.
     */
    public String apeYnom(){
        return (this.getApellido()+", "+this.getNombre());
    }

    /**
     * Verifica si la fecha actual coincide con el dia y mes del ingreso del empleado.
     * @return true si es el aniversario de ingreso, false en caso contrario.
     */
    public boolean esAniversario(){
        Calendar fechaActual = Calendar.getInstance();
        return (fechaActual.get(Calendar.DAY_OF_MONTH) == this.getFechaIngreso().get(Calendar.DAY_OF_MONTH) && fechaActual.get(Calendar.MONTH) == this.getFechaIngreso().get(Calendar.MONTH));

    }
}