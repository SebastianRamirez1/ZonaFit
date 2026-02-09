package zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {
    List<Cliente> listarClientes();
    boolean buscarClientePorId(Cliente cliente);
    boolean agregarCliene(Cliente cliente);
    boolean modificaCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
}
