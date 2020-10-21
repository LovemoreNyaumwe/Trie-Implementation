import java.util.ArrayList;

public class TrieNode {

	private Word wordHere;
	String theLongestPrefix = "";
	ArrayList<Word> values = new ArrayList<>();

	private TrieNode[] links;

	public TrieNode() {
		wordHere = null;
		links = new TrieNode[26];
	}

	//Covert a letter to a number
	private int let(char c) {
		return c - 'a';
	}

	private char firstChar(String key) {
		return key.charAt(0);
	}
	
	private String rest(String key) {
		if (key.length() == 1){
			return "";
		}
		return key.substring(1);
	}
	
	private TrieNode linkWordStart(String start) {
		return links[let(firstChar(start))];
	}
	
	public void insert(String key,String toHere) {
		if(this.links[let(firstChar(key))] == null){
			this.links[let(firstChar(key))] = new TrieNode();
			if(key.length() > 1){
				this.links[let(firstChar(key))].insert(rest(key), toHere);
			}
			else {
				this.links[let(firstChar(key))].wordHere = new Word(toHere, 1);
			}
		}
		else {
			if(key.length() > 1){
				this.links[let(firstChar(key))].insert(rest(key), toHere);
			}
			else if(this.links[let(firstChar(key))].wordHere != null &&
					this.links[let(firstChar(key))].wordHere.theWord.compareTo(toHere) == 0) {
				this.links[let(firstChar(key))].wordHere.theCount++;
			}
			else {
				this.links[let(firstChar(key))].wordHere = new Word(toHere, 1);
			}
		}
	}

	
	public Word find(String key) {
		if (key.length() == 0) {
			return wordHere;
		}
		else {
			if (linkWordStart(key) == null)
				return null;
			else return linkWordStart(key).find(rest(key));
		}		
	}

	public ArrayList<Word> traverseTrieNode(TrieNode[] parents){
			for(TrieNode child: parents){
				if(child != null){
					if (child.wordHere != null){
						values.add(child.wordHere);
					}
					traverseTrieNode(child.links);
			}
				}
		return values;

	}

	public void allKeyValue(ArrayList<Word> v) {
		/* return a list of all the key-value Words in the dictionary.
		 *
		 */
			traverseTrieNode(links);
		v.addAll(values);
	}
	public String longestPrefix(String start){
		if (start.length() != 0) {
			if (linkWordStart(start) != null)
				theLongestPrefix = firstChar(start) + linkWordStart(start).longestPrefix(rest(start));
			}
		return theLongestPrefix;
		}

	public void spellCheck1(ArrayList<Word> v, String start) {
		int count = longestPrefix(start).length();
		for(Word value : values){
			if((value.theWord.length() >= count) &&
					value.theWord.substring(0,count).compareTo(longestPrefix(start)) == 0){
				v.add(value);
			}
		}
	}

	public void prefixMatch(ArrayList<Word> v, String start) {
		int count = start.length();
		for(Word value : values){
			if((value.theWord.length() == count || value.theWord.length() > count)
					&& value.theWord.substring(0,count).compareTo(start) == 0){
				v.add(value);
			}
		}
	}

	public void spellCheck2(ArrayList<Word> ws, String key, int errs) {
		if (key.length() == 0 && errs >= 1 && this.wordHere != null) {
			ws.add(this.wordHere);
		}else {
			for (TrieNode child : links) {
				if (child != null) {
					if (child != linkWordStart(key) && errs > 1) {
						child.spellCheck2(ws, rest(key), errs - 1);
					}
					else if (child != linkWordStart(key) && errs == 1) {
						continue;
					} else if (child == linkWordStart(key)) {
						linkWordStart(key).spellCheck2(ws, rest(key), errs);
					}


				}
			}
		}
	}

	
	public void print(String string) {
		if (wordHere != null)
			System.out.println(string+" "+wordHere);
		else System.out.println(string+" empty");
		for (int i=0; i<26; i++) {
			if (links[i]!=null){
				links[i].print(string+"-");
			}
		}
	}

	public boolean delete(String key) {
		/* delete the given key, if the key was in the dictionary, return true
		 * otherwise, return false  Implementing this is optional
		 */
		if(this.linkWordStart(key) != null){
			if(key.length() > 1){
				linkWordStart(key).delete(rest(key));
			}
			else {
				this.linkWordStart(key).wordHere = null;
				return true;
			}
		}
			return false;
	}


}


