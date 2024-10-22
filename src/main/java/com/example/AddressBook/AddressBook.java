package com.example.AddressBook;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook() {
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
        buddy.setAddressBook(this);
    }

    public void removeBuddy(int id) {
        buddies.remove(id - 1);
    }

    public Long getId() {return id;}

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    @Override
    public String toString() {
        return "AddressBook{" + "id=" + id + ", buddies=" + buddies + '}';
    }

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();
        ab.addBuddy(new BuddyInfo("John Doe", "613-855-8942"));
        ab.addBuddy(new BuddyInfo("Jane Doe", "613-842-5487"));
        List<BuddyInfo> buddies = ab.getBuddies();
        for (BuddyInfo buddy : buddies) {
            System.out.println(buddy);
        }
    }
}
