package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Facture;


public interface IFacture extends Remote{
    public List<Facture> getAll() throws RemoteException;
    public void addFacture(Facture f) throws RemoteException;
    public Facture getFacture(String numero) throws RemoteException;
}