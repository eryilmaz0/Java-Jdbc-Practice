package base;

import java.sql.*;

public class JdbcPersonManager {
    private final String SQL_SERVER_URL = "jdbc:sqlserver://localhost:1433;databaseName=JdbcDatabase;";
    private final String username = "jdbc";
    private final String password = "123456";
    private Connection connection;


   public void listPersons(){
       try
       {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           connection = DriverManager.getConnection(SQL_SERVER_URL, username, password);
           Statement statement = connection.createStatement();

           ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");

           int id;
           String name;
           String lastname;
           int age;
           int gender;

           while (resultSet.next())
           {
               id = resultSet.getInt(1);
               name = resultSet.getString(2);
               lastname = resultSet.getString(3);
               age = resultSet.getInt(4);
               gender = resultSet.getInt(5);

               System.out.println(id + ", " + name + ", " + lastname + ", " + age + ", " +gender);
           }
       }
       catch (ClassNotFoundException | SQLException ex)
       {
           ex.printStackTrace();
       }
   }


    public void addPerson(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(SQL_SERVER_URL, username, password);
            Statement statement = connection.createStatement();

            String sql = "INSERT INTO "
                    + "Person(Id, Name, LastName, Age, Gender) "
                    + "VALUES(4, 'Zehra', 'Yılmaz', 50, 2)";

            System.out.println(statement.executeUpdate(sql) + " kayıt eklendi.");

            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }


    public void deletePerson(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(SQL_SERVER_URL, username, password);

            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Person WHERE Id = '4'";

            System.out.println(statement.executeUpdate(sql) + " kayıt silindi.");

            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }


    public void updatePerson(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(SQL_SERVER_URL, username, password);

            Statement statement = connection.createStatement();
            String sql = "UPDATE Person "
                    + "SET Name = 'Yusuf Sefa', LastName = 'SEZER', Age = 100 "
                    + "WHERE Id=2";;

            System.out.println(statement.executeUpdate(sql) + " kayıt güncellendi.");

            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }


    public void getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(SQL_SERVER_URL, username, password);
            if(connection != null) {
                DatabaseMetaData metaObj = (DatabaseMetaData) connection.getMetaData();
                System.out.println("Driver Name?= " + metaObj.getDriverName() + ", Driver Version?= " + metaObj.getDriverVersion() + ", Product Name?= " + metaObj.getDatabaseProductName() + ", Product Version?= " + metaObj.getDatabaseProductVersion());
            }
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
    }

}

