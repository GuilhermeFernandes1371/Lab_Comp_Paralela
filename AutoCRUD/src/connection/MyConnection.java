package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static String status = "Falha na conexÃ£o...";


    public static java.sql.Connection getConexaoMysql(){
        Connection connection = null;
        try{
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            //Configurando a conexão
            String serverName = "localhost";
            String banco = "Clientes";
            String url = "jdbc:mysql://" + serverName + "/" + banco;
            String usuario = "root";
            String senha = "root";

            connection = DriverManager.getConnection(url,usuario,senha);
            //Testando
            if(connection != null){
                status = "Conectado com sucesso!";
            } else {
                status = "Falha na conexão ao banco MySql...";
            }
            return connection;
        } catch (ClassNotFoundException e) { //Driver nÃ£o encontrado
            System.out.println(" Driver não encontrado!");
            return null;

        } catch (SQLException s) {
            System.out.println("Outro Erro");
            return null;
        }
    }

    public static String statusConexao(){
        return status;
    }

}
