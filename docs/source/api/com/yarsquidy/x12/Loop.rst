.. java:import:: java.util Iterator

.. java:import:: java.util List

.. java:import:: java.util ArrayList

Loop
====

.. java:package:: com.yarsquidy.x12
   :noindex:

.. java:type:: public class Loop implements Iterable<Segment>

   The Loop class is the representation of an Loop in a ANSI X12 transaction. The building block of an X12 transaction is an element. Some elements may be made of sub elements. Elements combine to form segments. Segments are grouped as loops. And a set of loops form an X12 transaction.

   :author: Prasad Balan

Constructors
------------
Loop
^^^^

.. java:constructor:: public Loop(Context c, String name)
   :outertype: Loop

   The constructor takes a context object.

   :param c: a Context object
   :param name: a \ :java:ref:`java.lang.String`\  object.

Methods
-------
addChild
^^^^^^^^

.. java:method:: public Loop addChild(String name)
   :outertype: Loop

   Creates an empty instance of \ :java:ref:`Loop`\  and adds the loop as a child to the current Loop. The returned instance can be used to add segments to the child loop.

   :param name: name of the loop
   :return: a new child Loop object

addChild
^^^^^^^^

.. java:method:: public void addChild(int index, Loop loop)
   :outertype: Loop

   Inserts \ :java:ref:`Loop`\  as a child loop at the specified position.

   :param index: position at which to add the loop.
   :param loop: a \ :java:ref:`Loop`\  object.

addChild
^^^^^^^^

.. java:method:: public Loop addChild(int index, String name)
   :outertype: Loop

   Creates an empty instance of \ :java:ref:`Loop`\  and inserts the loop as a child loop at the specified position. The returned instance can be used to add segments to the child loop.

   :param index: position at which to add the loop
   :param name: name of the loop
   :return: a new child \ :java:ref:`Loop`\  object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment()
   :outertype: Loop

   Creates an empty instance of \ :java:ref:`Segment`\  and adds the segment to current Loop. The returned instance can be used to add elements to the segment.

   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(String segment)
   :outertype: Loop

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and adds the segment to the current Loop.

   :param segment: \ :java:ref:`java.lang.String`\  representation of the Segment.
   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public void addSegment(Segment segment)
   :outertype: Loop

   Adds \ :java:ref:`Segment`\  at the end of the current Loop

   :param segment: \ :java:ref:`Segment`\

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(int index)
   :outertype: Loop

   Creates an empty instance of \ :java:ref:`Segment`\  and adds the segment at the specified position in the current Loop. The returned instance can be used to add elements to the segment.

   :param index: position at which to add the segment.
   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(int index, String segment)
   :outertype: Loop

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and adds the segment at the specified position in the current Loop.

   :param index: position to add the segment.
   :param segment: \ :java:ref:`java.lang.String`\  representation of the segment.
   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public void addSegment(int index, Segment segment)
   :outertype: Loop

   Adds \ :java:ref:`Segment`\  at the specified position in current Loop.

   :param index: position to add the segment.
   :param segment: \ :java:ref:`Segment`\  representation of the segment.

childList
^^^^^^^^^

.. java:method:: public List<Loop> childList()
   :outertype: Loop

   Returns \ :java:ref:`java.util.List`\  of child Loops

   :return: \ :java:ref:`java.util.List`\ <\ :java:ref:`Loop`\ >

findLoop
^^^^^^^^

.. java:method:: public List<Loop> findLoop(String name)
   :outertype: Loop

   Get the loop in the X12 transaction It will check the complete child hierarchy.

   :param name: name of a loop
   :return: \ :java:ref:`java.util.List`\ <\ :java:ref:`Loop`\ >

findSegment
^^^^^^^^^^^

.. java:method:: public List<Segment> findSegment(String name)
   :outertype: Loop

   Get the segment in the X12 transaction It will check the current loop and the complete child hierarchy.

   :param name: name of a segment
   :return: \ :java:ref:`java.util.List`\ <\ :java:ref:`Segment`\ >

getContext
^^^^^^^^^^

.. java:method:: public Context getContext()
   :outertype: Loop

   Returns the context of the X12 transaction.

   :return: Context object

getDepth
^^^^^^^^

.. java:method:: public int getDepth()
   :outertype: Loop

   Generally not used. Mostly for debugging.

   :return: depth

getLoop
^^^^^^^

.. java:method:: public Loop getLoop(int index)
   :outertype: Loop

   Returns the \ :java:ref:`Loop`\  at the specified position.

   :param index: the index from which to return the loop.
   :return: Loop at the specified index

getLoops
^^^^^^^^

.. java:method:: public List<Loop> getLoops()
   :outertype: Loop

   Returns the loops

   :return: \ :java:ref:`java.util.List`\ <\ :java:ref:`Loop`\ <

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Loop

   Returns the name of the current Loop.

   :return: \ :java:ref:`java.lang.String`\

getParent
^^^^^^^^^

.. java:method:: public Loop getParent()
   :outertype: Loop

   Getter for the field \ :java:ref:`Loop`\ .

   :return: Parent Loop

getSegment
^^^^^^^^^^

.. java:method:: public Segment getSegment()
   :outertype: Loop

   Returns the \ :java:ref:`Segment`\  at the default position.

   :return: Segment at the default index

getSegment
^^^^^^^^^^

.. java:method:: public Segment getSegment(int index)
   :outertype: Loop

   Returns the \ :java:ref:`Segment`\  at the specified position.

   :param index: the index from which to get the segment.
   :return: Segment at the specified index

getSegments
^^^^^^^^^^^

.. java:method:: public List<Segment> getSegments()
   :outertype: Loop

   Returns the segments in the current loop.

   :return: \ :java:ref:`java.util.List`\

hasLoop
^^^^^^^

.. java:method:: public boolean hasLoop(String name)
   :outertype: Loop

   Checks if the Loop contains the specified child Loop. It will check the complete child hierarchy.

   :param name: name of a child loop
   :return: boolean

iterator
^^^^^^^^

.. java:method:: public Iterator<Segment> iterator()
   :outertype: Loop

   Returns and \ :java:ref:`java.util.Iterator`\ to the segments in the loop.

   :return: \ :java:ref:`java.util.Iterator`\ <\ :java:ref:`Segment`\ >

removeLoop
^^^^^^^^^^

.. java:method:: public Loop removeLoop(int index)
   :outertype: Loop

   Removes the loop at the specified position in this list.

   :param index: the index of the loop to remove.
   :return: the loop that was removed.

removeSegment
^^^^^^^^^^^^^

.. java:method:: public Segment removeSegment(int index)
   :outertype: Loop

   Removes the segment at the specified position in this list.

   :param index: the index of the segment to remove.
   :return: the segment that was removed.

setChild
^^^^^^^^

.. java:method:: public Loop setChild(int index, String name)
   :outertype: Loop

   Creates a new \ :java:ref:`Loop`\  and replaces the child loop at the specified position. The returned instance can be used to add segments to the child loop.

   :param name: name of the loop
   :param index: position at which to add the loop.
   :return: a new child Loop object

setChild
^^^^^^^^

.. java:method:: public void setChild(int index, Loop loop)
   :outertype: Loop

   Replaces child \ :java:ref:`Loop`\  at the specified position.

   :param index: position at which to add the loop.
   :param loop: Loop to add

setContext
^^^^^^^^^^

.. java:method:: public void setContext(Context context)
   :outertype: Loop

   Sets the context of the current transaction.

   :param context: the context to set for the current transaction.

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Loop

   Sets the name of the current Loop

   :param name: \ :java:ref:`java.lang.String`\

setParent
^^^^^^^^^

.. java:method:: public void setParent(Loop parent)
   :outertype: Loop

   Sets the parent to the specified Loop.

   :param parent: the loop to use as the parent of this loop.

setSegment
^^^^^^^^^^

.. java:method:: public Segment setSegment(int index)
   :outertype: Loop

   Creates an empty instance of \ :java:ref:`Segment`\  and replaces the segment at specified position in the X12 transaction. The returned instance can be used to add elements to the segment.

   :param index: position at which to add the segment.
   :return: a new Segment object

setSegment
^^^^^^^^^^

.. java:method:: public Segment setSegment(int index, String segment)
   :outertype: Loop

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`java.lang.String`\  object and replaces the segment at the specified position in the X12 transaction.

   :param index: position of the segment to be replaced.
   :param segment: \ :java:ref:`java.lang.String`\  representation of the Segment.
   :return: a new Segment object

setSegment
^^^^^^^^^^

.. java:method:: public void setSegment(int index, Segment segment)
   :outertype: Loop

   Replaces \ :java:ref:`Segment`\  at the specified position in X12 transaction.

   :param index: position of the segment to be replaced.
   :param segment: \ :java:ref:`Segment`\

size
^^^^

.. java:method:: public int size()
   :outertype: Loop

   Returns number of segments in Loop and child loops

   :return: size

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Loop

   Returns the Loop in X12 \ :java:ref:`java.lang.String`\  format. This method is used to convert the X12 object into a X12 transaction.

   :return: String

toString
^^^^^^^^

.. java:method:: public String toString(boolean bRemoveTrailingEmptyElements)
   :outertype: Loop

   Returns the Loop in X12 \ :java:ref:`java.lang.String`\  format. This method is used to convert the X12 object into a X12 transaction.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: String representation of the loop.

toXML
^^^^^

.. java:method:: public String toXML()
   :outertype: Loop

   Returns the Loop in XML \ :java:ref:`java.lang.String`\  format. This method is used to convert the X12 object into a XML string.

   :return: XML String

toXML
^^^^^

.. java:method:: public String toXML(boolean bRemoveTrailingEmptyElements)
   :outertype: Loop

   Returns the Loop in XML \ :java:ref:`java.lang.String`\  format. This method is used to convert the X12 object into a XML string.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: String the loop in XML string format.

