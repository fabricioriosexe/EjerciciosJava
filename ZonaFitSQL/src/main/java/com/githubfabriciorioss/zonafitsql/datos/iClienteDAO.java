package com.githubfabriciorioss.zonafitsql.datos;

import com.githubfabriciorioss.zonafitsql.Dominio.Cliente;
import java.util.List;

public interface iClienteDAO {

    List<Cliente> listarCliente();

    boolean buscarClienteId(Cliente c);

    boolean agregarCliente(Cliente c);

    boolean modificarCliente(Cliente c);

    boolean eliminarCliente(Cliente c);

}
