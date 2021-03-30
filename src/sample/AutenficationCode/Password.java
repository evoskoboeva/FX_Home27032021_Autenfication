package sample.AutenficationCode;

import sample.Main;

import java.time.LocalDate;
import java.util.Objects;

public class Password implements java.io.Serializable{
    private String password;
    private boolean isActive;
    //private LocalDate date;

    /*public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password password1 = (Password) o;
        return getPassword().equals(password1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassword());
    }

    public static Password generateRandomly() {
        int generic = (int) (Math.random()*1000000);
        System.out.println(generic);

        String pass = "GenPass".concat("_"+generic);
        return new Password(pass);
    }

    @Override
    public String toString() {
        return password + isActive;
    } //" is Active = " +

    public Password(String password) {
        if (isValid(password)) {
            this.password = password;
            //this.date =date;

            this.setActive(true);
        } else {
            this.password = null;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isValid(String password) {
        //Определить, является ли введенное слово password,  не содержит других символов,
        // кроме букв английского алфавита (в любом регистре), цифр и знака подчеркивания.длина от 8 символов.
        final String LETTERSUP = "QWERTYUIOPASDFGHJKLZXCVBNM";
        final String LETTERSDOWN = "qwertyuiopasdfghjklzxcvbnm";
        final String NUMERALS = "1234567890";
        final String SYMBOL = "_.";
        String letter = "";
        String checkpoint = "";
        if (password.length() >= 8) {
            for (int i = 0; i <= password.length() - 1; i++) {
                letter = password.substring(i, i + 1);
                if (LETTERSDOWN.contains(letter)) {
                    checkpoint = checkpoint.concat("1");
                } else if (LETTERSUP.contains(letter)) {
                    checkpoint = checkpoint.concat("2");
                } else if (NUMERALS.contains(letter)) {
                    checkpoint = checkpoint.concat("3");
                } else if (SYMBOL.contains(letter)) {
                    checkpoint = checkpoint.concat("4");
                } else {
                    checkpoint = checkpoint.concat("no");
                }
                if (checkpoint.contains("no")) {
                    return false;
                }
            }
           if (checkpoint.contains("1")&&checkpoint.contains("2")&&checkpoint.contains("3")&&checkpoint.contains("4")) {
                return true;
           }
        }
        else return false;
        return false;
    }


    }
