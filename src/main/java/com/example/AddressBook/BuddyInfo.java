package com.example.AddressBook;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="addressBook_id")
    private AddressBook addressBook;

    public BuddyInfo() {}
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + this.name + ", Phone Number: " + this.phoneNumber;
    }

    public Long getId() {return id;}

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }
}
