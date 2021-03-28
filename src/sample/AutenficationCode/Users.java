package sample.AutenficationCode;

import sample.Main;

import java.time.LocalDate;
import java.util.ArrayList;

public class Users {
    private ArrayList<User>users;


    public boolean add(User user){
        for(User user1:users){
            if(user1.getLogin().equals(user.getLogin())){
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        String result = "Users:\n";
        for (User user:users) {
            result += user+System.lineSeparator();

        }
        return result;
    }

    public Users() {
        users = new ArrayList<User>();

    }



    public boolean isRegestered(String login,String password){
        for(User user : users) {
            if (user.getLogin().equals(login) && user.getPasswords().isCorrectActivePassword(password))
                return true;
        }
                return false;

    }



}
