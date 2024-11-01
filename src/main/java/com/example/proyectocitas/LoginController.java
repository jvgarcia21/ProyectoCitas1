package com.example.proyectocitas;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LoginController {

    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        // Cargar la imagen desde la ruta proporcionada
        Image image = new Image("file:C:/Users/javie/Desktop/proyectopob/ProyectoCitas/src/main/resources/imagenes/CAROLINA MORENO LOGO RENOVADO PNG 01");
        imageView.setImage(image);
    }
}