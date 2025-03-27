package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage.interfaceusage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample.ConnectionFactory;

public class Employee extends Person {
    private String cnss;

    public Employee() {}

    public Employee(int id, String firstName, String lastName, String cnss) {
        super(id, firstName, lastName);
        this.cnss = cnss;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    @Override
    public void showIdentity() {
        System.out.println(
            String.format("Employee with ID [%d], First Name [%s], Last Name [%s], Social Security [%s]", 
                getId(), getFirstName(), getLastName(), getCnss()));
    }

    @Override
    public int add(Person p) throws SQLException {
        if (!(p instanceof Employee)) {
            throw new IllegalArgumentException("L'objet fourni n'est pas un employé !");
        }

        String sqlQuery = "INSERT INTO employee(id, firstName, lastName, cnss) VALUES(?,?,?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, p.getId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setString(4, ((Employee) p).getCnss());

            return ps.executeUpdate();
        }
    }

    @Override
    public void showDynamicIdentity(int id) throws SQLException {
        String sqlQuery = "SELECT id, firstName, lastName, cnss FROM employee WHERE id=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection(ConnectionFactory.MYSQL_CONNECTION)
                .prepareStatement(sqlQuery)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                        String.format("Employee [ID: %d, Name: %s %s, Social Security: %s]", 
                            rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("cnss")));
                } else {
                    System.out.println("Aucun employé trouvé avec l'ID : " + id);
                }
            }
        }
    }
}
