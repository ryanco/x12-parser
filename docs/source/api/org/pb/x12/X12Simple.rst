.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

X12Simple
=========

.. java:package:: org.pb.x12
   :noindex:

.. java:type:: public class X12Simple implements EDI, Iterable<Segment>

   The X12 class is the object representation of an ANSI X12 transaction. The building block of an X12 transaction is an element. Some elements may be made of sub elements. Elements combine to form segments. Segments are grouped as loops. And a set of loops form an X12 transaction.

   :author: Prasad Balan

Constructors
------------
X12Simple
^^^^^^^^^

.. java:constructor:: public X12Simple(Context c)
   :outertype: X12Simple

   The constructor takes a context object.

   :param c: a Context object

Methods
-------
addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment()
   :outertype: X12Simple

   Creates an empty instance of \ :java:ref:`Segment`\  and adds the segment to the end of the X12 transaction. The returned instance can be used to add elements to the segment.

   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(String segment)
   :outertype: X12Simple

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and adds the segment to the end of the X12 transaction.

   :param segment: \ :java:ref:`java.lang.String`\  representation of the \ :java:ref:`Segment`\ .
   :return: a new \ :java:ref:`Segment`\  object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(Segment segment)
   :outertype: X12Simple

   Takes a \ :java:ref:`Segment`\  and adds the segment to the end of the X12 transaction.

   :param segment: \ :java:ref:`Segment`\  representation of the Segment.
   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(int index)
   :outertype: X12Simple

   Creates an empty instance of \ :java:ref:`Segment`\  and inserts the segment at the specified position in the X12 transaction. The returned instance can be used to add elements to the segment.

   :param index: position at which to add the segment.
   :return: a new Segment object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(int index, String segment)
   :outertype: X12Simple

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and inserts the segment at the specified position

   :param segment: \ :java:ref:`java.lang.String`\  representation of the \ :java:ref:`Segment`\ .
   :param index: a int.
   :return: a new \ :java:ref:`Segment`\  object

addSegment
^^^^^^^^^^

.. java:method:: public Segment addSegment(int index, Segment segment)
   :outertype: X12Simple

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and inserts the segment at the specified position

   :param segment: \ :java:ref:`java.lang.String`\  representation of the Segment.
   :param index: a int.
   :return: a new Segment object

findSegment
^^^^^^^^^^^

.. java:method:: public List<Segment> findSegment(String name)
   :outertype: X12Simple

   Get the segments in the X12 transaction.

   :param name: name of a segment
   :return: \ :java:ref:`java.util.List`\ <\ :java:ref:`Segment`\ >

getContext
^^^^^^^^^^

.. java:method:: public Context getContext()
   :outertype: X12Simple

   Returns the context of the X12 transaction.

   :return: Context object

getSegment
^^^^^^^^^^

.. java:method:: public Segment getSegment(int index)
   :outertype: X12Simple

   Returns the \ :java:ref:`Segment`\  at the specified position.

   :param index: the position of the segment to return.
   :return: Segment at the specified index

getSegments
^^^^^^^^^^^

.. java:method:: public List<Segment> getSegments()
   :outertype: X12Simple

   Returns the \ :java:ref:`java.util.List`\ <\ :java:ref:`Segment`\ >.

   :return: List of segments

iterator
^^^^^^^^

.. java:method:: public Iterator<Segment> iterator()
   :outertype: X12Simple

   Returns and \ :java:ref:`java.util.Iterator`\ <\ :java:ref:`java.lang.String`\ > to the elements in the segment.

   :return: \ :java:ref:`java.util.Iterator`\ <\ :java:ref:`java.lang.String`\ >

removeSegment
^^^^^^^^^^^^^

.. java:method:: public Segment removeSegment(int index)
   :outertype: X12Simple

   Removes the segment at the specified position in this list.

   :param index: the position of the segment to remove.
   :return: \ :java:ref:`Segment`\

setContext
^^^^^^^^^^

.. java:method:: public void setContext(Context context)
   :outertype: X12Simple

   Sets the context of the current transaction.

   :param context: the context to apply to this object.

setSegment
^^^^^^^^^^

.. java:method:: public Segment setSegment(int index)
   :outertype: X12Simple

   Creates an empty instance of \ :java:ref:`Segment`\  and replaces the segment at specified position in the X12 transaction. The returned instance can be used to add elements to the segment.

   :param index: position at which to add the segment.
   :return: a new Segment object

setSegment
^^^^^^^^^^

.. java:method:: public Segment setSegment(int index, String segment)
   :outertype: X12Simple

   Takes a \ :java:ref:`java.lang.String`\  representation of segment, creates a \ :java:ref:`Segment`\  object and replaces the segment at the specified position in the X12 transaction.

   :param index: position of the segment to be replaced.
   :param segment: \ :java:ref:`java.lang.String`\  representation of the Segment.
   :return: a new Segment object

setSegment
^^^^^^^^^^

.. java:method:: public Segment setSegment(int index, Segment segment)
   :outertype: X12Simple

   Replaces \ :java:ref:`Segment`\  at the specified position in X12 transaction.

   :param index: position of the segment to be replaced.
   :param segment: \ :java:ref:`Segment`\
   :return: a new Segment object

size
^^^^

.. java:method:: public int size()
   :outertype: X12Simple

   Returns number of segments in the transaction

   :return: size

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: X12Simple

   Returns the X12 transaction in \ :java:ref:`java.lang.String`\  format. This method is used to convert the X12 object into a X12 transaction.

   :return: a \ :java:ref:`java.lang.String`\  object.

toString
^^^^^^^^

.. java:method:: public String toString(boolean bRemoveTrailingEmptyElements)
   :outertype: X12Simple

   Returns the X12 representation of the segment.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: the segment as an X12 string.

toXML
^^^^^

.. java:method:: public String toXML()
   :outertype: X12Simple

   Returns the X12 transaction in XML format. This method translates the X12 object into XML format.

   :return: XML string

toXML
^^^^^

.. java:method:: public String toXML(boolean bRemoveTrailingEmptyElements)
   :outertype: X12Simple

   Returns the X12 transaction in XML format. This method translates the X12 object into XML format.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: the X12 as an XML string.

