package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
  	private int incorrectGuesses = 0;
    private int lettersLeft = 0;
    
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
    }
    
    public void setWord(String word) {
        this.word = word;
        lettersLeft = word.length();
    }
    
    public boolean available(char c) {
      
       if(!(usedLetters.contains(c))){return true;}
        
       else{return false;}
    }
    
    public int guess(char c) {
     	boolean currentGuessOk = available(c);
     	int letterCount = 0;
     	
     	if(currentGuessOk == true){
     		usedLetters.add(c);

			char[] charWord = word.toCharArray();
			
			boolean letterPresent = false;
			for (int i = 0; i < charWord.length; i++){
					if(charWord[i] == c){
					letterPresent = true;
					letterCount++;
					lettersLeft--;
					}
					else{}	
 	    	}
 	
     		if(letterPresent == false){
				incorrectGuesses++;
			}
			else{}
			}		
     	else{}
     	return letterCount;
    }
    
    public Result getResult() {
        Result current = Result.NONE;
        if(incorrectGuesses >= 6){
        	current= Result.LOSE;}
        else if(lettersLeft == 0){
        	current = Result.WIN;}
        else{
        	current = Result.NONE;}
        return current;
    }
    
}












