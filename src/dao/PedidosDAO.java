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
}
