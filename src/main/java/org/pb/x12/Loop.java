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

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/**
 * The Loop class is the representation of an Loop in a ANSI X12
 * transaction. The building block of an X12 transaction is an element. Some
 * elements may be made of sub elements. Elements combine to form segments.
 * Segments are grouped as loops. And a set of loops form an X12 transaction.
 *
 * @author Prasad Balan
 * @version $Id: $Id
 */
public class Loop implements Iterable<Segment> {
	private Context context;
	private String name;
	private List<Segment> segments = new ArrayList<Segment>();
	private List<Loop> loops = new ArrayList<Loop>();
	private Loop parent;
	private int depth; // used to debug

	/**
	 * The constructor takes a context object.
	 *
	 * @param c
	 *            a Context object
	 * @param name a {@link java.lang.String} object.
	 */
	public Loop(Context c, String name) {
		this.context = c;
		this.name = name;
		this.parent = null;
	}

	/**
	 * Creates an empty instance of {@link org.pb.x12.Loop} and adds the loop as a
	 * child to the current Loop. The returned instance can be used to add
	 * segments to the child loop.
	 *
	 * @param name
	 *            name of the loop
	 * @return a new child Loop object
	 */
	public Loop addChild(String name) {
		Loop l = new Loop(this.context, name);
		l.setParent(this);
		l.depth = this.depth + 1; // debug
		loops.add(l);
		return l;
	}

	/**
	 * Inserts {@link org.pb.x12.Loop} as a child loop at the specified position.
	 *
	 * @param index
	 *            position at which to add the loop.
	 * @param loop a {@link org.pb.x12.Loop} object.
	 */
	public void addChild(int index, Loop loop) {
		loop.setParent(this);
		loop.depth = this.depth + 1; // debug
		loops.add(index, loop);
	}

	/**
	 * Creates an empty instance of {@link org.pb.x12.Segment} and adds the segment to
	 * current Loop. The returned instance can be used to add elements to the
	 * segment.
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
	 * {@link org.pb.x12.Segment} object and adds the segment to the current Loop.
	 *
	 * @param segment
	 *            {@link java.lang.String} representation of the Segment.
	 * @return a new Segment object
	 */
	public Segment addSegment(String segment) {
		Segment s = new Segment(this.context);
		String[] elements = segment.split("\\" + context.getElementSeparator());
		s.addElements(elements);
		segments.add(s);
		return s;
	}

	/**
	 * Adds {@link org.pb.x12.Segment} at the end of the current Loop
	 *
	 * @param segment
	 *            {@link org.pb.x12.Segment}
	 */
	public void addSegment(Segment segment) {
		segments.add(segment);
	}

	/**
	 * Creates an empty instance of {@link org.pb.x12.Segment} and adds the segment at
	 * the specified position in the current Loop. The returned instance can be
	 * used to add elements to the segment.
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
	 * {@link org.pb.x12.Segment} object and adds the segment at the specified
	 * position in the current Loop.
	 *
	 * @param index
	 *            position to add the segment.
	 * @param segment
	 *            {@link java.lang.String} representation of the segment.
	 * @return a new Segment object
	 */
	public Segment addSegment(int index, String segment) {
		Segment s = new Segment(this.context);
		String[] elements = segment.split("\\" + context.getElementSeparator());
		s.addElements(elements);
		segments.add(index, s);
		return s;
	}

	/**
	 * Adds {@link org.pb.x12.Segment} at the specified position in current Loop.
	 *
	 * @param index
	 *            position to add the segment.
	 * @param segment
	 *           {@link org.pb.x12.Segment} representation of the segment.
	 */
	public void addSegment(int index, Segment segment) {
		segments.add(index, segment);
	}

	/**
	 * Creates an empty instance of {@link org.pb.x12.Loop} and inserts the loop as a
	 * child loop at the specified position. The returned instance can be used
	 * to add segments to the child loop.
	 *
	 * @param index
	 *            position at which to add the loop
	 * @param name
	 *            name of the loop
	 * @return a new child {@link org.pb.x12.Loop} object
	 */
	public Loop addChild(int index, String name) {
		Loop l = new Loop(this.context, name);
		l.setParent(this);
		l.depth = this.depth + 1; // debug
		loops.add(index, l);
		return l;
	}

	/**
	 * Checks if the Loop contains the specified child Loop. It will check the
	 * complete child hierarchy.
	 *
	 * @param name
	 *            name of a child loop
	 * @return boolean
	 */
	public boolean hasLoop(String name) {
		for (Loop l : this.childList()) {
			if (name.equals(l.getName())) {
				return true;
			}
			if (l.hasLoop(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the loop in the X12 transaction It will check the complete child
	 * hierarchy.
	 *
	 * @param name
	 *            name of a loop
	 * @return {@link java.util.List}&lt;{@link org.pb.x12.Loop}&gt;
	 */
	public List<Loop> findLoop(String name) {
		List<Loop> foundLoops = new ArrayList<Loop>();
		for (Loop l : this.childList()) {
			if (name.equals(l.getName())) {
				foundLoops.add(l);
			}
			List<Loop> moreLoops = l.findLoop(name);
			if (moreLoops.size() > 0) {
				foundLoops.addAll(moreLoops);
			}
		}
		return foundLoops;
	}

	/**
	 * Get the segment in the X12 transaction It will check the current loop and
	 * the complete child hierarchy.
	 *
	 * @param name
	 *            name of a segment
	 * @return {@link java.util.List}&lt;{@link org.pb.x12.Segment}&gt;
	 */
	public List<Segment> findSegment(String name) {
		List<Segment> foundSegments = new ArrayList<Segment>();
		for (Segment s : this.segments) {
			if (name.equals(s.getElement(0))) {
				foundSegments.add(s);
			}
		}
		for (Loop l : this.childList()) {
			List<Segment> moreSegments = l.findSegment(name);
			if (moreSegments.size() > 0) {
				foundSegments.addAll(moreSegments);
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
	 * Returns the {@link org.pb.x12.Loop} at the specified position.
	 *
	 * @param index the index from which to return the loop.
	 * @return Loop at the specified index
	 */
	public Loop getLoop(int index) {
		return loops.get(index);
	}

	/**
	 * Returns the loops
	 *
	 * @return {@link java.util.List}&lt;{@link org.pb.x12.Loop}&lt;
	 */
	public List<Loop> getLoops() {
		return this.loops;
	}

	/**
	 * Getter for the field {@link org.pb.x12.Loop}.
	 *
	 * @return Parent Loop
	 */
	public Loop getParent() {
		return parent;
	}

	/**
	 * Returns the {@link org.pb.x12.Segment} at the default position.
	 *
	 * @return Segment at the default index
	 */
	public Segment getSegment() {
		return getSegment(0);
	}

	/**
	 * Returns the {@link org.pb.x12.Segment} at the specified position.
	 *
	 * @param index the index from which to get the segment.
	 * @return Segment at the specified index
	 */
	public Segment getSegment(int index) {
		return segments.get(index);
	}

	/**
	 * Returns the segments in the current loop.
	 *
	 * @return {@link java.util.List}
	 */
	public List<Segment> getSegments() {
		return this.segments;
	}
	
	/**
	 * Returns the name of the current Loop.
	 *
	 * @return {@link java.lang.String}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns and {@link java.util.Iterator}to the segments in the loop.
	 *
	 * @return {@link java.util.Iterator}&lt;{@link org.pb.x12.Segment}&gt;
	 */
	public Iterator<Segment> iterator() {
		return segments.iterator();
	}

	/**
	 * Removes the loop at the specified position in this list.
	 *
	 * @param index the index of the loop to remove.
	 * @return the loop that was removed.
	 */
	public Loop removeLoop(int index) {
		return loops.remove(index);
	}
		
	/**
	 * Removes the segment at the specified position in this list.
	 *
	 * @param index the index of the segment to remove.
	 * @return the segment that was removed.
	 */
	public Segment removeSegment(int index) {
		return segments.remove(index);
	}
		
	/**
	 * Returns {@link java.util.List} of child Loops
	 *
	 * @return {@link java.util.List}&lt;{@link org.pb.x12.Loop}&gt;
	 */
	public List<Loop> childList() {
		return this.loops;
	}

	/**
	 * Returns number of segments in Loop and child loops
	 *
	 * @return size
	 */
	public int size() {
		int size;
		size = this.segments.size();
		for (Loop l : this.childList()) {
			size += l.size();
		}
		return size;
	}

	/**
	 * Sets the context of the current transaction.
	 *
	 * @param context the context to set for the current transaction.
	 */
	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * Creates a new {@link org.pb.x12.Loop} and replaces the child loop at the
	 * specified position. The returned instance can be used to add segments to
	 * the child loop.
	 *
	 * @param name
	 *            name of the loop
	 * @param index
	 *            position at which to add the loop.
	 * @return a new child Loop object
	 */
	public Loop setChild(int index, String name) {
		Loop l = new Loop(this.context, name);
		l.setParent(this);
		l.depth = this.depth + 1; // debug
		loops.set(index, l);
		return l;
	}

	/**
	 * Replaces child {@link org.pb.x12.Loop} at the specified position.
	 *
	 * @param index
	 *            position at which to add the loop.
	 * @param loop
	 *            Loop to add
	 */
	public void setChild(int index, Loop loop) {
		loop.setParent(this);
		loop.depth = this.depth + 1; // debug
		loops.set(index, loop);
	}

	/**
	 * Sets the parent to the specified Loop.
	 *
	 * @param parent the loop to use as the parent of this loop.
	 */
	public void setParent(Loop parent) {
		this.parent = parent;
	}
		
	/**
	 * Creates an empty instance of {@link org.pb.x12.Segment} and replaces the
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
	 * {@link java.lang.String} object and replaces the segment at the specified
	 * position in the X12 transaction.
	 *
	 * @param index
	 *            position of the segment to be replaced.
	 * @param segment
	 *           {@link java.lang.String} representation of the Segment.
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
	 * {@link org.pb.x12.Segment} at the specified position in X12 transaction.
	 *
	 * @param index
	 *            position of the segment to be replaced.
	 * @param segment
	 *            {@link org.pb.x12.Segment}
	 */
	public void setSegment(int index, Segment segment) {
		segments.set(index, segment);
	}

	/**
	 * Sets the name of the current Loop
	 *
	 * @param name
	 *            {@link java.lang.String}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the Loop in X12 {@link java.lang.String} format. This method is used
	 * to convert the X12 object into a X12 transaction.
	 *
	 * @return String
	 */
	public String toString() {
		return this.toString(false);
	}
 
	/**
	 * Returns the Loop in X12 {@link java.lang.String} format. This method is used
	 * to convert the X12 object into a X12 transaction.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return String representation of the loop.
	 */
	public String toString(boolean bRemoveTrailingEmptyElements) {
		StringBuilder dump = new StringBuilder();
		for (Segment s : this.segments) {
			dump.append(s.toString(bRemoveTrailingEmptyElements));
			dump.append(context.getSegmentSeparator());
		}
		for (Loop l : this.childList()) {
			dump.append(l.toString(bRemoveTrailingEmptyElements));
		}
		return dump.toString();
	}

	/**
	 * Returns the Loop in XML {@link java.lang.String} format. This method is used
	 * to convert the X12 object into a XML string.
	 *
	 * @return XML String
	 */
	public String toXML() {
		return this.toXML(false);
	}

	/**
	 * Returns the Loop in XML {@link java.lang.String} format. This method is used
	 * to convert the X12 object into a XML string.
	 *
	 * @param bRemoveTrailingEmptyElements a flag for whether or not empty
	 *        trailing elements should be removed.
	 * @return String the loop in XML string format.
	 */
	public String toXML(boolean bRemoveTrailingEmptyElements) {
		StringBuilder dump = new StringBuilder();
		dump.append("<LOOP NAME=\"").append(this.name).append("\">");
		for (Segment s : this.segments) {
			dump.append(s.toXML(bRemoveTrailingEmptyElements));
		}
		for (Loop l : this.childList()) {
			dump.append(l.toXML(bRemoveTrailingEmptyElements));
		}
		dump.append("</LOOP>");
		return dump.toString();
	}

	/**
	 * Generally not used. Mostly for debugging.
	 *
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
}
