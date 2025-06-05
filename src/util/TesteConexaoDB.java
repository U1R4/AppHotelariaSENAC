package util;

import dao.*;

import java.sql.Connection;


public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("conexao com sucesso");

            try {
                AdicionaisDAO AddDAO = new AdicionaisDAO();
                QuartosDAO quDAO = new QuartosDAO();
                CargosDAO caDAO = new CargosDAO();
                ClientesDAO cliDAO = new ClientesDAO();
                UsuariosDAO usuDAO = new UsuariosDAO();
                PedidosDAO pedDAO = new PedidosDAO();

                pedDAO.inserirPedido();
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

