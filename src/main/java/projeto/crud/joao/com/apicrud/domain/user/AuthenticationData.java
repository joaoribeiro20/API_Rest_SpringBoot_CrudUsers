package projeto.crud.joao.com.apicrud.domain.user;

public record AuthenticationData(
        String login,
        String password
) {
    public String password() {
        return password;
    }
}
