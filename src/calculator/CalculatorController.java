package calculator;

import java.util.ArrayList;
import java.util.ListIterator;

import calculator.model.CalculatorModel;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CalculatorController {

	boolean history = false;

	@FXML
	private CheckBox selectNewOrOld;

	@FXML
	private TextArea editHystory;

	@FXML
	private Pane panelMain, panelHistory;

	@FXML
	private TextField editResult;

	@FXML
	private Button checkHystory;
	
	
	private CalculatorModel model = new CalculatorModel();

	AnimationTimer timer = new AnimationTimer() {

		@Override
		public void handle(long now) {
			if (history) {
				if (panelMain.getLayoutX() < 280) {
					panelMain.setLayoutX(panelMain.getLayoutX() + 20);
					panelHistory.setLayoutX(panelHistory.getLayoutX() + 20);
				} else {
					checkHystory.setText("<");
					this.stop();
				}

			} else {
				if (panelMain.getLayoutX() > 0) {
					panelMain.setLayoutX(panelMain.getLayoutX() - 20);
					panelHistory.setLayoutX(panelHistory.getLayoutX() - 20);
				} else {
					checkHystory.setText(">");
					this.stop();
				}
			}
		}
	};


	@FXML
	void ClickButtonHistory(ActionEvent event) {
		history = (history) ? false : true;
		setEditHistory();
		this.timer.start();
	}

	@FXML
	void setEditHistory() {
		if (selectNewOrOld.isSelected()) {
			ArrayList<String> values = model.getHistory();
			ListIterator<String> listIterator = values.listIterator(values.size());
			editHystory.clear();
			while (listIterator.hasPrevious()) {
				editHystory.appendText(listIterator.previous() + "\n");
			}
		} else {
			ArrayList<String> values = model.getHistory();
			editHystory.clear();
			for (String value : values) {
				editHystory.appendText(value + "\n");
			}
		}
	}

	@FXML
	void ClickButtonNumber(ActionEvent event) {
		model.setValue(((Button) event.getSource()).getText());
		editResult.setText(model.getText());
	}

	@FXML
	void ClickButtonOperation(ActionEvent event) {
		model.setOperation(((Button) event.getSource()).getText());
		editResult.setText(model.getText());
	}

	@FXML
	void ClickButtonResult(ActionEvent event) {
		editResult.setText(model.getCalculation());
	}

	@FXML
	void ClickButtonClearEditResult(ActionEvent event) {
		model.clearModel();
		editResult.setText(model.getText());
	}

}
