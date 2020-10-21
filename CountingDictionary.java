import java.util.ArrayList;

public class CountingDictionary implements CS211CountingDictionaryInterface {
    @Override
    public void insert(String key) {
        /* insert the given key storing 1 as the value if the key does not already exist
         *  if the key already
         *  exists, increment the associated value
         *  CONVERT THE KEY TO LOWER CASE  (.toLowerCase())
         */

    }

    @Override
    public boolean delete(String key) {
        /* delete the given key, if the key was in the dictionary, return true
         * otherwise, return false  Implementing this is optional
         */
        return false;
    }

    @Override
    public int find(String key) {
        /* return the value associated with the given key,  If the key is NOT in the dictionary,
         * return -1
         */
        return 0;
    }

    @Override
    public ArrayList<Word> allKeyValue() {
        /* return a list of all the key-value Words in the dictionary.
         *
         */
        return null;
    }

    /*public boolean anyKids(){
        write a boolean method called anyKids which tells you whether at least
        one child pointer is non-null.
    }
    */
}
