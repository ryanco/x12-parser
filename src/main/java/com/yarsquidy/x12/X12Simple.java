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
package com.yarsquidy.x12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The X12 class is the object representation of an ANSI X12
 * transaction. The building block of an X12 transaction is an element. Some
 * elements may be made of sub elements. Elements combine to form segments.
 * Segments are grouped as loops. And a set of loops form an X12 transaction.
 *
 * @author Prasad Balan
 * @version $Id: $Id
 */
public class X12Simple implements EDI, Iterable<Segment> {
	private Context context;
	private List<Segment> segments;

	/**
	 * The constructor takes a context object.
	 *
	 * @param c
	 *            a Context object
	 */
	public X12Simple(Context c) {
		this.context = c;
		this.segments = new ArrayList<Segment>();
	}

	/**
	 * Creates an empty instance of {@link Segment} and adds the segment to
	 * the end of the X12 transaction. The returned instance can be used to add
	 * elements to the segment.
	 *
	 * @return a new Segment object
	 */
	public Segment addSegment() {
		Segment s = new Segment(this.context);
		segments.add(s);
		return s;
	}

	/**
	 * Takes a {@link java.lang.String} representation of segment, creates a
	 * {@link Segment} object and adds the segment to the end of the X12
	 * transaction.
	 *
	 * @param segment
	 *            {@link java.lang.String} representation of the {@link Segment}.
	 * @return a new {@link Segment} object
	 */
	public Segment addSegment(String segment) {
		Segment s = new Segment(this.context);
		String[] elements = segment.split("\\" + context.getElementSeparator());
		s.addElements(elements);
		segments.add(s);
		return s;
	}

	/**
	 * Takes a {@link Segment} and adds the segment to the end of the X12
	 * transaction.
	 *
	 * @param segment
	 *            {@link Segment} representation of the Segment.
	 * @return a new Segment object
	 */
	public Segment addSegment(Segment segment) {
		segments.add(segment);
		return segment;
	}

	/**
	 * Creates an empty instance of {@link Segment} and inserts the segment
	 * at the specified position in the X12 transaction. The returned instance
	 * can be used to add elements to the segment.
	 *
	 * @param index
	 *            position at which to add the segment.
	 * @return a new Segment object
	 */
	public Segment addSegment(int index) {
		Segment s = new Segment(this.context);
		segments.add(index, s);
		return s;
	}

	/**
	 * Takes a {@link java.lang.String} representation of segment, creates a
	 * {@link Segment} object and inserts the segment at the specified
	 * position
	 *
	 * @param segment
	 *            {@link java.lang.String} representation of the {@link Segment}.
	 * @return a new {@link Segment} object
	 * @param index a int.
	 */
	public Segment addSegment(int index, String segment) {
		Segment s = new Segment(this.context);
		String[] elements = segment.split("\\" + context.getElementSeparator());
		s.addElements(elements);
		segments.add(index, s);
		return s;
	}

	/**
	 * Takes a {@link java.lang.String} representation of segment, creates a
	 * {@link Segment} object and inserts the segment at the specified
	 * position
	 *
	 * @param segment
	 *            {@link java.lang.String} representation of the Segment.
	 * @return a new Segment object
	 * @param index a int.
	 */
	public Segment addSegment(int index, Segment segment) {
		segments.add(index, segment);
		return segment;
	}

	/**
	 * Get the segments in the X12 transaction.
	 *
	 * @param name
	 *            name of a segment
	 * @return {@link java.util.List}&lt;{@link Segment}&gt;
	 */
	public List<Segment> findSegment(String name) {
		List<Segment> foundSegments = new ArrayList<Segment>();
		for (Segment s : this.segments) {
			if (name.equals(s.getElement(0))) {
				foundSegments.add(s);
			}
		}
		return foundSegments;
	}
	
	/**
	 * Returns the context of the X12 transaction.
	 *
	 * @return Context object
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * Returns the {@link Segment} at the specified position.
	 *
	 * @param index the position of the segment to return.
	 * @return Segment at the specified index
	 */
	public Segment getSegment(int index) {
		return segments.get(index);
	}

	/**
	 * Returns the {@link java.util.List}&lt;{@link Segment}&gt;.
	 *
	 * @return List of segments
	 */
	public List<Segment> getSegments() {
		return this.segments;
	}
	
	/**
	 * Returns and {@link java.util.Iterator}&lt;{@link java.lang.String}&gt;
	 * to the elements in the segment.
	 *
	 * @return {@link java.util.Iterator}&lt;{@link java.lang.String}&gt;
	 */
	public Iterator<Segment> iterator() {
		return segments.iterator();
	}

	/**
	 * Removes the segment at the specified position in this list.
	 *
	 * @param index the position of the segment to remove.
	 * @return {@link Segment}
	 */
	public Segment removeSegment(int index) {
		return segments.remove(index);
	}
	
	/**
	 * Sets the context of the current transaction.
	 *
	 * @param context the context to apply to this object.
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * Creates an empty instance of {@link Segment} and replaces the
	 * segment at specified position in the X12 transaction. The returned
	 * instance can be used to add elements to the segment.
	 *
	 * @param index
	 *            position at which to add the segment.
	 * @return a new Segment object
	 */
	public Segment setSegment(int index) {
		Segment s = new Segment(this.context);
		segments.set(index, s);
		return s;
	}

	/**
	 * Takes a {@link java.lang.String} representation of segment, creates a
	 *{@link Segment} object and replaces the segment at the specified
	 * position in the X12 transaction.
	 *
	 * @param index
	 *            position of the segment to be replaced.
	 * @param segment
	 *            {@link java.lang.String} representation of the Segment.
	 * @return a new Segment object
	 */
	public Segment setSegment(int index, String segment) {
		Segment s = new Segment(this.context);
		String[] elements = segment.split("\\" + context.getElementSeparator());
		s.addElements(elements);
		segments.set(index, s);
		return s;
	}

	/**
	 * Replaces
	 * {@link Segment} at the specified position in X12 transaction.
	 *
	 * @param index
	 *            position of the segment to be replaced.
	 * @param segment
	 *            {@link Segment}
	 * @return a new Segment object
	 */
	public Segment setSegment(int index, Segment segment) {
		segments.set(index, segment);
		return segment;
	}

	/**
	 * Returns number of segments in the transaction
	 *
	 * @return size
	 */
	public int size() {
		return segments.size();
	}

	/**
	 * Returns the X12 transaction in {@link java.lang.String} format. This method is
	 * used to convert the X12 object into a X12 transaction.
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String toString() {
		return toString(false);
	}

	/**
	 * Returns the X12 representation of the segment.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return the segment as an X12 string.
	 */
	public String toString(boolean bRemoveTrailingEmptyElements) {
		StringBuilder dump = new StringBuilder();
		for (Segment s : this.segments) {
			dump.append(s.toString(bRemoveTrailingEmptyElements));
			dump.append(context.getSegmentSeparator());
		}
		return dump.toString();
	}
	
	/**
	 * Returns the X12 transaction in XML format. This method translates the X12
	 * object into XML format.
	 *
	 * @return XML string
	 */
	public String toXML() {
		return this.toXML(false);
	}
	
	/**
	 * Returns the X12 transaction in XML format. This method translates the X12
	 * object into XML format.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return the X12 as an XML string.
	 */
	public String toXML(boolean bRemoveTrailingEmptyElements) {
		StringBuilder dump = new StringBuilder();
		dump.append("<X12>");
		for (Segment s : this.segments) {
			dump.append(s.toXML(bRemoveTrailingEmptyElements));
		}
		dump.append("</X12>");
		return dump.toString();
	}	
}
