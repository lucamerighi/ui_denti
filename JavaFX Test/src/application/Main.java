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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		// Left
		Text data = new Text("Data: ");
		DatePicker datePicker = new DatePicker(LocalDate.now());
		VBox boxData = new VBox(10);
		boxData.getChildren().addAll(data, datePicker);

		Text durata = new Text("Durata: ");
		Spinner<Integer> spinnerDurata = new Spinner<Integer>(0, 100, 0, 5);
		VBox boxDurata = new VBox(10);
		boxDurata.getChildren().addAll(durata, spinnerDurata);		

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
		inserisciBtn.setAlignment(Pos.BOTTOM_RIGHT);		

		VBox boxDataAtt = new VBox(10);
		boxDataAtt.getChildren().addAll(boxData, boxAttività);
		
		VBox boxDurataInt = new VBox(10);
		boxDurataInt.getChildren().addAll(boxDurata, boxIntensità, inserisciBtn);

		HBox leftBox = new HBox(20);
		leftBox.getChildren().addAll(boxDataAtt, boxDurataInt);
		

		root.setLeft(leftBox);
		BorderPane.setMargin(leftBox, new Insets(10));

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
