package sample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AutenficationCode.Password;
import sample.AutenficationCode.Passwords;
import sample.AutenficationCode.User;
import sample.AutenficationCode.Users;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {

    public static ObjectMapper objectMapper = new ObjectMapper() .
            configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);;

    public  static Users users = new Users();
    static SaveClass saveClass;

    @Override
    public void stop(){
        //Main.users.Save();
         saveClass = new SaveClass();
         saveClass.start();

    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.styleProperty().setValue(" -fx-background-color: white;  -fx-border-color: white; -fx-border-width: 7px;");

        primaryStage.setTitle("Hello User))");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        User user = new User("qwerty", "Password.123");
        /*user.getPasswords().add("Password.456");
        user.getPasswords().add("Password.789");
        users.add(user);
        users.add(new User("asdfg","password_1Q"));
        users.add(new User("login",""));
        System.out.println(users.getUsers().size());
*/
        Main.users.Load();
        System.out.println(users);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
