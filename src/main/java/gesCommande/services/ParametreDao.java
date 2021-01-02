package gesCommande.services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import commande.model.Profil;
import org.hibernate.Session;

import commande.model.Categorie;
import commande.model.Marque;
import commande.model.TypeClient;
import commande.service.IParametre;
import gesCommande.utils.HibernateUtil;

public class ParametreDao extends UnicastRemoteObject implements IParametre {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Session session;

    public ParametreDao() throws RemoteException {
        session = HibernateUtil.getSession();
    }

    @Override
    public List<Categorie> getAllCategorie() throws RemoteException {
        return session.createQuery("SELECT c FROM Categorie c ORDER BY c.libelle", Categorie.class).list();
    }

    @Override
    public List<TypeClient> getAllType() throws RemoteException {
        return session.createQuery("SELECT t FROM TypeClient t ORDER BY t.libelle", TypeClient.class).list();
    }

    @Override
    public List<Marque> getAllMarque() throws RemoteException {
        return session.createQuery("SELECT m FROM Marque m ORDER BY m.libelle", Marque.class).list();
    }

    @Override
    public List<Marque> getMarque(Categorie c) throws RemoteException {
        return session.createQuery("SELECT m FROM Marque m WHERE m.categorie_id="+c.getId()+" ORDER BY m.libelle", Marque.class).list();
    }

    @Override
    public List<Profil> getProfil() throws RemoteException {
        return session.createQuery("SELECT p FROM Profil p ORDER BY p.libelle", Profil.class).list();
    }

}