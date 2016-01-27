.. java:import:: java.io File

.. java:import:: java.net URL

.. java:import:: java.util List

.. java:import:: com.yarsquidy.x12 Cf

.. java:import:: com.yarsquidy.x12 Loop

.. java:import:: com.yarsquidy.x12 Parser

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12

.. java:import:: com.yarsquidy.x12 X12Parser

exampleParseX12FileTwo
======================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleParseX12FileTwo

   Example showing X12 Parser reading a X12 file and looping over the segments.

   :author: Prasad Balan

   .. parsed-literal::

      Example of parsing a X12 file

      This is the modified loop hierarchy of a 835 transaction used in this example.
      The original/actual hierarchy is in example exampleParseX12FileTwo.
      This just illustrates different ways you can setup the hierarchy to achieve
      the desired results.
      Note: Such a hierarchy change will work only when there is not more than
      one Loop with the same identifiers. For e.g. in an 837 transaction both
      Loop 2010BA (Subscriber) and 2330A (Other Subscriber) have the same identifiers,
      which are segment id NM1 and IL at position NM102 (or index 1). This might
      cause the parser to identify both elements as the same loop. In such cases
      it is advisable to maintain the hierarchy.

       +--X12
       |  +--ISA - ISA
       |  +--GS - GS
       |  +--ST - ST - 835, - 1
       |  +--1000A - N1 - PR, - 1
       |  +--1000B - N1 - PE, - 1
       |  +--2000 - LX
       |  +--2100 - CLP
       |  +--2110 - SVC
       |  +--SE - SE
       |  +--GE - GE
       |  +--IEA - IEA

      Cf cf835 = loadCf();
      Parser parser = new X12Parser(cf835);
      // The configuration Cf can be loaded using DI framework.
      // Check the sample spring application context file provided.

      Double totalChargeAmount = 0.0;
      X12 x12 = (X12) parser.parse(new File("C:\\test\\835.txt"));
      List segments = x12.findSegment("CLP");
      for (Segment s : segments) {
          totalChargeAmount = totalChargeAmount + Double.parseDouble(s.getElement(3));
      }
      System.out.println("Total Change Amount " + s.getElement(3));

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: exampleParseX12FileTwo

