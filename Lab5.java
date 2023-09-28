// Lab 5: STARTER FILE FOR STUDENTS

/* Don't forget your documentation info!
 * <Lab5.java
 * <Preston Rottinghaus / Section: 02B/ Day: Thursday/ Time: 3:30-5:20pm>
 *<This program is designed to open a file containing a list of words and randomly choose a word. 
 *then randomly jumble the word up to be guessed.
 *Finds compuned value and the interst value
 *Result ins for each client is printed.>
*/

// Add necessary import statements
import java.io.*;
import java.util.*;

public class Lab5 {
	public static void main(String[] args) throws IOException {
		 Random r = new Random();	
		 Scanner s = new Scanner(System.in);
		 String cont = "Y";
    Scanner inFile = new Scanner(new File("Lab5_Words.txt"));// READ THE FILE
		//open a connection to words.txt
		int numWord = inFile.nextInt();//the first line in the file is the number of words
		String[] wordList = new String[numWord];  //create a String array to be the size you read from the file
		for(int i = 0; i< numWord - 1; i++) {//read the rest of words.txt file into the String array
			wordList[i] = inFile.nextLine();
		}
    while((cont == "Y")) {
		// PICK A WORD
		int chosen = r.nextInt(numWord-1);
		String correct = wordList[chosen];//Randomly pick a word from the words array and assign to a variable called 'correct'
		
		
		
	
		
		
    // JUMBLE THE CHOSEN WORD
		boolean [] used = new boolean[correct.length()];//create a boolean array the same length as the correct word named 'used'
		StringBuilder build = new StringBuilder();//create an empty StringBuilder named 'build'
		int ctr = 0;//set a counter to 0
		
		
		

		while(ctr<correct.length()){ //while count < correct word length (while not all characters have been added)
			Random rand = new Random();
			int index = rand.nextInt(correct.length());//randomly pick an index in 'correct' - name it 'index'

			if(used[index]== false){//if used[index] is still false
				build.append(correct.charAt(index));//add the character at position 'index' in 'correct' to 'build'
				used[index] = true;//set used[index] to true to show that spot has been used
			
			
			ctr++;
			}
		}
		String jumb = build.toString();
		System.out.println("Unjumbled word: " + correct);
		
	// DISPLAY unjumbled word for testing purposes

    // PLAY GAME
		System.out.println("Jumbled word: " + jumb + "\n");//Display the jumbled word and repeatedly ask the user to guess a word
		int guess = 1;
		
		System.out.print("Enter a guess: ");
		String userGuess = s.nextLine();
		
		while(guess <= 4){
			if(userGuess.equals(correct)) {	
			break;
			}
			System.out.println("Incorrect. Try again");
			guess++;
			System.out.print("Enter a guess : ");
			userGuess = s.nextLine();
			
		}
		if(guess <= 5 && userGuess.equals(correct)){
		System.out.println("You guessed it! It took you " +  guess + " guesses.");
		}
		else
			System.out.println("Maximum number of guesses reached. Word was " + correct);
			
		System.out.print("Run again? (Y/N): ");
			cont = s.nextLine();
			cont = cont.toUpperCase();

    // Ask the user if they want to play again...if yes, loop to PICK A WORD
		
    }
    s.close();
    inFile.close();
    
	} //end main
} // end class