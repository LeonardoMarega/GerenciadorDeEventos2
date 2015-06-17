/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.dao;

import br.com.fean.si.poo2.model.Sessao;
import br.com.fean.si.poo2.util.EntityManagerUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Leonardo
 */
public class SessaoDAO {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public String apagarSessao(Sessao s) {
        String retorno = "Dados apagados com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().remove(s);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }

    public String alterarSessao(Sessao s) {
        String retorno = "Dados alterados com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().merge(s);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;
    }

    public Sessao retornarSessao(int id) {

        Sessao sessao = null;
        try {
            sessao = entityManager.find(Sessao.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return sessao;
    }
//sessao = entityManager.find(sessao.class, id);
    public ArrayList<Sessao> listarSessao() {

        ArrayList<Sessao> lista = new ArrayList<Sessao>();
        Query query = entityManager.createQuery("select s from Sessao s");
        lista = (ArrayList<Sessao>) query.getResultList();

        return lista;
    }

    public String incluirSessao(Sessao s) {
        String retorno = "Dados gravados com sucesso";

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().persist(s);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }

}
