package com.Zinkworks.ATMApp.acounts;

import antlr.collections.List;
import com.Zinkworks.ATMApp.acounts.dao.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;



@Configuration
public class LoadAccountDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadAccountDatabase.class);


    @Bean
    CommandLineRunner initDatabaseAccount(AccountRepository accountRepository){
        return args -> {
            log.info("Preloading data account");
            Account account1 = new Account(123456789, 1234, 800d, 200d,new java.util.Date());
            Account account2 = new Account(987654321, 4321, 1230d, 150d,new java.util.Date());
            accountRepository.saveAll(Arrays.asList(account1,account2));
            log.info("Preloading data account finish");

        };
    }
}
