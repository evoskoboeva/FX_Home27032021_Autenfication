package sample;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.ObjectReader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
//import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import sample.AutenficationCode.User;
import sample.AutenficationCode.Users;

import java.io.*;

public class ReportAllController extends RegistFormController {
    @FXML
    TextArea taReport;
    @FXML
    TextArea taJson;



    public void Report(ActionEvent actionEvent) throws IOException {
       // Main.users.Load();
        taReport.setText(Main.users.toString());

        Main.users.readJson();

       // System.out.println(Main.users);

        taJson.setText(Main.users.toString());





    }
}
