package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.User;
import commande.service.IUser;
import gesCommande.utils.HibernateUtil;

public class UserDao extends UnicastRemoteObject implements IUser {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;

    public UserDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addUser(User user) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void bloqueUser(int id) throws RemoteException {
        User u = find(id);
        u.setEtat(1);
        updateUser(u);
    }

    @Override
    public User find(int id) throws RemoteException {
        return session.find(User.class, id);
    }

    @Override
    public User findByLogin(String login) throws RemoteException {
        return session.createQuery("SELECT u FROM User u WHERE u.email = '" + login + "'", User.class).uniqueResult();
    }

    @Override
    public List<User> getAll() throws RemoteException {
        return session.createQuery("SELECT u FROM User u", User.class).list();
    }

    @Override
    public void updateUser(User user) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.merge(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }
    
}