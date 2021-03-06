package Classes;

import java.util.List;
import java.util.Objects;

public class Lead {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;
    private int id;
    public static int idCount = 1;

    public Lead() {
    }


    public Lead(String name, String phoneNumber, String emailAddress, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
        //this.id = idCount;
        //Lead.idCount++;
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
    public String toString() {
        return "Lead{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", companyName='" + companyName + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lead lead = (Lead) o;
        return idCount == lead.idCount && Objects.equals(name, lead.name) && Objects.equals(phoneNumber, lead.phoneNumber) && Objects.equals(emailAddress, lead.emailAddress) && Objects.equals(companyName, lead.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, emailAddress, companyName, idCount);
    }
}
