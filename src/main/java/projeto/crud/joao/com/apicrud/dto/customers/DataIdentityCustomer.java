package projeto.crud.joao.com.apicrud.dto.customers;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import projeto.crud.joao.com.apicrud.enums.customers.CustomerIdentification;

public record DataIdentityCustomer(
        @Enumerated(EnumType.STRING)
        CustomerIdentification identityCustomer,

        @NotNull
        String numberIdentity
) {
}
