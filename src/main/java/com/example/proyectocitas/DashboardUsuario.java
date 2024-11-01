package com.example.proyectocitas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardUsuario {

    // FXML components for adding a new patient
    @FXML
    private TextField nombreTextField;
    @FXML
    private TextField apellidoTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField telefonoTextField;
    @FXML
    private Button agregarPacienteButton;

    // FXML components for scheduling an appointment
    @FXML
    private TextField pacienteTextField;
    @FXML
    private DatePicker fechaDatePicker;
    @FXML
    private TextField horaTextField;
    @FXML
    private Button agendarCitaButton;

    // FXML components for the appointments table
    @FXML
    private TableView<Cita> appointmentsTable;
    @FXML
    private TableColumn<Cita, String> colPaciente;
    @FXML
    private TableColumn<Cita, String> colFecha;
    @FXML
    private TableColumn<Cita, String> colHora;

    // Data model for appointments
    private ObservableList<Cita> citasList;

    @FXML
    public void initialize() {
        // Initialize appointments list
        citasList = FXCollections.observableArrayList();
        appointmentsTable.setItems(citasList);

        // Set up table columns
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));

        // Set button actions
        agregarPacienteButton.setOnAction(event -> agregarPaciente());
        agendarCitaButton.setOnAction(event -> agendarCita());
    }

    // Method to handle adding a new patient
    private void agregarPaciente() {
        String nombre = nombreTextField.getText();
        String apellido = apellidoTextField.getText();
        String email = emailTextField.getText();
        String telefono = telefonoTextField.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty()) {
            showAlert("Error", "Todos los campos son obligatorios para agregar un paciente.");
        } else {
            showAlert("Éxito", "Paciente agregado correctamente: " + nombre + " " + apellido);
            // Clear fields after adding
            nombreTextField.clear();
            apellidoTextField.clear();
            emailTextField.clear();
            telefonoTextField.clear();
        }
    }

    // Method to handle scheduling an appointment
    private void agendarCita() {
        String paciente = pacienteTextField.getText();
        String fecha = (fechaDatePicker.getValue() != null) ? fechaDatePicker.getValue().toString() : "";
        String hora = horaTextField.getText();

        if (paciente.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
            showAlert("Error", "Todos los campos son obligatorios para agendar una cita.");
        } else {
            Cita nuevaCita = new Cita(paciente, fecha, hora);
            citasList.add(nuevaCita);
            showAlert("Éxito", "Cita agendada correctamente para: " + paciente);
            // Clear fields after adding
            pacienteTextField.clear();
            fechaDatePicker.setValue(null);
            horaTextField.clear();
        }
    }

    // Utility method to show alerts
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Class to represent an appointment
    public static class Cita {
        private String paciente;
        private String fecha;
        private String hora;

        public Cita(String paciente, String fecha, String hora) {
            this.paciente = paciente;
            this.fecha = fecha;
            this.hora = hora;
        }

        public String getPaciente() {
            return paciente;
        }

        public String getFecha() {
            return fecha;
        }

        public String getHora() {
            return hora;
        }
    }
}
