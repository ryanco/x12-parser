Context
=======

.. java:package:: com.yarsquidy.x12
   :noindex:

.. java:type:: public class Context

   The class represents an X12 context. A X12 context consists of a segment separator, element separator and a composite element separator.

   :author: Prasad Balan

Constructors
------------
Context
^^^^^^^

.. java:constructor:: public Context()
   :outertype: Context

   Default constructor.

Context
^^^^^^^

.. java:constructor:: public Context(Character s, Character e, Character c)
   :outertype: Context

   Constructor which takes the segment separator, element separator and composite element separator as input.

   :param s: segment separator
   :param e: element separator
   :param c: composite element separator

Methods
-------
getCompositeElementSeparator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public Character getCompositeElementSeparator()
   :outertype: Context

   Returns the composite element separator.

   :return: composite element separator

getElementSeparator
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Character getElementSeparator()
   :outertype: Context

   Returns the element separator.

   :return: an element separator

getSegmentSeparator
^^^^^^^^^^^^^^^^^^^

.. java:method:: public Character getSegmentSeparator()
   :outertype: Context

   Returns the segment separator.

   :return: a segment separator

setCompositeElementSeparator
^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setCompositeElementSeparator(Character c)
   :outertype: Context

   Sets the composite element separator.

   :param c: the composite element separator.

setElementSeparator
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setElementSeparator(Character e)
   :outertype: Context

   Sets the element separator.

   :param e: the element separator.

setSegmentSeparator
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setSegmentSeparator(Character s)
   :outertype: Context

   Sets the segment separator.

   :param s: the segment separator

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Context

   Returns a \ ``String``\  consisting of segment, element and composite element separator.

   :return: a \ :java:ref:`java.lang.String`\  object.

