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

    public boolean deletarAdicional(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeAdicional = conndb.prepareStatement("DELETE FROM adicionais WHERE id = ?;");
            removeAdicional.setInt(1, id);
            int linhaAfetada = removeAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
            return false;
        }
    }

    public boolean alterarAdicional(String nome, double preco, int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarAdicional = conndb.prepareStatement(
                    "UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;"
            );
            alterarAdicional.setString(1, nome);
            alterarAdicional.setDouble(2, preco);
            alterarAdicional.setInt(3, id);
            int linhaAfetada = alterarAdicional.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar adicional: " + erro);
            return false;
        }
    }
}


