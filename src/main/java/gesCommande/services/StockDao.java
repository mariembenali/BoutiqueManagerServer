package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Stock;
import commande.service.IStock;
import gesCommande.utils.HibernateUtil;

public class StockDao extends UnicastRemoteObject implements IStock {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;
    public StockDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addEntree(Stock stock) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(stock);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stock find(int id) throws RemoteException {
        return session.find(Stock.class, id);
    }

    @Override
    public List<Stock> getEntrees() throws RemoteException {
        return session.createQuery("SELECT e FROM Stock e WHERE e.type='entree'", Stock.class).list();
    }

    @Override
    public List<Stock> getSorties() throws RemoteException {
        return session.createQuery("SELECT e FROM Stock e WHERE e.type='sortie'", Stock.class).list();
    }

    @Override
    public List<Stock> getAll() throws RemoteException {
        return session.createQuery("SELECT e FROM Stock e", Stock.class).list();
    }
}