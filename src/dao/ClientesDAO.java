package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement(
                    "INSERT INTO clientes (nome, email, telefone, cpf) VALUES " +
                            "(?, ?, ?, ?);");

            novoCliente.setString(1, "ggg");
            novoCliente.setString(2, "ighjhghjkg@uygugiu");
            novoCliente.setString(3, "123456789");
            novoCliente.setString(4, "1158465169");

            int linhaAfetada = novoCliente.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Cliente inserido com sucesso!" + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCliente(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCliente = conndb.prepareStatement("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, id);
            int linhaAfetada = removeCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cliente: " + erro);
            return false;
        }
    }

    public boolean alterarCliente(String nome, String email, String telefone, String cpf, int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarCliente = conndb.prepareStatement(
                    "UPDATE clientes SET nome = ?, email = ?, telefone = ?, cpf = ? WHERE id = ?;"
            );
            alterarCliente.setString(1, nome);
            alterarCliente.setString(2, email);
            alterarCliente.setString(3, telefone);
            alterarCliente.setString(4, cpf);
            alterarCliente.setInt(5, id);
            int linhaAfetada = alterarCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cliente: " + erro);
            return false;
        }
    }
}

