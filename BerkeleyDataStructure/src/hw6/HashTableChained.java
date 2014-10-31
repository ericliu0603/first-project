/* HashTableChained.java */

package hw6;

import java.util.ArrayList;
import java.util.List;

/**
 * HashTableChained implements a Dictionary as a hash table with chaining. All
 * objects used as keys must have a valid hashCode() method, which is used to
 * determine which bucket of the hash table an entry is stored in. Each object's
 * hashCode() is presumed to return an int between Integer.MIN_VALUE and
 * Integer.MAX_VALUE. The HashTableChained class implements only the compression
 * function, which maps the hash code to a bucket in the table's range.
 *
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

	/**
	 * Place any data fields here.
	 **/
	private ArrayList<ArrayList<Entry>> list;
	private int size;

	/**
	 * Construct a new empty hash table intended to hold roughly sizeEstimate
	 * entries. (The precise number of buckets is up to you, but we recommend
	 * you use a prime number, and shoot for a load factor between 0.5 and 1.)
	 **/

	public HashTableChained(int sizeEstimate) {
		list = new ArrayList<ArrayList<Entry>>();
		for (int i = 0; i < sizeEstimate; ++i) {
			list.add(new ArrayList<Entry>());
		}
		size = 0;
	}

	/**
	 * Construct a new empty hash table with a default size. Say, a prime in the
	 * neighborhood of 100.
	 **/

	public HashTableChained() {
		list = new ArrayList<ArrayList<Entry>>();
		for (int i = 0; i < 101; ++i) {
			list.add(new ArrayList<Entry>());
		}
		size = 0;
	}

	/**
	 * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
	 * to a value in the range 0...(size of hash table) - 1.
	 *
	 * This function should have package protection (so we can test it), and
	 * should be used by insert, find, and remove.
	 **/

	int compFunction(int code) {
		return Math.abs(code % list.size());
	}

	/**
	 * Returns the number of entries stored in the dictionary. Entries with the
	 * same key (or even the same key and value) each still count as a separate
	 * entry.
	 *
	 * @return number of entries in the dictionary.
	 **/

	@Override
	public int size() {
		return size;
	}

	/**
	 * Tests if the dictionary is empty.
	 *
	 * @return true if the dictionary has no entries; false otherwise.
	 **/

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Create a new Entry object referencing the input key and associated value,
	 * and insert the entry into the dictionary. Return a reference to the new
	 * entry. Multiple entries with the same key (or even the same key and
	 * value) can coexist in the dictionary.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * @param key
	 *            the key by which the entry can be retrieved.
	 * @param value
	 *            an arbitrary object.
	 * @return an entry containing the key and value.
	 **/

	@Override
	public Entry insert(Object key, Object value) {
		Entry entry = new Entry();
		entry.key = key;
		entry.value = value;
		int index = compFunction(key.hashCode());
		ArrayList<Entry> curList = list.get(index);
		if (curList == null) {
			curList = new ArrayList<Entry>();
			list.add(curList);
		}
		curList.add(entry);
		++size;
		return entry;
	}

	/**
	 * Search for an entry with the specified key. If such an entry is found,
	 * return it; otherwise return null. If several entries have the specified
	 * key, choose one arbitrarily and return it.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 **/

	@Override
	public Entry find(Object key) {
		int index = compFunction(key.hashCode());
		List<Entry> curList = list.get(index);
		if (curList == null) {
			return null;
		} else {
			for (Entry curEntry : curList) {
				if (curEntry.key().equals(key)) {
					return curEntry;
				}
			}
		}
		return null;
	}

	/**
	 * Remove an entry with the specified key. If such an entry is found, remove
	 * it from the table and return it; otherwise return null. If several
	 * entries have the specified key, choose one arbitrarily, then remove and
	 * return it.
	 *
	 * This method should run in O(1) time if the number of collisions is small.
	 *
	 * @param key
	 *            the search key.
	 * @return an entry containing the key and an associated value, or null if
	 *         no entry contains the specified key.
	 */

	@Override
	public Entry remove(Object key) {
		int index = compFunction(key.hashCode());
		List<Entry> curList = list.get(index);
		if (curList == null) {
			return null;
		} else {
			for (Entry curEntry : curList) {
				if (curEntry.key().equals(key)) {
					curList.remove(curEntry);
					size--;
					return curEntry;
				}
			}
		}
		return null;
	}

	/**
	 * Remove all entries from the dictionary.
	 */
	@Override
	public void makeEmpty() {
		for (int i = 0; i < list.size(); ++i) {
			list.get(0).clear();
		}
		size = 0;
	}

}
