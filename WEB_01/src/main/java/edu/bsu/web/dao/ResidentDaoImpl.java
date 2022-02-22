package edu.bsu.web.dao;

import edu.bsu.web.conncection.ConnectionPool;
import edu.bsu.web.dto.ResidentDto;
import edu.bsu.web.entity.Address;
import edu.bsu.web.entity.Resident;
import edu.bsu.web.exception.DaoException;
import edu.bsu.web.exception.ResourceNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResidentDaoImpl implements ResidentDao{

    private final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String INSERT_RESIDENT_SQL = "INSERT INTO residents (first_name, last_name, address_id) VALUES (?, ?, ?)";

    private static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    private static final String INSERT_ADDRESS_SQL = "INSERT INTO addresses (city, street, house_number) VALUES (?, ?, ?)";

    private static final String COUNT_RESIDENTS_IN_CITY_SQL = "SELECT addresses.city, COUNT(residents.resident_id) FROM residents JOIN addresses ON residents.address_id = addresses.address_id GROUP BY addresses.city;";

    private static final String GET_ALL_RESIDENTS_SQL = "SELECT residents.resident_id, residents.first_name, residents.last_name, addresses.address_id, addresses.city, addresses.street, addresses.house_number FROM residents JOIN addresses ON residents.address_id = addresses.address_id";

    private static final String DELETE_ADDRESS_BY_ID_SQL = "DELETE FROM addresses WHERE address_id = ?";

    private static final String GET_RESIDENT_BY_ID_SQL = "SELECT resident_id FROM residents WHERE resident_id = ?";

    private static final String GET_ADDRESS_ID_BY_RESIDENT_ID_SQL = "SELECT address_id FROM residents WHERE resident_id = ?";

    @Override
    public Resident addResident(ResidentDto residentDto) throws DaoException {
        Connection connection = null;
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);
            long addressId;
            long residentId;

            PreparedStatement insertAddressStatement = connection.prepareStatement(INSERT_ADDRESS_SQL);
            insertAddressStatement.setString(1, residentDto.getCity());
            insertAddressStatement.setString(2, residentDto.getStreet());
            insertAddressStatement.setInt(3, residentDto.getHouseNumber());
            insertAddressStatement.execute();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_LAST_INSERT_ID);
            if (resultSet.next()) {
                addressId = resultSet.getLong(1);
            } else {
                throw new SQLException("Unable to insert new address in ResidentDao");
            }

            PreparedStatement insertResidentStatement = connection.prepareStatement(INSERT_RESIDENT_SQL);
            insertResidentStatement.setString(1, residentDto.getFirstName());
            insertResidentStatement.setString(2, residentDto.getLastName());
            insertResidentStatement.setLong(3, addressId);
            insertResidentStatement.execute();

            statement = connection.createStatement();
            ResultSet residentResultSet = statement.executeQuery(GET_LAST_INSERT_ID);
            if (residentResultSet.next()) {
                residentId = residentResultSet.getLong(1);
            } else {
                throw new SQLException("Unable to insert new resident in ResidentDao");
            }
            return Resident.builder()
                    .id(residentId)
                    .firstName(residentDto.getFirstName())
                    .lastName(residentDto.getLastName())
                    .address(
                            Address.builder()
                                    .id(addressId)
                                    .city(residentDto.getCity())
                                    .street(residentDto.getStreet())
                                    .houseNumber(residentDto.getHouseNumber())
                                    .build()
                    ).build();
        } catch (SQLException e) {
            if (connection != null){
                try{
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new DaoException("Unable to rollback in ResidentDao", ex);
                }
            }
            throw new DaoException("Unable to execute addResident method in ResidentDao", e);
        } finally {
            if (connection != null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Unable to close connection in ResidentDao");
                }
            }
        }
    }

    @Override
    public Map<String, Integer> countResidentsInCities() throws DaoException {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(COUNT_RESIDENTS_IN_CITY_SQL);
            Map<String, Integer> map = new HashMap<>();
            while (resultSet.next()) {
                String city = resultSet.getString(1);
                Integer count = resultSet.getInt(2);
                map.put(city, count);
            }
            return map;
        } catch (SQLException e) {
            throw new DaoException("Unable to count residents in cities in ResidentDao", e);
        }
    }

    @Override
    public List<Resident> getAll() throws DaoException {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_RESIDENTS_SQL);
            List<Resident> residents = new ArrayList<>();
            while (resultSet.next()) {
                residents.add(Resident.builder()
                        .id(resultSet.getLong(1))
                        .firstName(resultSet.getString(2))
                        .lastName(resultSet.getString(3))
                        .address(
                                Address.builder()
                                        .id(resultSet.getLong(4))
                                        .city(resultSet.getString(5))
                                        .street(resultSet.getString(6))
                                        .houseNumber(resultSet.getInt(7))
                                        .build()
                        ).build());
            }
            return residents;
        } catch (SQLException e) {
            throw new DaoException("Unable to get all residents in ResidentDao", e);
        }
    }

    @Override
    public void deleteById(Long id) throws DaoException, ResourceNotFoundException {
        Connection connection = null;
        try {
            connection = pool.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement getResidentStatement = connection.prepareStatement(GET_RESIDENT_BY_ID_SQL);
            getResidentStatement.setLong(1, id);
            ResultSet resultSet = getResidentStatement.executeQuery();

            if (!resultSet.next()) {
                throw new ResourceNotFoundException("No such user");
            }

            PreparedStatement getAddressStatement = connection.prepareStatement(GET_ADDRESS_ID_BY_RESIDENT_ID_SQL);
            getAddressStatement.setLong(1, id);
            ResultSet resultSet1 = getAddressStatement.executeQuery();
            if (!resultSet1.next()) {
                throw new ResourceNotFoundException("No such address");
            }
            long address_id = resultSet1.getLong(1);
            PreparedStatement deleteAddressStatement = connection.prepareStatement(DELETE_ADDRESS_BY_ID_SQL);
            deleteAddressStatement.setLong(1, address_id);
            deleteAddressStatement.execute();

        } catch (SQLException | ResourceNotFoundException e) {
            if (connection != null){
                try{
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new DaoException("Unable to rollback in ResidentDao", ex);
                }
            }
            if (e instanceof SQLException) {
                throw new DaoException("Unable to execute addResident method in ResidentDao", e);
            } else {
                throw new ResourceNotFoundException("No such resident", e);
            }

        } finally {
            if (connection != null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Unable to close connection in ResidentDao");
                }
            }
        }
    }
}
