package org.formation.proxibanque.repository;

import org.formation.proxibanque.entity.Compte;
import org.formation.proxibanque.entity.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {
}
