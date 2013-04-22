package db;

import javax.naming.InitialContext;

import org.hibernate.SessionFactory;
import sk.tuke.seregely.dipl.entity.model.*;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
           Configuration configuration = new Configuration()
           .addClass(Jazda.class)
           .addClass(Suradnica.class)
           .addClass(Tankovanie.class)
           .addClass(Uctovnik.class)
           .addClass(Veduci.class)
           .addClass(Vodic.class)
           .addClass(Vozidlo.class)
           .addClass(VozidloVodic.class)
           .addClass(Zakazka.class)
           .addClass(Pracovisko.class)
           .addClass(StavJazdy.class)
           .addClass(CiselnikStavov.class)
           .addClass(GpsExport.class)
   		 .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
   		 .setProperty("hibernate.connection.driver_class", 
   		 "org.postgresql.Driver")
   		 .setProperty("hibernate.connection.url", 
   		 "jdbc:postgresql://localhost/postgres")
   		 .setProperty("hibernate.connection.username", "postgres")
   		 .setProperty("hibernate.current_session_context_class","org.hibernate.context.ThreadLocalSessionContext")
   		 .setProperty("hibernate.connection.password", "superpass");
           
           SessionFactory sessFact = configuration.buildSessionFactory();
           InitialContext ctx = new InitialContext();
        //   System.out.println(ctx.lookup("sessFact"));
        //   if(!(ctx.lookup("sessFact") instanceof SessionFactory)) ctx.bind("sessFact", sessFact);
            return sessFact;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}