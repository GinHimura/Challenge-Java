package br.com.candidate.config;


import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
public class ConnectionFactory {


    private static volatile ConnectionFactory instance;

    private String url;
    private String user;
    private String pass;
    private String driver;
    private volatile Connection conexao;

    private ConnectionFactory(String url, String user, String pass, String driver) {
        super();
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
    }

    public static ConnectionFactory getInstance() {

        ConnectionFactory result = instance;

        if (result != null) {
            return result;
        }

        String url = System.getenv("URL");
        String user = System.getenv("USER");
        String pass = System.getenv("PASSWORD");
        String driver = System.getenv("DRIVER_CLASS_NAME");


        synchronized (ConnectionFactory.class) {
            if (instance == null) {
                instance = new ConnectionFactory(url, user, pass, driver);
            }
            return instance;
        }

    }

    public Connection getConnection() {

        synchronized (Connection.class) {

            try {

                if (this.conexao != null && !this.conexao.isClosed()) {
                    return this.conexao;
                }

                if (this.getDriver() == null || this.getDriver().equals("")) {
                    System.out.println(
                            "\nInforme os dados de conex�o no arquivo application.properties [ datasource.driver-class-name ]");
                    throw new RuntimeException(
                            "Informe os dados de conexão no arquivo application.properties [ datasource.driver-class-name ]");
                }

                if (this.getUrl() == null || this.getUrl().equals("")) {
                    System.out.println(
                            "\nInforme os dados de conexão no arquivo application.properties [ datasource.url ]");
                    throw new RuntimeException(
                            "Informe os dados de conexão no arquivo application.properties [ datasource.url ]");
                }

                if (this.getUser() == null || this.getUser().equals("")) {
                    System.out.println(
                            "\nInforme os dados de conexão no arquivo application.properties [ datasource.username ]");
                    throw new RuntimeException(
                            "Informe os dados de conexão no arquivo application.properties [ datasource.username ]");
                }

                Class.forName(this.getDriver());

                this.conexao = DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPass());

            } catch (ClassNotFoundException e) {
                System.out.println("Não foi possível encotrar o driver de conexão: " + e.getMessage());
                System.exit(1);
            } catch (SQLException sqle) {
                System.out.println("Erro nos parâmetros da conexão com o banco de dados :" + sqle.getMessage());
                System.exit(1);
            }
            return this.conexao;
        }

    }

}
