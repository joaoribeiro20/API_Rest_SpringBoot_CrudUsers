package projeto.crud.joao.com.apicrud.dto.customers;

import projeto.crud.joao.com.apicrud.model.customers.Addres;
import projeto.crud.joao.com.apicrud.model.customers.Customers;

public record DtoCustomerReturn(
        Long id, String nome, String email, String telefone, DataTypeCustomer dataTypeCustomer, Addres endereco
) {

    public DtoCustomerReturn(Customers customers) {
        this(customers.getId(), customers.getNome(), customers.getEmail(), customers.getTelefone(),customers.getTypeCustomer(),customers.getDataAddresCustomers());
    }


}
