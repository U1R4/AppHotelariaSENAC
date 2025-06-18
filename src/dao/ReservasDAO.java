package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirReserva(int quartoId, int clienteId, Date dataEntrada, Date dataSaida, double valorTotal) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novaReserva = conndb.prepareStatement(
                    "INSERT INTO reservas (quarto_id, cliente_id, data_entrada, data_saida, valor_total) " +
                            "VALUES (?, ?, ?, ?, ?);");

            novaReserva.setInt(1, quartoId);
            novaReserva.setInt(2, clienteId);
            novaReserva.setDate(3, dataEntrada);
            novaReserva.setDate(4, dataSaida);
            novaReserva.setDouble(5, valorTotal);

            int linhaAfetada = novaReserva.executeUpdate();
            conndb.close();

            if (linhaAfetada > 0) {
                System.out.println("Reserva inserida com sucesso!");
                return true;
            }
            return false;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir reserva: " + erro);
            return false;
        }
    }

    public boolean deletarReserva(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeReserva = conndb.prepareStatement("DELETE FROM reservas WHERE id = ?;");
            removeReserva.setInt(1, id);
            int linhaAfetada = removeReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar reserva: " + erro);
            return false;
        }
    }

    public boolean alterarReserva(int id, int quartoId, int clienteId, Date dataEntrada, Date dataSaida, double valorTotal) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarReserva = conndb.prepareStatement(
                    "UPDATE reservas SET quarto_id = ?, cliente_id = ?, data_entrada = ?, " +
                            "data_saida = ?, valor_total = ? WHERE id = ?;"
            );
            alterarReserva.setInt(1, quartoId);
            alterarReserva.setInt(2, clienteId);
            alterarReserva.setDate(3, dataEntrada);
            alterarReserva.setDate(4, dataSaida);
            alterarReserva.setDouble(5, valorTotal);
            alterarReserva.setInt(6, id);

            int linhaAfetada = alterarReserva.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar reserva: " + erro);
            return false;
        }
    }
}