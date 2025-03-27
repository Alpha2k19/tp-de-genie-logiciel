package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import genie_lgiciel_tp.newpackage.com.groupe4.projets.connectionsample.ConnectionFactory;

public class Employee extends Person {
    private String cnss;

    public Employee() {
    }

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
        System.out.println(String.format("Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
                id, firstName, lastName, cnss));
    }

    @Override
    public int add(Person p) throws SQLException {
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
                    System.out.println(String.format("Employee with ID [%s], FirstName [%s], LastName [%s], Social Security [%s]",
                            rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"),
                            rs.getString("cnss")));
                }
            }
        }
    }
}
