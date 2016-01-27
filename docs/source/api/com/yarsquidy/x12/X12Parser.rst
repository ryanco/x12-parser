.. java:import:: java.io BufferedReader

.. java:import:: java.io File

.. java:import:: java.io FileReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.io InputStreamReader

.. java:import:: java.io Reader

.. java:import:: java.util Scanner

.. java:import:: java.util.regex Pattern

X12Parser
=========

.. java:package:: com.yarsquidy.x12
   :noindex:

.. java:type:: public class X12Parser implements Parser

   The class represents methods used to translate a X12 transaction represented as a file or string into an X12 object.

   :author: Prasad Balan

Fields
------
POS_COMPOSITE_ELEMENT
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: public static final int POS_COMPOSITE_ELEMENT
   :outertype: X12Parser

   Constant \ ``POS_COMPOSITE_ELEMENT=104``\

POS_ELEMENT
^^^^^^^^^^^

.. java:field:: public static final int POS_ELEMENT
   :outertype: X12Parser

   Constant \ ``POS_ELEMENT=3``\

POS_SEGMENT
^^^^^^^^^^^

.. java:field:: public static final int POS_SEGMENT
   :outertype: X12Parser

   Constant \ ``POS_SEGMENT=105``\

START_TAG
^^^^^^^^^

.. java:field:: public static final String START_TAG
   :outertype: X12Parser

   Constant \ ``START_TAG="ISA"``\

Constructors
------------
X12Parser
^^^^^^^^^

.. java:constructor:: public X12Parser(Cf cf)
   :outertype: X12Parser

   Constructor for X12Parser.

   :param cf: a \ :java:ref:`Cf`\  object.

Methods
-------
doesChildLoopMatch
^^^^^^^^^^^^^^^^^^

.. java:method::  boolean doesChildLoopMatch(Cf parent, String[] tokens)
   :outertype: X12Parser

   Checks if the segment (or line read) matches to any of the child loops configuration.

   :param parent: Cf
   :param tokens: String[] represents the segment broken into elements
   :return: boolean

parse
^^^^^

.. java:method:: public EDI parse(File fileName) throws FormatException, IOException
   :outertype: X12Parser

   {@inheritDoc} The method takes a X12 file and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

parse
^^^^^

.. java:method:: public EDI parse(InputStream source) throws FormatException, IOException
   :outertype: X12Parser

   The method takes a InputStream and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

   :param source: InputStream
   :throws java.io.IOException: if any.
   :throws FormatException: if any.
   :return: the X12 object

parse
^^^^^

.. java:method:: public EDI parse(String source) throws FormatException
   :outertype: X12Parser

   The method takes a X12 string and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

   :param source: String
   :throws FormatException: if any.
   :return: the X12 object

