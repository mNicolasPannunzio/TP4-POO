import java.util.*;
import java.util.Scanner;
/**
 * Clase creada para instanciar objetos de tipo Banco, Localidad y Empleado, y probar sus metodos de
 * forma exhaustiva
 * 
 * @author Pannunzio M. Nicolas - Quintana Antonio
 * @version 10/09/25
 */
public class AplicacionBanco
{
    /**
     * Metodo main que inicia la aplicacion
     * limpia la pantalla y ejecuta el menu principal
     */
    public static void main(String[] args)
    {
        System.out.print("\f");
        menu();
    }
    /**
     * Menu principal que permite crear, eliminar y seleccionar un banco para operar
     * Utiliza un ArrayList para almacenar los bancos creados
     * Llama al subMenu para operar sobre el banco seleccionado
     * Finaliza cuando el usuario elige la opcion de salir
     */
    private static void menu(){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        int opcion;
        ArrayList<Banco> bancos = new ArrayList();
        do{
            System.out.println("Menu de Principal: ");
            System.out.println("1. Crear Banco"); 
            System.out.println("2. Eliminar Banco");
            System.out.println("3. Seleccionar Banco para operar");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opcion: ");           
            opcion = teclado.nextInt();
            System.out.print("\f");
            switch(opcion){
                case 1:
                    //Crear Banco
                    Banco banco = crearBanco(teclado);
                    bancos.add(banco);
                    System.out.println("Banco creado con exito.");
                    break;
                case 2:
                    //Eliminar Banco
                    if(bancos.isEmpty()){
                        System.out.println("No hay bancos para eliminar.");
                    }else{
                        System.out.println("Bancos disponibles: ");
                        for(int i=0; i<bancos.size(); i++){
                            System.out.println((i+1) + ". " + bancos.get(i).getNombre());
                        }
                        System.out.println("Ingrese el numero del banco a eliminar: ");
                        int numBanco = teclado.nextInt();
                        if(numBanco < 1 || numBanco > bancos.size()){   
                            System.out.println("Numero de banco invalido.");
                        }else{
                            bancos.remove(numBanco - 1);
                            System.out.println("Banco eliminado con exito.");
                        }
                    }
                    break;
                case 3:
                    //Seleccionar Banco para operar
                    if(bancos.isEmpty()){
                        System.out.println("No hay bancos para seleccionar.");
                    }else{
                        System.out.println("Bancos disponibles: ");
                        for(int i=0; i<bancos.size(); i++){
                            System.out.println((i+1) + ". " + bancos.get(i).getNombre());
                        }
                        System.out.println("Ingrese el numero del banco a seleccionar: ");
                        int numBanco = teclado.nextInt();
                        if(numBanco < 1 || numBanco > bancos.size()){   
                            System.out.println("Numero de banco invalido.");
                        }else{
                            Banco bancoSel = bancos.get(numBanco - 1);
                            System.out.print("\f");
                            System.out.println("Banco seleccionado: " + bancoSel.getNombre());
                            subMenu(bancoSel);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente."); 
                    break;
            }
        }while(opcion != 4);
    }
    /**
     * Crea una cuenta bancaria solicitando los datos por teclado
     * @param teclado Scanner para leer los datos por teclado
     * @return retorna una cuenta bancaria creada
     */
    private static Banco crearBanco(Scanner teclado){
        System.out.println("Ingrese nombre del banco: ");
        String nombre = teclado.next();
        System.out.println("Ingrese numero de sucursal: ");
        int nroSucursal = teclado.nextInt();
        System.out.println("Ingrese nombre de la localidad: ");
        String nombreLocalidad = teclado.next();
        System.out.println("Ingrese provincia de la localidad: ");
        String provincia = teclado.next();
        
        Localidad loc = new Localidad(nombreLocalidad, provincia);
        System.out.println("Ingrese un empleado: ");
        Empleado emp = crearEmpleado(teclado);
        System.out.println("Desea agregar mas empleados? (s/n): ");
        String respuesta = teclado.next();
        ArrayList<Empleado> empleados = new ArrayList();
        empleados.add(emp);
        while(respuesta.equalsIgnoreCase("s")){
            System.out.println("Ingrese un empleado: ");
            emp = crearEmpleado(teclado);
            empleados.add(emp);
            System.out.println("Desea agregar mas empleados? (s/n): ");
            respuesta = teclado.next();
        }
        if(empleados.size() == 1){
            Banco banco = new Banco(nombre, loc, nroSucursal, emp);
            //utliza el constructor con un solo empleado
            return banco;
        }else{
            System.out.println("Desea agregar cuentas bancarias al banco? (s/n): ");
            respuesta = teclado.next();
            if(respuesta.equalsIgnoreCase("s")){
                ArrayList<CuentaBancaria> cuentas = new ArrayList();
                do{
                    System.out.println("Ingrese una cuenta bancaria: ");
                    CuentaBancaria cuenta = crearCuentaBancaria(teclado);
                    cuentas.add(cuenta);
                    System.out.println("Desea agregar mas cuentas bancarias? (s/n): ");
                    respuesta = teclado.next();
                }while(respuesta.equalsIgnoreCase("s"));
                Banco banco = new Banco(nombre, loc, nroSucursal, empleados, cuentas);
                //utliza el constructor con array de empleados y array de cuentas bancarias
                return banco;
            }else{
                Banco banco = new Banco(nombre, loc, nroSucursal, empleados);
                //utliza el constructor con array de empleados sin cuentas bancarias
                return banco;
            }
        } 
    }
    /**
     * Crea un empleado solicitando los datos por teclado
     * @param teclado Scanner para leer los datos por teclado
     * @return retorna un empleado creado
     */
    private static Empleado crearEmpleado(Scanner teclado){
        System.out.println("Ingrese nombre del empleado: ");
        String nombre = teclado.next();
        System.out.println("Ingrese apellido del empleado: ");
        String apellido = teclado.next();
        System.out.println("Ingrese CUIL del empleado: ");
        long cuil = teclado.nextLong();
        System.out.println("Ingrese sueldo básico del empleado: ");
        double sueldo = teclado.nextDouble();
        System.out.println("Ingrese año de ingreso del empleado: ");
        int anio = teclado.nextInt();
        System.out.println("Ingrese mes de ingreso del empleado: ");
        int mes = teclado.nextInt();
        System.out.println("Ingrese día de ingreso del empleado: ");
        int dia = teclado.nextInt();
        Calendar fechaIngreso = new GregorianCalendar(anio, mes-1, dia);
        
        return new Empleado(cuil, apellido, nombre, sueldo, fechaIngreso);
    }   
    /**
     * Submenu para operar sobre un banco seleccionado
     * Permite agregar y quitar empleados, agregar y eliminar cuentas bancarias,
     * listar cuentas con saldo cero, mostrar empleados y sueldos, y mostrar resumen del banco
     * @param p_banco Banco sobre el cual se van a realizar las operaciones
     */
    private static void subMenu(Banco p_banco){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        int opcion;
        do{
            System.out.println("Menu de Operaciones: ");
            System.out.println("1. Agregar Empleado"); 
            System.out.println("2. Quitar Empleado");
            System.out.println("3. Agregar cuenta bancaria");
            System.out.println("4. Eliminar cuenta bancaria");
            System.out.println("5. Listar cuentas con saldo cero");
            System.out.println("6. Mostrar empleados y sueldos");
            System.out.println("7. Mostrar resumen");
            System.out.println("8. Volver al menu principal");
            System.out.println("Ingrese una opcion: ");           
            opcion = teclado.nextInt();
            System.out.print("\f");
            switch(opcion){
                case 1:
                    //Agregar Empleado al Banco
                    p_banco.agregarEmpleado(crearEmpleado(teclado));
                    System.out.println("Empleado agregado con exito.");
                    break;
                case 2:
                    //Quitar Empleado del Banco
                    for(int i=0; i<p_banco.getEmpleados().size(); i++){
                        Empleado unEmpleado = p_banco.getEmpleados().get(i);
                        System.out.println((i+1) + ". " + unEmpleado.getCuil() + " - " + unEmpleado.apeYnom());
                    }
                    System.out.println("Ingrese el numero del empleado a eliminar: ");
                    int numEmpleado = teclado.nextInt();
                    if(numEmpleado < 1 || numEmpleado > p_banco.getEmpleados().size()){   
                        System.out.println("Numero de empleado invalido.");
                    }else{
                        Empleado emp = p_banco.getEmpleados().get(numEmpleado - 1);
                        p_banco.quitarEmpleado(emp);
                        System.out.println("Empleado eliminado con exito.");
                    }
                    break;
                case 3:
                    //Agregar cuenta bancaria
                    p_banco.agregarCuentaBancaria(crearCuentaBancaria(teclado));
                    System.out.println("Cuenta bancaria agregada con exito.");  
                    break;
                case 4:
                    //Eliminar cuenta bancaria
                    for(int i=0; i<p_banco.getCuentasBancarias().size(); i++){
                        CuentaBancaria unaCuenta = p_banco.getCuentasBancarias().get(i);
                        System.out.println((i+1) + ". " + unaCuenta.getNroCuenta() + " - Titular: " + unaCuenta.getTitular().apeYNom());
                    }
                    System.out.println("Ingrese el numero de la cuenta a eliminar: ");
                    int numCuenta = teclado.nextInt();
                    if(numCuenta < 1 || numCuenta > p_banco.getCuentasBancarias().size()){   
                        System.out.println("Numero de cuenta invalido.");
                    }else{
                        CuentaBancaria cuenta = p_banco.getCuentasBancarias().get(numCuenta - 1);
                        p_banco.quitarCuentaBancaria(cuenta);
                        System.out.println("Cuenta bancaria eliminada con exito.");
                    }
                    break;
                case 5:
                    //Listar cuentas con saldo cero
                    p_banco.listarCuentasConSaldoCero();
                    break;
                case 6:
                    //Lista de Empleados
                    p_banco.mostrar();
                    break;
                case 7:
                    //Mostrar resumen
                    p_banco.mostrarResumen();
                    break;
                case 8:
                    System.out.println("Volviendo al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente."); 
                    break;
            }
        }while(opcion != 8);
    }
    /**
     * Crea una cuenta bancaria solicitando los datos por teclado
     * @param teclado Scanner para leer los datos por teclado
     * @return retorna una cuenta bancaria creada
     */
    private static CuentaBancaria crearCuentaBancaria(Scanner teclado){
        System.out.println("Ingrese numero de cuenta: ");
        int nroCuenta = teclado.nextInt();
        System.out.println("Ingrese saldo inicial: ");
        double saldo = teclado.nextDouble();
        System.out.println("Ingrese datos del titular: ");
        Persona titular = crearPersona(teclado);
        
        return new CuentaBancaria(nroCuenta, titular, saldo);
    }
    /**
     * Crea una persona solicitando los datos por teclado
     * @param teclado Scanner para leer los datos por teclado
     * @return retorna una persona creada
     */
    private static Persona crearPersona(Scanner teclado){
        System.out.println("Ingrese nombre del titular: ");
        String nombre = teclado.next();
        System.out.println("Ingrese apellido del titular: ");
        String apellido = teclado.next();
        System.out.println("Ingrese DNI del titular: ");
        int dni = teclado.nextInt();
        System.out.println("Ingrese año de nacimiento del titular: ");
        int anio = teclado.nextInt();
        System.out.println("Ingrese mes de nacimiento del titular: ");
        int mes = teclado.nextInt();
        System.out.println("Ingrese día de nacimiento del titular: ");
        int dia = teclado.nextInt();
        Calendar fechaNacimiento = new GregorianCalendar(anio, mes-1, dia);
        return new Persona(dni, nombre, apellido, fechaNacimiento);
    }
}