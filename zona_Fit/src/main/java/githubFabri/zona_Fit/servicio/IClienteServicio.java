package githubFabri.zona_Fit.servicio;

import githubFabri.zona_Fit.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    public List<Cliente> listarCliente();

    public Cliente buscarClienteID(Integer id);

    public void guardarCliente(Cliente c);

    public void eliminarCliente(Cliente c);

}
