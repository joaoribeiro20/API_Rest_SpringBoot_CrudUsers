package projeto.crud.joao.com.apicrud.model.customers;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import projeto.crud.joao.com.apicrud.dto.customers.DataAddresCustomers;
import projeto.crud.joao.com.apicrud.dto.customers.DataCustomersCreate;
import projeto.crud.joao.com.apicrud.dto.customers.DataTypeCustomer;
import projeto.crud.joao.com.apicrud.dto.customers.DataUpdateCustomers;
import  projeto.crud.joao.com.apicrud.model.customers.Addres;
@Table(name = "customers")
@Entity(name = "Customers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customers {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private DataTypeCustomer typeCustomer;
    @Embedded
    private Addres dataAddresCustomers;

    public Customers(DataCustomersCreate dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.dataAddresCustomers = new Addres(dados.dataAddresCustomers());
        this.typeCustomer = dados.dataTypeCustomer();
    }

    public void atualizarInformacoes(DataUpdateCustomers dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.dataAddres() != null) {
            this.dataAddresCustomers.atualizarInformacoes(dados.dataAddres());
        }


    }

    public void excluir() {

    }
}
