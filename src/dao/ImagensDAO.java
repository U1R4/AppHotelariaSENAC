package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImagensDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirImagem(String url, String descricao) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novaImagem = conndb.prepareStatement(
                    "INSERT INTO imagens (url, descricao) VALUES (?, ?);");

            novaImagem.setString(1, url);
            novaImagem.setString(2, descricao);

            int linhaAfetada = novaImagem.executeUpdate();
            conndb.close();

            if (linhaAfetada > 0) {
                System.out.println("Imagem inserida com sucesso!");
                return true;
            }
            return false;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir imagem: " + erro);
            return false;
        }
    }

    public boolean deletarImagem(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeImagem = conndb.prepareStatement("DELETE FROM imagens WHERE id = ?;");
            removeImagem.setInt(1, id);
            int linhaAfetada = removeImagem.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar imagem: " + erro);
            return false;
        }
    }

    public boolean alterarImagem(int id, String url, String descricao) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarImagem = conndb.prepareStatement(
                    "UPDATE imagens SET url = ?, descricao = ? WHERE id = ?;"
            );
            alterarImagem.setString(1, url);
            alterarImagem.setString(2, descricao);
            alterarImagem.setInt(3, id);

            int linhaAfetada = alterarImagem.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar imagem: " + erro);
            return false;
        }
    }
}
