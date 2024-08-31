package com.githubfabriciorioss.zonafitsql.datos;

import com.githubfabriciorioss.zonafitsql.Dominio.Cliente;
import com.githubfabriciorioss.zonafitsql.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements iClienteDAO {
//?-----------LISTAR LOS CLIENTES QUE ESTAN ALMACENADOS EN DB

    @Override
    public List<Cliente> listarCliente() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getString("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("ERROR AL LISTAR" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("error al cerrar conexion");
            }
        }
        return clientes;
    }

//?-----------BUSCAR LOS CLIENTES QUE ESTAN ALMACENADOS EN DB
    @Override
    public boolean buscarClienteId(Cliente c) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConexion();
        var sql = "SELECT * FROM cliente WHERE id=?";
        try {
            //! Pasamos el codigo sql y el parametro ?
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setMembresia(rs.getString("membresia"));
                return true;
            }
        } catch (Exception e) {
            System.out.println("****ERROR AL BUSCAR CLIENTE POR ID" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("ERROR AL CERRAR CONEXION");
            }
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente c) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO cliente(nombre,apellido,membresia)" + " VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getMembresia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR AL AGREGAR CLIENTE" + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("ERROR AL CERRAR CONEXION");
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente c) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        String sql = "UPDATE cliente SET nombre=?, apellido=?,membresia=?" + " WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getApellido());
            ps.setString(3, c.getMembresia());
            ps.setInt(4, c.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("ERROR AL CERRAR CONEXION");
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente c) {
        PreparedStatement ps;
        Connection con = Conexion.getConexion();
        var sql = "DELETE FROM cliente WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("ERROR AL CERRAR CONEXION");
            }
        }
        return false;
    }

}
