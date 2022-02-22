package edu.bsu.web;

import edu.bsu.web.dao.ResidentDao;
import edu.bsu.web.dao.ResidentDaoImpl;
import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Operation;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final ResidentDao RESIDENT_DAO_IMPL = new ResidentDaoImpl();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("Enter command type:");
            System.out.println("1. Insert");
            System.out.println("2. Count");
            System.out.println("3. All(to view all residents)");
            System.out.println("4. Delete");
            System.out.println("5. Exit");

            String userAnswer = scanner.next();
            Operation operation;
            try{
                operation = Operation.valueOf(userAnswer.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("You entered incorrect command");
                continue;
            }

            switch (operation) {
                case INSERT:
                    ResidentDto dto = new ResidentDto();
                    System.out.println("Enter resident firstName");
                    dto.setFirstName(scanner.next());
                    System.out.println("Enter resident lastName");
                    dto.setLastName(scanner.next());
                    System.out.println("Enter resident city");
                    dto.setCity(scanner.next());
                    System.out.println("Enter resident street");
                    dto.setStreet(scanner.next());
                    System.out.println("Enter resident houseNumber");
                    dto.setHouseNumber(scanner.nextInt());
                    try {
                        Resident resident = RESIDENT_DAO_IMPL.addResident(dto);
                        System.out.println(resident);
                    } catch (DaoException e) {
                        System.out.println("Something went wrong. Try again later...");
                        return;
                    }
                    break;
                case COUNT:
                    try {
                        Map<String, Integer> map = RESIDENT_DAO_IMPL.countResidentsInCities();
                        System.out.println(map);
                    } catch (DaoException e) {
                        System.out.println("Something went wrong. Try again later...");
                        return;
                    }
                    break;
                case ALL:
                    try {
                        List<Resident> residents = RESIDENT_DAO_IMPL.getAll();
                        System.out.println(residents);
                    } catch (DaoException e) {
                        System.out.println("Something went wrong. Try again later...");
                        return;
                    }
                    break;
                case DELETE:
                    try {
                        System.out.println("Enter residents id");
                        Long id = scanner.nextLong();
                        RESIDENT_DAO_IMPL.deleteById(id);
                    } catch (DaoException e) {
                        System.out.println("Something went wrong. Try again later...");
                    } catch (ResourceNotFoundException e) {
                        System.out.println("No such resident...");
                    }
                    break;
                case EXIT:
                    System.out.println("Application closed...");
                    return;
            }
        }
    }
}
