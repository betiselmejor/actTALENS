package app;

import Model.Direccion;
import org.hibernate.Session;
import Model.*;

public class App {
    public static void main(String[] args) {
        Session laSesion =
                HibernateUtil.getSessionFactory().getCurrentSession();

        laSesion.beginTransaction();

        Cliente c = new Cliente("Antonio Talens", true);
        c.setDireccionFacturacion(new Direccion("C/ Costa Brava 2", "Barcelona", "Barcelona",8024));
        c.setDireccioEnvio(new Direccion("C/ Manuel de Falla 4", "Barcelona", "Barcelona",8038));

        laSesion.persist(c);
        laSesion.getTransaction().commit();

    }
}
