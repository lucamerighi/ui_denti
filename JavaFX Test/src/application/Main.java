package application;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		// Top
		Text data = new Text("Data: ");
		DatePicker datePicker = new DatePicker(LocalDate.now());
		VBox boxData = new VBox(10);
		boxData.getChildren().addAll(data, datePicker);

		Text durata = new Text("Durata: ");
		Spinner<Integer> spinnerDurata = new Spinner<Integer>(0, 100, 0, 5);
		VBox boxDurata = new VBox(10);
		boxDurata.getChildren().addAll(durata, spinnerDurata);

		HBox dataDurata = new HBox(20);
		dataDurata.getChildren().addAll(boxData, boxDurata);

		Text attività = new Text("Attività: ");
		ComboBox comboAttività = new ComboBox<String>(FXCollections.observableArrayList("Attività a corpo libero"));
		comboAttività.getSelectionModel().selectFirst();
		VBox boxAttività = new VBox(10);
		boxAttività.getChildren().addAll(attività, comboAttività);

		Text intensità = new Text("Intensità: ");
		ComboBox comboIntensità = new ComboBox<String>(FXCollections.observableArrayList("HIGH", "MEDIUM", "LOW"));
		comboIntensità.getSelectionModel().selectFirst();
		VBox boxIntensità = new VBox(10);
		boxIntensità.getChildren().addAll(intensità, comboIntensità);

		Button inserisciBtn = new Button("Inserisci");

		HBox boxAttInt = new HBox(30);
		boxAttInt.getChildren().addAll(boxAttività, boxIntensità);

		VBox topBox = new VBox(20);
		topBox.getChildren().addAll(dataDurata, boxAttInt);
		

		root.setTop(topBox);
		BorderPane.setMargin(topBox, new Insets(10));

		String cssLayout = "-fx-border-color: red;\n" + "-fx-border-insets: 5;\n" + "-fx-border-width: 3;\n"
				+ "-fx-border-style: dashed;\n";

//		topBox.setStyle(cssLayout);
//		boxAttInt.setStyle(cssLayout);
//		boxIntensità.setStyle(cssLayout);
//		boxAttività.setStyle(cssLayout);
//		boxDurata.setStyle(cssLayout);
//		boxData.setStyle(cssLayout);
//		dataDurata.setStyle(cssLayout);

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
