package com.mycompany.crudinvestigacion;
import java.sql.*;
import java.util.*;



public class CRUDtipoproyecto {

    // Método para insertar un nuevo tipo de proyecto
    public static void insertarTipoProyecto(Connection connection, String nombreTipo) throws SQLException {
        String sql = "INSERT INTO TipoProyecto (NombreTipo) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombreTipo);
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los tipos de proyecto
    public static List<String> obtenerTiposProyecto(Connection connection) throws SQLException {
        List<String> tipos = new ArrayList<>();
        String sql = "SELECT NombreTipo FROM TipoProyecto";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                tipos.add(resultSet.getString("NombreTipo"));
            }
        }
        return tipos;
    }

    // Método para actualizar un tipo de proyecto
    public static void actualizarTipoProyecto(Connection connection, int tipoProyectoID, String nuevoNombre) throws SQLException {
        String sql = "UPDATE TipoProyecto SET NombreTipo = ? WHERE TipoProyectoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setInt(2, tipoProyectoID);
            statement.executeUpdate();
        }
    }

    // Método para eliminar un tipo de proyecto
    public static void eliminarTipoProyecto(Connection connection, int tipoProyectoID) throws SQLException {
        String sql = "DELETE FROM TipoProyecto WHERE TipoProyectoID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, tipoProyectoID);
            statement.executeUpdate();
        }
    }
}
//https://github.com/IsaacA274312/project-bd/upload/main