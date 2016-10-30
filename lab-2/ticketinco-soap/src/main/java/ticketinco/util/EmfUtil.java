package ticketinco.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by acabrera on 10/31/16.
 */
public class EmfUtil {
    private static EmfUtil instance = null;
    private static EntityManagerFactory emf = null;

    private EmfUtil() {
        emf = Persistence.createEntityManagerFactory("postgresds");
    }

    public static EmfUtil getInstance() {
        if (EmfUtil.instance == null) {
            EmfUtil.instance = new EmfUtil();
        }

        return EmfUtil.instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
