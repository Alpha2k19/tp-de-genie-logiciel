package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage.interfaceusage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample.ConnectionFactory;

public class Student extends Person {
    private String rollNumber;

    // Constructeurs
    public Student() {}

    public Student(int id, String firstName, String lastName, String rollNumber) {
        super(id, firstName, lastName);
        this.rollNumber = rollNumber;
    }

    // Getters & Setters
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    // Affichage standard
    @Override
    public String toString() {
        return super.toString() + String.format(", Roll Number: %s", rollNumber);
    }

    /**
     * Affiche l'identité complète de l'étudiant.
     */
    public String getFullIdentity() {
        return String.format("Student [ID: %d, Name: %s %s, Roll Number: %s]", getId(), getFirstName(), getLastName(), rollNumber);
    }

    @Override
    public void showIdentity() {
        System.out.println(getFullIdentity());
    }

    @Override
    public int add(Person p) throws SQLException {
        if (!(p instanceof Student)) {
            throw new IllegalArgumentException("L'objet fourni n'est pas un étudiant !");
        }

        String sqlQuery = "INSERT INTO student(id, firstName, lastName, rollNumber) VALUES(?,?,?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, p.getId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setString(4, ((Student) p).getRollNumber());

            return ps.executeUpdate();
        }
    }

    @Override
    public void showDynamicIdentity(int id) throws SQLException {
        String sqlQuery = "SELECT id, firstName, lastName, rollNumber FROM student WHERE id=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                        String.format("Student [ID: %d, Name: %s %s, Roll Number: %s]",
                            rs.getInt("id"), rs.getString("firstName"),
                            rs.getString("lastName"), rs.getString("rollNumber")));
                } else {
                    System.out.println("Aucun étudiant trouvé avec l'ID : " + id);
                }
            }
        }
    }
}
