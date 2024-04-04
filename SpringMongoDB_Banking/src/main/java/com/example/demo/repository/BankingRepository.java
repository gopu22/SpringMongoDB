package com.example.demo.repository;

import com.example.demo.model.Banking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankingRepository extends MongoRepository<Banking,String>
{
    Optional<Banking> findByAccno(int accno);
    void deleteByAccno(int accno);

}
