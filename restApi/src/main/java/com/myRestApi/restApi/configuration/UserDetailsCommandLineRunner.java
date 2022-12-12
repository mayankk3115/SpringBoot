package com.myRestApi.restApi.configuration;

import com.myRestApi.restApi.model.UserDetails;
import com.myRestApi.restApi.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserDetailsRepository repository;

    public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info(Arrays.toString(args));
        repository.save(new UserDetails("Mayank","Admin"));
        repository.save(new UserDetails("Priyadharsshini","Admin"));
        repository.save(new UserDetails("Mayanku","user"));
        repository.save(new UserDetails("Priyanshu","child"));

        List<UserDetails> user = repository.findAll();
        logger.info(user.toString());

        List<UserDetails> userRole = repository.findByRole("Admin");
        logger.info(userRole.toString());


    }
}
