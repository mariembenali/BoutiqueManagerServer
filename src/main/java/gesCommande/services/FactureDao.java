package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Facture;
import commande.service.IFacture;
import gesCommande.utils.HibernateUtil;

public class FactureDao extends UnicastRemoteObject implements IFacture {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;
    public FactureDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addFacture(Facture facture) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(facture);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Facture> getAll() throws RemoteException {
        return session.createQuery("SELECT f FROM Facture c", Facture.class).list();
    }

    @Override
    public Facture getFacture(String numero) throws RemoteException {
        return session.createQuery("SELECT f FROM Facture f WHERE f.numero="+numero, Facture.class).uniqueResult();
    }
    
}