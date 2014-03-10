package com.laazer.games;

/**
 * A class representing the game Bizz Buzz.
 * This class can be imported to any enviorment in order for play.
 * @author Jacob
 *
 */
public class Buzzer {
    private static int count = 0;
    private int bizz;
    private int buzz;
    private String ans = "0";
    private final static String BIZZ = "bizz";
    private final static String BUZZ = "buzz";
    private final static String BIZZBUZZ = "bizzbuzz";
    
    public final static String INSTRUCT = "Players generally sit in a circle. The player designated to go \n" +
    		"first says the number \"1\", and each player thenceforth counts one number in turn. However, \n" +
    				"any number divisible by three is replaced by the word fizz and any divisible \n" +
    				"by five by the word buzz. Numbers divisible by both become fizz buzz. A player who \n" +
    				"hesitates or makes a mistake is eliminated from the game.";
   
    /** Default buzzer where bizz equals 4 and buzz equals 3 */
    public Buzzer() {
        bizz = 4;
        buzz = 3;
    }
    /** 
     * Buzzer that can be set up with any values for bizz and buzz
     * 
     * @param bizz a given positive int;
     * @param buzz a given positive int;
     */
    public Buzzer(int bizz, int buzz) {
        this.bizz = Math.abs(bizz);
        this.buzz = Math.abs(buzz);
    }
    
    /** returns the answer as a string */
    public String getAnswer() { return this.ans;}
    
    /** checks if a given answer is correct 
     * @param ans a given String answer
     * @return true if the given answer is correct
     */
    public boolean correct(String ans) {
        return this.ans.equals(ans.toLowerCase());
    }
    
    /** checks if a given answer is correct 
     * @param ans a given int answer
     * @return true if the given answer is correct
     */
    public boolean correct(int ans){
        return correct(Integer.toString(ans));
    }
    
    /** Gets the answer for a single round */
    public void play() {
        count++;
        //System.out.println(count);
        if(this.bizz(count) && this.buzz(count)) {
            ans = BIZZBUZZ;
        }
        else if(this.bizz(count)) {
            ans = BIZZ;
        }
        else if(this.buzz(count)) {
            ans = BUZZ;
        }
        else {
            ans = Integer.toString(count);
        }
    }
    
    /**
     * Plays a single round of bizzbuzz and returns the result
     * @param ans a given String
     * @return true if the given answer was correct after a single round
     */
    public boolean play(String ans) {
        this.play();
        return this.correct(ans);
    }
    
    /**
     * Plays a single round of bizzbuzz and returns the result
     * @param ans a given int
     * @return true if the given answer was correct after a single round
     */
    public boolean play(int ans){
        return play(Integer.toString(ans));
    }
    /**
     * Is x contained in c
     * @param x a given positive int
     * @param c a given positive int
     * @return true if the given int x is contained within the given int c
     */
    private static boolean contains(int x, int c) {
        int acc = 1;
        boolean result = false;
        while(x % acc != x) {
            acc = acc * 10;
            result = result || (x % acc == c);
        }
        return result;
    }
    
    /**
     * Returns if this is a bizz
     * @param x a given int
     * @return true if this is a bizz
     */
    private boolean bizz(int x) {
        return (x % this.bizz == 0) || contains(this.bizz, count);
    }
    
    /**
     * Returns if this is a buzz
     * @param x a given int
     * @return true if this is a buzz
     */
    private boolean buzz(int x) {
        return (x % this.buzz == 0) || contains(this.buzz, count);
    }
    
    /** resets the count **/
    public void reset() {
        this.ans = "0";
        count = 0;}
}