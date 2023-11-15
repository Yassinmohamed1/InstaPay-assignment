import java.sql.*;

public class AccountDLL {

    public Account RetrieveAccount(long AccountId) {
        var account=new Account();

        // Connection parameters
        String url = "jdbc:jtds:sqlserver://localhost:1434/InstaPayDemo";


        try {
            // Load the SQL JDBC driver (for example)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create a connection
            Connection connection = DriverManager.getConnection(url);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to select data from a table (e.g., users)
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Account where Id="+AccountId);

            // Process the result set
            while (resultSet.next()) {
                // Access data by column name or index
                account.Id = resultSet.getInt("Id");
                account.AccountNumber = resultSet.getString("AccountNumber");
                account.AccountType =AccountType.values() [resultSet.getInt("AccountType")];
                account.Balance =resultSet.getDouble("Balance");
                account.UserId =resultSet.getLong("UserId");

            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  account;
    }
    public void  InsertAccount(Account account){
    // Connection parameters
    String url = "jdbc:jtds:sqlserver://localhost:1434/InstaPayDemo";


    try {
        // Load the SQL JDBC driver (for example)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Create a connection
        Connection connection = DriverManager.getConnection(url);

        // Create a statement
        Statement statement = connection.createStatement();

        // Define the INSERT query
        String insertQuery = "INSERT INTO account (AccountType,AccountNumber,Balance,UserId) VALUES (?, ?, ?, ?)";

        // Create a PreparedStatement
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        // Set values for the parameters in the query
        preparedStatement.setInt(1, account.AccountType.ordinal()); // Replace with actual values
        preparedStatement.setString(2, account.AccountNumber); // Replace with actual values
        preparedStatement.setDouble(3, account.Balance); // Replace with actual values
        preparedStatement.setLong(4, account.UserId); // Replace with actual values


        // Execute the INSERT query
        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Row inserted successfully.");
        } else {
            System.out.println("Insertion failed.");
        }

        // Close resources
        preparedStatement.close();
        connection.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
}
    public Double GetBalance(long UserId) {
         double balance=-1;

        // Connection parameters
        String url = "jdbc:jtds:sqlserver://localhost:1434/InstaPayDemo";


        try {
            // Load the SQL JDBC driver (for example)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create a connection
            Connection connection = DriverManager.getConnection(url);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to select data from a table (e.g., users)
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Account where UserId="+UserId);

            // Process the result set
            while (resultSet.next()) {
                // Access data by column name or index
                balance =resultSet.getDouble("Balance");

            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return  balance;
    }
    public boolean TransferToAnotherAccount(long SenderAccountId,long ReceieverAccountId,double Balance)
    {
        // Connection parameters
        String url = "jdbc:jtds:sqlserver://localhost:1434/InstaPayDemo";


        try {
            // Load the SQL JDBC driver (for example)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Create a connection
            Connection connection = DriverManager.getConnection(url);

            // Create a statement
            Statement statement = connection.createStatement();

            // Define the INSERT query
            String UpdateRecieverQuery = "UPDATE account set Balance= Balance - ? where Id=?";

            // Create a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(UpdateRecieverQuery);

            // Set values for the parameters in the query
            preparedStatement.setDouble(1, Balance); // Replace with actual values
            preparedStatement.setLong(2, SenderAccountId); // Replace with actual values


            preparedStatement.executeUpdate();

            String UpdateSenderQuery = "UPDATE account set Balance= Balance + ? where Id=?";

            // Create a PreparedStatement
            PreparedStatement preparedStatement1 = connection.prepareStatement(UpdateSenderQuery);

            // Set values for the parameters in the query
            preparedStatement1.setDouble(1, Balance); // Replace with actual values
            preparedStatement1.setLong(2, ReceieverAccountId); // Replace with actual values


            // Execute the INSERT query
            int rowsAffected = preparedStatement.executeUpdate();


            // Close resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
return  true;
    }
}
