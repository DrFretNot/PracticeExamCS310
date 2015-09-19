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
       return !usedLetters.contains(c);
    }
    
	public int guess(char c) {
		boolean currentGuessOk = available(c);
		int letterCount = 0;
		if(currentGuessOk == true){
			usedLetters.add(c);
			boolean letterPresent = false;
			for (int i = 0; i < word.length(); i++){
					if(word.charAt(i) == c){
						letterPresent = true;letterCount++;
						lettersLeft--;
					}
			}
			if(letterPresent == false){
				incorrectGuesses++;
			}
		}		
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












