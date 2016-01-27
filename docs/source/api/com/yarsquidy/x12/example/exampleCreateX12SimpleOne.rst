.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12Simple

.. java:import:: com.yarsquidy.x12 Context

exampleCreateX12SimpleOne
=========================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleCreateX12SimpleOne

   Example showing how to create a X12 transaction from scratch.

   :author: Prasad Balan

   .. parsed-literal::

      Example of creating a X12 transaction

      //Create a X12 context. Set the segment, element and sub-element separator
      Context c = new Context('~','*',':');

      //Create a X12 passing the context
      X12Simple x = new X12Simple(c);

      //Add a segment to the X12
      Segment s = x.addSegment();

      //Add elements to the segment
      s.addElement("ISA");
      s.addElement("00");
      ...
      //Continue to add segments and then add elements
      s = x.addSegment();
      s.addElement("GS");
      s.addElement("121");
      ...

      //Convert X12Simple object to X12 string representation
      String x12 = x.toString();

      //Convert X12 object to XML string representation if that is what you need
      String xml = x.toXML();

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: exampleCreateX12SimpleOne

