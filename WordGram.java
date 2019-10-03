
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author EILEEN WEN
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		String[] x = new String[size];
		for(int i = 0; i<size; i++)
		{
			x[i] = source[i+start];
		}
		myWords = x;
		myToString = null;
		myHash = 0;

		// TODO: initialize all instance variable - DONE
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return the length of the sequence of strings (length of myWords)
	 * @return integer value of length of string sequence
	 */
	public int length(){
		// TODO: change this - DONE
		return myWords.length;
	}


	/**
	 * Return boolean determining whether or not object o is already in the word sequence
	 * @param o
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {

		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method - DONE

		else {
			WordGram wg = (WordGram) o;
			if (myWords.length == wg.myWords.length)
			{
				for(int i = 0; i<myWords.length; i++)
				{
					if(!myWords[i].equals(wg.myWords[i]))
						return false;
				}
			}
			else
				return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		if(myHash == 0)
		{
			myHash =  this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return the object WordGram (sequence of words) with the String last added to the end
	 */
	public WordGram shiftAdd(String last) {

		String[] temp = new String[myWords.length + 1];
		for(int i= 0; i<myWords.length; i++)
		{
			temp[i] = myWords[i];
		}
		temp[myWords.length] = last;
		WordGram wg = new WordGram(temp,1,myWords.length);
		return wg;
	}


	@Override
	public String toString()
	{
		// TODO: Complete this method
		if(myToString == null)
			myToString = String.join(" ",myWords);
		return myToString;

	}



}
