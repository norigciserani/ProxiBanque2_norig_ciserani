package org.formation.proxibanque.repository;

import org.formation.proxibanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
