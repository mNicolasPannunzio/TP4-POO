
/**
 * Punto define un par de coordenadas (x,y) y permite mostrar esos valores y ademas
 * desplazar x e y.
 * 
 * @author Pannunzio M. Nicolas - Quintana R. J. Antonio
 * @version 15/08/25
 */
public class Punto
{
    //Variables de instancia
    private double x;
    private double y;
    
    /**
     * Constructor que no recibe parametros, situa el punto en el origen (0,0).
     */
    public Punto(){
        this.setX(0);
        this.setY(0);
    }
    
    /**
     * Constructor que situa el punto en (p_x,p_y).
     */
    public Punto(double p_x, double p_y){
        this.setX(p_x);
        this.setY(p_y);
    }
    
    //Setters ------------------------------
    private void setX(double p_x){
        this.x = p_x;
    }
    
    private void setY(double p_y){
        this.y = p_y;
    }
    
    //Getters ------------------------------
    public double getX(){
        return this.x;
    }
    
    public double getY(){
        return this.y;
    }
    
    /**
     * Calcula y devuelve la distancia entre el Punto y otro Punto que es recibido como parametro
     * para eso usa pitagoras: d = raizCuadrada( (x2-x1)^2 + (y2-y1)^2 )
     * @param Objeto de clase Punto
     * @return La distancia entre el punto "this" y el punto que se recibe como parametro.
     */
    public double distanciaA(Punto p_ptoDistante){
        double termino1 = Math.pow((p_ptoDistante.getX() - this.getX()), 2);//(x2-x1)^2
        double termino2 = Math.pow((p_ptoDistante.getY() - this.getY()), 2);//(y2-y1)^2
        return Math.sqrt(termino1 + termino2);//raizCuadrada( (x2-x1)^2 + (y2-y1)^2 )
    }
    
    /**
     * Suma p_dx a x y p_dy a y. Desplaza (x,y) a (x+p_dx,y+p_dy).
     * @param Recibe dos Double que son dx y dy, cuyos valores desplazaran a X e Y respectivamente
     */
    public void desplazar(double p_dx, double p_dy){
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }
    
    /**
     * Muestra en pantalla el punto (x, y)
     */
    public void mostrar(){
        System.out.println("Punto. X: "+ this.getX() +", Y: "+ this.getY());
    }
    
    /**
     * Retorna un String que contiene la coordenada (x, y)
     * @return (X, Y) con sus respectivos valores.
     */
    public String coordenadas(){
        return "("+ this.getX() +", "+ this.getY() +")"; 
    }
}