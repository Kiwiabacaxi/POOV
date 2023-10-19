package poov.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import poov.models.Vacina;

public class UpdateBanco {

    public static void main(String[] args) {
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
            System.out.println("Conectando com o banco de dados.");
            Class.forName(classeDriver);
            conexao = DriverManager.getConnection(url, login, senha);
            System.out.println("Conexão com o banco de dados estabelecida.");
            // UPDATE DO BANCO

            // a) Faça com que o programa solicite um código de uma vacina via teclado
            Scanner teclado = new Scanner(System.in);

            System.out.println("Digite o código da vacina, que deseja consultar: ");
            Long codigo = teclado.nextLong();

            // b) Busque essa vacina no banco, coloque-a em um objeto Vacina e mostre-a na
            // tela caso ela exista. Caso não exista informe ao usuário.
            Vacina vacina = new Vacina();
            String sql = "SELECT * FROM vacina WHERE codigo = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, codigo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Código: " + rs.getLong("codigo"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Situação: " + rs.getString("situacao"));
                System.out.println("====================================");

                // c) Pergunte se o usuário deseja alterar essa vacina
                System.out.println("Deseja alterar essa vacina? (S/N)");
                String resposta = teclado.next();

                // d) Se sim, enquanto o usuário desejar, pergunte ao usuário qual parte da
                // vacina ele deseja alterar
                if (resposta.equalsIgnoreCase("S")) {
                    boolean alterando = true;
                    while (alterando) {
                        System.out.println("Qual parte da vacina você deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Descrição");
                        System.out.println("3 - Situação");
                        int opcao = teclado.nextInt();
                        teclado.nextLine(); // Consumes the \n character

                        // e) Leia o novo valor da parte escolhida e altere o objeto Vacina com esse
                        // novo valor
                        switch (opcao) {
                            case 1:
                                System.out.println("Digite o novo nome:");
                                vacina.setNome(teclado.nextLine());
                                break;
                            case 2:
                                System.out.println("Digite a nova descrição:");
                                vacina.setDescricao(teclado.nextLine());
                                break;
                            case 3:
                                System.out.println("Digite a nova situação:");
                                // verifcar se a situação ja esta ATIVA
                                String situacao = teclado.next();
                                if (situacao.equalsIgnoreCase("ATIVO")) {
                                    System.out.println("A situação já está ATIVA.");
                                } else {
                                    // vacina.setSituacao(situacao);
                                    vacina.setSituacao(Situacao.INATIVO);
                                }

                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        System.out.println("Deseja continuar alterando? (S/N)");
                        resposta = teclado.next();
                        if (resposta.equalsIgnoreCase("N")) {
                            alterando = false;
                        }
                    }
                }

            } else {
                System.out.println("Vacina não encontrada.");
            }

            // f) Atualize o banco de dados usando os novos dados desse objeto Vacina (o
            // codigo não muda!)
            String sqlAtualizar = "UPDATE vacina SET nome = ?, descricao = ?, situacao = ? WHERE codigo = ?";

            PreparedStatement stmtAtualizar = conexao.prepareStatement(sqlAtualizar,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmtAtualizar.setString(1, vacina.getNome());
            stmtAtualizar.setString(2, vacina.getDescricao());
            stmtAtualizar.setString(3, vacina.getSituacao().toString());
            stmtAtualizar.setLong(4, codigo);

            // g) Mostre na tela os dados da vacina atualizada
            sql = "SELECT * FROM vacina WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Código: " + rs.getLong("codigo"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Descrição: " + rs.getString("descricao"));
                System.out.println("Situação: " + rs.getString("situacao"));
                System.out.println("====================================");
            } else {
                System.out.println("Vacina não encontrada.");
            }

            // h) Feche os objetos utilizados
            teclado.close();
            stmt.close();
            rs.close();

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
                }
                System.out.println("Conexão com o banco de dados terminada.");
            }
        }
    }

}
