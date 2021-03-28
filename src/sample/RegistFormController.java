package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.AutenficationCode.Password;
import sample.AutenficationCode.User;

import java.time.LocalDate;
import java.util.Date;

public class RegistFormController {
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField pswPassword;
    @FXML
    DatePicker dpToday;
    private LocalDate LocalDate;

    public void registerClick(ActionEvent actionEvent) {
        String login = txtLogin.getText();
        String password = pswPassword.getText();
        LocalDate localDate = dpToday.getValue();
        Main.users.add(new User(login, password, LocalDate));
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
}
