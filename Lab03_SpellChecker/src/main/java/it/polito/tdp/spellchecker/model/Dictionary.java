package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Dictionary {
	
	List<String> dictionary;
	List<String> inputText;
	List<RichWord> paroleSbagliate;
	
	public void loadDictionary (String lang) {
		if(lang.equals("Italian")) {
			
			try {
				System.out.println("Exit read");
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				System.out.println("Exit read");
				BufferedReader br = new BufferedReader(fr);
				System.out.println("Exit buffer");
				String word;
				while((word= br.readLine())!=null) {
					this.dictionary.add(word);
				}
				System.out.println("Exit post-while");
				br.close();
				fr.close();
			}
			catch(IOException e) {
				System.out.println("Errore nella lettura del file ");
			}
			
			
		}
		
	
	else {
		try {
			FileReader fr = new FileReader("English.txt");
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
	
//	public List<RichWord> spellCheckText(List<String> txt){
//		for(String s :txt) {
//			if(dictionary.contains(s)) {
//				paroleSbagliate.add(new RichWord(s));
//				s.setControl(false);
//			}
//		}
//		
//		
//		
//	}
	
	
	
	
	
	
}
