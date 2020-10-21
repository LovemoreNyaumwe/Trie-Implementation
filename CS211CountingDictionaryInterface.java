import java.util.ArrayList;

/* Everything should be LOWERCASE! */

public interface CS211CountingDictionaryInterface {
	void insert(String key);
	/* insert the given key storing 1 as the value if the key does not already exist
	 *  if the key already
	 *  exists, increment the associated value 
	 *  CONVERT THE KEY TO LOWER CASE  (.toLowerCase())
	 */

	boolean delete(String key);
	/* delete the given key, if the key was in the dictionary, return true
	 * otherwise, return false  Implementing this is optional 
	 */

	int find(String key);
	/* return the value associated with the given key,  If the key is NOT in the dictionary,
	 * return -1
	 */

	ArrayList<Word> allKeyValue();
	/* return a list of all the key-value Words in the dictionary. 
	 * 
	 */

}
