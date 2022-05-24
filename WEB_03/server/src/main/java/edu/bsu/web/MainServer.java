package edu.bsu.web;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dao.impl.ResidentDaoJaxbImpl;
import edu.bsu.web.dao.impl.ResidentDaoStaxImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Aleksandr_Dzyachenka
 * Main server class
 */
public class MainServer {

    /**
     * Unique name for a stub
     */
    private static final String UNIQUE_BINDING_NAME = "resident_dao";

    /**
     * Main server method
     * @param args - command line args
     * @throws RemoteException if problems with RMI occurred
     * @throws AlreadyBoundException if name is already bound
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        final ResidentDao residentDao = new ResidentDaoJaxbImpl();
        final Registry registry = LocateRegistry.createRegistry(2732);
        final ResidentDao stub = (ResidentDao) UnicastRemoteObject.exportObject(residentDao, 0);
        registry.bind(UNIQUE_BINDING_NAME, stub);
        System.out.println("Server is ready");
    }
}
