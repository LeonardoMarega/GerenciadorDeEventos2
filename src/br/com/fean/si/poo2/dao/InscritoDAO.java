/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fean.si.poo2.dao;

import br.com.fean.si.poo2.model.Inscrito;
import br.com.fean.si.poo2.util.EntityManagerUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author PabloHenrique
 */
public class InscritoDAO {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public String apagarInscrito(Inscrito i) {
        String retorno = "Inscrito apagado com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().remove(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }

    public String alterarInscrito(Inscrito i) {
        String retorno = "Inscrito alterado com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().merge(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;
    }

    public Inscrito retornarInscrito(int id) {

        Inscrito inscrito = null;
        try {
            inscrito = entityManager.find(Inscrito.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return inscrito;
    }

    public ArrayList<Inscrito> listarInscrito() {

        ArrayList<Inscrito> lista = new ArrayList<Inscrito>();
        Query query = entityManager.createQuery("select i from Inscrito i");
        lista = (ArrayList<Inscrito>) query.getResultList();

        return lista;
    }

    public String incluirInscrito(Inscrito i) {
        String retorno = "Inscrito gravado com sucesso";

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().persist(i);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }
}
