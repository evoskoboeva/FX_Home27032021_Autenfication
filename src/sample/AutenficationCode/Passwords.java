package sample.AutenficationCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Passwords implements java.io.Serializable{
    private ArrayList<Password>passwords;


    @Override
    public String toString() {
        return
                "passwords( " + passwords+ ")";
    }

    public Passwords(String password) {
        this.passwords = new ArrayList<>();
        this.passwords.add(new Password(password));
    }

    public Passwords(ArrayList<Password> passwords) {
        this.passwords = passwords;
    }

    public ArrayList<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<Password> passwords) {
        this.passwords = passwords;
    }

    public boolean canBeAdded(String password){
        return true;
    }

    public boolean add (String password){
        if (canBeAdded(password)){
            for (Password pass:passwords)
            {
                if (pass.getPassword().equals((password))){
                    return false;
                }
            }
            if (Password.isValid(password)) {

                /*for (Password passs : passwords) {
                    passs.setActive(false);
                }
*/
                passwords.get(passwords.size()-1).setActive(false); // из примера вариант

                passwords.add(new Password(password));
            }
        }
        return true;
    }
    public boolean isCorrectActivePassword(String password){
        if (passwords.get(passwords.size()-1).getPassword().equals(password))
            return true;
        else
            return false;
    }
   /* public LocalDate isCorrectActivePasswordDate(String password){
        if (passwords.get(passwords.size()-1).getPassword().equals(password))
            return isCorrectActivePasswordDate(password);
        else
            return null;
    }
*/

}
