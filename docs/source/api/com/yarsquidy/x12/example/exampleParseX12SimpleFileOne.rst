.. java:import:: java.io File

.. java:import:: java.net URL

.. java:import:: com.yarsquidy.x12 Parser

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12Simple

.. java:import:: com.yarsquidy.x12 X12SimpleParser

exampleParseX12SimpleFileOne
============================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleParseX12SimpleFileOne

   Example showing X12Simple Parser reading a X12 file and looping over the segments.

   :author: Prasad Balan

   .. parsed-literal::

      Example of parsing a X12 file

      X12Simple x12 = (X12Simple) new X12SimpleParser().parse(new File("C:\\test\\835.txt"));
      for (Segment s : x12) {
          if (s.getElement(0).equals("CLP")) {
              System.out.println("Total Change Amount " + s.getElement(3));
          }
      }

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: exampleParseX12SimpleFileOne

