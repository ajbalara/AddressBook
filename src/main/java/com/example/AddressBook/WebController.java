package com.example.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    AddressBookRepository addressBookRepository;

    public WebController(AddressBookRepository addressBookRepository) {this.addressBookRepository = addressBookRepository;}

    @GetMapping("/home")
    public String homePage(Model model) {
        List<AddressBook> addressBookList = (List<AddressBook>) addressBookRepository.findAll();
        model.addAttribute("books", addressBookList);

        return "home";
    }

    @GetMapping("/home/{id}")
    public String buddies(@PathVariable("id") Long id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        model.addAttribute("bookId", id);
        model.addAttribute("buddies", addressBook.getBuddies());
        model.addAttribute("newBuddy", new BuddyInfo());
        return "buddies";
    }

    @PostMapping("/home")
    public String bookSubmit(Model model) {
        addressBookRepository.save(new AddressBook());
        model.addAttribute("books", addressBookRepository.findAll());
        return "redirect:/home";
    }

    @PostMapping("/home/{id}")
    public String buddySubmit(@PathVariable("id") Long id, @ModelAttribute("newBuddy") BuddyInfo newBuddy, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        newBuddy.setId(null);
        addressBook.addBuddy(newBuddy);
        model.addAttribute("bookId", id);
        model.addAttribute("buddies", addressBook.getBuddies());
        addressBookRepository.save(addressBook);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "redirect:/home/" + id;
    }

}
