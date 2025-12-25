package start.ctci.ood;

import java.util.List;

enum Rank {
	Responder(0), Manager(1), Director(2);

	int value;

	Rank(int v) {
		value = v;
	}
}

class Caller {
	String name;
}

class Call {
	Rank rank;
	Caller caller;
	Employee handler;

	public Call(Caller caller) {
		this.rank = Rank.Responder;
		this.caller = caller;
	}

	void setHandler(Employee e) {
		this.handler = e;
	}

	// get/set rank
	void reply(String message) {
	}

	void disconnect() {
	}

}

abstract class Employee {
	Call currentCall;
	Rank rank;

	void receiveCall(Call call) {
	}

	void callCompleted() {
	}

	void escalateAndReassign() {
	}

	boolean assignNewCall() {
		return true;
	}

	boolean isFree() {
		return currentCall == null;
	}

	Rank rank() {
		return rank;
	}
}

class Respondent extends Employee {
}

class Manager extends Employee {
}

class Director extends Employee {
}

public class CallHandler {
	final int levels = 3;
	int num_respondents = 10;
	int num_managers = 6;
	int num_directors = 2;

	List<List<Employee>> employeeLevels;
	List<List<Call>> callQueue;

	Employee getHandlerForCall(Call call) {
		return null;
	}

	void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}

	void dispatchCall(Call call) {
		Employee employee = getHandlerForCall(call);
		if (employee != null) {
			employee.receiveCall(call);
			call.setHandler(employee);
		} else {
			call.reply("Call added into queue..");
			callQueue.get(call.rank.value).add(call);
		}
	}

	boolean assignCall() {
		return false;
	}

}
