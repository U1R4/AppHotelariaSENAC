package util;

import dao.UsuariosDAO;

import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("conexao com sucesso");

            try {
                UsuariosDAO userDAO = new UsuariosDAO();
                userDAO.inserirUsuario();
                System.out.println("Usuario Inserido com sucesso");
                condb.close();
                System.out.println("conexao encerrada");

            } catch (Exception e) {
                System.out.println("Erro ao encerrar conexao" + e.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar");
        }
    }
}

