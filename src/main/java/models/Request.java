package models;

public class Request {

	// Declaring request variables
	private Employee author;
	private boolean isApproved;
	private String content;
	
	// Custom constructor
	public Request(Employee author, boolean isApproved, String content) {
		this.author = author;
		this.isApproved = isApproved;
		this.content = content;
	}



	// Getter/Setter for author
	public Employee getAuthor() {
		return author;
	}
	public void setAuthor(Employee author) {
		this.author = author;
	}
	
	// Getter/Setter for isApproved
	public boolean isApproved() {
		return isApproved;
	}
	public void setIsApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	// Getter/Setter for isApproved
	public String content() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
