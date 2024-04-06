package projeto.crud.joao.com.apicrud.controller.customers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import projeto.crud.joao.com.apicrud.domain.user.AuthenticationData;
import projeto.crud.joao.com.apicrud.domain.user.User;
import projeto.crud.joao.com.apicrud.domain.user.UserRepository;
import projeto.crud.joao.com.apicrud.infra.security.TokenService;
import projeto.crud.joao.com.apicrud.infra.security.DataTokenJWT;
@RestController
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity actionLogin(@RequestBody @Valid AuthenticationData dados){
        try {
            System.out.println("teste");
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());

            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.generationToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/create")
    @Transactional
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid AuthenticationData dados, UriComponentsBuilder uriBuilder) {
        var encoder = new BCryptPasswordEncoder();
        var hashedPassword = encoder.encode(dados.password());

        var user = new User(dados.login(), hashedPassword); // Supondo que você tenha um construtor adequado
        repository.save(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new AuthenticationData(user.getLogin(), dados.password())); // Corrigido para usar getLogin()
    }

}

