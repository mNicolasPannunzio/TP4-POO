import java.util.*;
/**
 * Classe que contiene como atributos nombre, numero de sucursal, localidad y una lista de empleados
 * Permite agregar y quitar empleados, listar sueldos, calcular el total de sueldos a pagar y mostrar
 * los datos del banco.
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 10/09/25
 */
public class Banco
{
    // Variables de instancia
    private String nombre;
    private int nroSucursal;
    private Localidad localidad;
    private ArrayList<Empleado> empleados;
    private ArrayList<CuentaBancaria> cuentasBancarias;
    
    /**
     * Constructor que recibe un solo empleado sin cuentas bancarias, inicializa la lista de empleados y agrega el empleado recibido
     * Inicializa la lista de cuentas bancarias vacia.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList());
        this.agregarEmpleado(p_empleado);
        this.setCuentasBancarias(new ArrayList());
    }
    /**
     * Constructor que recibe una lista de empleados sin cuentas bancarias, inicializa la lista de cuentas bancarias vacia.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(new ArrayList());
    }
    /**
     * Constructor que recibe una lista de empleados y una lista de cuentas bancarias
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList<Empleado> p_empleados, ArrayList<CuentaBancaria> p_cuentas){
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuentas);
    }
    //Setters -------------------------------------
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    private void setNroSucursal(int p_nroSucursal){
        this.nroSucursal = p_nroSucursal;
    }
    private void setLocalidad(Localidad p_localidad){
        this.localidad = p_localidad;
    }
    private void setEmpleados(ArrayList p_empleados){
        this.empleados = p_empleados;
    }
    private void setCuentasBancarias(ArrayList<CuentaBancaria> p_cuentas){
        this.cuentasBancarias = p_cuentas;
    }
    //Getters -------------------------------------
    public String getNombre(){
        return this.nombre;
    }
    public int getNroSucursal(){
        return this.nroSucursal;
    }
    public Localidad getLocalidad(){
        return this.localidad;
    }
    public ArrayList<Empleado> getEmpleados(){
        return this.empleados;
    }
    public ArrayList<CuentaBancaria> getCuentasBancarias(){
        return this.cuentasBancarias;
    }
    
    //Otros metodos
    /**
     * Agrega un empleado a la lista de empleados
     * @param p_empleado empleado a agregar
     * @return true si se agrego, false si no
     */
    public boolean agregarEmpleado(Empleado p_empleado){
        return this.getEmpleados().add(p_empleado);
    }
    /**
     * Quita un empleado de la lista de empleados
     * @param p_empleado empleado a quitar
     * @return true si se quito, false si no
     */
    public boolean quitarEmpleado(Empleado p_empleado){
        return this.getEmpleados().remove(p_empleado);
    }
    /**
     * Lista los sueldos de todos los empleados
     */
    public void listarSueldos(){
        for(Empleado unEmpleado: this.getEmpleados()){
            System.out.print(unEmpleado.getCuil()+" "+unEmpleado.apeYnom());
            System.out.printf("------------------------  %.2f\n", unEmpleado.sueldoNeto());
        }
    }
    /**
     * Calcula el total de sueldos a pagar
     * @return el total de sueldos a pagar
     */
    public double sueldosAPagar(){
        double total = 0;
        for(Empleado unEmpleado: this.getEmpleados()){
            total += unEmpleado.sueldoNeto();
        }
        return total;
    }
    /**
     * Muestra los datos del banco, la localidad, provincia, lista de sueldos de sus empleados y total a pagar
     */
    public void mostrar(){
        System.out.println("Banco: "+this.getNombre()+"\t Sucursal: "+this.getNroSucursal());
        System.out.println("Localidad: "+this.getLocalidad().getNombre()+"\t Provincia: "+this.getLocalidad().getProvincia());
        this.listarSueldos();
        System.out.println("\nTotal a Pagar ---------------------------- $ "+ this.sueldosAPagar());
    }
    //Nuevos metodos ejercicio 4
    /**
     * Agrega una cuenta bancaria a la lista de cuentas bancarias
     * @param p_cuenta cuenta bancaria a agregar
     * @return true si se agrego, false si no
     */
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta){
        return this.getCuentasBancarias().add(p_cuenta);
    }
    /**
     * Quita una cuenta bancaria de la lista de cuentas bancarias
     * @param p_cuenta cuenta bancaria a quitar
     * @return true si se quito, false si no
     */
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta){
        return this.getCuentasBancarias().remove(p_cuenta);
    }
    /**
     * Lista las cuentas bancarias con saldo cero, mostrando el numero de cuenta y el titular
     */
    public void listarCuentasConSaldoCero(){
        System.out.println("Cuenta sin saldo:");
        System.out.println("---Cuenta--------------------Apellido y Nombre------------");
        for(CuentaBancaria unaCuenta: this.getCuentasBancarias()){
            if(unaCuenta.getSaldo() == 0){
                System.out.println(unaCuenta.getNroCuenta()+"                  "+unaCuenta.getTitular().apeYNom());
            }
        }
    }
    /**
     * Genera una lista de titulares sin repetir, es decir si hay mas de una cuenta con el mismo titular, solo lo agrega una vez
     * @return un HashSet<Pesona> con los titulares
     */
    public HashSet<Persona> listaDeTitulares(){
        HashSet<Persona> titulares = new HashSet();
        for(CuentaBancaria unaCuenta: this.getCuentasBancarias()){
            Persona auxPersona = unaCuenta.getTitular();
            
            if(!titulares.contains(auxPersona)){
                titulares.add(auxPersona);
            }
            
        }
        return titulares;
    }
    /**
     * Cuenta la cantidad de cuentas con saldo mayor a cero
     * @return la cantidad de cuentas con saldo mayor a cero
     */
    private int cuentasSaldoActivo(){
        int cantidadCuentas = 0;
        for(CuentaBancaria unaCuenta: this.getCuentasBancarias()){
            if(unaCuenta.getSaldo() > 0){
                cantidadCuentas += 1;
            }
        }
        return cantidadCuentas;
    }
    /**
     * Muestra un resumen del banco, sucursal, localidad, provincia, cantidad de cuentas bancarias, cantidad de cuentas activas 
     * y con saldo cero
     * Lista las cuentas con saldo cero y un listado de titulares sin repetir
     */
    public void mostrarResumen(){
        System.out.println("Banco: "+this.getNombre()+"\t Sucursal: "+this.getNroSucursal());
        System.out.println("Localidad: "+this.getLocalidad().getNombre()+"\t Provincia: "+this.getLocalidad().getProvincia());
        System.out.println("***********************************************************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("***********************************************************************************");
        System.out.println("Número total de cuentas bancarias: " + this.getCuentasBancarias().size());
        System.out.println("Cuentas Activas: "+ this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: "+ (this.getCuentasBancarias().size() - this.cuentasSaldoActivo()));
        System.out.println("-----------------------------------------------------------------------------------");
        this.listarCuentasConSaldoCero();
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.print("Listado de clientes: ");
        
        for(Persona unTitular: this.listaDeTitulares()){
            System.out.print(unTitular.apeYNom()+"; ");
        }
        System.out.println("\n-----------------------------------------------------------------------------------");

    }
    
    
    
}