package start.ctci.ood;

import java.util.Date;
import java.util.List;
import java.util.Map;

class Message {
	String content;
	Date date;
	
	//getters/setters
}

abstract class Conversation {
	int id;
	List<UserCS> participants;
	List<Message> messages;
	
	boolean addMessage(Message m) { return false; }
}
 class GroupChat extends Conversation {
	 
	 void addParticipant(UserCS u) {}
	 void removeParticipant(UserCS u) {}
 }
 
class PrivateChat extends Conversation {
	 
	UserCS getOtherParticipant() {
		return null;
	}
 }

enum RequestStatus {
	Unread, Read, Accepted, Rejected;
}

enum UserStatusType {
	Idle, Away, Offline, Busy;
}

class UserStatus {
	String message;
	UserStatusType type;	
}

class AddRequest {
	UserCS from;
	UserCS to;
	Date date;
	RequestStatus status;
	
	//getters/setters
}

class UserCS {

	int id;
	UserStatus status;
	Map<Integer, AddRequest> sentRequests;
	Map<Integer, AddRequest> receivedRequests;
	Map<Integer, UserCS> contacts;
	
	String accountName;
	String fullName;
	
	void sendMessageToUser(UserCS user, String content) {}
	void sendMessageToGroup(int id, String content) {}
	void setStatus(UserStatus status) {}
	void addContact(UserCS user) {}
	void sendAddReuest(AddRequest addRequest) {}
	void receiveAddReuest(AddRequest addRequest) {}
	void addConversation(PrivateChat privateChat) {}
	void addConversation(GroupChat groupChat) {}
}

public class ChatServer {

	Map<Integer, UserCS> usersById;
	Map<Integer, UserCS> onlineUsers;
	
	void approveAddRequest(AddRequest addRequest) {}
	void rejectAddRequest(AddRequest addRequest) {}
	void online(UserCS user) {}
	void offline(UserCS user) {}
}
