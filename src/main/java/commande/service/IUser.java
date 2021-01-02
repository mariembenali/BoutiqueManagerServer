package commande.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import commande.model.User;

public interface IUser extends Remote {
    public void addUser(User u) throws RemoteException;
    public void updateUser(User u) throws RemoteException;
    public void bloqueUser(int id) throws RemoteException;
    public User find(int id) throws RemoteException;
    public User findByLogin(String login) throws RemoteException;
    public List<User> getAll() throws RemoteException;
}