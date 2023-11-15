import java.sql.*;

public class UserDLL {

    public void RetrieveUser() {
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");

            // Process the result set
            while (resultSet.next()) {
                // Access data by column name or index
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String FirstName = resultSet.getString("FirstName");

                // Process retrieved data
                System.out.println("User ID: " + userId + ", Username: " + userName + ", FirstName: " + FirstName);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void InsertUser(User user) {
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
            String insertQuery = "INSERT INTO user (UserName,FirstName,SecondName,PhoneNumber,Password) VALUES (?, ?, ?, ?, ?)";

            // Create a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set values for the parameters in the query
            preparedStatement.setString(1, user.UserName); // Replace with actual values
            preparedStatement.setString(2, user.FirstName); // Replace with actual values
            preparedStatement.setString(3, user.SecondName); // Replace with actual values
            preparedStatement.setString(4, user.PhoneNumber); // Replace with actual values
            preparedStatement.setString(5, user.Password); // Replace with actual values


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
  public  LoginModel GetLoginInfo(String UserName,String Password)
  {
      var result=new LoginModel();
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
          ResultSet resultSet = statement.executeQuery("SELECT * FROM User where username="+UserName);

          // Process the result set
          while (resultSet.next()) {
              // Access data by column name or index
              String userName = resultSet.getString("username");
              String password = resultSet.getString("Password");
              if (userName!=null){
result.UserName=userName;
result.Password=password;}
          }

          // Close resources
          resultSet.close();
          statement.close();
          connection.close();
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }
      return  result;
  }

}
