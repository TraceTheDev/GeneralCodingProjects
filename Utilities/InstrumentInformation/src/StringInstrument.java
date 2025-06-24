// TODO: Define a class: StringInstrument that is derived from the Instrument class
public class StringInstrument extends Instrument {
	// TODO: Declare private fields: numStrings, numFrets
	private int numStrings;
	private int numFrets;
	// TODO: Define mutator methods - 
	//      setNumOfStrings(), setNumOfFrets()
	public void setNumOfStrings(int numStrings) 
	{
		this.numStrings = numStrings;
	} // end method
	
	public void setNumOfFrets(int numFrets) 
	{
		this.numFrets = numFrets;
	} // end method

	// TODO: Define accessor methods -
	//      getNumOfStrings(), getNumOfFrets()
	public int getNumOfStrings() 
	{
		return numStrings;
	} // end method
	
	public int getNumOfFrets() 
	{
		return numFrets;
	} // end method
} // end class

