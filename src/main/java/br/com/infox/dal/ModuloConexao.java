package br.com.infox.dal;


import java.sql.*;

public class ModuloConexao {

    public static Connection conector() { //metodo
        java.sql.Connection conexao = null;  //esse metodo sem o void significa que requer um retorno
        // Chamar o driver 
        String driver = "com.mysql.cj.jdbc.Driver";
        // armazenar informações do banco de dados
        String url = "jdbc:mysql://localhost:3306/dbinfox"; 
        String user = "root";
        String password = "Senha_12345_";
        //Estabelecer a conexao com o banco
        try {
            Class.forName(driver); //executar arquivo do driver
            conexao = DriverManager.getConnection(url, user, password); //obter conexao usando esses parametros 
            return conexao; //retorno requerido
        } catch (Exception e) { 
            System.out.println(e); // linha para esclarecer o erro
            return null;

        }

    }

}
