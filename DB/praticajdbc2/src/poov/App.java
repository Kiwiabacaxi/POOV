package poov;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        String caminho = "jdbc:postgresql";
        String host = "localhost";
        String porta = "5432";
        String bd = "postgres";
        String login = "postgres";
        String senha = "12345";
        String url = caminho + "://" + host + ":" + porta + "/" + bd;
        String classeDriver = "org.postgresql.Driver";
        Connection conexao = null;

        try {
            DatabaseMetaData dbmd;
            System.out.print("  Carregando Driver JDBC -> " + classeDriver + "\n");
            System.out.print("  Conectando a           -> " + url + "\n");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.print("  Conectado como         -> " + login + "\n");
            dbmd = conexao.getMetaData();
            System.out.println("  Informação DatabaseMetaData");
            System.out.println("  ===========================");
            System.out.print("  - Nome do Produto             : ");
            System.out.println(dbmd.getDatabaseProductName());
            System.out.print("  - Número da versão do Produto : ");
            System.out.println(dbmd.getDatabaseProductVersion());
            System.out.print("  - Database Major Version      : ");
            System.out.println(dbmd.getDatabaseMajorVersion());
            System.out.print("  - Database Minor Version      : ");
            System.out.println(dbmd.getDatabaseMinorVersion());
            System.out.print("  - Nome do Driver              : ");
            System.out.println(dbmd.getDriverName());
            System.out.println("  - Driver Major Version        : " + dbmd.getDriverMajorVersion());
            System.out.println("  - Driver Minor Version        : " + dbmd.getDriverMinorVersion());
            System.out.print("  - Nome do usuário             : ");
            System.out.println(dbmd.getUserName());
            System.out.println("Suporta Select for Update?      : " + dbmd.supportsSelectForUpdate());
            System.out.println("Suporta Transacoes?             : " + dbmd.supportsTransactions());
            System.out.println("  - Catálogos                   : ");
            try (ResultSet catalogs = dbmd.getCatalogs()) {
                while (catalogs.next()) {
                    System.out.println("    - " + catalogs.getString(1));
                }
            }
            System.out.println();
            try (ResultSet resultSet = dbmd.getColumns(null, null, "vacina", null)) {
                while (resultSet.next()) {
                    String name = resultSet.getString("COLUMN_NAME");
                    String type = resultSet.getString("TYPE_NAME");
                    int size = resultSet.getInt("COLUMN_SIZE");
                    System.out.println("Nome da Coluna: [" + name + "]; tipo: [" + type
                            + "]; tamanho: [" + size + "]");
                }
            }

            System.out.println();
            try (Statement stmt = conexao.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM vacina")) {
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("  Informação ResultSetMetaData");
                System.out.println("  ===========================");
                int numColunas = rsmd.getColumnCount();
                System.out.println("Total de Colunas = " + numColunas);

                for (int i = 0; i < numColunas; i++) {
                    System.out.print("Nome da Coluna=" + rsmd.getColumnName(i + 1));
                    System.out.print(" Tipo=" + rsmd.getColumnType(i + 1));
                    System.out.print(" Nome do Tipo=" + rsmd.getColumnTypeName(i + 1));
                    System.out.print(" Tamanho=" + rsmd.getColumnDisplaySize(i + 1));
                    System.out.println(" Casas Decimais=" + rsmd.getScale(i + 1));
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver JDBC.");
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            SQLException e = ex;
            while (e != null) {
                System.out.println("SQL State: " + e.getSQLState());
                System.out.println("Error Code: " + e.getErrorCode());
                System.out.println("Mensagem: " + e.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Causa: " + t);
                    t = t.getCause();
                }
                e = e.getNextException();
            }
        } finally {
            if (conexao != null) {
                System.out.println("Terminando a conexão com o banco de dados.");
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro fechando a conexão com o banco de dados.");
                    SQLException e = ex;
                    while (e != null) {
                        System.out.println("SQL State: " + e.getSQLState());
                        System.out.println("Error Code: " + e.getErrorCode());
                        System.out.println("Mensagem: " + e.getMessage());
                        Throwable t = e.getCause();
                        while (t != null) {
                            System.out.println("Causa: " + t);
                            t = t.getCause();
                        }
                        e = e.getNextException();
                    }
                }
                System.out.println("Conexão com o banco de dados terminada.");
            }
        }
    }
}
