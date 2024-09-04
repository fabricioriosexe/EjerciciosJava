package githubFabri.zona_Fit.servicio;

import githubFabri.zona_Fit.modelo.Cliente;
import githubFabri.zona_Fit.repositorio.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired //*sirve para inyectar la dependencia
    private clienteRepositorio CR;

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> clientes = CR.findAll();
        return clientes;
    }

    @Override
    public Cliente buscarClienteID(Integer id) {
        Cliente c = CR.findById(id).orElse(null);//*si no regresa el cliente devuelve un valor nulo
        return c;
    }

    @Override
    public void guardarCliente(Cliente c) {
        CR.save(c);
    }

    @Override
    public void eliminarCliente(Cliente c) {
        CR.delete(c);
    }
}
