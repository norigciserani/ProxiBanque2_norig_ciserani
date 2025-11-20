package org.formation.proxibanque.controller;

import lombok.RequiredArgsConstructor;
import org.formation.proxibanque.entity.Agence;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.Compte;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.service.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankController {
    private final BankService service;

    @GetMapping("/clients")
    List<Client> getClients(){
        return service.getClients();
    }

    @GetMapping("/agences")
    List<Agence> getAgences(){
        return service.getAgences();
    }

    @GetMapping("/conseillers")
    List<Conseiller> getConseillers(){
        return service.getConseillers();
    }

    @GetMapping("/comptes/{clientId}")
    public ResponseEntity<List<Compte>> getComptesByClient(@PathVariable Long clientId) {
        return service.getComptesByClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    @PostMapping("/agences")
    public Agence createAgence(@RequestBody Agence agence) {
        return service.createAgence(agence);
    }

    @PostMapping("/conseillers")
    public Conseiller createConseiller(@RequestBody Conseiller conseiller) {
        return service.createConseiller(conseiller);
    }

    @PostMapping("/comptes")
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        return service.createCompte(compte)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

}
