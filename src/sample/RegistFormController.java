package sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.AutenficationCode.Password;
import sample.AutenficationCode.User;
import sample.AutenficationCode.Users;

import java.io.File;
import java.io.IOException;

public class RegistFormController {
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField pswPassword;



    public void registerClick(ActionEvent actionEvent) throws IOException {

        String login = txtLogin.getText();
        String password = pswPassword.getText();
        User user = new User(login,password);


        Main.users.add(user);
        //Main.users.Save();
        //Main.users.Clear();
        //Jackson library serialization

        Main.users.writeJson();


        if (!Password.isValid(password)){
            Alert alert123 = new Alert(Alert.AlertType.ERROR);
            alert123.setTitle("invalid password");
            alert123.setHeaderText("Your password must be at least 8 symbols and contain: numbers," +
                    " characters -/., at least one large and one small letter");
            alert123.setContentText("enter new password please");
            alert123.showAndWait().ifPresent(rs->{
                if (rs== ButtonType.OK) {
                    System.out.println("Pressed OK");
                }
            });
        }
        else{

            Alert alert123 = new Alert(Alert.AlertType.INFORMATION);
            alert123.setTitle("good password - registration ok");
            alert123.showAndWait().ifPresent(rs->{
                if (rs== ButtonType.OK) {
                    System.out.println("Pressed OK");
                }
            });


        }
        }



    public void cancelClick(ActionEvent actionEvent) {
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("operation cancel");
        alert1.setHeaderText("info dialog");
        alert1.setContentText("your oreration cancelled");
        alert1.showAndWait().ifPresent(rs->{
            if (rs== ButtonType.OK) {
                System.out.println("Pressed OK");
            }
        });
    }

    public void ReportALL(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ReportAll.fxml"));
        Stage stage = new Stage();
        stage.setTitle("reports form");
        stage.setScene(new Scene(root));
        root.styleProperty().setValue(" -fx-background-color: white;  -fx-border-color: white; -fx-border-width: 7px;");

        stage.show();
    }
}
