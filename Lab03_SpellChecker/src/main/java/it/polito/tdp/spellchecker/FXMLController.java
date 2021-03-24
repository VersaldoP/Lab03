/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboLanguage;

    @FXML
    private TextArea txtTranslate;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Button btcClear;

    @FXML
    private Label textTemp;

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doLanguegge(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert comboLanguage != null : "fx:id=\"comboLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTranslate != null : "fx:id=\"txtTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btcClear != null : "fx:id=\"btcClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert textTemp != null : "fx:id=\"textTemp\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Dictionary model) {
		// TODO Auto-generated method stub
		
		this.dictionary = model;
		comboLanguage.getItems().addAll("English", "Italian");

		
	}
}



