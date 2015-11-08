package document;

import java.util.List;

/** 
 * A naive implementation of the Document abstract class. 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document 
{
	/** Create a new BasicDocument object
	 * 
	 * @param text The full text of the Document.
	 */
	public BasicDocument(String text)
	{
		super(text);
		
	}
	
	
	/**
	 * Get the number of words in the document.
	 * "Words" are defined as contiguous strings of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords()
	{
		//TODO: Implement this method.  See the Module 1 support videos 
	    // if you need help.
		List <String> tokens=getTokens("[a-zA-Z]+");
	    return tokens.size();
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
        // if you need help.
		List <String> tokens=getTokens("[^.?!]+");
	    return tokens.size();        
	}
	
	/**
	 * Get the number of sentences in the document.
	 * Words are defined as above.  Syllables are defined as:
	 * a contiguous sequence of vowels, except for an "e" at the 
	 * end of a word if the word has another set of contiguous vowels, 
	 * makes up one syllable.   y is considered a vowel.
	 * @return The number of syllables in the document.
	 */
	@Override
	public int getNumSyllables()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
        // if you need help.
		int count=0;
		List <String> tokens=getTokens("[a-zA-Z]+");
	    for(int i=0;i<tokens.size();i++)
	    {
	    	count+=countSyllables(tokens.get(i));
	    	//System.out.println(tokens.get(i));
	    }
		return count;
	}
	
	public void sample(){
		List <String> tokens=getTokens("[^,]+");
		String text;		
		String s1="My String";
		text=s1;
		//System.out.println(text);
		String t="%one%%two%%%three%%%%";
		String[] x=t.split("[one,two,three]");
		for(int i=0;i<tokens.size();i++)
			System.out.print(tokens.get(i));
		/*for(int i=0;i<x.length;i++)
			System.out.println(x[i]);*/
	}
	
	/* The main method for testing this class. 
	 * You are encouraged to add your own tests.  */
	public static void main(String[] args)
	{
		
		testCase(new BasicDocument("This is a test.  How many???  "
		        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
				16, 13, 5);
		testCase(new BasicDocument(""), 0, 0, 0);
		testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
		testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);		
		testCase(new BasicDocument("segue."), 2, 1, 1);
		testCase(new BasicDocument("double."), 1, 1, 1);
		//BasicDocument b=new BasicDocument("one (1), two (2), three (3)");
		//b.sample();
	}
	
}
