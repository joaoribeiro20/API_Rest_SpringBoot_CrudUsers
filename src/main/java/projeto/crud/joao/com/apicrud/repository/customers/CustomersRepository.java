package projeto.crud.joao.com.apicrud.repository.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.crud.joao.com.apicrud.model.customers.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
}
