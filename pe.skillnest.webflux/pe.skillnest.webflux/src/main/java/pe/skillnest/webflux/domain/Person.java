package pe.skillnest.webflux.domain;

public class Person {
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Person(int id, String name, String lastName, String documentNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.documentNumber = documentNumber;
    }

    private int id;
    private String name;
    private String lastName;
    private String documentNumber;
}
