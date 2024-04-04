package projeto.crud.joao.com.apicrud.dto.customers;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import projeto.crud.joao.com.apicrud.model.customers.Addres;
import projeto.crud.joao.com.apicrud.model.customers.Customers;
import projeto.crud.joao.com.apicrud.dto.customers.DataAddresCustomers;
import projeto.crud.joao.com.apicrud.dto.customers.DataTypeCustomer;
public record DataCustomersCreate(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        DataTypeCustomer dataTypeCustomer,
        @NotNull
        @Valid
        DataAddresCustomers dataAddresCustomers

) {



}
