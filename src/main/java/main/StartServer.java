package main;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commande.service.*;
import gesCommande.services.*;

public class StartServer {
	public static void main(String[] args) throws URISyntaxException, RemoteException, AlreadyBoundException {
		System.setProperty("java.security.policy", getPolicy().getPath());
		System.setSecurityManager(new SecurityManager());
		Registry registre = LocateRegistry.createRegistry(8695);
		IClient iClient = new ClientDao();
		ICommande iCommande = new CommandeDao();
		IDetail iDetail = new DetailDao();
		IFacture iFacture = new FactureDao();
		IProduit iProduit = new ProduitDao();
		IParametre iParametre = new ParametreDao();
		IStock iStock = new StockDao();
		IUser iUser = new UserDao();
		registre.bind("clientRemote", iClient);
		registre.bind("commandeRemote", iCommande);
		registre.bind("detailRemote", iDetail);
		registre.bind("factureRemote", iFacture);
		registre.bind("produitRemote", iProduit);
		registre.bind("stockRemote", iStock);
		registre.bind("userRemote", iUser);
		registre.bind("parametreRemote", iParametre);
		System.out.println("\nConnexion de serveur reussie sur le port 8695\n");
	}

	private static File getPolicy() throws URISyntaxException {
		URL resource = StartServer.class.getClassLoader().getResource("security.policy");
		if (resource == null) {
			throw new IllegalArgumentException("Le fichier de sécurité n'existe pas!");
		} else {
			return new File(resource.toURI());
		}
	}
}
