/**
 * Interface for any class that can provide a CSV-formatted string of its data.
 * Used to support uniform file output from different object types.
 */
public interface Printable {
	String getFileData();
}
