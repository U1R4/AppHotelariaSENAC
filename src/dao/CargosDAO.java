package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCargo = conndb.prepareStatement(
                    "INSERT INTO cargos (nome) VALUES " +
                            "(?);");

            novoCargo.setString(1, "ggg");

            int linhaAfetada = novoCargo.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Cargo inserido com sucesso!" + linhaAfetada);
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCargo(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCargo = conndb.prepareStatement("DELETE FROM cargos WHERE id = ?;");
            removeCargo.setInt(1, id);
            int linhaAfetada = removeCargo.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }
    }

    public boolean alterarCargo(String nome, int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarCargo = conndb.prepareStatement(
                    "UPDATE cargos SET nome = ? WHERE id = ?;"
            );
            alterarCargo.setString(1, nome);
            alterarCargo.setInt(2, id);
            int linhaAfetada = alterarCargo.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cargo: " + erro);
            return false;
        }
    }
}

