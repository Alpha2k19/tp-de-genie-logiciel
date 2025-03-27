package genie_lgiciel_tp.newpackage.com.groupe4.projet.abstractclasssusage.interfaceusage;

import java.sql.SQLException;

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;

    // Constructeurs
    public Person() {}

    public Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    // Méthode pour récupérer le nom complet
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Méthode d'affichage standard
    @Override
    public String toString() {
        return String.format("Person [ID: %d, Name: %s %s]", id, firstName, lastName);
    }

    /**
     * Affiche l'identité de la personne sans connexion à la base de données.
     */
    public abstract void showIdentity();

    /**
     * Affiche l'identité de la personne en se connectant à la base de données en utilisant l'ID.
     * @param id Identifiant de la personne.
     * @throws SQLException En cas d'erreur SQL.
     */
    public abstract void showDynamicIdentity(int id) throws SQLException;

    /**
     * Insère une nouvelle personne dans la base de données.
     * @param p Référence de la personne (peut être un employé ou un étudiant).
     * @return Nombre de lignes affectées dans la base de données.
     * @throws SQLException En cas d'erreur SQL.
     */
    public abstract int add(Person p) throws SQLException;
}
