package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao{

    private String driver;
    private String url;
    private String usuario;
    private String senha;

    public Conexao() {
        carregarConfiguracoes();

    }

    private void carregarConfiguracoes() {

        Properties prop = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("conf.properties")) {
            prop.load(inputPropsConfig);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            usuario = prop.getProperty("usuario");
            senha = prop.getProperty("senha");

        } catch (IOException error) {
            System.out.println("Error ao carregar configuracoes" + error.getMessage());
        }
    }

    public Connection conectar(){
        Connection condb = null;

        try{
            Class.forName(driver);
            condb = DriverManager.getConnection(url ,usuario , senha);
            return condb;
        }
        catch (SQLException | ClassNotFoundException error) {
            System.out.println("Erro ao conectar ao Banco de Dados" + error);
            return null;
        }
    }
}