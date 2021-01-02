package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.Stock;

public interface IStock extends Remote{
    public void addEntree(Stock u) throws RemoteException;
    public Stock find(int id) throws RemoteException;
    public List<Stock> getAll() throws RemoteException;
    public List<Stock> getEntrees() throws RemoteException;
    public List<Stock> getSorties() throws RemoteException;
}