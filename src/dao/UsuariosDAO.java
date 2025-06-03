package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement(
                    "INSERT INTO usuarios (nome, senha, email, cargo_id) VALUES (?, ?, md5(?), ?);");

            novoUsuario.setString(1, "ggg");
            novoUsuario.setString(2, "123");
            novoUsuario.setString(3, "fgaa@fdsdfs.kas");
            novoUsuario.setInt(4, 1);

            int linhaAfetada = novoUsuario.executeUpdate();

            if (linhaAfetada > 0) {
                System.out.println("Usuario inserido com sucesso!" + linhaAfetada);
                return true;
            }
            return true;

        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }
}

