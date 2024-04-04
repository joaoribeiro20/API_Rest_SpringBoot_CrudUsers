package projeto.crud.joao.com.apicrud.dto.customers;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import projeto.crud.joao.com.apicrud.enums.customers.TypesOfCustomers;
import projeto.crud.joao.com.apicrud.dto.customers.DataIdentityCustomer;
import projeto.crud.joao.com.apicrud.enums.customers.CustomerIdentification;
public record DataTypeCustomer(
        @Enumerated(EnumType.STRING)
        TypesOfCustomers type,
        @NotNull
        @Embedded
        DataIdentityCustomer dataIdentityCustomer

) {
}
