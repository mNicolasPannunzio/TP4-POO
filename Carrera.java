import java.util.*;
import java.util.Scanner;
/**
 * Clase ejecutable para instanciar y probar exhaustivamente los metodos de 
 * Curso.
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 09/09/25
 */

public class Carrera{
    public static void main(String[] args){
        //5.1.1. Crear un curso y varios Alumnos
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");

        System.out.println("Ingrese el nombre del curso:");
        String nombreCurso = teclado.nextLine();
        Curso unCurso = new Curso(nombreCurso);

        //Creo con un bucle varios alumnos con sus respectivas notas
        String respuesta = "S";
        do{
            System.out.println("Ingrese los datos del alumno:");
            System.out.println("Ingrese LU:");
            int lu = teclado.nextInt();
            System.out.println("Ingrese Nombre:");
            String nombre = teclado.next();
            System.out.println("Ingrese Apellido:");
            String apellido = teclado.next();
            System.out.println("Ingrese Nota 1:");
            double nota1 = teclado.nextDouble();
            System.out.println("Ingrese Nota 2:");
            double nota2 = teclado.nextDouble();

            Alumno unAlumno = new Alumno(lu, nombre, apellido);
            unAlumno.setNota1(nota1);
            unAlumno.setNota2(nota2);

            unCurso.inscribirAlumno(unAlumno);

            System.out.println("Desea ingresar otro alumno? (s/n)");
            respuesta = teclado.next();

        }while(respuesta.equalsIgnoreCase("s"));

        //5.1.4. Imprimir cantidad y lista de alumnos inscriptos
        System.out.println("****-- Cantidad de inscriptos: " + unCurso.cantidadDeAlumnos());
        unCurso.mostrarInscriptos();

        //5.1.5. Dar de baja un alumno y luego verifico que no este mas inscripto.
        System.out.println("Ingrese el numero de libreta del alumno a dar de baja:");
        int p_lu = teclado.nextInt();
        unCurso.quitarAlumno(p_lu);
        System.out.println("****-- Se da de baja al alumno con LU " + p_lu + " --****");
        System.out.println("Esta inscripto ?? -->" + unCurso.estaInscripto(p_lu));

        //5.1.6. Imprimir nuevamente la cantidad y lista de alumnos inscriptos
        System.out.println("****-- Alumnos inscriptos actualmente: " + unCurso.cantidadDeAlumnos());
        unCurso.mostrarInscriptos();

        //5.1.7. Buscar un alumno por su libreta. Y mustra sus datos.
        System.out.println("Ingrese el numero de libreta del alumno a buscar:");
        p_lu = teclado.nextInt();
        unCurso.buscarAlumno(p_lu).mostrar();

        //5.1.8. Buscar un alumno y muestra solamente su promedio.
        System.out.println("Ingrese el numero de libreta del alumno a buscar su promedio:");
        p_lu = teclado.nextInt();
        unCurso.imprimirPromedioDelAlumno(p_lu);


        //Creo otra clase Curso con el segundo constructor para probar los metodos restantes
        HashMap<Integer, Alumno> alumnosIniciales = new HashMap();

        do{
            System.out.println("\nIngrese los datos del alumno para el nuevo curso:");
            System.out.println("Ingrese LU:");
            int lu = teclado.nextInt();
            System.out.println("Ingrese Nombre:");
            String nombre = teclado.next();
            System.out.println("Ingrese Apellido:");
            String apellido = teclado.next();
            System.out.println("Ingrese Nota 1:");
            double nota1 = teclado.nextDouble();
            System.out.println("Ingrese Nota 2:");
            double nota2 = teclado.nextDouble();

            Alumno unAlumno = new Alumno(lu, nombre, apellido);
            unAlumno.setNota1(nota1);
            unAlumno.setNota2(nota2);

            alumnosIniciales.put(lu, unAlumno);

            System.out.println("Desea ingresar otro alumno? (s/n)");
            respuesta = teclado.next();
        }while(respuesta.equalsIgnoreCase("s"));

        System.out.println("\nIngrese el nombre del nuevo curso:");
        nombreCurso = teclado.next();
        Curso otroCurso = new Curso(nombreCurso, alumnosIniciales);

        //Metodos que faltaron probar...
        System.out.println(" Ingrese el numero de libreta del alumno a buscar:");
        p_lu = teclado.nextInt();
        Alumno auxAlumno = otroCurso.buscarAlumno(p_lu);
        System.out.println("Esta inscripto ?? -->" + otroCurso.estaInscripto(auxAlumno));

        System.out.println("Cantidad de inscriptos: " + otroCurso.cantidadDeAlumnos());
        otroCurso.mostrarInscriptos();

    }
}