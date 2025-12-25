package start.ctci.ood;

import java.util.Date;
import java.util.List;

abstract class Entry {
	Directory parent;
	String name;
	Date created;
	Date updated;
	Date lastAccessed;

	void delete() {
		parent.delete();
	}

	String getFullPath() {
		return parent.getFullPath() + "/" + name;
	}

	abstract int size();
}

class File extends Entry {
	String content;
	int size;

	int size() {
		return size;
	}
}

class Directory extends Entry {

	List<Entry> entries;

	int numberOfFiles() {
		int count = 0;

		for (Entry e : entries) {
			if (e instanceof Directory) {
				count++;
				count += ((Directory) e).numberOfFiles();
			} else if (e instanceof File) {
				count++;
			}
		}
		return count;
	}

	boolean deleteEntry(Entry entry) {
		return entries.remove(entry);
	}

	void addEntry(Entry entry) {
		entries.add(entry);
	}

	int size() {
		int size = 0;

		for (Entry e : entries) {
			size += e.size();
		}
		return size;
	}
}

public class FileSystem {
	
}
