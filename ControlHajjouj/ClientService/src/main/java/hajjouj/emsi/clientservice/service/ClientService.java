package hajjouj.emsi.clientservice.service;

import java.util.List;

import hajjouj.emsi.clientservice.entity.Client;

public interface ClientService {
    List<Client> findAll();
    Client findById(Long id) throws Exception;
    void addClient(Client client);

    void delete(Long id) throws Exception;
    void update(Client client,Long id) throws Exception;
}
