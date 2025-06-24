public class Encyclopedia extends Book {
	// TODO: Declare private fields: edition, numVolumes
	private String edition;
	private int numVolumes;
	
	// Getters
	public String getEdition() {
		return edition;
	} // end method
	
	public int getNumVolumes() {
		return numVolumes;
	} // end method
	
	// Setters
	public void setEdition(String edition) {
		this.edition = edition;
	} // end method
	
	public void setNumVolumes(int numVolumes) {
		this.numVolumes = numVolumes;
	} // end method

	// TODO: Define a printInfo() method that overrides 
	//       the printInfo in Book class 
	
	// printing not only the title, author, 
	// publisher, and publication date, but also the 
	// edition and number of volumes.
	@Override
	public void printInfo()
	{
	      super.printInfo();
	      System.out.println("   Edition: " + edition);
	      System.out.println("   Number of Volumes: " + numVolumes);
	} // end method
}