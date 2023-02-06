package app;

import Model.Cliente;
import Model.Direccion;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    // Código estático. Sólo se ejecuta una vez, como un Singleton
    static {
        try {
            // Creamos es SessionFactory desde el fichero hibernate.cfg.xml
            Configuration configuration = new Configuration();
            sessionFactory = configuration
                    .configure(new File("hibernate.cfg.xml")).addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Direccion.class)
                    .buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Error en la inicialización.  " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
