package sample.AutenficationCode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import sample.Main;

import java.io.*;
import java.util.ArrayList;

public class Users implements java.io.Serializable{
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)


    public ArrayList<User> users;

    public Users(ArrayList<User> users) {
        this.users = users;
    }


    public void readJson() throws IOException {
        JsonNode users = Main.objectMapper.readTree(new File("json_users.json"));

    }

    public void writeJson() throws IOException {
        Main.objectMapper.writeValue(new File("json_users.json"), users );
    }




    public void Clear()
    {
        this.users.clear();
    }
    public void Save()
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream("./user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            // out.flush();
            out.close();
            //fileOut.flush();
            fileOut.close();
            System.out.print("Serialized data is saved in file: " + "./user.ser ");
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void Load() {
        try {
            FileInputStream fileIn = new FileInputStream("./user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.users = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (
                IOException ex) {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
    }

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
        return this.users;
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
