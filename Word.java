
public class Word implements Comparable<Word> {

    String theWord;
    int theCount = 0;

    public String toString() {
        return theWord + "  " + theCount;
    }

    public Word(String word, Integer count) {
        this.theWord = word;
        this.theCount += count;
    }

    /* compareTo should return a positive number if this is greater
     * than other, 0 if they are equal and a negative number if this is less.
     *
     * this is greater (less than) if its count is greater (less than) that of
     * other.  If the counts are equal, you should determine which theWord is
     * larger as a String.  compareTo is implemented in Java for Strings, you
     * should use it
     */
    public int compareTo(Word other) {
        int number;
        if (this.theCount > other.theCount) {
            number = 1;
        }
        else if (this.theCount < other.theCount) {
            number = -1;
        }
        else{
            number = Integer.compare(this.theWord.length(), other.theWord.length());
        }
        return number;
    }


    public int getCount() {
        return theCount;
    }

    public String getTheWord() { return theWord; }
    public void setCount(int Count) {  theCount += Count; }
}
