import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment14 extends Application {

    private ComboBox<String> conversionTypeComboBox;
    private TextField inputField;
    private TextField resultField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Converter");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        Label conversionTypeLabel = new Label("Conversion Type:");
        GridPane.setConstraints(conversionTypeLabel, 0, 0);

        conversionTypeComboBox = new ComboBox<>();
        conversionTypeComboBox.getItems().addAll("Kilometers to Miles", "Celsius to Fahrenheit", "Ounces to Pounds");
        conversionTypeComboBox.setValue("Kilometers to Miles"); // Default value
        GridPane.setConstraints(conversionTypeComboBox, 1, 0);

        Label inputLabel = new Label("Input:");
        GridPane.setConstraints(inputLabel, 0, 1);

        inputField = new TextField();
        GridPane.setConstraints(inputField, 1, 1);

        Button convertButton = new Button("Convert");
        convertButton.setOnAction(e -> convert());
        GridPane.setConstraints(convertButton, 1, 2);

        Label resultLabel = new Label("Result:");
        GridPane.setConstraints(resultLabel, 0, 3);

        resultField = new TextField();
        resultField.setEditable(false);
        GridPane.setConstraints(resultField, 1, 3);

        grid.getChildren().addAll(conversionTypeLabel, conversionTypeComboBox, inputLabel, inputField, convertButton, resultLabel, resultField);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void convert() {
        try {
            String conversionType = conversionTypeComboBox.getValue();
            double inputValue = Double.parseDouble(inputField.getText());
            double result = 0.0;

            switch (conversionType) {
                case "Kilometers to Miles":
                    result = convertKilometersToMiles(inputValue);
                    break;
                case "Celsius to Fahrenheit":
                    result = convertCelsiusToFahrenheit(inputValue);
                    break;
                case "Ounces to Pounds":
                    result = convertOuncesToPounds(inputValue);
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
        }
    }

    private double convertKilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    private double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double convertOuncesToPounds(double ounces) {
        return ounces / 16;
    }
}
