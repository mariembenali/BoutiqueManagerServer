package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Commande;
import commande.service.ICommande;
import gesCommande.utils.HibernateUtil;



public class CommandeDao extends UnicastRemoteObject implements ICommande {

    private static final long serialVersionUID = 1L;


    private Session session;

    public CommandeDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addCommande(Commande c) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.merge(c);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void bloqueCommande(int id) throws RemoteException {
        Commande c = find(id);
        c.setEtat(-1);
        updateCommande(c);
    }

    @Override
    public Commande find(int id) throws RemoteException {
        return session.find(Commande.class, id);
    }

    @Override
    public Commande findByNumber(String numero) throws RemoteException {
        List<Commande> liste = session.createQuery("SELECT c FROM Commande c WHERE c.id IN(SELECT MAX(c.id) FROM Commande c)", Commande.class).list();
        if (liste == null || liste.isEmpty()) {
            return null;
        }else{
            return liste.get(0);
        }
    }

    @Override
    public List<Commande> getAll() throws RemoteException {
        return session.createQuery("SELECT c FROM Commande c WHERE c.etat=0 OR c.etat=1 ORDER BY c.id DESC", Commande.class).list();
    }

    @Override
    public void updateCommande(Commande c) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.update(c);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public int getMaxId() throws RemoteException {
        return session.createQuery("SELECT MAX(c.id) FROM Commande c", Commande.class).list().get(0).getId();
    }
    
}