package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Commande;

public interface ICommande extends Remote{
    public void addCommande(Commande u) throws RemoteException;
    public void updateCommande(Commande u) throws RemoteException;
    public void bloqueCommande(int id) throws RemoteException;
    public Commande find(int id) throws RemoteException;
    public Commande findByNumber(String numero) throws RemoteException;
    public List<Commande> getAll() throws RemoteException;
    public int getMaxId() throws RemoteException;
}