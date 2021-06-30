package models;

public class Mail {

	// Declaring request variables
	private User sender;
	private User receiver;
	private String content;
	
	// Custom constructor
	public Mail(User sender, User receiver, String content) {
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}



	// Getter/Setter for sender
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	// Getter/Setter for receiver
	public User receiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	
	// Getter/Setter for content
	public String content() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
