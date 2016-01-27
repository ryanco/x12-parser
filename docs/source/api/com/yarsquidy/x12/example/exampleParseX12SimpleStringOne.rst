.. java:import:: com.yarsquidy.x12 Parser

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12Simple

.. java:import:: com.yarsquidy.x12 X12SimpleParser

exampleParseX12SimpleStringOne
==============================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleParseX12SimpleStringOne

   Example showing X12Simple Parser reading a X12 String and looping over the segments.

   :author: Prasad Balan

   .. parsed-literal::

      Example of parsing a X12 String

      X12Simple x12 = new X12SimpleParser().parse("ISA*00*          *00*          *ZZ*SENDERID ......... "));
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
   :outertype: exampleParseX12SimpleStringOne

