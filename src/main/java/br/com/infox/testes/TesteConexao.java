package br.com.infox.testes;

import br.com.infox.dal.ModuloConexao;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {
        System.out.println("Testando conexão...");

        Connection conn = ModuloConexao.conector();

        if (conn != null) {
            System.out.println("✅ Conexão estabelecida com sucesso!");
            try {
                conn.close();
                System.out.println("Conexão fechada.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Falha na conexão!");
        }
    }
}
