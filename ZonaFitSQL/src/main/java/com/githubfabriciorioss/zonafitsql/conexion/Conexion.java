package com.githubfabriciorioss.zonafitsql.conexion;

import java.sql.*;

public class Conexion {

    public static Connection getConexion() {
        Connection conexion = null;
        var DB = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + DB;
        var usuario = "root";
        var password = "Fabri1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("Error al conectar al bd: " + e.getMessage());
        }
        return conexion;
    }

}
