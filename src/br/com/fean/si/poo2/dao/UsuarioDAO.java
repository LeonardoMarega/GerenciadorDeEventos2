package br.com.fean.si.poo2.dao;

import br.com.fean.si.poo2.model.Usuario;
import br.com.fean.si.poo2.model.Usuario;
import br.com.fean.si.poo2.util.EntityManagerUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UsuarioDAO {

    private final EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public String incluirUsuario(Usuario u) {
        String retorno = "Dados gravados com sucesso";

        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().persist(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }

    public String alterarUsuario(Usuario u) {
        String retorno = "Dados alterados com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().merge(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;
    }

    public String apagarUsuario(Usuario u) {
        String retorno = "Dados apagados com sucesso";
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().remove(u);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {

        }

        return retorno;

    }

    public ArrayList<Usuario> listarUsuario() {

        ArrayList<Usuario> usuario = new ArrayList<Usuario>();
        Query query = entityManager.createQuery("select u from Evento u");
        usuario = (ArrayList<Usuario>) query.getResultList();

        return usuario;
    }
    public Usuario retornarUsuario(int id) {

        Usuario usuario = null;
        try {
            usuario = entityManager.find(Usuario.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return usuario;
    }

}
