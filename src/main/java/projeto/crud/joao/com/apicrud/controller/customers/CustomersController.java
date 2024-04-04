package projeto.crud.joao.com.apicrud.controller.customers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projeto.crud.joao.com.apicrud.dto.customers.*;
import projeto.crud.joao.com.apicrud.model.customers.Customers;
import projeto.crud.joao.com.apicrud.repository.customers.CustomersRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("customers")
public class CustomersController {
    @Autowired
    private CustomersRepository repository;

    @GetMapping("/hello")
    public String olaMundo() {
        return "Hello World!";
    }
    @GetMapping("/")
    public ResponseEntity<Page<DataListCustomer>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DataListCustomer::new);
        return ResponseEntity.ok(page);
    }
    @PostMapping("/crateNewCustomer")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DataCustomersCreate dados, UriComponentsBuilder uriBuilder) {
        var customer = new Customers(dados);
        repository.save(customer);

        var uri = uriBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(uri).body(new DtoCustomerReturn(customer));
    }
    @GetMapping("/{id}")
    public ResponseEntity buscaId(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        return  ResponseEntity.ok(new DataListCustomer(user));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCustomer(@RequestBody @Valid DataUpdateCustomers dados){
        try {
            var customer = repository.getReferenceById(dados.id());
            customer.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DtoCustomerReturn(customer));
        }catch (Exception e) {
            // Se ocorrer um erro, retorne uma resposta de erro com uma mensagem adequada.
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o cliente: " + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
