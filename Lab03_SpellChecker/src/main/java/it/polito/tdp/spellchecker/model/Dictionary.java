package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<String> dictionary;
	List<String> inputText;
	List<RichWord> paroleSbagliate;
	private RichWord rw;
	private String temptxt;
	private Boolean contains;
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
					this.dictionary.add(word.toLowerCase());
				}
				br.close();
				fr.close();
			}
			catch(IOException e) {
				System.out.println("Errore nella lettura del file ");
			}
		}
	}
	
//	ALTERNATIVA DI CARICAMENTO PIù VELOCE E PIù INTERATTIVO !!!!!
//public boolean loadDictionary(String language) {
//		
//		
//		if (dizionario!=null && this.language.equals(language)){
//			return true;
//		}
//		
//		dizionario = new ArrayList<String>();
//		this.language = language;
//		
//		try {
//
//			FileReader fr = new FileReader("src/main/resources/" + language + ".txt");
//			BufferedReader br = new BufferedReader(fr);
//			String word;
//
//			while ((word = br.readLine()) != null) {
//				dizionario.add(word.toLowerCase());
//			}
//
//			Collections.sort(dizionario);
//
//			br.close();
//			System.out.println("Dizionario " + language + " loaded. Found " + dizionario.size() + " words.");
//			
//			return true;
//
//		} catch (IOException e) {
//			System.err.println("Errore nella lettura del file");
//			return false;
//		}
//
//		
//	}
	
	
	
	public List<String> getList(String txt){
		temptxt = txt.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]"," ");
//    	System.out.println(txt);
    	Atxt = temptxt.split(" ");
    	
    	inputText = new ArrayList<String>();
    
    	
    	for(String s:Atxt) {
    		inputText.add(s.toLowerCase());
    	}
    	
    	return inputText;
		
	}
	
	public List<RichWord> spellCheckText(List<String> txt){
		paroleSbagliate = new LinkedList<RichWord>();
		for(String s :txt) {
			if(!this.dictionary.contains(s)) {
				paroleSbagliate.add(rw=new RichWord(s));
				rw.setControl(false);
				
			}
			
		}
		return paroleSbagliate;	
	}
	
	public List<RichWord>spellCheckTextLinear(List<String>txt){
		paroleSbagliate = new ArrayList<RichWord>();
		for(String s :txt) {
//			int id =0;
			contains=false;
			
			for(int i =0;i<dictionary.size()&&!contains;i++) {
				if(dictionary.get(i).equals(s)) 
					contains=true;
				
//				id=Collections.binarySearch(dictionary,s);
			}
			if(!contains) {
				paroleSbagliate.add(rw=new RichWord(s));
				rw.setControl(false);
				
			}
			
			
			

			
			
		}
		return paroleSbagliate;
	
	
	
	}	
	public List<RichWord>spellCheckTextDicotomic(List<String>txt){
		paroleSbagliate = new LinkedList<RichWord>();
		for(String s :txt) {
			int idtop =dictionary.size();
			int idbot = 0;

	
			contains=false;
			
			for( int i= dictionary.size()/2 ;i<idtop&&i>=idbot&&!contains;i++) {
				if(dictionary.get(i).equals(s)) 
					contains=true;
				else {
					if(dictionary.get(i).compareTo(s)<0) {
						idbot=i;
						i=(idtop-idbot)/2;
						
					}
					else {
						idtop=i;
						i=(idtop-idbot)/2;
					}
				}
				
//				id=Collections.binarySearch(dictionary,s);
			}
			if(!contains) {
				paroleSbagliate.add(rw=new RichWord(s));
				rw.setControl(false);
				
			}
	
		}
		return paroleSbagliate;
	}
}
