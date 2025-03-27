package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage.interfaceusage;

import java.sql.Connection;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample.ConnectionFactory;

public class TestInterface {

    public static void main(String[] args) {
        try {
            // Création et insertion des employés
            Employee e1 = new Employee(1, "isaac", "kibeho", "12dsuifdsfh234");
            e1.add(e1);
            System.out.println("✅ Employee 1 inserted successfully!");
            
           
            Employee e2 = new Employee(2, "iyumba", "elias", "fyidt02");
            e2.add(e2);
            System.out.println("✅ Employee 2 inserted successfully!");
            
            Employee e3 = new Employee(3, "kahindo", "symanya", "dftyfdsfh234");
            e1.add(e3);
            System.out.println("✅ Employee 3 inserted successfully!");
            
            Employee e4 = new Employee(4, "kafindi", "musrka", "fdsfh234");
            e1.add(e4);
            System.out.println("✅ Employee 4 inserted successfully!");
            
            Employee e5 = new Employee(5, "israel", "mazirane", "uifdsfh234");
            e1.add(e5);
            System.out.println("✅ Employee 5 inserted successfully!");
            
            Employee e6 = new Employee(6, "mwezi", "claudette", "12dsuifds44");
            e1.add(e6);
            System.out.println("✅ Employee 6 inserted successfully!");
            
            Employee e7 = new Employee(7, "itengo", "beho", "12dsuifh234");
            e1.add(e7);
            System.out.println("✅ Employee 7 inserted successfully!");


            Student s1 = new Student(1, "irangi", "nzibonera", "rtytTCFE514");
            s1.add(s1);
            System.out.println("✅ Student 1 inserted successfully!");

            Student s2 = new Student(2, "itongwa", "christopher", "sdsrg3765TSREGF");
            s2.add(s2);
            System.out.println("✅ Student 2 inserted successfully!");

            // Affichage des informations des employés
            System.out.println("\n🔍 Displaying Employees from Database:");
            e1.showDynamicIdentity(e1.getId());
            System.out.println("-----------------------------------------");
            e2.showDynamicIdentity(e2.getId());
            System.out.println("-----------------------------------------");

            // Affichage des informations des étudiants
            System.out.println("\n🔍 Displaying Students from Database:");
            s1.showDynamicIdentity(s1.getId());
            System.out.println("-----------------------------------------");
            s2.showDynamicIdentity(s2.getId());
            System.out.println("-----------------------------------------");

        } catch (SQLException e) {
            System.err.println("❌ Failed to insert records into the database.");
            e.printStackTrace();
        } finally {
            // Fermeture sécurisée de la connexion
            try (Connection connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)) {
                System.out.println("\n🔌 Database connection closed successfully.");
            } catch (Exception e2) {
                System.err.println("⚠️ Error closing the database connection: " + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }
}
