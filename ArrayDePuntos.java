
import java.util.Scanner;
/**
 * Classe creada para instanciar un array de 6 objetos Punto, cargar sus coordenadas por teclado,
 * mostrar sus coordenadas y calcular la distancia entre puntos consecutivos.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 2/09/25
 */
public class ArrayDePuntos
{
    public static void main(String []args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        //item 1.1
        Punto []puntos = new Punto[6];
        //item 1.2
        for(int i=0; i<6; i++){
            System.out.println("Ingrese coord X del punto " + (i+1) + " : ");
            double p_x = teclado.nextDouble();
            System.out.println("Ingrese coord Y del punto " + (i+1) + " : ");
            double p_y = teclado.nextDouble();
            
            puntos[i]= new Punto(p_x,p_y); //instancia un Punto en la posicion i del vector de Puntos
        }
        //item 1.3
        for(int i=0; i<6;i++){
            System.out.println("Las coordenadas del punto "+(i+1)+" son: "+puntos[i].coordenadas());
        }
        //item 1.4
        for(int i=0; i<5;i++){
            System.out.printf("La distancia entre el punto %d y el punto %d es: %.2f \n", i+1, i+2,
                                puntos[i].distanciaA(puntos[i+1])); 
                                //Se usa printf para formatear la salida de los valores y mostrar solo 2 decimales de la distancia
        }
    }
}