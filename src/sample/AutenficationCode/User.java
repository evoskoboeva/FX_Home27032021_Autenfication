package sample.AutenficationCode;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class User implements java.io.Serializable {
    private String login;



    public User(String login, Passwords passwords) {
        this.login = login;
        this.passwords = passwords;
    }

    private  Passwords passwords;

    @Override
    public String toString() {
        return "(" +
                 login + '\'' + passwords +")";
    }

   /* public User(String login, Passwords passwords) {
        this.login = login;
        this.passwords = passwords;
    }
*/
    public User(String login, String password) {
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
