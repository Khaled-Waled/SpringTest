package com.test.persitence;

import com.test.dto.CustomerDTO;
import com.test.dto.Loan;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDAO extends DBConnectorOld implements IDAO<CustomerDTO>
{

    @Override
    public boolean insert(CustomerDTO customerDTO)
    {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO `test`.`customers`\n" +
                         "(`name`,`phone`,`address`)\n" +
                         "VALUES(?,?,?)\n";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerDTO.getfName());
            preparedStatement.setString(2, customerDTO.getAddress());
            preparedStatement.setString(3, customerDTO.getPhone());


            int status = preparedStatement.executeUpdate();
            return status > 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            closeConnection(connection);
        }
        return false;
    }

    @Override
    public List<CustomerDTO> retrieve(String filter)
    {
        Connection connection;
        try
        {
            connection = getConnection();
            String sql = "SELECT * FROM customers Where 1=1 ";
            if(filter != null && filter.length() > 0)
            {
                sql = sql + " and " + filter;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<CustomerDTO> customerDTOS = new ArrayList<>();
            while(resultSet.next())
            {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setId(resultSet.getInt(1));
                customerDTO.setfName(resultSet.getString(2));
                customerDTO.setPhone(resultSet.getString(3));
                customerDTO.setAddress(resultSet.getString(4));

                customerDTOS.add(customerDTO);
            }

            if (customerDTOS.isEmpty())
                return null;
            return customerDTOS;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public boolean createLoanProposal(Loan loan)
    {
        Connection connection = null;
        try
        {
            String sql = "INSERT INTO loans VALUES (?,?,?);";
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,loan.getAccountId());
            preparedStatement.setLong(2, loan.getAmount());
            preparedStatement.setString(3,loan.getLoanState());

            int rows = preparedStatement.executeUpdate();

            return rows>0;
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        finally
        {
           closeConnection(connection);
        }
        return false;
    }
}
