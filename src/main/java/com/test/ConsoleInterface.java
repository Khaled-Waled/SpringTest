package com.test;

import com.test.dto.CustomerDTO;
import com.test.persitence.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsoleInterface
{
    public static void main(String[] args)
    {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("aaaa");
        customerDTO.setPhone("123");
        customerDTO.setAddress("streeet 1");

        CustomerDAO customerDao = new CustomerDAO();
        Connection connection = customerDao.getConnection();
        if(connection==null) System.out.println("null connection");
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from customers");
            preparedStatement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        customerDao.insert(customerDTO);
    }
}
