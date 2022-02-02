package com.example.schoolsystemfx;

import com.example.schoolsystemfx.model.Grade;
import com.example.schoolsystemfx.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {

    @FXML
    private ComboBox<Integer> gradeComboBox;

    @FXML
    private ComboBox<Double> gradeValueComboBox;

    @FXML
    private ComboBox<String> selectOperation;

    @FXML
    private ListView<String> studentsList;

    @FXML
    public ListView<Integer> gradesList;

    @FXML
    private Label SelectedStudent;

    private Map<String, Student> students;

    public HelloController() {
        this.students = new HashMap<>();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.gradeComboBox.getItems().addAll(new Integer[]{1,2,3,4,5});
        this.gradeValueComboBox.getItems().addAll(new Double[]{0.2,0.4,0.6,0.8,1.0});
        this.selectOperation.getItems().addAll(new String[]{"Vytvořit žáka", "Editovat žáka", "Vymazat žáka"});

    }

    public void showDialog(MouseEvent mouseEvent) throws IOException {
        String opration = selectOperation.getSelectionModel().getSelectedItem();
        switch (opration) {
            case "Vytvořit žáka" -> createStudent();
            case "Editovat žáka" -> updateStudent();
            case "Vymazat žáka" -> deleteStudent();
        }


    }

    private void deleteStudent() {
        int index = studentsList.getSelectionModel().getSelectedIndex();
        studentsList.getItems().remove(index);

    }

    private void updateStudent() throws IOException {
        String studentKey = studentsList.getSelectionModel().getSelectedItem();
        Student editStudent = students.get(studentKey);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("edit-dialog.fxml"));
        Parent parent = fxmlLoader.load();
        EditDialogController dialogController = fxmlLoader.<EditDialogController>getController();
        dialogController.prepareStudentForm(editStudent);
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        String name = EditDialogController.getName();
        String lastName = EditDialogController.getLastName();
        String clazz = EditDialogController.getClazz();

        editStudent.setFirstName(name);
        editStudent.setSurname(lastName);
        editStudent.setClazz(clazz);

        int index = studentsList.getSelectionModel().getSelectedIndex();
        studentKey = name + " " + lastName + " " + clazz;
        studentsList.getItems().remove(index);
        studentsList.getItems().add(studentKey);

    }

    private void createStudent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("edit-dialog.fxml"));
        Parent parent = fxmlLoader.load();
        EditDialogController dialogController = fxmlLoader.<EditDialogController>getController();

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        String name = EditDialogController.getName();
        String lastName = EditDialogController.getLastName();
        String clazz = EditDialogController.getClazz();

        Student student = new Student();
        student.setGradeList(new LinkedList<>());
        student.setFirstName(name);
        student.setSurname(lastName);
        student.setClazz(clazz);

        String studentKey = name + " " + lastName + " " + clazz;
        studentsList.getItems().add(studentKey);
        students.put(studentKey, student);
    }

    @FXML
    public void onStudentSelected(MouseEvent mouseEvent){

        String selectedStudent = studentsList.getSelectionModel().getSelectedItem();
        SelectedStudent.setText(selectedStudent);

    }
}