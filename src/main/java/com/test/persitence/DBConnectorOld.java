package com.test.persitence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorOld
{
    private static Connection connection;

    public Connection getConnection()
    {
        try
        {
            if(connection== null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String username = "root";
                String password = "root";
                connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test", username, password);
                return connection;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }
    public void closeConnection(Connection connection)
    {
        try
        {
            connection.close();
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
        //connection = null;
    }

}
