package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Produit;

public interface IProduit extends Remote{
    public List<Produit> getAll() throws RemoteException;
    public void addProduit(Produit p) throws RemoteException;
    public void updateProduit(Produit p) throws RemoteException;
    public void deleteProduit(Produit p) throws RemoteException;
    public Produit findProduit(int id) throws RemoteException;
    public Produit findProduit(String libelle) throws RemoteException;
    
}