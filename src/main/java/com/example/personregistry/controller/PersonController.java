package com.example.personregistry.controller;

import com.example.personregistry.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class PersonController {
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private Button addButton;
    @FXML private TextArea displayArea;

    private List<Person> people = new ArrayList<>();

    @FXML
    private void addPerson() {
        try {
            String name = nameField.getText();
            String surname = surnameField.getText();
            int age = Integer.parseInt(ageField.getText()); // Potential NumberFormatException

            Person person = new Person(name, surname, age);
            people.add(person);

            updateDisplay();
            clearFields();

        } catch (NumberFormatException e) {
            displayArea.setText("Invalid age. Please enter a number.");
        }
    }

    private void updateDisplay() {
        displayArea.clear(); // Clear previous content
        for (Person p : people) {
            displayArea.appendText(p.toString() + "\n");
        }
    }

    private void clearFields() {
        nameField.clear();
        surnameField.clear();
        ageField.clear();
    }
}
