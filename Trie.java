import java.util.ArrayList;

public class Trie implements CS211CountingDictionaryInterface {

	TrieNode root = new TrieNode();

	public void insert(String key) {
		root.insert(key,key);
	}

	public boolean delete(String key) {
		if (root.find(key)==null)
			return false;
		else root.delete(key);
		return true;
	}

	public int find(String key) {
		if (root == null)
			return -1;
		else {
			Word w = root.find(key);
			if (w==null)
				return -1;
			else return w.getCount();
		}
	}

	public ArrayList<Word> prefixMatch(String start) {
		ArrayList<Word> v = new ArrayList<>();
		root.prefixMatch(v,start);
		return v;
	}

	public ArrayList<Word> spellCheck1(String start) {
		ArrayList<Word> v = new ArrayList<>();
		root.spellCheck1(v,start);
		return v;
	}

	@Override
	public ArrayList<Word> allKeyValue() {
		ArrayList<Word> v = new ArrayList<>();
		root.allKeyValue(v);
		return v;
	}

	public ArrayList<Word> spellCheck2(String key, int errs) {
		ArrayList<Word> ws = new ArrayList<>();
		root.spellCheck2(ws,key,errs+1);
		return ws;
	}

	public void print() {
		root.print("");
	}
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("hello");
		t.insert("why");
		t.insert("hellor");
		t.insert("hello");
		t.insert("mezzo");
		t.insert("mezza");
		t.insert("a");
		t.insert("he");
		t.insert("him");





		t.print();

		System.out.println(t.find("hello"));
		System.out.println(t.find("hellor"));
		System.out.println(t.find("why"));

		System.out.println("All Key Value");
		ArrayList<Word> ws = t.allKeyValue();
		for (Word w: ws) {
			System.out.println("WS "+w);
		}

		System.out.println("Prefix Match");
		ws = t.prefixMatch("hel");
		for (Word w: ws) {
			System.out.println("SS "+w);
		}

		System.out.println("Spell Check 1");
		ws = t.spellCheck1("hezzo");
		for (Word w: ws) {
			System.out.println("ST "+w);
		}

		System.out.println("Spell Check 2");
		ws = t.spellCheck2("hezzo",1);
		for (Word w: ws) {
			System.out.println("EM "+w);
		}


		System.out.println(t.delete("why"));
		t.print();

	}


}
