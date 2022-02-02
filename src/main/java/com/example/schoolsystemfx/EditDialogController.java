package com.example.schoolsystemfx;


import com.example.schoolsystemfx.model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditDialogController  {

    private static String name;
    private static String clazz;
    private static String lastName;

    @FXML
    public TextArea firstNameArea;

    @FXML
    public TextArea lastNameArea;

    @FXML
    public TextArea clazzArea;

    @FXML
    public Button saveAndExit;

    @FXML
    public Button exit;

    @FXML
    public void exitDialog(MouseEvent mouseEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void saveAndExitDialog(MouseEvent mouseEvent) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();

        setName(firstNameArea.getText());
        setLastName(lastNameArea.getText());
        setClazz(clazzArea.getText());
    }

    public void prepareStudentForm(Student student) {
        firstNameArea.setText(student.getFirstName());
        lastNameArea.setText(student.getSurname());
        clazzArea.setText(student.getClazz());
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        EditDialogController.name = name;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        EditDialogController.lastName = lastName;
    }

    public static String getClazz() {
        return clazz;
    }

    public static void setClazz(String clazz) {
        EditDialogController.clazz = clazz;
    }
}
