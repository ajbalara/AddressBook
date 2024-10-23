package com.example.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    /*
    @Bean
    public CommandLineRunner demo(BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        return (args) -> {
            BuddyInfo buddyInfo1 = new BuddyInfo("Jack", "613-256-4615");
            BuddyInfo buddyInfo2 = new BuddyInfo("Chloe", "613-138-7662");
            BuddyInfo buddyInfo3 = new BuddyInfo("Kim", "613-515-8155");
            BuddyInfo buddyInfo4 = new BuddyInfo("David", "613-618-6196");
            BuddyInfo buddyInfo5 = new BuddyInfo("Michelle", "613-428-5862");

            // save a few s
            buddyInfoRepository.save(buddyInfo1);
            buddyInfoRepository.save(buddyInfo2);
            buddyInfoRepository.save(buddyInfo3);
            buddyInfoRepository.save(buddyInfo4);
            buddyInfoRepository.save(buddyInfo5);

            // fetch all BuddyInfos
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            buddyInfoRepository.findAll().forEach(BuddyInfo -> {
                log.info(BuddyInfo.toString());
            });
            log.info("");

            // fetch an individual BuddyInfo by ID
            BuddyInfo BuddyInfo = buddyInfoRepository.findById(1L);
            log.info("BuddyInfo found with findById(1L):");
            log.info("--------------------------------");
            log.info(BuddyInfo.toString());
            log.info("");

            // fetch BuddyInfos by name
            log.info("BuddyInfo found with findByName('Kim'):");
            log.info("--------------------------------------------");
            buddyInfoRepository.findByName("Kim").forEach(buddyInfo -> {
                log.info(buddyInfo.toString());
            });
            log.info("");

            log.info("Save Buddies 2, 3 and 5 in AddressBook");

            BuddyInfo buddyInfo6 = new BuddyInfo("John", "613-256-4615");
            BuddyInfo buddyInfo7 = new BuddyInfo("Chester", "613-138-7662");
            BuddyInfo buddyInfo8 = new BuddyInfo("Steve", "613-515-8155");

            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(buddyInfo6);
            addressBook.addBuddy(buddyInfo7);
            addressBook.addBuddy(buddyInfo8);
            addressBookRepository.save(addressBook);

            // fetch AddressBook
            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            addressBookRepository.findAll().forEach(AddressBook -> {
                log.info(AddressBook.toString());
            });
            log.info("");

        };
    }

     */
}