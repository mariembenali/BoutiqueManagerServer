package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Client;

public interface IClient extends Remote {
    public void addClient(Client u) throws RemoteException;
    public Client find(int id) throws RemoteException;
    public Client findByMatClient(String identifiant) throws RemoteException;
    public List<Client> getAll() throws RemoteException;
    
}