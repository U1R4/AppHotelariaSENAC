package dao;

import model.Adicionais;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoAdicional = conndb.prepareStatement(
                    "INSERT INTO adicionais (nome, preco) VALUES " +
                            "(?, ?);");

            novoAdicional.setString(1, "ggg");
            novoAdicional.setDouble(2, 10.27);

            int linhaAfetada = novoAdicional.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Adicional inserido com sucesso!" + linhaAfetada + " Linha Afetada com sucesso!");
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir Adicional: " + erro);
            return false;
        }
    }
}


