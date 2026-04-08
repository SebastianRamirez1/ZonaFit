package zona_fit.presentacion;

import zona_fit.datos.ClienteDAO;
import zona_fit.datos.IClienteDAO;
import zona_fit.dominio.Cliente;

import java.util.List;
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
               salir = ejecutarOpciones(clienteDao, opcion, consola);
            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static boolean ejecutarOpciones(IClienteDAO clienteDao, int opcion, Scanner consola) {

        var salir = false;
        switch(opcion){
            case 1 -> {
                List<Cliente> clientes = clienteDao.listarClientes();
                clientes.forEach(System.out::println);
            }
            case 2 ->{
                System.out.println("Ingresa id: ");
                int id = consola.nextInt();
                var cliente = new Cliente(id);
                var encontrado = clienteDao.buscarClientePorId(cliente);
                if(encontrado){
                    System.out.println("Encontrado ");
                }else{
                    System.out.println("no se encuentra");
                }
            }
            case 3 ->{
                System.out.println("Ingresa el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Ingresa el apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Ingresa membresia: ");
                var membresia = consola.nextInt();
                var cliente = new Cliente(nombre,apellido,membresia);

                var agregado = clienteDao.agregarCliene(cliente);
                if(agregado){
                    System.out.println("Agregado correctamente: ");
                }else{
                    System.out.println("No se ha agregado correctamente: ");
                }
            }
            case 4 ->{
                System.out.println("Ingresa el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Ingresa el apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Ingresa membresia: ");
                var membresia = consola.nextInt();
                var cliente = new Cliente(nombre,apellido,membresia);

                var modificado = clienteDao.modificaCliente(cliente);
                if(modificado){
                    System.out.println("Modificado correctamente: ");
                }else{
                    System.out.println("No se ha modificado correctamente: ");
                }
            }
            case 5 ->{
                System.out.println("Ingresa id: ");
                int id = consola.nextInt();
                var cliente = new Cliente(id);
                var eliminado = clienteDao.eliminarCliente(cliente);
                if(eliminado){
                    System.out.println("Eliminado correctamente ");
                }else{
                    System.out.println("no se elimino");
                }
            }
            case 6 -> {
                // Salir
                System.out.println("Saliendo del sistema...");
                return true;
            }
            default -> System.out.println("Opción no implementada aún.");
        }

        return salir;
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
        while(!(consola.hasNextInt())){
            System.out.println("Ingresa un numero valido: ");
        }
        var opcion = consola.nextInt();
        return opcion;
    }

}
