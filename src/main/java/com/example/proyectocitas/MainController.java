package com.example.proyectocitas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    private ImageView logoImageView;
    @FXML
    private ImageView pacientesIcon;
    @FXML
    private ImageView citasIcon;
    @FXML
    private ImageView exportarIcon;

    @FXML
    private Button pacientesButton;
    @FXML
    private Button citasButton;
    @FXML
    private Button exportarButton;

    @FXML
    private StackPane contentPane;

    public void initialize() {
        // Cargar iconos de la barra lateral
        loadImage(logoImageView, "/com/example/proyectocitas/imagenes/CARO ISOTIPO LOTO CON DORADO PNG.png");
        loadImage(pacientesIcon, "/com/example/proyectocitas/imagenes/paciente.png");
        loadImage(citasIcon, "/com/example/proyectocitas/imagenes/calendar.png");
        loadImage(exportarIcon, "/com/example/proyectocitas/imagenes/exportar.png");

        // Cargar la vista de "Pacientes" como vista predeterminada
        loadView("DASHBOAR-TERAPEUTA-PACIENTE.fxml");
    }

    private void loadImage(ImageView imageView, String resourcePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));
            imageView.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo cargar la imagen en la ruta " + resourcePath);
        }
    }

    private void loadView(String fxmlFile) {
        try {
            Node view = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlFile)));
            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handlePacientes() {
        loadView("DASHBOAR-TERAPEUTA-PACIENTE.fxml");
    }

    @FXML
    private void handleCitas() {
        loadView("DASHBOAR-TERAPEUTA-CITAS.fxml");
    }

    @FXML
    private void handleExportar() {
        loadView("DASHBOAR-TERAPEUTA-EXPORT.fxml");
    }
}
