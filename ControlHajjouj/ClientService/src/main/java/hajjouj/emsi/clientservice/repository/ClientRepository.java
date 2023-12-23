package hajjouj.emsi.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hajjouj.emsi.clientservice.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> { }
