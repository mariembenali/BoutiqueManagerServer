package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import commande.model.Client;
import commande.service.IClient;
import gesCommande.utils.HibernateUtil;

public class ClientDao extends UnicastRemoteObject implements IClient {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;

    public ClientDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public void addClient(Client client) throws RemoteException {
        Transaction t = session.getTransaction();
        try {
            t.begin();
            session.save(client);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Client find(int id) throws RemoteException {
        return session.find(Client.class, id);
    }

    @Override
    public Client findByMatClient(String cin) throws RemoteException {
        List<Client> liste = session.createQuery("SELECT c FROM Client c WHERE c.identification =" + cin, Client.class)
                .list();
        if (liste == null || liste.isEmpty()) {
            return null;
        }else{
            return liste.get(0);
        }
    }

    @Override
    public List<Client> getAll() throws RemoteException {
        return session.createQuery("SELECT c FROM Client c", Client.class).list();
    }

    
    
}