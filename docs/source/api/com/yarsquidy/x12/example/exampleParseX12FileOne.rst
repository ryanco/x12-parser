.. java:import:: java.io File

.. java:import:: java.net URL

.. java:import:: java.util List

.. java:import:: com.yarsquidy.x12 Cf

.. java:import:: com.yarsquidy.x12 Loop

.. java:import:: com.yarsquidy.x12 Parser

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12

.. java:import:: com.yarsquidy.x12 X12Parser

exampleParseX12FileOne
======================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleParseX12FileOne

   Example showing X12 Parser reading a X12 file and looping over the segments.

   :author: Prasad Balan

   .. parsed-literal::

      Example of parsing a X12 file

      This is the loop hierarchy of a 835 transaction used here.

      +--X12
      |  +--ISA - ISA
      |  |  +--GS - GS
      |  |  |  +--ST - ST - 835, - 1
      |  |  |  |  +--1000A - N1 - PR, - 1
      |  |  |  |  +--1000B - N1 - PE, - 1
      |  |  |  |  +--2000 - LX
      |  |  |  |  |  +--2100 - CLP
      |  |  |  |  |  |  +--2110 - SVC
      |  |  |  +--SE - SE
      |  |  +--GE - GE
      |  +--IEA - IEA

      Cf cf835 = loadCf();
      Parser parser = new X12Parser(cf835);
      // The configuration Cf can be loaded using DI framework.
      // Check the sample spring application context file provided.

      Double totalChargeAmount = 0.0;
      X12 x12 = (X12) parser.parse(new File("C:\\test\\835.txt"));
      List<Segment> segments = x12.findSegment("CLP");
      for (Segment s : segments) {
          totalChargeAmount = totalChargeAmount + Double.parseDouble(s.getElement(3));
      }
      System.out.println("Total Change Amount " + s.getElement(3));

   .. parsed-literal::

      Example of how to create a configuration object for the above hierarchy

      private static Cf loadCf() {
          Cf cfX12 = new Cf("X12");
          Cf cfISA = cfX12.addChild("ISA", "ISA");
          Cf cfGS = cfISA.addChild("GS", "GS");
          Cf cfST = cfGS.addChild("ST", "ST", "835", 1);
          cfST.addChild("1000A", "N1", "PR", 1);
          cfST.addChild("1000B", "N1", "PE", 1);
          Cf cf2000 = cfST.addChild("2000", "LX");
          Cf cf2100 = cf2000.addChild("2100", "CLP");
          cf2100.addChild("2110", "SVC");
          cfISA.addChild("GE", "GE");
          cfX12.addChild("IEA", "IEA");
          //System.out.println(cfX12);
          return cfX12;
      }

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: exampleParseX12FileOne

