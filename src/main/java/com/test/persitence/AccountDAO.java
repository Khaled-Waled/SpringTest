package com.test.persitence;

import com.test.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class AccountDAO extends DBConnectorOld implements IDAO<AccountDTO>
{
    @Override
    public boolean insert(AccountDTO accountDTO)
    {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO `test`.`accounts`\n" +
                         "(`customerID`,`balance`)\n" +
                         "VALUES (?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, accountDTO.getCustomerID());
            preparedStatement.setLong(2, accountDTO.getBalance());


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
    public List<AccountDTO> retrieve(String filter)
    {
        Connection connection;
        try
        {
            connection = getConnection();
            String sql = "SELECT * FROM accounts Where 1=1 ";
            if(filter != null && filter.length() > 0)
            {
                sql = sql + " and " + filter;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<AccountDTO> accountDTOS = new ArrayList<>();
            while(resultSet.next())
            {
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setId(resultSet.getLong(1));
                accountDTO.setCustomerID(resultSet.getLong(2));
                accountDTO.setBalance(resultSet.getLong(3));

                accountDTOS.add(accountDTO);
            }

            if (accountDTOS.isEmpty())
                return null;
            return accountDTOS;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
