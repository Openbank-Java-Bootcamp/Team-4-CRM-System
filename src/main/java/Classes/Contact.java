package Classes;

import java.util.Objects;

public class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;
    private int id;
    private int idCount =1;

    public Contact(String name, String phoneNumber, String emailAddress, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
        this.id = idCount++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress) && Objects.equals(companyName, contact.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAddress, companyName);
    }
}
