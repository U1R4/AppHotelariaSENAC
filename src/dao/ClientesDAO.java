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
}

