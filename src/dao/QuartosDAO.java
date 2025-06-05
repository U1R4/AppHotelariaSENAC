package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoQuarto = conndb.prepareStatement(
                    "INSERT INTO quartos (nome, numero, qnt_cama_casal, qnt_cama_solteiro,preco,disponivel) VALUES " +
                            "(?, ?, ?, ?, ?, ?);");

            novoQuarto.setString(1, "ggg");
            novoQuarto.setString(2, "505");
            novoQuarto.setInt(3, 2);
            novoQuarto.setInt(4, 2);
            novoQuarto.setDouble(5, 200.65);
            novoQuarto.setBoolean(6, true);

            int linhaAfetada = novoQuarto.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Quarto inserido com sucesso!" + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Cliente: " + erro);
            return false;
        }
    }
}

