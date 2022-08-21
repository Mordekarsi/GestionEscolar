/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elrevo
 */
public class DataBaseConnection {
    private Connection connection;
        
    public Connection getConnection() throws SQLException {
        connect();
        return connection;
    }
    
    private void connect() throws SQLException {
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\"
                + "cashd\\OneDrive - Universidad Veracruzana\\Documentos\\"
                + "NetBeansProjects\\pruebaSarai\\src\\uv\\fei\\sistemadetutorias"
                + "\\dataaccess\\basededatos.properties")) {
            Properties propiedades = new Properties();
            propiedades.load(fileInputStream);
            String url = propiedades.getProperty("url");
            String usuario = propiedades.getProperty("user");
            String contrasena = propiedades.getProperty("password");
            connection = DriverManager.getConnection(url,usuario,contrasena);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void cerrarConexion() {
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}