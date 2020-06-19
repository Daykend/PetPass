package br.unit.petpass.repository;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.unit.petpass.entities.CategoriaPet;
import br.unit.petpass.entities.Cliente;
import br.unit.petpass.entities.Contrato;
import br.unit.petpass.entities.Empresa;
import br.unit.petpass.entities.Pet;
import br.unit.petpass.entities.Plano;
import br.unit.petpass.entities.Raca;
import br.unit.petpass.entities.Servicos;

public class HibernateUtil {
	
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
                settings.put(Environment.URL, "jdbc:sqlserver://DEBORA\\SQLEXPR:1433;databaseName=UIB");
                settings.put(Environment.USER, "dba");
                settings.put(Environment.PASS, "123");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Cliente.class);
                configuration.addAnnotatedClass(Plano.class);
                configuration.addAnnotatedClass(Empresa.class);
                configuration.addAnnotatedClass(Contrato.class);
                configuration.addAnnotatedClass(Pet.class);
                configuration.addAnnotatedClass(CategoriaPet.class);
                configuration.addAnnotatedClass(Raca.class);
                configuration.addAnnotatedClass(Servicos.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}