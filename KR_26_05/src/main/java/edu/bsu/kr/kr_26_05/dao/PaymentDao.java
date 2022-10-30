package edu.bsu.kr.kr_26_05.dao;

import edu.bsu.kr.kr_26_05.connection.ConnectionPool;
import edu.bsu.kr.kr_26_05.entity.Payment;
import edu.bsu.kr.kr_26_05.entity.PaymentType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentDao {

    private final ConnectionPool pool = ConnectionPool.getInstance();

    private static final String GET_ALL_SQL = "SELECT * from apyments";

    private static final String GET_MAX_TAXES_SQL = "SELECT * from apyments where sum = (SElECT MAX(sum) from apyments where type = 'TAXES')";

    private static final String GET_ALL_TAXES_SQL = "SELECT COUNT(id) FROM apyments WHERE type = 'TAXES'";

    public List<Payment> getAll() {
        try (Connection connection = pool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);
            List<Payment> payments = new ArrayList<>();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong(1));
                payment.setType(PaymentType.valueOf(resultSet.getString(2)));
                payment.setPayer(resultSet.getString(3));
                payment.setSum(resultSet.getDouble(4));
                payments.add(payment);
            }
            return payments;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Payment getPaymentWithMaxSumTaxes() {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_MAX_TAXES_SQL);
            if (resultSet.next()) {
                Payment payment = new Payment();
                payment.setId(resultSet.getLong(1));
                payment.setType(PaymentType.valueOf(resultSet.getString(2)));
                payment.setPayer(resultSet.getString(3));
                payment.setSum(resultSet.getDouble(4));
                return payment;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCountOfTaxPayments() {
        try(Connection connection = pool.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_TAXES_SQL);
            if (resultSet.next()) {
                int result = resultSet.getInt(1);
                return result;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
