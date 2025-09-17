import java.util.Scanner;
import java.util.*;
/**
 * Clase ejecutable de Comercio, instancia y prueba exhaustivamente los metodos de Comercio.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio 
 * @version 09/09/25
 */
public class GestionComercio{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        Comercio miComercio = new Comercio("P.O.Objetos S.A.");

        System.out.println(" Quiere Dar de alta un empleado? (s/n)");
        String respuesta = teclado.next();
        while(respuesta.equalsIgnoreCase("s")){
            System.out.println(" Ingrese CUIL: ");
            long cuil = teclado.nextLong();
            System.out.println(" Ingrese Apellido: ");
            String apellido = teclado.next();
            System.out.println(" Ingrese Nombre: ");
            String nombre = teclado.next();
            System.out.println(" Ingrese Sueldo Basico: ");
            double sueldoBasico = teclado.nextDouble();
            System.out.println(" Ingrese Anio de Ingreso: ");
            int anioIngreso = teclado.nextInt();

            Empleado unEmpleado = new Empleado(cuil, apellido, nombre, sueldoBasico, anioIngreso);
            miComercio.altaEmpleado(unEmpleado);

            System.out.println(" Quiere Dar de alta otro empleado? (s/n)");
            respuesta = teclado.next();
        }


        // Mostrar nomina
        System.out.println("\nCantidad de empleados en el comercio: " + miComercio.cantidadDeEmpleados());
        miComercio.nomina();

        // Baja de un empleado
        System.out.println("\n Ingrese el CUIL del empleado a dar de baja: ");
        long cuilBaja = teclado.nextLong();
        miComercio.bajaEmpleado(cuilBaja);
        System.out.println(" El empleado se dio de baja? --> " + miComercio.esEmpleado(cuilBaja));

        // Mostrar nomina actualizada
        System.out.println("\nCantidad de empleados luego de la baja: " + miComercio.cantidadDeEmpleados());
        miComercio.nomina();
       
        //Creo otro comercio, con el otro metodo contructor para probar los metodos restantes.
        HashMap empleadosIniciales = new HashMap();

    
        do{
            System.out.println(" Ingrese los datos del empleado del nuevo comercio:");
            System.out.println(" Ingrese CUIL: ");
            long cuil = teclado.nextLong();
            System.out.println(" Ingrese Apellido: ");
            String apellido = teclado.next();
            System.out.println(" Ingrese Nombre: ");
            String nombre = teclado.next();
            System.out.println(" Ingrese Sueldo Basico: ");
            double sueldoBasico = teclado.nextDouble();
            System.out.println(" Ingrese Anio de Ingreso: ");
            int anioIngreso = teclado.nextInt();

            Empleado unEmpleado = new Empleado(cuil, apellido, nombre, sueldoBasico, anioIngreso);
            empleadosIniciales.put(cuil, unEmpleado);

            System.out.println(" Quiere Dar de alta otro empleado? (s/n)");
            respuesta = teclado.next();

        }while(respuesta.equalsIgnoreCase("s"));

        Comercio otroComercio = new Comercio("Sistemas S.R.L", empleadosIniciales);

        System.out.println("\n Ingrese el CUIL del empleado para ver su sueldo neto: ");
        long cuilConsulta = teclado.nextLong();
        otroComercio.sueldoNeto(cuilConsulta);
        //Muestra la nomina del otro comercio
        otroComercio.nomina();


    }
}