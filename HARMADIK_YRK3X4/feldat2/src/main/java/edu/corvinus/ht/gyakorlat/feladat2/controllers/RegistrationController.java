package edu.corvinus.ht.gyakorlat.feladat2.controllers;

import edu.corvinus.ht.gyakorlat.feladat2.models.RegistrationForm;
import edu.corvinus.ht.gyakorlat.feladat2.models.User;
import edu.corvinus.ht.gyakorlat.feladat2.models.*;
import edu.corvinus.ht.gyakorlat.feladat2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegistrationController {

    private final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final UserRepository repository;

    @Autowired
    public RegistrationController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showRegistrationForm(RegistrationForm registrationForm) {

        return "registration";
    }

    @PostMapping("/")
    public String register(@Valid RegistrationForm registrationForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors occurred!");
            return "registration";
        }

        logger.info("Registering user with email: {}", registrationForm.getEmail());
        final boolean userIsRegistered = repository.findByEmail(registrationForm.getEmail()).isPresent();
        if (!userIsRegistered) {
            repository.save(new User(registrationForm.getEmail()));
        }

        return "registered";
    }



}
