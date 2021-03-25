package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	
	List<String> dictionary;
	List<String> inputText;
	List<RichWord> paroleSbagliate;
	private RichWord rw;
	private String temptxt;
	String[] Atxt;
	
	public void loadDictionary (String lang) {
		if(lang.equals("Italian")) {
			dictionary = new ArrayList<String>();
			
			try {
		
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
			
				BufferedReader br = new BufferedReader(fr);
				
				String word;
				while((word= br.readLine())!=null) {
					this.dictionary.add(word);
				}
				
				br.close();
				fr.close();
			}
			catch(IOException e) {
				System.out.println("Errore nella lettura del file ");
			}
			
			
		}
		
	
		else {
			dictionary = new ArrayList<String>();
			try {
				FileReader fr = new FileReader("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while((word= br.readLine())!=null) {
					this.dictionary.add(word);
				}
				br.close();
				fr.close();
			}
			catch(IOException e) {
				System.out.println("Errore nella lettura del file ");
			}
		}
	}
	public List<String> getList(String txt){
		temptxt = txt.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]"," ");
    	System.out.println(txt);
    	Atxt = temptxt.split(" ");
    	
    	inputText = new ArrayList<String>();
    
    	
    	for(String s:Atxt) {
    		inputText.add(s.toLowerCase());
    	}
    	
    	return inputText;
		
	}
	
	public List<RichWord> spellCheckText(List<String> txt){
		paroleSbagliate = new ArrayList<RichWord>();
		for(String s :txt) {
			if(!this.dictionary.contains(s)) {
				paroleSbagliate.add(rw=new RichWord(s));
				rw.setControl(false);
			}
			
		}
		return paroleSbagliate;
		
		
		
	}
	
	
	
	
	
	
}
