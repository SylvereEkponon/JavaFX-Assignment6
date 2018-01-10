import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

	private TextField firstNumberTxt = new TextField();
	private TextField secondNumberTxt = new TextField();
	private TextField resultTxt = new TextField();
	
	private Label firstNumberLabel = new Label("Enter no. 1:");
	private Label secondNumberLabel = new Label("Enter n0. 2:");
	private Label resultLabel = new Label("Result:");
	
	private RadioButton addButton = new RadioButton("Add");
	private RadioButton substractButton = new RadioButton("Substract");
	private RadioButton multiplicationeButton = new RadioButton("Multiple");
	private RadioButton divideButton = new RadioButton("Divide");
	
	private Button calculateButton = new Button("Calculate");
	
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ToggleGroup radioButtonGroup = new ToggleGroup();
		addButton.setToggleGroup(radioButtonGroup);
		substractButton.setToggleGroup(radioButtonGroup);
		multiplicationeButton.setToggleGroup(radioButtonGroup);
		divideButton.setToggleGroup(radioButtonGroup);
		
		GridPane gridpane = new GridPane();
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		gridpane.add(firstNumberLabel,0,0);
		gridpane.add(firstNumberTxt, 1, 0);
		gridpane.add(secondNumberLabel, 0, 1);
		gridpane.add(secondNumberTxt, 1, 1);
		gridpane.add(addButton, 0, 2);
		gridpane.add(substractButton, 1, 2);
		gridpane.add(multiplicationeButton, 0, 3);
		gridpane.add(divideButton, 1, 3);
		gridpane.add(resultLabel, 0, 4);
		gridpane.add(resultTxt, 1, 4);
		gridpane.add(calculateButton, 1, 5);
		
		gridpane.setAlignment(Pos.CENTER);
		resultTxt.setEditable(false);
		GridPane.setHalignment(calculateButton, HPos.RIGHT);
		firstNumberTxt.setAlignment(Pos.BOTTOM_RIGHT);
		secondNumberTxt.setAlignment(Pos.BOTTOM_RIGHT);
		substractButton.setAlignment(Pos.BOTTOM_RIGHT);
		divideButton.setAlignment(Pos.BOTTOM_RIGHT);
		resultTxt.setAlignment(Pos.BOTTOM_RIGHT);
		
		calculateButton.setOnAction(e -> calculate());


		
		
		
		Scene scene = new Scene(gridpane,300,300);
		primaryStage.setTitle("CENTENNIAL JAVAFX CALCULATOR");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

	private void calculate() {
		
		int number1 = Integer.parseInt(firstNumberTxt.getText());
		int number2 = Integer.parseInt(secondNumberTxt.getText());
		double result=0.0;
		
		if (addButton.isSelected()) {
			
			result = number1 + number2;
			resultTxt.setText(String.format("%.2f", result));
			
		}
		else if (substractButton.isSelected()) {
			result = number1 - number2;
			resultTxt.setText(String.format("%.2f", result));
			
		}
		else if (multiplicationeButton.isSelected()) {
			result = number1 * number2;
			resultTxt.setText(String.format("%.2f", result));
		}
		else if(divideButton.isSelected()){
			if (number2!=0) {
				result = number1/number2;
				resultTxt.setText(String.format("%.2f", result));
			}
			
		}

	}

}
