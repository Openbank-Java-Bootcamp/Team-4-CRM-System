package Classes;

import java.util.List;

public class Lead {
    private String name;
    private String phoneNumber;
    private String emailAddress;
    private String companyName;
    private int id;
    private int idCount = 1;

    public Lead(String name, String phoneNumber, String emailAddress, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.companyName = companyName;
        this.id = idCount;
        idCount++;
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
}
