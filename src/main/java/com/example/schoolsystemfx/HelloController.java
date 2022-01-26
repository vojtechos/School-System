package com.example.schoolsystemfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ComboBox<Integer> gradeComboBox;

    @FXML
    private ComboBox<Double> gradeValueComboBox;

    @FXML
    private ComboBox<String> selectOperation;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.gradeComboBox.getItems().addAll(new Integer[]{1,2,3,4,5});
        this.gradeValueComboBox.getItems().addAll(new Double[]{0.2,0.4,0.6,0.8,1.0});
        this.selectOperation.getItems().addAll(new String[]{"Vytvořit žáka, Editovat žáka, Vymazat žáka"});

    }

    public void showDialog(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("edit-dialog.fxml"));
        Parent parent = fxmlLoader.load();
        EditDialogController dialogController = fxmlLoader.<EditDialogController>getController();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
    }
}