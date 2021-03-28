package sample.AutenficationCode;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User {
    private String login;
    private  Passwords passwords;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", passwords= " + passwords +
                               '}';
    }

    public User(String login, String password, LocalDate date) {
        this.login = login;
        this.passwords = new Passwords(password);
        if (!passwords.getPasswords().get(0).isActive()){
            this.passwords.getPasswords().set(0,Password.generateRandomly());
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Passwords getPasswords() {
        return passwords;
    }

    public void setPasswords(Passwords passwords) {
        this.passwords = passwords;
    }
}
