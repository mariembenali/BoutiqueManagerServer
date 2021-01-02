package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Produit;
import commande.service.IProduit;
import gesCommande.utils.HibernateUtil;

public class ProduitDao extends UnicastRemoteObject implements IProduit {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;

    public ProduitDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addProduit(Produit p) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(p);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Produit> getAll() throws RemoteException {
        return session.createQuery("SELECT p FROM Produit p WHERE p.etat = 0", Produit.class).list();
    }

    @Override
    public void updateProduit(Produit p) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.merge(p);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduit(Produit p) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(p);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }        
    }

    @Override
    public Produit findProduit(int id) throws RemoteException{
        return session.find(Produit.class, id);
    }

    @Override
    public Produit findProduit(String libelle) throws RemoteException {
        return session.createQuery("SELECT p FROM Produit p WHERE p.libelle = '"+libelle+"'", Produit.class).list().get(0);
    }
    
}