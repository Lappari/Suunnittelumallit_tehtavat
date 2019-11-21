package application;

import adapter.Pokemon;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;


public class MainViewController {

	private Controller controller;

	@FXML
	private TextArea consoleTextArea;
	@FXML
	private TableView<Pokemon> pokemonTable;
	@FXML
	private TableColumn<Pokemon, String> nameColumn;
	@FXML
	private TableColumn<Pokemon, Number> levelColumn;
	@FXML
	private TableColumn<Pokemon, String> expColumn;
	@FXML
	private TableColumn<Pokemon, Number> atkColumn;
	@FXML
	private TableColumn<Pokemon, Number> defColumn;
	@FXML
	private TableColumn<Pokemon, String> hpColumn;
	
	@FXML
	void initialize() {
		controller = new Controller(this);
		
		//Pokemon taulukon alustus
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().pokemonNameProperty());
		levelColumn.setCellValueFactory(cellData -> cellData.getValue().lvlProperty());
		expColumn.setCellValueFactory(cellData -> cellData.getValue().expProperty());
		atkColumn.setCellValueFactory(cellData -> cellData.getValue().atkProperty());
		defColumn.setCellValueFactory(cellData -> cellData.getValue().defProperty());
		hpColumn.setCellValueFactory(cellData -> cellData.getValue().hpProperty());
		
		pokemonTable.setItems(controller.getPokemons());
	}
	
	@FXML
	public void battleBtn() {
		controller.battle();
	}
	
	@FXML
	public void pikaBattleBtn() {
		controller.battlePika();
	}
	
	@FXML
	public void exitBtn() {
		System.exit(0);
	}
	
	@FXML
	public void printConsole(String txt) {
		consoleTextArea.appendText(txt);
	}
}
