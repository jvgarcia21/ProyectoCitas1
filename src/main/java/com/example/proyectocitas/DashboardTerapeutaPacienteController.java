package com.example.proyectocitas;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class DashboardTerapeutaPacienteController {

    @FXML
    private ImageView logoImageView;

    @FXML
    private ImageView pacientesIcon;

    @FXML
    private ImageView citasIcon;

    @FXML
    private ImageView exportarIcon;

    @FXML
    private Label menuLabel;

    @FXML
    private Button pacientesButton;

    @FXML
    private Button citasButton;

    @FXML
    private Button exportarButton;

    @FXML
    private TextField searchField;

    @FXML
    private GridPane patientGrid;

    public void initialize() {
        // Aplicar estilos para el menú y los botones
        menuLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: #5E4B96; -fx-font-weight: bold;");
        pacientesButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #5E4B96; -fx-font-size: 16px;");
        citasButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #5E4B96; -fx-font-size: 16px;");
        exportarButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #5E4B96; -fx-font-size: 16px;");

        // Cargar íconos en los botones
        loadImage(logoImageView, "/com/example/proyectocitas/imagenes/CARO ISOTIPO LOTO CON DORADO PNG.png");
        loadImage(pacientesIcon, "/com/example/proyectocitas/imagenes/paciente.png");
        loadImage(citasIcon, "/com/example/proyectocitas/imagenes/calendar.png");
        loadImage(exportarIcon, "/com/example/proyectocitas/imagenes/exportar.png");

        // Crear tarjetas de ejemplo de pacientes
        for (int i = 0; i < 6; i++) {
            VBox patientCard = createPatientCard(
                    "Nombre del Paciente " + (i + 1),
                    "Edad - Ocupación",
                    "Última cita: 15/12/2024",
                    "Próxima cita: 25/01/2025"
            );
            patientGrid.add(patientCard, i % 3, i / 3);
        }
    }

    private void loadImage(ImageView imageView, String resourcePath) {
        // Cargar la imagen y manejar posibles errores
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));
            imageView.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo cargar la imagen en la ruta " + resourcePath);
        }
    }

    private VBox createPatientCard(String name, String info, String lastAppointment, String nextAppointment) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #E0E0E0; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        // Imagen de perfil (usando el nombre de archivo correcto para el perfil)
        Image profileImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/proyectocitas/imagenes/persona.png")));
        ImageView profileImageView = new ImageView(profileImage);
        profileImageView.setFitWidth(50);
        profileImageView.setFitHeight(50);

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label infoLabel = new Label("Información: " + info);
        Label lastAppointmentLabel = new Label(lastAppointment);
        Label nextAppointmentLabel = new Label(nextAppointment);

        card.getChildren().addAll(profileImageView, nameLabel, infoLabel, lastAppointmentLabel, nextAppointmentLabel);
        return card;
    }
}
