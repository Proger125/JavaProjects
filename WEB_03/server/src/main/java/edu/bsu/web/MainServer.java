package edu.bsu.web;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dao.ResidentDaoImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServer {

    private static final String UNIQUE_BINDING_NAME = "resident_dao";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        final ResidentDao residentDao = new ResidentDaoImpl();
        final Registry registry = LocateRegistry.createRegistry(2732);
        final ResidentDao stub = (ResidentDao) UnicastRemoteObject.exportObject(residentDao, 0);
        registry.bind(UNIQUE_BINDING_NAME, stub);
        System.out.println("Server is ready");
    }
}
