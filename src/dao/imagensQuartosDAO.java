
package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class imagensQuartosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirImagemQuarto(int quartoId, int imagemId) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novaImagemQuarto = conndb.prepareStatement(
                    "INSERT INTO imagens_quartos (quarto_id, imagem_id) VALUES (?, ?);");

            novaImagemQuarto.setInt(1, quartoId);
            novaImagemQuarto.setInt(2, imagemId);

            int linhaAfetada = novaImagemQuarto.executeUpdate();
            conndb.close();

            if (linhaAfetada > 0) {
                System.out.println("Imagem do quarto inserida com sucesso!");
                return true;
            }
            return false;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir imagem do quarto: " + erro);
            return false;
        }
    }

    public boolean deletarImagemQuarto(int quartoId, int imagemId) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeImagemQuarto = conndb.prepareStatement(
                    "DELETE FROM imagens_quartos WHERE quarto_id = ? AND imagem_id = ?;");
            removeImagemQuarto.setInt(1, quartoId);
            removeImagemQuarto.setInt(2, imagemId);
            int linhaAfetada = removeImagemQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar imagem do quarto: " + erro);
            return false;
        }
    }

    public boolean alterarImagemQuarto(int quartoIdAntigo, int imagemIdAntigo, int quartoIdNovo, int imagemIdNovo) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarImagemQuarto = conndb.prepareStatement(
                    "UPDATE imagens_quartos SET quarto_id = ?, imagem_id = ? " +
                            "WHERE quarto_id = ? AND imagem_id = ?;"
            );
            alterarImagemQuarto.setInt(1, quartoIdNovo);
            alterarImagemQuarto.setInt(2, imagemIdNovo);
            alterarImagemQuarto.setInt(3, quartoIdAntigo);
            alterarImagemQuarto.setInt(4, imagemIdAntigo);

            int linhaAfetada = alterarImagemQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar imagem do quarto: " + erro);
            return false;
        }
    }
}