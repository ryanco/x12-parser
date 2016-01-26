.. java:import:: java.util ArrayList

.. java:import:: java.util Iterator

.. java:import:: java.util List

Segment
=======

.. java:package:: org.pb.x12
   :noindex:

.. java:type:: public class Segment implements Iterable<String>

   This class represents an X12 segment.

   :author: Prasad Balan

Constructors
------------
Segment
^^^^^^^

.. java:constructor:: public Segment(Context c)
   :outertype: Segment

   The constructor takes a \ :java:ref:`Context`\  object as input. The context object represents the delimiters in a X12 transaction.

   :param c: the context object

Methods
-------
addCompositeElement
^^^^^^^^^^^^^^^^^^^

.. java:method:: public boolean addCompositeElement(String... ces)
   :outertype: Segment

   Adds strings as a composite element to the end of the segment.

   :param ces: sub-elements of a composite element
   :return: boolean

addCompositeElement
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addCompositeElement(int index, String... ces)
   :outertype: Segment

   Inserts strings as a composite element to segment at specified position

   :param ces: sub-elements of a composite element
   :param index: a int.

addElement
^^^^^^^^^^

.. java:method:: public boolean addElement(String e)
   :outertype: Segment

   Adds \ :java:ref:`java.lang.String`\  element to the segment. The element is added at the end of the elements in the current segment.

   :param e: the element to be added
   :return: boolean

addElement
^^^^^^^^^^

.. java:method:: public boolean addElement(int index, String e)
   :outertype: Segment

   Inserts \ :java:ref:`java.lang.String`\  element to the segment at the specified position

   :param e: the element to be added
   :param index: a int.
   :return: boolean true if element matches the element at the index provided.

addElements
^^^^^^^^^^^

.. java:method:: public boolean addElements(String s)
   :outertype: Segment

   Adds \ :java:ref:`java.lang.String`\  with elements to the segment. The elements are added at the end of the elements in the current segment. e.g. \ ``addElements("ISA*ISA01*ISA02");``\

   :param s: the element to add.
   :return: boolean

addElements
^^^^^^^^^^^

.. java:method:: public boolean addElements(String... es)
   :outertype: Segment

   Adds \ :java:ref:`java.lang.String`\  elements to the segment. The elements are added at the end of the elements in the current segment. e.g. \ ``addElements("ISA", "ISA01", "ISA02");``\

   :param es: elements to add.
   :return: boolean

getContext
^^^^^^^^^^

.. java:method:: public Context getContext()
   :outertype: Segment

   Returns the context object

   :return: Context object

getElement
^^^^^^^^^^

.. java:method:: public String getElement(int index)
   :outertype: Segment

   Returns the \ :java:ref:`java.lang.String`\  element at the specified position.

   :param index: position
   :return: the element at the specified position.

getElements
^^^^^^^^^^^

.. java:method:: public List<String> getElements()
   :outertype: Segment

   Getter for the field \ :java:ref:`java.util.List`\ <\ :java:ref:`java.lang.String`\ >

   :return: List of elements

iterator
^^^^^^^^

.. java:method:: public Iterator<String> iterator()
   :outertype: Segment

   Returns and \ :java:ref:`java.util.Iterator`\ <\ :java:ref:`java.lang.String`\ > to the elements in the segment.

   :return: \ :java:ref:`java.util.Iterator`\ <\ :java:ref:`java.lang.String`\ >

removeElement
^^^^^^^^^^^^^

.. java:method:: public String removeElement(int index)
   :outertype: Segment

   Removes the element at the specified position in this list.

   :param index: the index at which to remove the element.
   :return: String element that was removed.

setCompositeElement
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCompositeElement(int index, String... ces)
   :outertype: Segment

   Replaces composite element at the specified position in segment.

   :param ces: sub-elements of a composite element
   :param index: a int.

setContext
^^^^^^^^^^

.. java:method:: public void setContext(Context context)
   :outertype: Segment

   Sets the context of the segment

   :param context: context object

setElement
^^^^^^^^^^

.. java:method:: public void setElement(int index, String s)
   :outertype: Segment

   Replaces element at the specified position with the specified \ :java:ref:`java.lang.String`\

   :param index: position of the element to be replaced
   :param s: new element with which to replace

size
^^^^

.. java:method:: public int size()
   :outertype: Segment

   Returns number of elements in the segment.

   :return: size

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Segment

   Returns the X12 representation of the segment.

   :return: a \ :java:ref:`java.lang.String`\  object.

toString
^^^^^^^^

.. java:method:: public String toString(boolean bRemoveTrailingEmptyElements)
   :outertype: Segment

   Returns the X12 representation of the segment.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: \ :java:ref:`java.lang.String`\

toXML
^^^^^

.. java:method:: public String toXML()
   :outertype: Segment

   Returns the XML representation of the segment.

   :return: \ :java:ref:`java.lang.String`\  XML representation of the segment.

toXML
^^^^^

.. java:method:: public String toXML(boolean bRemoveTrailingEmptyElements)
   :outertype: Segment

   Returns the XML representation of the segment.

   :param bRemoveTrailingEmptyElements: a flag for whether or not empty trailing elements should be removed.
   :return: \ :java:ref:`java.lang.String`\  XML representation of the segment.

