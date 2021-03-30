package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.AutenficationCode.User;

import java.io.IOException;
import java.time.LocalDate;

public class MainController {
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField pswPassword;
    @FXML
    TextField txtDate;

    public void loginClick(ActionEvent actionEvent) {
        String login = txtLogin.getText();
        String password = pswPassword.getText();
        if (Main.users.isRegestered(login, password)){
           // txtDate.setText(Main.users.isRegesteredDate(login, password).toString());

            //System.out.println("Registered");

           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("user registration check");
            alert.setHeaderText("info dialog");
            alert.setContentText("user found. change your password?");
            alert.showAndWait().ifPresent(rs->{
                /*if (rs== ButtonType.OK) {
                    try {
                        ChangePass();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                */if (rs== ButtonType.OK) {
                    System.out.println("Pressed OK");
                }
            });
        }
        else {
            //System.out.println("not registered");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("user registration check");
            alert.setHeaderText("info dialog");
            alert.setContentText("user or password not found");
            alert.showAndWait().ifPresent(rs->{
                if (rs== ButtonType.OK) {
                    System.out.println("Pressed OK");
                }
            });
        }
    }

    private void ChangePass() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChangePassForm.fxml"));
        Stage stage = new Stage();
        stage.setTitle(" change password form");
        stage.setScene(new Scene(root, 300, 275));
        root.styleProperty().setValue(" -fx-background-color: white;  -fx-border-color: white; -fx-border-width: 7px;");

        stage.show();
    }

    /*public void ChangePass(ActionEvent actionEvent) throws IOException{

    }*/
    public void Registr(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RegistForm.fxml"));
        Stage stage = new Stage();
        stage.setTitle("user registration form");
        stage.setScene(new Scene(root, 300, 275));
        root.styleProperty().setValue(" -fx-background-color: white;  -fx-border-color: white; -fx-border-width: 7px;");

        stage.show();
    }


}
