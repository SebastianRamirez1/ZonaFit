package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));

                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        }catch(Exception e){
            System.out.println("Error al listar clientes: " + e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar: " + e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public boolean buscarClientePorId(Cliente cliente) {
        var encontrado = false;
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId());
            rs = ps.executeQuery();
            if(rs.next()){
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                encontrado = true;
            }
        }catch(Exception e){
            System.out.println("Error al buscar id: " + e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }

        }
        return encontrado;
    }

    @Override
    public boolean agregarCliene(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "INSERT INTO cliente(nombre, apellido, membresia) VALUES (?, ?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificaCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "UPDATE cliente SET nombre=?, apellido=?, membresia=? WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }
        finally{
            try {

            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        return false;
    }

    public static void main(String[] args) {
        //Listar clientes
        IClienteDAO clienteDao = new ClienteDAO();
        var modificarCliente = new Cliente(7,"Oscar", "Ramirez", 300);
        var modificado = clienteDao.modificaCliente(modificarCliente);
        if(modificado){
            System.out.println("Cliente modificado: " + modificado);
        }else{
            System.out.println("no se agrego");
        }
        var clientes = clienteDao.listarClientes();
        clientes.forEach(System.out::println);

    }
}
