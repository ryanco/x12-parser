.. java:import:: java.io File

.. java:import:: java.net URL

.. java:import:: java.util List

.. java:import:: com.yarsquidy.x12 Cf

.. java:import:: com.yarsquidy.x12 Loop

.. java:import:: com.yarsquidy.x12 Parser

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12

.. java:import:: com.yarsquidy.x12 X12Parser

.. java:import:: org.springframework.beans.factory BeanFactory

.. java:import:: org.springframework.beans.factory.xml XmlBeanFactory

.. java:import:: org.springframework.core.io FileSystemResource

.. java:import:: org.springframework.core.io Resource

exampleSpringParseX12FileOne
============================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleSpringParseX12FileOne

   Example showing X12 Parser reading a X12 file and looping over the segments.

   :author: Prasad Balan

   .. parsed-literal::

      Example of using Spring to load the configuration

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
      // Check this example to see how to load configuration using Spring.

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
   :outertype: exampleSpringParseX12FileOne

