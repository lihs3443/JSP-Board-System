package message;

public class Message {
	private int messageID;
	private String userID;
	private String senderID;
	private String messageContent;
	private String messageDate;
	private int messageAvailable;
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getSenderID() {
		return senderID;
	}
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	public int getMessageAvailable() {
		return messageAvailable;
	}
	public void setMessageAvailable(int messageAvailable) {
		this.messageAvailable = messageAvailable;
	}


}
