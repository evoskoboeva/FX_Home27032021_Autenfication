package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.AutenficationCode.Password;
import sample.AutenficationCode.Passwords;
import sample.AutenficationCode.User;
import sample.AutenficationCode.Users;

import java.time.LocalDate;

public class Main extends Application {

    public  static Users users = new Users();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.styleProperty().setValue(" -fx-background-color: white;  -fx-border-color: white; -fx-border-width: 7px;");

        primaryStage.setTitle("Hello User))");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        User user = new User("qwerty", "Password.123", LocalDate.of(2021, 01, 01));
        user.getPasswords().add("Password.456", LocalDate.of(2021,01,20));
        user.getPasswords().add("Password.789",LocalDate.of(2021, 01, 31));

        users.add(user);
        users.add(new User("asdfg","password_1Q",LocalDate.of(2021,02,01)));
        users.add(new User("login","",LocalDate.of(2021,02,02)));


        System.out.println(users);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
