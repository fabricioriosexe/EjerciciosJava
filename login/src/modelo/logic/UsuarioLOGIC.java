package modelo.logic;

import modelo.beans.Usuario;
import modelo.dao.UsuarioDAO;

public class UsuarioLOGIC {
    private static UsuarioDAO usuariodao = new UsuarioDAO();
    
    public static boolean autentificar(String usuario,String contrasenia){
            if(obtener(usuario)!= null){
                Usuario usuarioConsulta= obtener(usuario);
                if(usuarioConsulta.getUsuario().equals(usuario)&&usuarioConsulta.getContraseña().equals(contrasenia)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
    }
    
    public static boolean modificar(Usuario usuario){
        return usuariodao.modificar(usuario);
    }
    public static boolean insertar(Usuario usuario){
        return usuariodao.insertar(usuario);
    }
    public static boolean eliminar(String usuario){
        return usuariodao.eliminar(usuario);
    }
    public static Usuario obtener(String usuario){
        return usuariodao.obtener(usuario);
    }
}
