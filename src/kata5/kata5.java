package kata5;

public class kata5 {

    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\DB_SQLite\\BDKata5.db");
        DataBase database = new DataBase(URL);
        
        database.open();
        database.selectAll();
        
        //People people = new People("Fefo", "Hernández", "Taller");
        //database.insertPEOPLE(people);
        //database.selectAll();
        database.close();
    }
    
}
