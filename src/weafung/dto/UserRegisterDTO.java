package weafung.dto;

public class UserRegisterDTO {
    private String username;
    private String password;
    private String passwordAgain;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
    }

    public String getPassword_again() {
        return passwordAgain;
    }

    public void setPassword_again(String password_again) {
        this.passwordAgain = password_again;
    }
}
