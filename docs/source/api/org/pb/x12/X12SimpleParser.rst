.. java:import:: java.io BufferedReader

.. java:import:: java.io File

.. java:import:: java.io FileReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

.. java:import:: java.io InputStreamReader

.. java:import:: java.io Reader

.. java:import:: java.util Scanner

.. java:import:: java.util.regex Pattern

X12SimpleParser
===============

.. java:package:: org.pb.x12
   :noindex:

.. java:type:: public class X12SimpleParser implements Parser

   The class represents methods used to translate a X12 transaction represented as a file or string into an X12 object.

   :author: Prasad Balan

Fields
------
POS_COMPOSITE_ELEMENT
^^^^^^^^^^^^^^^^^^^^^

.. java:field:: static final int POS_COMPOSITE_ELEMENT
   :outertype: X12SimpleParser

POS_ELEMENT
^^^^^^^^^^^

.. java:field:: static final int POS_ELEMENT
   :outertype: X12SimpleParser

POS_SEGMENT
^^^^^^^^^^^

.. java:field:: static final int POS_SEGMENT
   :outertype: X12SimpleParser

SIZE
^^^^

.. java:field:: static final int SIZE
   :outertype: X12SimpleParser

Methods
-------
parse
^^^^^

.. java:method:: public EDI parse(File fileName) throws FormatException, IOException
   :outertype: X12SimpleParser

   {@inheritDoc} The method takes a X12 file and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

parse
^^^^^

.. java:method:: public EDI parse(InputStream source) throws FormatException, IOException
   :outertype: X12SimpleParser

   The method takes a InputStream and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

   :param source: InputStream
   :throws java.io.IOException: if any.
   :throws FormatException: if any.
   :return: the X12 object

parse
^^^^^

.. java:method:: public EDI parse(String source) throws FormatException
   :outertype: X12SimpleParser

   The method takes a X12 string and converts it into a X2 object. The X12 class has methods to convert it into XML format as well as methods to modify the contents.

   :param source: String
   :throws FormatException: if any.
   :return: the X12 object

