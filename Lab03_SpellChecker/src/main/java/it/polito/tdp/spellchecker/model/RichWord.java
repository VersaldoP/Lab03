package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	public String word;
	public boolean control;
	public RichWord(String word) {
		super();
		this.word = word;
		this.control= true;
	}
	
	
	public void setControl(boolean control) {
		this.control = control;
	}


	@Override
	public String toString() {
		return " " + word + "\n";
	}
	
}
