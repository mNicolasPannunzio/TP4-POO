import java.util.*;
/**
 * Clase Comercio contiene como atributos el nombre del comercio y un HashMap de empleados pertenecientes al 
 * mismo. permite dar de alta o de baja los empleados, y mostrar los datos de los mismos.
 *
 * @author Pannunzio M. Nicolas - Quintana Antonio 
 * @version 09/09/25
 */

 public class Comercio{
    private String nombre;
    private HashMap empleados;

    /**
     * Constructor de la clase Comercio que solo recibe el nombre, inicializando 
     * el HashMap de empleados con 0 elementos. Caso 0.
     */
    public Comercio(String p_nombre){
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap());
    }

    /**
     * Constructor sobrecargado que recibe el nombre y el HashMap de empleados. Caso *
     */
    public Comercio(String p_nombre, HashMap p_empleados){
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }

    //Setters----------------------------------------
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setEmpleados(HashMap p_empleados){
        this.empleados = p_empleados;
    }

    //Getters----------------------------------------
    public String getNombre(){
        return this.nombre;
    }

    public HashMap getEmpleados(){
        return this.empleados;
    }

    //Metodos Put y Remove del HashMap-------------------
    /**
     * Da de alta un empleado en el HashMap de empleados. Utiliza el metodo put.
     * que pasa el cuil del empleado como clave y el objeto Empleado como valor.
     * @param p_empleado Empleado a dar de alta
     */
    public void altaEmpleado(Empleado p_empleado){
        this.getEmpleados().put(new Long(p_empleado.getCuil()), p_empleado);
    }

    /**
     * Da de baja un empleado del HashMap de empleados. Utiliza el metodo remove
     * que recibe el cuil del empleado a dar de baja.
     * @param p_cuil Cuil del empleado a dar de baja
     * @return Empleado dado de baja
     */
    public Empleado bajaEmpleado(long p_cuil){
        return (Empleado)this.getEmpleados().remove(new Long(p_cuil));
        //        ^-> Es necesario el casteo porque remove devuelve un Object
    }

    //Otros Metodos----------------------------------------
    /**
     * Devuelve la cantidad de empleados contenidos en el HashMap.
     * @return Cantidad de empleados (Tamanio del HashMap)
     */
    public int cantidadDeEmpleados(){
        return this.getEmpleados().size();
    }

    /**
     * Verifica si un empleado existe en el HashMap de empleados. 
     * Usando la clave p_Cuil. Devuelve true si existe, false si no.
     * @param p_cuil Cuil del empleado a buscar
     * @return True si existe, false si no
     */
    public boolean esEmpleado(long p_cuil){
        return this.getEmpleados().containsKey(new Long(p_cuil));
    }

    /**
     * Busca un empleado con su clave p_cuil, si lo encuentra devuelve ese empleado,
     * si no devuelve null y muestra un mensaje por pantalla.
     * @param p_cuil Cuil del empleado a buscar
     * @return Empleado encontrado, null si no se encontro.
     */
    public Empleado buscarEmpleado(long p_cuil){
        if(this.getEmpleados().get(new Long(p_cuil)) == null){
            System.out.println("*** Ese empleado no esta dado de alta. ***");
        }
        return (Empleado)this.getEmpleados().get(new Long(p_cuil));
        //         ^-->Cast necesario para retornar tipo Empleado / caso contrario devuelve Object
    }

    /**
     * Verifica mediante la clave p_cuil (parametro) si un empleado esta dado de alta,
     * y si es asi muestra en pantalla el sueldo neto del mismo. 
     * Caso contario muestra un mensaje por pantalla.
     * @param p_cuil Cuil del empleado que se quiere saber el sueldo neto.
     */
    public void sueldoNeto(long p_cuil){
        if(this.esEmpleado(p_cuil)){
            System.out.println("Sueldo Neto: $"+this.buscarEmpleado(p_cuil).sueldoNeto());
        }else{
            System.out.println("*** Ese empleado no esta dado de alta. ***");
        }
    }

    /**
     * Muestra la nomina de empleados del comercio, recorriendo el HashMap con un For-Each
     * y mostrando una linea por cada empleado con su cuil, apellido, nombre y sueldo neto.
     * Utiliza el metodo mostrarLinea() de la clase Empleado.
     */
    public void nomina(){
        System.out.println("**** Nomina de empleados de "+ this.getNombre() +" ****");

        for(Object objeto : this.getEmpleados().entrySet()){
            Map.Entry entry = (Map.Entry)objeto;
            Empleado auxEmpleado = (Empleado)entry.getValue(); //Cast necesario
            System.out.println(auxEmpleado.mostrarLinea());
        }
    }

}