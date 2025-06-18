package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedido() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoPedido = conndb.prepareStatement(
                    "INSERT INTO pedidos (usuario_id, cliente_id, pagamento) VALUES " +
                            "(?, ?, ?);");

            novoPedido.setInt(1, 4);
            novoPedido.setInt(2, 2);
            novoPedido.setString(3, "PIX");

            int linhaAfetada = novoPedido.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Pedido inserido com sucesso! " + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente: " + erro);
            return false;
        }
    }


    public boolean deletarPedido(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removePedido = conndb.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            removePedido.setInt(1, id);
            int linhaAfetada = removePedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar pedido: " + erro);
            return false;
        }
    }

    public boolean alterarPedido(int usuarioId, int clienteId, String pagamento, int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarPedido = conndb.prepareStatement(
                    "UPDATE pedidos SET usuario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;"
            );
            alterarPedido.setInt(1, usuarioId);
            alterarPedido.setInt(2, clienteId);
            alterarPedido.setString(3, pagamento);
            alterarPedido.setInt(4, id);
            int linhaAfetada = alterarPedido.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar pedido: " + erro);
            return false;
        }
    }
}
