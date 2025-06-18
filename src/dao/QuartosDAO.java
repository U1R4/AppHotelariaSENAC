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

    public boolean deletarQuarto(int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement("DELETE FROM quartos WHERE id = ?;");
            removeQuarto.setInt(1, id);
            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }

    public boolean alterarQuarto(String nome, String numero, int qntCamaCasal, int qntCamaSolteiro,
                                 double preco, boolean disponivel, int id) {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement alterarQuarto = conndb.prepareStatement(
                    "UPDATE quartos SET nome = ?, numero = ?, qnt_cama_casal = ?, " +
                            "qnt_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?;"
            );
            alterarQuarto.setString(1, nome);
            alterarQuarto.setString(2, numero);
            alterarQuarto.setInt(3, qntCamaCasal);
            alterarQuarto.setInt(4, qntCamaSolteiro);
            alterarQuarto.setDouble(5, preco);
            alterarQuarto.setBoolean(6, disponivel);
            alterarQuarto.setInt(7, id);
            int linhaAfetada = alterarQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quarto: " + erro);
            return false;
        }
    }
}

