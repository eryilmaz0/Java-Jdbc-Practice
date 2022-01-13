package base;

public class main {

    public static void main(String[] args){
        System.out.println("Hello");
        JdbcPersonManager manager = new JdbcPersonManager();
        manager.listPersons();
        manager.addPerson();
        manager.updatePerson();
        manager.deletePerson();
    }
}






































































































