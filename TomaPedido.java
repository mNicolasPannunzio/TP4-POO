import java.util.*;
import java.util.Scanner;
/**
 * Clase ejecutable para probar las clases Cliente, Laboratorio, Producto y Pedido.
 * Crea instancias de cada clase, agrega productos a un pedido y muestra el detalle del pedido.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 08/09/25
 */

public class TomaPedido {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        
        System.out.println("****-- Ingrese los datos del Cliente --**** ");
        System.out.println("-Ingrese el numero de DNI: ");
        int dniCliente = teclado.nextInt();
        teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.
        System.out.println("-Ingrese el/los Apellido/s del cliente: ");
        String apeCliente = teclado.nextLine();
        System.out.println("-Ingrese el/los Nombre/s del cliente: ");
        String nomCliente = teclado.nextLine();
        System.out.println("-Ingrese el saldo del cliente: ");
        double saldoCliente = teclado.nextDouble();
        // Crear un cliente
        Cliente unCliente = new Cliente(dniCliente, apeCliente, nomCliente, saldoCliente);
        
        System.out.println("\n***-- Ingrese los datos del Laboratorio --****");
        System.out.println("-Ingrese el nombre del Laboratorio: ");
        teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.        
        String nomLab = teclado.nextLine();
        System.out.println("-Ingrese la direccion del laboratorio: ");
        String direcLab = teclado.nextLine();
        System.out.println("-Ingrese el numero de telefono del laboratorio: ");
        String telLab = teclado.nextLine();
        // Crear un laboratorio
        Laboratorio laboratorio = new Laboratorio(nomLab, direcLab, telLab);
        
        
        
        System.out.println("\n****-- Ingrese los datos de un Producto --****");
        System.out.println("-Ingrese el codigo del producto: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.
        System.out.println("-Ingrese el rubro del producto: ");
        String rubro = teclado.nextLine();
        System.out.println("-Ingrese la descripcion del producto: ");
        String descripcion = teclado.nextLine();
        System.out.println("-Ingrese el costo del producto: $");
        double costo = teclado.nextDouble();
        //Crea un producto    
        Producto producto = new Producto(codigo, rubro, descripcion, costo, laboratorio);
        
        //Crea un pedido
        Calendar fechaPedido = Calendar.getInstance();
        Pedido miPedido = new Pedido(fechaPedido, unCliente, producto);    
        
        System.out.println("\n-Desea agregar mas productos al pedido? (s/n)");
        String respuesta = teclado.next();
        while(respuesta.equalsIgnoreCase("s")){
            System.out.println("\n****-- Ingrese los datos de un Producto --****");
            System.out.println("-Ingrese el codigo del producto: ");
            codigo = teclado.nextInt();
            System.out.println("-Ingrese el rubro del producto: ");
            teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.
            rubro = teclado.nextLine();
            System.out.println("-Ingrese la descripcion del producto: ");
            descripcion = teclado.nextLine();
            System.out.println("-Ingrese el costo del producto: $");
            costo = teclado.nextDouble();
            //Crea un producto    
            Producto unProducto = new Producto(codigo, rubro, descripcion, costo, laboratorio);
            //Agrego el producto a miPedido
            System.out.println("Se agreo correctamente el producto al pedido? --> "+ miPedido.agregarProducto(unProducto));
            
            System.out.println("\n-Desea agregar mas productos al pedido? (s/n)");
            respuesta = teclado.next();
        }
        
        // Mostrar el detalle del pedido
        miPedido.mostrarPedido();
        
        //Para intanciar otro pedido usando el segundo constructor
        System.out.println("\n****-- Ingrese los datos de un Producto para el segundo pedido --****");
        System.out.println("-Ingrese el codigo del producto: ");
        codigo = teclado.nextInt();
        System.out.println("-Ingrese el rubro del producto: ");
        teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.
        rubro = teclado.nextLine();
        System.out.println("-Ingrese la descripcion del producto: ");
        descripcion = teclado.nextLine();
        System.out.println("-Ingrese el costo del producto: $");
        costo = teclado.nextDouble();
        //Crea un producto    
        Producto otroProducto = new Producto(codigo, rubro, descripcion, costo, laboratorio);
        
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(otroProducto);
        
        System.out.println("\n****-- Ingrese los datos de otro Producto --****");
        System.out.println("-Ingrese el codigo del producto: ");
        codigo = teclado.nextInt();
        System.out.println("-Ingrese el rubro del producto: ");
        teclado.nextLine();//Para que no saltee al momento de ingresar por teclado.
        rubro = teclado.nextLine();
        System.out.println("-Ingrese la descripcion del producto: ");
        descripcion = teclado.nextLine();
        System.out.println("-Ingrese el costo del producto: $");
        costo = teclado.nextDouble();
        
        //Crea el ultimo producto    
        Producto ultimoProducto = new Producto(codigo, rubro, descripcion, costo, laboratorio);
        
        //lo agrega al array
        listaProductos.add(ultimoProducto);
        
        //Instancia el segundo pedido
        Pedido otroPedido = new Pedido(fechaPedido, unCliente, listaProductos);
        otroPedido.mostrarPedido();
        //quito un elemento para la prueba exhaustiva y muestro el resultado
        System.out.println("Se pudo eliminar producto del pedido? --> "+ otroPedido.quitarProducto(ultimoProducto));
        otroPedido.mostrarPedido();

        
    }
}