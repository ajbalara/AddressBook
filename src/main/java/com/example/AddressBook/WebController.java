package com.example.AddressBook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "buddies";
    }

}
