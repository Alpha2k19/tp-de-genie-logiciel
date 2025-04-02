package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage;

import java.sql.Connection;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample.ConnectionFactory;

public class TestAbstract {

    public static void main(String[] args) {
        try {
            // Création et insertion du premier employé
            Person e1 = new Employee();
            e1.setId(1);
            e1.setFirstName("Isaac");
            e1.setLastName("Kibeho");
            ((Employee) e1).setCnss("12IJdfogsrdGSD890");

            int result1 = e1.add(e1);
            if (result1 > 0) {
                System.out.println("✅ Employee 1 inserted successfully!");
            } else {
                System.out.println("⚠️ Failed to insert Employee 1.");
            }

            // Création et insertion du deuxième employé
            Person e2 = new Employee();
            e2.setId(2);
            e2.setFirstName("Bamwisho");
            e2.setLastName("Feli");
            ((Employee) e2).setCnss("5239NBK82302");

            int result2 = e2.add(e2);
            if (result2 > 0) {
                System.out.println("✅ Employee 2 inserted successfully!");
            } else {
                System.out.println("⚠️ Failed to insert Employee 2.");
            }

            // Création et insertion du premier étudiant
            Person s1 = new Student(1, "Byenda", "Muhindo", "sdfcdfd233");
            int result3 = s1.add(s1);
            if (result3 > 0) {
                System.out.println("✅ Student 1 inserted successfully!");
            } else {
                System.out.println("⚠️ Failed to insert Student 1.");
            }

            // Création et insertion du deuxième étudiant
            Person s2 = new Student(2, "David", "Ndeze", "DFGSFefeeTSREGF");
            int result4 = s2.add(s2);
            if (result4 > 0) {
                System.out.println("✅ Student 2 inserted successfully!");
            } else {
                System.out.println("⚠️ Failed to insert Student 2.");
            }

            // Affichage des identités des employés et étudiants
            System.out.println("\n🔍 Showing inserted employees:");
            e1.showDynamicIdentity(e1.getId());
            System.out.println("-----------------------------------------");
            e2.showDynamicIdentity(e2.getId());
            System.out.println("-----------------------------------------");

            System.out.println("\n🔍 Showing inserted students:");
            s1.showDynamicIdentity(s1.getId());
            System.out.println("------------------------------------------");
            s2.showDynamicIdentity(s2.getId());
            System.out.println("-----------------------------------------");

        } catch (SQLException e) {
            System.out.println("❌ Erreur lors de l'insertion des données dans la base de données !");
            e.printStackTrace();
        } finally {
            // Fermeture propre de la connexion
            try (Connection connection = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)) {
                if (connection != null) {
                    System.out.println("🔌 Connection closed successfully.");
                }
            } catch (Exception e2) {
                System.out.println("⚠️ Problème lors de la fermeture de la connexion.");
                e2.printStackTrace();
            }
        }
    }
}
