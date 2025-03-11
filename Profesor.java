public class Profesor {

    // Método para insertar un nuevo profesor
    public static void insertarProfesor(Connection connection, String nombrePro) throws SQLException {
        String sql = "INSERT INTO Profesor (NombrePro) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombrePro);
            statement.executeUpdate();
        }
    }

    // Método para obtener todos los profesores
    public static List<String> obtenerProfesores(Connection connection) throws SQLException {
        List<String> profesores = new ArrayList<>();
        String sql = "SELECT NombrePro FROM Profesor";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                profesores.add(resultSet.getString("NombrePro"));
            }
        }
        return profesores;
    }

    // Método para actualizar un profesor
    public static void actualizarProfesor(Connection connection, int claveProfesor, String nuevoNombre) throws SQLException {
        String sql = "UPDATE Profesor SET NombrePro = ? WHERE ClaveProfesor = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoNombre);
            statement.setInt(2, claveProfesor);
            statement.executeUpdate();
        }
    }

    // Método para eliminar un profesor
    public static void eliminarProfesor(Connection connection, int claveProfesor) throws SQLException {
        String sql = "DELETE FROM Profesor WHERE ClaveProfesor = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, claveProfesor);
            statement.executeUpdate();
        }
    }
}