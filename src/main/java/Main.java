import com.example.HibernateUtil;
import com.example.entities.Client;
import com.example.services.ClientService;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ClientService clientService=new ClientService(HibernateUtil.getSessionFactory());

        Client client=new Client("othmanElidrissi@hottmail.com","naruto12","othman","el idrissi",new Date());

        clientService.create(client);

        System.out.println(clientService.getBasedOnLogin("othmanElidrissi@hottmail.com"));;
    }
}
