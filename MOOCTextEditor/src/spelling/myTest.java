package spelling;

import java.util.List;

public class myTest {

	public static void main(String[] args)
	{
		AutoCompleteDictionaryTrie dict=new AutoCompleteDictionaryTrie();
		String word="hello";
		System.out.println("Check if "+word+" is in the dictionary "+dict.isWord(word));
		System.out.println("word added to dictionary "+dict.addWord(word));
		System.out.println("Check if "+word+" is in the dictionary "+dict.isWord(word));
		System.out.println("Size of dictionary "+dict.size());
		System.out.println("word added to dictionary "+dict.addWord("he"));
		System.out.println("Check if "+"he"+" is in the dictionary "+dict.isWord("he"));
		System.out.println("Size of dictionary "+dict.size());
		System.out.println("word added to dictionary "+dict.addWord("eat"));
		System.out.println("Size of dictionary "+dict.size());
		System.out.println("word added to dictionary "+dict.addWord("hey"));
		dict.printTree();
		List<String>completions=dict.predictCompletions("h", 4);
		System.out.println(completions.toString());
	}
}
