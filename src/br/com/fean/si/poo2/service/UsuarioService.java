/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.service;

import br.com.fean.si.poo2.dao.UsuarioDAO;
import br.com.fean.si.poo2.model.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class UsuarioService {
     private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean incluirUsuario(int id, String email, String nome, String senha) {
        boolean retorno = false;
        Usuario usuario = new Usuario(id, email, nome, senha);
        try {
            usuarioDAO.incluirUsuario(usuario);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão do usuário... " + e);
        }
        return retorno;
    }

    public boolean alterarUsuario(int id, String email, String nome, String senha) {
        boolean retorno = false;
        Usuario usuario = new Usuario(id, email, nome, senha);
        try {
            usuarioDAO.alterarUsuario(usuario);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração do usuário... " + e);
        }
        return retorno;
    }

    public void apagarUsuario(int id) {
        try {
            usuarioDAO.apagarUsuario(retornarUsuario(id));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o usuário... " + e);
        }
    }

    public Usuario retornarUsuario(int id) {
        Usuario usuario = null;
        try {
            usuarioDAO.retornarUsuario(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno do usuário... " + e);
        }
        return usuario;
    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        try {
            usuario = usuarioDAO.listarUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem dos usuários... " + e);
        }
        return usuario;
    }
}
