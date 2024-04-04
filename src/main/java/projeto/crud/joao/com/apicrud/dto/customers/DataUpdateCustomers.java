package projeto.crud.joao.com.apicrud.dto.customers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import projeto.crud.joao.com.apicrud.model.customers.Addres;

public record DataUpdateCustomers(
        @NotNull
        Long id,
        String nome,
        String telefone,
        @Email
        String email,
        DataAddresCustomers dataAddres

) {
}
