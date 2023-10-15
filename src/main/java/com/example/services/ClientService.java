package com.example.services;

import com.example.dao.IDao;
import com.example.entities.Client;
import com.example.utility.PasswodUtility;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class ClientService implements IDao<Client> {


    public SessionFactory getFactory() {
        return factory;
    }

    private SessionFactory factory;

    public ClientService(SessionFactory factory){
        this.factory=factory;
    }
    @Override
    public Client getBasedOnLogin(String email) {
        Transaction tx = null;
        Client client=null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            String queryString = "SELECT c FROM com.example.entities.Client c WHERE c.email = :email";
            Query<Client> query=session.createQuery(queryString,Client.class);
            query.setParameter("email",email);

            Optional<Client> result=query.uniqueResultOptional();

            if(result.isPresent()){
                client=result.get();
            }

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            System.out.println(error.getMessage());

        }
        return client;
    }

    @Override
    public boolean create(Client o) throws NoSuchAlgorithmException {
        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            String strPassword=o.getPassword();
            String hashedPassword= PasswodUtility.MD5(strPassword);
            o.setPassword(hashedPassword);
            session.save(o);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            System.out.println(error.getMessage());

            return false;
        }
        return true;
    }

    @Override
    public boolean update(Client o) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {

            tx = session.getTransaction();

            tx.begin();

            session.update(o);

            tx.commit();

        } catch (HibernateException error) {
            if (tx != null)
                tx.rollback();
            System.out.println(error.getMessage());

            return false;
        }
        return true;
    }


}
