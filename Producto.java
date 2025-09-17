
/**
 * Producto contiene como atributos los elementos basicos de un producto (Descripcion, costo, stock, entre otros)
 * Permite mostrar sus datos en pantalla, y ajustar sus valores.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 18/08/25
 */
public class Producto
{
    //Variables de instancia
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;
    
    /**
     * Constructor que recibe todos los atributos como parametros, menos el stock que se inicializa en 0
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, 
                    double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab){
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
    }
    
    /**
     * Constructor sobrecargado que recibe solo codigo, rubro, descripcion, costo y laboratorio
     * como parametros, los demas atributos los inicializa en 0
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab){
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(0);
        this.setExistMinima(0);
        this.setLaboratorio(p_lab);
    }
    
    //Setters ------------------------------
    private void setCodigo(int p_codigo){
        this.codigo = p_codigo;
    }
    
    private void setRubro(String p_rubro){
        this.rubro = p_rubro;
    }
    
    private void setDescripcion(String p_desc){
        this.descripcion = p_desc;
    }
    
    private void setCosto(double p_costo){
        this.costo = p_costo;
    }
    
    private void setStock(int p_stock){
        this.stock = p_stock;
    }
    
    private void setPorcPtoRepo(double p_porcPtoRepo){
        this.porcPtoRepo = p_porcPtoRepo;
    }
    
    private void setExistMinima(int p_existMinima){
        this.existMinima = p_existMinima;
    }
    
    private void setLaboratorio(Laboratorio p_lab){
        this.laboratorio = p_lab;
    }
    
    //Getters ------------------------------
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getRubro(){
        return this.rubro;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public double getCosto(){
        return this.costo;
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public double getPorcPtoRepo(){
        return this.porcPtoRepo;
    }
    
    public int getExistMinima(){
        return this.existMinima;
    }
    
    public Laboratorio getLaboratorio(){
        return this.laboratorio;
    }
    
    /**
     * Muestra en pantalla todos los datos relevantes del producto (Costo, stock, laboratorio, entre otros)
     */
    public void mostrar(){
        //Manda el mensaje mostrar() a laboratorio, que devuelve un string con Nombre, domicilio y tel.
        System.out.println("\n"+ this.getLaboratorio().mostrar() +"\n\nRubro: "+ this.getRubro()   //Sigue en la sig linea
                           +"\nDescripcion: "+ this.getDescripcion() +"\nPrecio Costo: "+    //Sigue en la sig linea
                           this.getCosto() +"\nStock: "+ this.getStock()                     //Sigue en la sig linea
                           +" - Stock Valorizado: $"+ (this.getStock() * this.getCosto()) ); 
    }
    
    /**
     * Modifica el Stock (Agrega o quita) segun el valor del parametro.
     * @param Un entero cuyo valora se sumara o restara al stock
     */
    public void ajuste(int p_cantidad){
        this.setStock(this.getStock() + p_cantidad);
    }
    
    /**
     * Calcula el costo total de todo el stock y devuelve ese valor + una rentabilidad del 12%
     * @return El costo total de todo el stock + 12%
     */
    public double stockValorizado(){
        double costoStock = this.getStock() * this.getCosto();
        return costoStock + (costoStock * 12 / 100); 
    }
    
    /**
     * Calcula y devuelve el costo unitario mas un 12% de rentabilidad
     * @return Precio de costo + 12%
     */
    public double precioLista(){
        return this.getCosto() + (this.getCosto() * 12 / 100);
    }
    
    /**
     * Calcula y devuelve el precio contado, que es el precio de lista - 5%
     * @return precio de lista - 5%
     */
    public  double precioContado(){
        return this.precioLista() - (this.precioLista() * 5 / 100);
    }
    
    /**
     * Concatena y devuelve en un string la descripcion, el precio de lista y el precio contado
     * @return String con Descripcio + Precio de lista + precio al contado
     */
    public String mostrarLinea(){
        return this.getDescripcion() +"\t\t"+ this.precioLista() +"\t\t"+ this.precioContado();
    }
    
    /**
     * Permite modificar el valor del porcentaje de punto de reposicion (porcPtoRepo)
     * asignandole el valor del parametro p_porce.
     */
    public void ajustarPtoRepo(double p_porce){
        this.setPorcPtoRepo(p_porce);
    }
    
    /**
     * Permite modificar el valor de la existencia minima (existMinima)
     * asignandole el valor del parametro p_cantidad.
     */
    public void ajustarExistMin(int p_cantidad){
        this.setExistMinima(p_cantidad);
    }
    
    /**
     * Es un metodo que no esta en el UML de la clase pero lo agregue para poder luego mostrar en pantalla
     * los valores de los atributos porcPtoRepo y existMinima.
     * @return El estado de los atributos porcPtoRepo y existMinima.
     */
    public String mostrarPtoRepoYExistMin(){
        return "\nPorcentaje de punto de reposicion: "+ this.getPorcPtoRepo() //Sigue en la sig linea
                +"% - Existencia Minima: "+ this.getExistMinima();
    }
}