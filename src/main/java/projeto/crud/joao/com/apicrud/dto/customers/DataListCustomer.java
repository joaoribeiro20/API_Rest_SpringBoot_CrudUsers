package projeto.crud.joao.com.apicrud.dto.customers;

import projeto.crud.joao.com.apicrud.enums.customers.TypesOfCustomers;
import projeto.crud.joao.com.apicrud.model.customers.Customers;

public record DataListCustomer(
        Long id,
        String name,
        String email,
        TypesOfCustomers type

) {
    public DataListCustomer(Customers customers){
        this(customers.getId(), customers.getNome(), customers.getEmail(), customers.getTypeCustomer().type());
    }

}
