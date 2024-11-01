package com.example.proyectocitas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Objects;

public class DashboardTerapeutaCitasController {

    @FXML
    private ImageView logoImageView, pacientesIcon, citasIcon, exportarIcon, searchIcon;

    @FXML
    private TextField searchField;

    @FXML
    private GridPane calendarGrid;

    public void initialize() {
        // Cargar imágenes en los iconos
        loadImage(logoImageView, "/com/example/proyectocitas/imagenes/CARO ISOTIPO LOTO CON DORADO PNG.png");
        loadImage(pacientesIcon, "/com/example/proyectocitas/imagenes/paciente.png");
        loadImage(citasIcon, "/com/example/proyectocitas/imagenes/calendar.png");
        loadImage(exportarIcon, "/com/example/proyectocitas/imagenes/exportar.png");
        loadImage(searchIcon, "/com/example/proyectocitas/imagenes/search.png");

        // Generar el calendario para el mes actual
        populateCalendar(LocalDate.now());
    }

    private void loadImage(ImageView imageView, String resourcePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(resourcePath)));
            imageView.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error: No se pudo cargar la imagen en la ruta " + resourcePath);
        }
    }

    private void populateCalendar(LocalDate date) {
        calendarGrid.getChildren().clear();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstOfMonth = yearMonth.atDay(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue(); // 1 = Monday, ..., 7 = Sunday

        int currentDay = 1;

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                VBox dayBox = new VBox(5); // Ajuste de espaciado interno
                dayBox.setPrefSize(100, 100); // Tamaño de cada día en el calendario
                dayBox.setStyle("-fx-border-color: #E0E0E0; -fx-background-color: #FFFFFF; -fx-padding: 10;");

                if (row == 0 && col < dayOfWeek - 1) {
                    // Espacios en blanco para los días antes del primer día del mes
                    dayBox.getChildren().add(new Label(""));
                } else if (currentDay <= daysInMonth) {
                    // Añadir el número de día
                    Label dayLabel = new Label(String.valueOf(currentDay));
                    dayLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
                    dayBox.getChildren().add(dayLabel);

                    // Aquí puedes agregar citas simuladas
                    Label appointmentLabel = new Label("Cita " + currentDay);
                    appointmentLabel.setStyle("-fx-text-fill: #5E4B96; -fx-font-size: 12px;");
                    dayBox.getChildren().add(appointmentLabel);

                    currentDay++;
                }

                calendarGrid.add(dayBox, col, row);
            }
        }
    }

}
