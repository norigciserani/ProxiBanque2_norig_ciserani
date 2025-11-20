
package org.formation.proxibanque.service;

import lombok.RequiredArgsConstructor;

import org.formation.proxibanque.entity.Agence;
import org.formation.proxibanque.entity.Client;
import org.formation.proxibanque.entity.Compte;
import org.formation.proxibanque.entity.Conseiller;
import org.formation.proxibanque.repository.AgenceRepository;
import org.formation.proxibanque.repository.ClientRepository;
import org.formation.proxibanque.repository.CompteRepository;
import org.formation.proxibanque.repository.ConseillerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankService {

    private final ClientRepository clientRepository;
    private final AgenceRepository agenceRepository;
    private final ConseillerRepository conseillerRepository;
    private final CompteRepository compteRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public List<Agence> getAgences() {
        return agenceRepository.findAll();
    }

    public List<Conseiller> getConseillers() {
        return conseillerRepository.findAll();
    }

    public Optional<List<Compte>> getComptesByClient(Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isEmpty()) {
            return Optional.empty();
        }

        List<Compte> comptes = compteRepository.findByClientId(clientId);

        return Optional.of(comptes);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    public Conseiller createConseiller(Conseiller conseiller) {
        return conseillerRepository.save(conseiller);
    }

    public Optional<Compte> createCompte(Compte compte) {
        return Optional.of(compteRepository.save(compte));
    }


}
