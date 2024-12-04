package entities;

public class Address {
    String state;
    String city;
    String street;
    String landmark;
    int zipcode;

    public Address(String state, String city, String street, String landmark, int zipcode) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.landmark = landmark;
        this.zipcode = zipcode;
    }
}
