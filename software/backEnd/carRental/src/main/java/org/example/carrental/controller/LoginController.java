package org.example.carrental.controller;

import org.example.carrental.entity.ClientEntity;
import org.example.carrental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/login")
    public boolean login(String account, String password) {
        System.out.println("account:" + account);
        System.out.println("password:" + password);
        return clientService.login(account, password);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody ClientEntity client) {
        return clientService.register(client);
    }

    @PostMapping("/update")
    public boolean update(@RequestBody ClientEntity client) {
        return clientService.update(client);
    }

    @GetMapping("/logout")
    public boolean logout() {
        return clientService.logout();
    }
}
