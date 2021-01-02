package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Commande;
import commande.model.Detail;
import commande.model.Produit;

public interface IDetail extends Remote{
    public void addDetail(Detail u) throws RemoteException;
    public void updateDetail(Detail u) throws RemoteException;
    public Detail find(int id) throws RemoteException;
    public List<Detail> getAll() throws RemoteException;
    public List<Detail> getByProduit(Produit p) throws RemoteException;
    public List<Detail> getByCommande(Commande c) throws RemoteException;
}