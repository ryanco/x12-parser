/*
   Copyright [2011] [Prasad Balan]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.pb.x12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents an X12 segment.
 *
 * @author Prasad Balan
 * @version $Id: $Id
 */
public class Segment implements Iterable<String> {
	private static final String EMPTY_STRING = "";
	
	private Context context;
	private List<String> elements = new ArrayList<String>();

	/**
	 * The constructor takes a {@link org.pb.x12.Context} object as input. The context
	 * object represents the delimiters in a X12 transaction.
	 *
	 * @param c
	 *            the context object
	 */
	public Segment(Context c) {
		this.context = c;
	}

	/**
	 * Adds {@link java.lang.String} element to the segment. The element is added at
	 * the end of the elements in the current segment.
	 *
	 * @param e
	 *            the element to be added
	 * @return boolean
	 */
	public boolean addElement(String e) {
		return elements.add(e);
	}

	/**
	 * Adds {@link java.lang.String} with elements to the segment. The elements are
	 * added at the end of the elements in the current segment. e.g.
	 * {@code addElements("ISA*ISA01*ISA02");}
	 *
	 * @param s the element to add.
	 * @return boolean
	 */
	public boolean addElements(String s) {
		String[] elements = s.split("\\" + context.getElementSeparator());
		return this.addElements(elements);
	}

	/**
	 * Adds {@link java.lang.String} elements to the segment. The elements are added
	 * at the end of the elements in the current segment. e.g.
	 * {@code addElements("ISA", "ISA01", "ISA02");}
	 *
	 * @param es elements to add.
	 * @return boolean
	 */
	public boolean addElements(String... es) {
		for (String s : es) {
			if (!this.elements.add(s))
				return false;
		}
		return true;
	}

	/**
	 * Adds strings as a composite element to the end of the segment.
	 *
	 * @param ces
	 *            sub-elements of a composite element
	 * @return boolean
	 */
	public boolean addCompositeElement(String... ces) {
		StringBuilder dump = new StringBuilder();
		for (String s : ces) {
			dump.append(s);
			dump.append(context.getCompositeElementSeparator());
		}
		return this.elements.add(dump.substring(0, dump.length() - 1));
	}

	/**
	 * Inserts {@link java.lang.String} element to the segment at the specified
	 * position
	 *
	 * @param e
	 *            the element to be added
	 * @return boolean true if element matches the element at the index provided.
	 * @param index a int.
	 */
	public boolean addElement(int index, String e) {
		this.elements.add(index, e);
		return elements.get(index).equals(e);
	}

	/**
	 * Inserts strings as a composite element to segment at specified position
	 *
	 * @param ces
	 *            sub-elements of a composite element
	 * @param index a int.
	 */
	public void addCompositeElement(int index, String... ces) {
		StringBuilder dump = new StringBuilder();
		for (String s : ces) {
			dump.append(s);
			dump.append(context.getCompositeElementSeparator());
		}
		this.elements.add(index, dump.substring(0, dump.length() - 1));
	}

	/**
	 * Returns the context object
	 *
	 * @return Context object
	 */
	public Context getContext() {
		return this.context;
	}

	/**
	 * Returns the {@link java.lang.String} element at the specified position.
	 *
	 * @param index
	 *            position
	 * @return the element at the specified position.
	 */
	public String getElement(int index) {
		return elements.get(index);
	}

	/**
	 * Getter for the field {@link java.util.List}&lt;{@link java.lang.String}&gt;
	 *
	 * @return List of elements
	 */
	public List<String> getElements() {
		return this.elements;
	}
	
	/**
	 * Returns and {@link java.util.Iterator}&lt;{@link java.lang.String}&gt;
	 * to the elements in the segment.
	 *
	 * @return {@link java.util.Iterator}&lt;{@link java.lang.String}&gt;
	 */
	public Iterator<String> iterator() {
		return elements.iterator();
	}

	/**
	 * Removes the element at the specified position in this list.
	 *
	 * @param index the index at which to remove the element.
	 * @return String element that was removed.
	 */
	public String removeElement(int index) {
		return elements.remove(index);
	}

	/**
	 * Removes empty and null elements at the end of segment 
	 */
	private void removeTrailingEmptyElements() {
		for (int i = elements.size() - 1; i >= 0; i--) {
			if (elements.get(i) == null || elements.get(i).length() == 0) {
				elements.remove(i);
			} else {
				break;
			}
		}		
	}
	
	/**
	 * Sets the context of the segment
	 *
	 * @param context
	 *            context object
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * Replaces element at the specified position with the specified
	 * {@link java.lang.String}
	 *
	 * @param index
	 *            position of the element to be replaced
	 * @param s
	 *            new element with which to replace
	 */
	public void setElement(int index, String s) {
		elements.set(index, s);
	}

	/**
	 * Replaces composite element at the specified position in segment.
	 *
	 * @param ces
	 *            sub-elements of a composite element
	 * @param index a int.
	 */
	public void setCompositeElement(int index, String... ces) {
		StringBuilder dump = new StringBuilder();
		for (String s : ces) {
			dump.append(s);
			dump.append(context.getCompositeElementSeparator());
		}
		elements.set(index, dump.substring(0, dump.length() - 1));
	}

	/**
	 * Returns number of elements in the segment.
	 *
	 * @return size
	 */
	public int size() {
		return elements.size();
	}

	/**
	 * Returns the X12 representation of the segment.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String toString() {
		StringBuilder dump = new StringBuilder();
		for (String s : this.elements) {
			dump.append(s);
			dump.append(context.getElementSeparator());
		}
		if (dump.length() == 0) {
			return EMPTY_STRING;
		}
		return dump.substring(0, dump.length() - 1);
	}

	/**
	 * Returns the X12 representation of the segment.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return {@link java.lang.String}
	 */
	public String toString(boolean bRemoveTrailingEmptyElements) {
		if (bRemoveTrailingEmptyElements)
			removeTrailingEmptyElements();
		return this.toString();
	}
	
	/**
	 * Returns the XML representation of the segment.
	 *
	 * @return {@link java.lang.String} XML representation of the segment.
	 */
	public String toXML() {
		StringBuilder dump = new StringBuilder();
		dump.append("<");
		dump.append(this.elements.get(0));
		dump.append(">");
		for (int i = 1; i < this.elements.size(); i++) {
			dump.append("<");
			dump.append(this.elements.get(0));
			dump.append(String.format("%1$02d", i));
			dump.append("><![CDATA[");
			dump.append(this.elements.get(i));
			dump.append("]]></");
			dump.append(this.elements.get(0));
			dump.append(String.format("%1$02d", i));
			dump.append(">");
		}
		dump.append("</");
		dump.append(this.elements.get(0));
		dump.append(">");
		return dump.toString();
	}

	/**
	 * Returns the XML representation of the segment.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return {@link java.lang.String} XML representation of the segment.
	 */
	public String toXML(boolean bRemoveTrailingEmptyElements) {
		if (bRemoveTrailingEmptyElements)
			removeTrailingEmptyElements();
		return this.toXML();
	}

}
