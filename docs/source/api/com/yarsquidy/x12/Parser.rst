.. java:import:: java.io File

.. java:import:: java.io IOException

.. java:import:: java.io InputStream

Parser
======

.. java:package:: com.yarsquidy.x12
   :noindex:

.. java:type:: public interface Parser

   Parser interface.

   :author: colwellr

Methods
-------
parse
^^^^^

.. java:method::  EDI parse(File source) throws FormatException, IOException
   :outertype: Parser

   parse.

   :param source: a \ :java:ref:`java.io.File`\  object.
   :throws java.io.IOException: if any.
   :throws FormatException: if any.
   :return: a \ :java:ref:`EDI`\  object.

parse
^^^^^

.. java:method::  EDI parse(String source) throws FormatException
   :outertype: Parser

   parse.

   :param source: a \ :java:ref:`java.lang.String`\  object.
   :throws FormatException: if any.
   :return: a \ :java:ref:`EDI`\  object.

parse
^^^^^

.. java:method::  EDI parse(InputStream source) throws FormatException, IOException
   :outertype: Parser

   parse.

   :param source: a \ :java:ref:`java.io.InputStream`\  object.
   :throws java.io.IOException: if any.
   :throws FormatException: if any.
   :return: a \ :java:ref:`EDI`\  object.

