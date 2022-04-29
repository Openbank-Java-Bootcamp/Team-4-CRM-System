package Classes;

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

}
