package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataBase {

    private String URL;
    private Connection connection = null;
    DataBase(String URL) {
        this.URL=URL;
    }

    void open() {
        try{
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Base de datos abierta");
        }
        catch(SQLException ex){
            System.out.println("Error DataBase::open (SQLException)" + ex.getMessage());
        }
        
        
    }

    void close() {
        try{
            if( this.connection != null){
                this.connection.close();
                System.out.println("Base de datos cerrada");
            }
        }
        catch(SQLException ex){
            System.out.println("Error DataBase::close (SQLException)" + ex.getMessage());
        }
    }

    void selectAll() {
        String SQL = "Select * From PEOPLE";
        try{
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NAME \t APELLIDOS \t DEPARTAMENTO");
            while (resultset.next()){
                System.out.println(resultset.getInt("ID")+ "\t" +
                        resultset.getString("NAME")+ "\t"+
                        resultset.getString("APELLIDOS")+ "\t\t"+
                        resultset.getString("DEPARTAMENTO")+ "\t");
            }
        }
        catch(SQLException ex){
            System.out.println("Error DataBase::selectAll (SQLException)" + ex.getMessage());
        }
    }

    void insertPEOPLE(People people) {
        String SQL= "INSERT INTO PEOPLE (NAME, APELLIDOS, DEPARTAMENTO) VALUES (?,?,?)";
        try{
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, people.getName());
            preparedstatement.setString(2, people.getApellidos());
            preparedstatement.setString(3, people.getDepartamento());
            preparedstatement.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Error DataBase::insertPeople (SQLException)" + ex.getMessage());
        }
    }
}
    
    