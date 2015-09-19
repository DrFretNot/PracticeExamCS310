package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class HangmanTest {
    
    // Exam Question 1
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testAllLettersAvailableAtBeginning() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        String allLetters = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < allLetters.length(); i++) {
            assertTrue(h.available(allLetters.charAt(i)));
        }
    }

    // Exam Question 2
    // Implement the Hangman available() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterMakesItUnavailable() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        boolean eIsAvailable = h.available('e');
        assertTrue(eIsAvailable);
        int numOccurrences = h.guess('e');
        eIsAvailable = h.available('e');
        assertFalse(eIsAvailable);
    }
    
    
    // Exam Question 3
    // Implement the Hangman guess() method to make this 
    // unit test pass correctly.
    @Test
    public void testGuessLetterReturnsCorrectOccurrences() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
        int numOccurrences = h.guess('e');
        assertEquals(2, numOccurrences);
    }

    // Exam Question 4
    // Implement this unit test to ensure that six or more missed
    // letters before the word is guessed results in a loss. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testSixOrMoreMissesCausesALoss() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
  		h.guess('d');
  		Hangman.Result value = h.getResult();
  		assertEquals(value, Hangman.Result.NONE);
        h.guess('f');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('g');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('h');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('j');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('k');
        value = h.getResult();
        assertEquals(value, Hangman.Result.LOSE);
    }
    
    // Exam Question 5
    // Implement this unit test to ensure that guessing all the 
    // letters correctly before six misses results in a win. Then,
    // implement the Hangman class methods required to make the 
    // test pass correctly.
    @Test
    public void testGuessingEveryLetterBeforeSixMissesCausesAWin() {
        Hangman h = new Hangman();
        h.setWord("inconceivable");
  		
  		h.guess('d');
  		Hangman.Result value = h.getResult();
  		assertEquals(value, Hangman.Result.NONE);
        h.guess('f');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('g');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('h');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('j');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
  		
  		h.guess('i');
  		value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('n');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('c');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('o');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('e');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('v');
        value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);   
		h.guess('a');
		value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);      
		h.guess('b');
		value = h.getResult();
        assertEquals(value, Hangman.Result.NONE);
        h.guess('l');
        value = h.getResult();
        assertEquals(value, Hangman.Result.WIN);
    }
    
    
    
}
