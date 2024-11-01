package com.example.proyectocitas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Cambia el nombre del archivo FXML a "DASHBOAR-TERAPEUTA-PACIENTE.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DASHBOAR-TERAPEUTA-PACIENTE.fxml"));

        // Ajusta el tamaño de la ventana según lo que necesitas para la vista
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

        // Cambia el título de la ventana
        stage.setTitle("Vista de Pacientes");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
