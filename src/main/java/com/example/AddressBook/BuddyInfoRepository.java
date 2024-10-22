package com.example.AddressBook;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    BuddyInfo findById(long l);

    List<BuddyInfo> findByName(String name);
    void deleteById(long id);
}
