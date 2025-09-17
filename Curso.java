import java.util.*;
/**
 * Clase Curso contiene el nombre del curso y un HashMap con los alumnos inscriptos
 * permite Agregar e inscribir alumnos al curso ademas de mostrar los datos de los mismos
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 08/09/25
 */
public class Curso{
    private String nombre;
    private HashMap<Integer, Alumno> alumnos; //Clave: LU, Valor: Objeto Alumno

    /**
     * Constructor que recibe solo el nombre del curso
     */
    public Curso(String p_nombre){
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap<Integer, Alumno>());
    }

    /**
     * Constructor que recibe el nombre del curso y un HashMap de alumnos
     */
    public Curso(String p_nombre, HashMap<Integer, Alumno> p_alumnos){
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    //Setters ---------------------------------------------------------------
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setAlumnos(HashMap<Integer, Alumno> p_alumnos){
        this.alumnos = p_alumnos;
    }

    //Getters ----------------------------------------------------------------
    public String getNombre(){
        return this.nombre;
    }

    public HashMap<Integer, Alumno> getAlumnos(){
        return this.alumnos;
    }

    //Metodos put y remove del HashMap
    public void inscribirAlumno(Alumno p_alumno){
        this.getAlumnos().put(new Integer(p_alumno.getLu()), p_alumno);
    }

    public Alumno quitarAlumno(int p_lu){
        return (Alumno)this.getAlumnos().remove(new Integer(p_lu));
        //        ^-> Es necesario el casteo porque remove devuelve un Object
    }

    //Otros Metodos -----------------------------------------------------------
    /**
     * Devuelve la cantidad de alumnos que hay en el HashMap
     * utilizando el metodo predefinido .size()
     * @return Cantidad de alumnos (Tamanio del HashMap)
     */
    public int cantidadDeAlumnos(){
        return this.getAlumnos().size();
    }

    /**
     * Verifica si esta en el HashMap un determinado alumno, buscandolo
     * por su clave LU. utiliza el metodo .containsKey()
     * @param p_lu que es la clave para buscar el alumno.
     * @return True si esta inscripto (pertenece al HashMap), False caso contrario.
     */
    public boolean estaInscripto(int p_lu){
        return this.getAlumnos().containsKey(new Integer(p_lu));
    }

    /**
     * Verifica si esta en el HashMap un determinado alumno, buscandolo
     * por su valor p_alumno (tipo Alumno). utiliza el metodo .containsValue()
     * @param p_alumno que es el valor para buscar el alumno.
     * @return True si esta inscripto (pertenece al HashMap), False caso contrario.
     */
    public boolean estaInscripto(Alumno p_alumno){
        return this.getAlumnos().containsValue(p_alumno);
    }

    /**
     * Busca y devuelve un Alumno, teniendo en cuenta el p_lu recibido por parametro.
     * @param p_lu que se usara como clave para buscar el Alumno.
     * @return Objeto Alumno encontrado, null si no se encontro.
     */
    public Alumno buscarAlumno(int p_lu){
        if(this.getAlumnos().get(new Integer(p_lu)) == null){
            System.out.println("*** Ese alumno no esta inscripto al curso. ***");
        }
        return this.getAlumnos().get(new Integer(p_lu));
    }

    /**
     * Busca e imprime el apellido y nombre, junto con el promedio del Alumno,
     * teniendo en cuenta el p_lu recibido por parametro.
     * @param p_lu que se usara como clave para buscar el Alumno.
     */
    public void imprimirPromedioDelAlumno(int p_lu){
        Alumno auxAlumno = this.getAlumnos().get(new Integer(p_lu));

        if(auxAlumno == null){
            System.out.println("*** Ese alumno no esta inscripto al curso. ***");

        }else{
            System.out.println("****-- Mostrar Promedio del alumno "+ p_lu + " --****");
            System.out.println("Promedio: "+ auxAlumno.promedio());

        }
        
    }

    /**
     * Recorre y muestra LU y NomYApe de cada Alumno contenido en el HashMap.
     * Lo hace con un ForEach (Map.Entry : .entrySet())
     */
    public void mostrarInscriptos(){
        for (Map.Entry <Integer, Alumno> auxAlumno : this.getAlumnos().entrySet()){
            System.out.println(auxAlumno.getKey() + " " + auxAlumno.getValue().nomYApe());
        }

    }



    


}
