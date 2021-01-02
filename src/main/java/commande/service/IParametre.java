package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Categorie;
import commande.model.Marque;
import commande.model.TypeClient;
import commande.model.Profil;

public interface IParametre extends Remote{
    public List<TypeClient> getAllType() throws RemoteException;
    public List<Categorie> getAllCategorie() throws RemoteException;
    public List<Marque> getAllMarque() throws RemoteException;
    public List<Marque> getMarque(Categorie c) throws RemoteException;
    public List<Profil> getProfil() throws RemoteException;
}