/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.service;

import br.com.fean.si.poo2.dao.SessaoDAO;
import br.com.fean.si.poo2.model.Evento;
import br.com.fean.si.poo2.model.Inscrito;
import br.com.fean.si.poo2.model.Ministrante;
import br.com.fean.si.poo2.model.Sessao;
import br.com.fean.si.poo2.model.TipoSessao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
public class SessaoService {

    private SessaoDAO sessaoDAO = new SessaoDAO();

    public boolean incluirSessao(Date data, Evento evento, Date horaFim, Date horaInicio, int id, String local, String nome, int numeroMaximo, TipoSessao tipoSessao, List<Inscrito> inscrito, List<Ministrante> ministrante) {
        boolean retorno = false;
        Sessao sessao = new Sessao(data, evento, horaFim, horaInicio, id, local, nome, numeroMaximo, tipoSessao, inscrito, ministrante);
        try {
            sessaoDAO.incluirSessao(sessao);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na inclusão da sessão... " + e);
        }
        return retorno;
    }

    public boolean alterarSessao(Date data, Evento evento, Date horaFim, Date horaInicio, int id, String local, String nome, int numeroMaximo, TipoSessao tipoSessao, List<Inscrito> inscrito, List<Ministrante> ministrante) {
        boolean retorno = false;
        Sessao sessao = new Sessao(data, evento, horaFim, horaInicio, id, local, nome, numeroMaximo, tipoSessao, inscrito, ministrante);
        try {
            sessaoDAO.alterarSessao(sessao);
            retorno = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na alteração da sessão... " + e);
        }
        return retorno;
    }

    public void apagarSessao(int id) {
        try {
            sessaoDAO.apagarSessao(retornarSessao(id));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao apagar a sessão... " + e);
        }
    }

    public Sessao retornarSessao(int id) {
        Sessao sessao = null;
        try {
            sessaoDAO.retornarSessao(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no retorno da sessão... " + e);
        }
        return sessao;
    }

    public ArrayList<Sessao> listarSessao() {
        ArrayList<Sessao> sessao = new ArrayList<Sessao>();
        try {
            sessao = sessaoDAO.listarSessao();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro na listagem de sessões... " + e);
        }
        return sessao;
    }

}
