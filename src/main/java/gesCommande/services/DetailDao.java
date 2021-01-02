package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Commande;
import commande.model.Detail;
import commande.model.Produit;
import commande.service.IDetail;
import gesCommande.utils.HibernateUtil;

public class DetailDao extends UnicastRemoteObject implements IDetail {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;

    public DetailDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addDetail(Detail d) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(d);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Detail find(int id) throws RemoteException {
        return session.find(Detail.class, id);
    }

    @Override
    public List<Detail> getAll() throws RemoteException {
        return session.createQuery("SELECT d FROM Detail d", Detail.class).list();
    }

    @Override
    public List<Detail> getByProduit(Produit p) throws RemoteException {
        return session.createQuery("SELECT d FROM Detail d WHERE d.produit_id=" + p.getId(), Detail.class).list();
    }

    @Override
    public void updateDetail(Detail d) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.update(d);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<Detail> getByCommande(Commande c) throws RemoteException {
        return session.createQuery("SELECT d FROM Detail d WHERE d.commande_id="+c.getId(), Detail.class).list();
    }

    
}