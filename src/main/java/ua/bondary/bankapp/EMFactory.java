package ua.bondary.bankapp;


import com.sun.xml.internal.ws.Closeable;
import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.CloseableService;


import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

public class EMFactory implements Factory<EntityManager> {

    private static final String PERSISTENCE_UNIT = "h2BankUnit";
    private final EntityManagerFactory emf;
    private final CloseableService closeService;

    @Inject
    public EMFactory (EntityManagerFactory emf, CloseableService closeService){
        this.emf = emf;
        this.closeService = closeService;
    }
    public EntityManager provide() {
        final EntityManager em = emf.createEntityManager();
        this.closeService.add(new Closeable(){
            @Override
            public void close() {
                em.close();
            }
        });
        return em;
    }

    @Override
    public void dispose(EntityManager entityManager) {
        if(entityManager.isOpen()) {
            entityManager.close();
        }
    }
}