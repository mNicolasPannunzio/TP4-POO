import java.util.*;
/**
 * Pedido contiene la fecha del pedido, el cliente que lo realiza y un arraylist de productos.
 * Permite agregar y quitar productos del arraylist, calcular el total al contado y financiado
 * y mostrar el detalle del pedido.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 08/09/25
 */
public class Pedido {
    //Variables de instancia
    private Calendar fecha;
    private Cliente cliente;
    private ArrayList<Producto> productos;

    /**
     * Constructor que recibe como parametros la fecha, el cliente y 
     * el arraylist de productos
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos){ 
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    /**
     * Constructor sobrecargado que recibe solo la fecha, el cliente y
     * un solo producto, inicializando el arraylist y agregando el producto
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.getProductos().add(p_producto);
    }

    //Setters ----------------------------------------
    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }
    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }
    private void setProductos(ArrayList<Producto> p_productos) {
        this.productos = p_productos;
    }

    //Getters ----------------------------------------
    public Calendar getFecha() {
        return this.fecha;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    //Metodos Add y Remove ------------------------------
    /**
     * Agrega un producto al arraylist de productos
     * @param p_producto Producto a agregar
     * @return true si se agrego, false si no
     */
    public boolean agregarProducto(Producto p_producto) {
       return this.getProductos().add(p_producto);  
    }

    /**
     * Elimina un producto del arraylist de productos
     * @param p_producto Producto a eliminar
     * @return true si se elimino, false si no
     */
    public boolean quitarProducto(Producto p_producto) {
        return this.getProductos().remove(p_producto);
    }

    // Otros metodos ----------------------------------------
    /**
     * Calcula el total del pedido al contado
     * Inicializa una variable total en 0, recorre el arraylist de productos 
     * mediante un For Each, sumando el precio al contado de cada producto al total
     * @return total del pedido al contado
     */
     public double totalAlContado(){
        double total = 0;
        for(Producto prod : this.getProductos()){
            total += prod.precioContado();
        }
        return total;
    }

    /**
     * Calcula el total del pedido financiado
     * Inicializa una variable total en 0, recorre el arraylist de productos 
     * mediante un For Each, sumando el precio de lista de cada producto al total
     * @return total del pedido financiado
     */
    public double totalFinanciado(){
        double total = 0;
        for(Producto prod : this.getProductos()){
            total += prod.precioLista();
        }
        return total;
    }

    /**
     * Muestra en pantalla la fecha del pedido, seguido de el listado
     * de productos con sus respectivos precios al contado y de lista
     * y por ultimo el total al contado y financiado
     */
    public void mostrarPedido(){
        System.out.printf("****** Detalle del pedido ****** Fecha: %te de %tB de %tY%n", this.getFecha(), this.getFecha(), this.getFecha());
        System.out.println("Producto \tPrecio Lista \tPrecio Contado");
        System.out.println("-----------------------------------------------");
        for(Producto prod : this.getProductos()){
            System.out.println(prod.mostrarLinea());
            //mostrarLinea() devuelve un string con la descripcion, el precio de lista y el precio al contado.
        }
        System.out.println("-----------------------------------------------");
        System.out.println("*** Total ------ \t" + this.totalFinanciado() +"\t"+ this.totalAlContado());
    }
}

    /* 
    // Metodo alternativo para formatear la fecha.
    
    private String getFechaFormateada() {
    String[] meses = {
        "enero", "febrero", "marzo", "abril", "mayo", "junio",
        "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    };//Un array de strings con los nombres de los meses - enero es el mes 0
   int dia = this.getFecha().get(Calendar.DAY_OF_MONTH);
    int mes = this.getFecha().get(Calendar.MONTH);
   int anio = this.getFecha().get(Calendar.YEAR);
    return dia + " de " + meses[mes] + " de " + anio;
  } 
    */

    
