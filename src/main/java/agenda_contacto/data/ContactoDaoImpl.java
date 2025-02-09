package agenda_contacto.data;

import agenda_contacto.dominio.Contacto;
import agenda_contacto.service.PersistenceService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;



public class ContactoDaoImpl implements ContactoDao {

    @Override
    public void newContacto(Contacto contacto) {

        EntityManager em = PersistenceService.getEm();
        EntityTransaction tx=em.getTransaction();

        tx.begin();
        em.persist(contacto);
        tx.commit();
        em.close();

    }

    @Override
    public List<Contacto> listContactos() {
        EntityManager em=PersistenceService.getEm();
        EntityTransaction tx=em.getTransaction();

        List<Contacto> lista= em.createNamedQuery("contacto.findAll").getResultList();
        em.close();
        return lista;
    }

    @Override
    public Contacto getContacto(Contacto contacto) {
        EntityManager em=PersistenceService.getEm();
        Contacto resultado= em.find(contacto.getClass(),contacto.getId());
        em.close();
        return contacto;
    }

    public Contacto findByTelefono(Contacto contacto){

        EntityManager em=PersistenceService.getEm();
        Query query= em.createNamedQuery("contacto.findByTelefono");
        query.setParameter("telefono",contacto.getTelefono());
        Contacto resultado= (Contacto) query.getSingleResult();
        return resultado;

    }

    @Override
    public void deleteContacto(Contacto contacto) {
        EntityManager em=PersistenceService.getEm();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        em.remove(em.merge(contacto));
        tx.commit();
        em.close();
    }
}
