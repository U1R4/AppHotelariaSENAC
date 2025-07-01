package controller;

import dao.UsuariosDAO;
import model.Usuarios;

public class UsuariosController {
    private final UsuariosDAO usuariosDao;

    public UsuariosController() {
        this.usuariosDao = new UsuariosDAO();
    }

    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuarios usuario = new Usuarios("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }
}