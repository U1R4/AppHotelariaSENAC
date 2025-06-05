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
}

