/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dictionary dictionary;
	List<String> inputText;
	List<RichWord> ww;
	String txt;
	String wt="";
	String[] Atxt;
	private long tmp = 0;

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
    private Label lblNumeroErrori;

    @FXML
    void doClear(ActionEvent event) {
    	txtTranslate.clear();
    	txtWrong.clear();
    	comboLanguage.setValue("");
    	lblNumeroErrori.setText("");
    	ww.clear();
    	inputText.clear();
    	wt="";
    	
    }

    @FXML
    void doLanguegge(ActionEvent event) {
    	String lang = comboLanguage.getValue();
    	if(lang.equals("")) {
    		return;
    	}
    	else {
//    	System.out.println(lang);
    	this.dictionary.loadDictionary(lang);
    	}
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
//    	txt= txtTranslate.getText().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]"," ");
//    	System.out.println(txt);
//    	Atxt = txt.split(" ");
    	if(!comboLanguage.getValue().equals("")) {
	    	
	    	
	    	txt= txtTranslate.getText();
	    	inputText = new ArrayList<String>();
	    	inputText = this.dictionary.getList(txt);

//	    	SOLUZIONE PROPOSTA CON I STRING TOKEN MOLTO PIù OTTIMALE PERCHè 
//	    	NON VA AD IMPLEMENTARE UN METODO PER TRASFORMARE IN LISTA LA STRINGA DI TESTO ->(getList())
//	    		inputText = inputText.replaceAll("\n", " ");
//			inputText = inputText.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]]", "");
//			StringTokenizer st = new StringTokenizer(inputText, " ");
//			while (st.hasMoreTokens()) {
//				inputTextList.add(st.nextToken()); 
//			}
	    	
	    	
	    	ww = new LinkedList<RichWord>();
	    	
	//    	for(String s:Atxt) {
	//    		inputText.add(s.toLowerCase());
	//    	}
	    	tmp=System.nanoTime();
	    	ww=this.dictionary.spellCheckTextDicotomic(inputText);
	    	
	    	tmp= System.nanoTime()-tmp;
	    	for(RichWord s: ww) {
	    		wt=wt+ s.toString();
	    	}
	    	txtWrong.setText(wt);
	    	lblNumeroErrori.setText("text content N:"+ww.size()+" Error");
	    	textTemp.setText("Spell check completed in :"+tmp+" nanosecond");
    	}

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
		
		System.out.println("ciao");
		
	}
}



