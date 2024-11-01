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

public class DashboardTerapeutaExportController {

    @FXML
    private ImageView logoImageView, pacientesIcon, citasIcon, exportarIcon, searchIcon;

    @FXML
    private TextField searchField;

    @FXML
    private GridPane exportGrid;

    public void initialize() {
        // Cargar íconos en los elementos del menú
        loadImage(logoImageView, "/com/example/proyectocitas/imagenes/CARO ISOTIPO LOTO CON DORADO PNG.png");
        loadImage(pacientesIcon, "/com/example/proyectocitas/imagenes/paciente.png");
        loadImage(citasIcon, "/com/example/proyectocitas/imagenes/calendar.png");
        loadImage(exportarIcon, "/com/example/proyectocitas/imagenes/exportar.png");
        loadImage(searchIcon, "/com/example/proyectocitas/imagenes/search.png");

        // Generar tarjetas de exportación de ejemplo
        for (int i = 0; i < 6; i++) {
            VBox exportCard = createExportCard(
                    "Nombre del Paciente " + (i + 1),
                    "Edad - Ocupación",
                    "Última cita: 15/12/2024",
                    "Próxima cita: 25/01/2025"
            );
            exportGrid.add(exportCard, i % 3, i / 3);
        }
    }

    private void loadImage(ImageView imageView, String resourcePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));
            imageView.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo cargar la imagen en la ruta " + resourcePath);
        }
    }

    private VBox createExportCard(String name, String info, String lastAppointment, String nextAppointment) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #E0E0E0; -fx-border-radius: 5px; -fx-background-radius: 5px;");

        // Imagen de perfil
        Image profileImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/proyectocitas/imagenes/persona.png")));
        ImageView profileImageView = new ImageView(profileImage);
        profileImageView.setFitWidth(50);
        profileImageView.setFitHeight(50);

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label infoLabel = new Label("Información: " + info);
        Label lastAppointmentLabel = new Label(lastAppointment);
        Label nextAppointmentLabel = new Label(nextAppointment);

        // Ícono de exportación
        Image exportIcon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/proyectocitas/imagenes/exportar.png")));
        ImageView exportIconView = new ImageView(exportIcon);
        exportIconView.setFitWidth(20);
        exportIconView.setFitHeight(20);
        Button exportButton = new Button();
        exportButton.setGraphic(exportIconView);
        exportButton.setStyle("-fx-background-color: transparent;");

        // Acción de exportación
        exportButton.setOnAction(event -> exportPatientData(name));

        // Agregar elementos al card
        card.getChildren().addAll(profileImageView, nameLabel, infoLabel, lastAppointmentLabel, nextAppointmentLabel, exportButton);
        return card;
    }

    private void exportPatientData(String patientName) {
        // Aquí iría la lógica para exportar los datos del paciente
        System.out.println("Exportando datos del paciente: " + patientName);
    }
}
