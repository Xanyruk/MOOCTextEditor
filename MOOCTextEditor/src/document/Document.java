package document;

/** 
 * A class that represents a text document
 * @author UC San Diego Intermediate Programming MOOC team
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Document {

	private String text;
	
	/** Create a new document from the given text.
	 * Because this class is abstract, this is used only from subclasses.
	 * @param text The text of the document.
	 */
	protected Document(String text)
	{
		this.text = text;
	}
	
	/** Returns the tokens that match the regex pattern from the document 
	 * text string.
	 * @param pattern A regular expression string specifying the 
	 *   token pattern desired
	 * @return A List of tokens from the document text that match the regex 
	 *   pattern
	 */
	protected List<String> getTokens(String pattern)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	// This is a helper function that returns the number of syllables
	// in a word.  You should write this and use it in your 
	// BasicDocument class.
	// You will probably NOT need to add a countWords or a countSentences method
	// here.  The reason we put countSyllables here because we'll use it again
	// next week when we implement the EfficientDocument class.
	protected int countSyllables(String word)
	{
		// TODO: Implement this method so that you can call it from the 
	    // getNumSyllables method in BasicDocument (module 1) and 
	    // EfficientDocument (module 2).
		int countSyl = 0;
	    boolean vowel = false;
		//int length = word.length();
		
		for(int i=0; i<word.length(); i++) {			
			if(isVowel(word.charAt(i)) && (vowel==false)) {
				vowel = true;
		        countSyl++;
		    }
			else if (isVowel(word.charAt(i)) && (vowel==true)) {
		        vowel = true;
		    }
			else {
		        vowel = false;
		    }
		}
		char lastChar = word.charAt(word.length()-1);
		//check for 'e' at the end, as long as not a word w/ one Syllable
		if (("eE".indexOf(lastChar)>=0) && (countSyl != 1) && !isVowel(word.charAt(word.length()-2))) {
			countSyl--;
		}
		return countSyl;
}
	public static boolean isVowel(char c) {
		String str="aeiouyAEIOUY";
	    if(str.indexOf(c)>=0)
	    	return true;	    
	    else
	    	return false;
	  }
	
	/** A method for testing
	 * 
	 * @param doc The Document object to test
	 * @param syllables The expected number of syllables
	 * @param words The expected number of words
	 * @param sentences The expected number of sentences
	 * @return true if the test case passed.  False otherwise.
	 */
	public static boolean testCase(Document doc, int syllables, int words, int sentences)
	{
		System.out.println("Testing text: ");
		System.out.print(doc.getText() + "\n....");
		boolean passed = true;
		int syllFound = doc.getNumSyllables();
		int wordsFound = doc.getNumWords();
		int sentFound = doc.getNumSentences();
		if (syllFound != syllables) {
			System.out.println("\nIncorrect number of syllables.  Found " + syllFound 
					+ ", expected " + syllables);
			passed = false;
		}
		if (wordsFound != words) {
			System.out.println("\nIncorrect number of words.  Found " + wordsFound 
					+ ", expected " + words);
			passed = false;
		}
		if (sentFound != sentences) {
			System.out.println("\nIncorrect number of sentences.  Found " + sentFound 
					+ ", expected " + sentences);
			passed = false;
		}
		
		if (passed) {
			System.out.println("passed.\n");
		}
		else {
			System.out.println("FAILED.\n");
		}
		return passed;
	}
	
	
	/** Return the number of words in this document */
	public abstract int getNumWords();
	
	/** Return the number of sentences in this document */
	public abstract int getNumSentences();
	
	/** Return the number of syllables in this document */
	public abstract int getNumSyllables();
	
	/** Return the entire text of this document */
	public String getText()
	{
		return this.text;
	}
	
	/** return the Flesch readability score of this document */
	public double getFleschScore()
	{
	    // TODO: Implement this method
		double fleschScore=0.0;
		//System.out.println("words: "+getNumWords()+" sentences: "+getNumSentences()+" syllables: "+getNumSyllables());
		double part1=(double)getNumWords()/getNumSentences();
		//System.out.println("part1: "+part1);
		double part2=(double)getNumSyllables()/getNumWords();
		//System.out.println("part2: "+part2);
		fleschScore=206.835-(1.015*(part1))-(84.6*(part2));
	    return fleschScore;
	}
	
	
	
}
