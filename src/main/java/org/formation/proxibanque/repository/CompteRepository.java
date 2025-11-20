package org.formation.proxibanque.repository;

import org.formation.proxibanque.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByClientId(Long clientId);
}
