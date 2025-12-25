package start.ctci.ood;

import java.util.HashMap;
import java.util.Map;

class User {
	int id;
	String details;

	void renewMembership() {
	}
}

class Book {
	int id;
	String details;
}

class Display {
	Book activeBook;
	User activeUser;
	int pageNumber;

	void displayUser(User user) {
		activeUser = user;
		refreshUsername();
	}

	void displayBook(Book book) {
		pageNumber = 0;
		activeBook = book;
		refreshUsername();
	}

	void nextPage() {
		pageNumber++;
		refreshPage();
	}

	void previousPage() {
		pageNumber--;
		refreshPage();
	}

	void refreshUsername() {
	}

	void refreshBookDetails() {
	}

	void refreshPage() {
	}

}

class UserManager {
	private Map<Integer, User> users = new HashMap<>();

	User addUser(User user) {
		if (users.containsKey(user.id)) {
			return null;
		}
		users.put(user.id, user);
		return user;
	}

	User find(Integer userId) {
		return users.get(userId);
	}

	boolean remove(int userId) {
		return users.remove(userId) != null;
	}
}

class Library {
	private Map<Integer, Book> books = new HashMap<>();

	Book addUser(Book book) {
		if (books.containsKey(book.id)) {
			return null;
		}
		books.put(book.id, book);
		return book;
	}

	Book find(Integer bookId) {
		return books.get(bookId);
	}

	boolean remove(int bookId) {
		return books.remove(bookId) != null;
	}
}

public class OnlineReaderSystem {

	Library library;
	UserManager userManager;
	Display display;

	Book currentBook;
	User currentUser;

	void setActiveBook(Book book) {
		currentBook = book;
		display.displayBook(book);
	}

	void setActiveUser(User user) {
		currentUser = user;
		display.displayUser(user);
	}

}
