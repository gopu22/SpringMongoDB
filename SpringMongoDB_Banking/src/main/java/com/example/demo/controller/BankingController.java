package com.example.demo.controller;

import com.example.demo.model.Banking;
import com.example.demo.repository.BankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankingController {

    @Autowired
    BankingRepository repo;

    @GetMapping("/all")
    public List<Banking> getall() {
        return repo.findAll();
    }

    @RequestMapping("/all/{accno}")
    @ResponseBody
    public Optional<Banking> getone(@PathVariable("accno") int accno)
    {
        return repo.findByAccno(accno);
    }

    @PostMapping("/add")
    public String addacc(@RequestBody Banking bank) {
        repo.save(bank);
        return "Account Added Successfully";
    }

    @PutMapping("/all")
    public String updateacc(@RequestBody Banking bank) {
        repo.save(bank);
        return "Account Updated Successfully";
    }

    @DeleteMapping("/all/{accno}")
    public String deleteacc(@PathVariable("accno") int accno) {
        repo.deleteByAccno(accno);
        return "Account Deleted Successfully";
    }

}
