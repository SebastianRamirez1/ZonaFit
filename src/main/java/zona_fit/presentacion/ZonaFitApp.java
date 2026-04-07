package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        zonaFitApp();
    }

    private static void zonaFitApp() {
        var salir = false;
        var consola = new Scanner(System.in);
        // Creamos un objeto de la clase clienteDao
        var clienteDao = new ClienteDAO();
        while(!salir){
            try{
                mostrarMenu(consola);
                var opcion = verificarOpcion(consola);
               salir = ejecutarOpciones(clienteDao, opcion);
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static boolean ejecutarOpciones(IClienteDAO clienteDao, int opcion) {

        switch(opcion){
            case 1 -> {
                //Eliminar clientes
                System.out.println("Ingrese el id a eliminar: ");
                var cliente = new Cliente(2);
                clienteDao.eliminarCliente(cliente);

            }
            case 6 -> {
                // Salir
                System.out.println("Saliendo del sistema...");
                return true;
            }
            default -> System.out.println("Opción no implementada aún.");
        }

        return false;
    }

    public static void mostrarMenu(Scanner consola){
        System.out.println("""
            ***zONA FIT***
            1. Listar Clientes
            2. Buscar Clientes
            3. Agregar Cliente
            4. Modificar Cliente
            5. Eliminar Cliente
            6. Salir
            """);
    }

    public static int verificarOpcion(Scanner consola){
        mostrarMenu(consola);
        while(!(consola.hasNextInt())){
            System.out.println("Ingresa un numero valido: ");
        }
        var opcion = consola.nextInt();
        return opcion;
    }

}
