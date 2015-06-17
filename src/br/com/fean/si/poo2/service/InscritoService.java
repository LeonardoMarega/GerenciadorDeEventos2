/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.service;

import br.com.fean.si.poo2.dao.InscritoDAO;
import br.com.fean.si.poo2.model.Inscrito;
import br.com.fean.si.poo2.model.Sessao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class InscritoService {
    private InscritoDAO inscritoDAO = new InscritoDAO();

    public boolean incluirInscrito(int id, String instituicao, String naturalidade, String nome, String cpf, Date dataNascimento, String email, List<Sessao> sessao) {
        boolean retorno = false;
        Inscrito inscrito = new Inscrito(id, instituicao, naturalidade, nome, cpf, dataNascimento, email, sessao);
        try {
            inscritoDAO.incluirInscrito(inscrito);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão do inscrito... " + e);
        }
        return retorno;
    }

    public boolean alterarInscrito(int id, String instituicao, String naturalidade, String nome, String cpf, Date dataNascimento, String email, List<Sessao> sessao) {
        boolean retorno = false;
        Inscrito inscrito = new Inscrito(id, instituicao, naturalidade, nome, cpf, dataNascimento, email, sessao);
        try {
            inscritoDAO.alterarInscrito(inscrito);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração do inscrito... " + e);
        }
        return retorno;
    }

    public void apagarInscrito(int id) {
        try {
            inscritoDAO.apagarInscrito(retornarInscrito(id));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar o inscrito... " + e);
        }
    }

    public Inscrito retornarInscrito(int id) {
        Inscrito inscrito = null;
        try {
            inscritoDAO.retornarInscrito(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno do inscrito... " + e);
        }
        return inscrito;
    }

    public ArrayList<Inscrito> listarInscrito() {
        ArrayList<Inscrito> inscritos = new ArrayList<Inscrito>();
        try {
            inscritos = inscritoDAO.listarInscrito();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem dos inscritos... " + e);
        }
        return inscritos;
    }
}
