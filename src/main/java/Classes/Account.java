package Classes;

import Enums.Industry;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private Industry industry;
    private int numberOfEmployees;
    private String city;
    private String country;
    private String name; //take it from lead object
    private List<Contact> contactList;
    private List<Opportunity> opportunityList;

    public Account(Industry industry, int numberOfEmployees, String city, String country, String name) {
        this.industry = industry;
        this.numberOfEmployees = numberOfEmployees;
        this.city = city;
        this.country = country;
        this.name = name;
        this.contactList = new ArrayList<>();
        this.opportunityList = new ArrayList<>();
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

}
