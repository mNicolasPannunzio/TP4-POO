
/**
 * La clase Alumno recibe el nombre completo, lu y ambas notas de un alumno.
 * Permite mostrar los datos junto con el promedio de ambas notas y una leyenda que indica si 
 * el alumno aprueba o no la materia.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 14/08/25
 */
public class Alumno
{
    //Variables de instancia
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    
    /**
     * Metodo Contructor, recibe LU, nombre y apellido de parametros, a nota1 y nota2 las inicializa en 0
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido){
        this.setLu(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(0);
        this.setNota2(0);
    }
    
     //Setters
    private void setLu(int p_lu){
        this.lu = p_lu;
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    public void setNota1(double p_nota){
        this.nota1 = p_nota;
    }
    
    public void setNota2(double p_nota){
        this.nota2 = p_nota;
    }
    
     //Getters
    public int getLu(){
        return this.lu;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public double getNota1(){
        return this.nota1;
    }
    
    public double getNota2(){
        return this.nota2;
    }
    
    /**
     * Calcula si el alumno aprueba o no dependiendo de si promedio es > 7 y tanto Nota1 como Nota2 son >= 6.
     * @return Si promedio es > 7 y tanto Nota1 como Nota2 son >= 6 Retorna TRUE, caso contrario FALSE
     */
    private boolean aprueba(){
        if((this.promedio() > 7) && (this.getNota1() >= 6) && (this.getNota2() >= 6)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Usa como condicion el metodo aprueba() para devolver "APROBADO" o "DESAPROBADO" segun corresponda
     * @return Devuelve "APROBADO" o "DESAPROBADO" dependiendo del retorno del metodo aprueba()
     */
    private String leyendaAprueba(){
        if(this.aprueba()){
            return "APROBADO";
        } else{
            return "DESAPROBADO";
        }
    }
    
    /**
     * Devuelve el promedio entre nota1 y nota2
     * @return Devuelve el promedio entre Nota1 y Nota2
     */
    public double promedio(){
        return (this.getNota1() + this.getNota2()) / 2;
    }
    
    /**
     * Devuelve un String que contiene nombre y seguido de un espacio el apellido
     * @return Devuelve el nombre y seguido de un espacio el apellido
     */
    public String nomYApe(){
        return this.getNombre() +" "+ this.getApellido();
    }
    
    /**
     * Devuelve un String que contiene apellido y seguido de un espacio el nombre
     * @return Devuelve el apellido y seguido de un espacio el nombre
     */
    public String apeYNom(){
        return this.getApellido() +" "+ this.getNombre();
    }
    
    /**
     * Muestra en pantalla el nombre y apellido, el LU junto con ambas notas y el promedio junto con una leyenda que 
     * indica si el alumno aprueba o no.
     */
    public void mostrar(){
        System.out.println("Nombre y Apellido: "+ this.nomYApe());
        System.out.println("LU: "+ this.getLu() +"  Notas: "+ this.getNota1() +" - "+ this.getNota2());
        System.out.println("Promedio: "+ this.promedio() +" - "+ this.leyendaAprueba() );
    }
    
    
    
    
    
    
    
    
    
}