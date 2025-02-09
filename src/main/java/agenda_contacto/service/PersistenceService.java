package agenda_contacto.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceService {

    private static EntityManagerFactory emf;

    static {
        try {
            // Crear EntityManagerFactory al inicio (es thread-safe)
            emf = Persistence.createEntityManagerFactory("contactoPu");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar EntityManagerFactory", e);
        }
    }

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }

    // Cerrar factory al apagar la aplicación
    public static void shutdown() {
        if (emf != null) {
            emf.close();
        }
    }

}
