.. java:import:: com.yarsquidy.x12 Context

.. java:import:: com.yarsquidy.x12 Segment

.. java:import:: com.yarsquidy.x12 X12Simple

exampleCreateX12SimpleTwo
=========================

.. java:package:: com.yarsquidy.x12.example
   :noindex:

.. java:type:: public class exampleCreateX12SimpleTwo

   Example showing how to create a X12 transaction from scratch.

   :author: Prasad Balan

   .. parsed-literal::

      Example of creating a X12 transaction

      //Create a X12 context. Set the segment, element and sub-element separator
      Context c = new Context('˜','*',':');

      //Create a X12 transaction passing the context
      X12Simple x = new X12Simple(c);

      //Add a segments to the X12 transaction
      Segment s = x.addSegment("ISA*00*          *00*      .... T*:");
      s = x.addSegment("GS*1212*SENDERID* ... X*00401");
      s = x.addSegment("ST*835*000000000");

      //Modify one of the elements in ST segment just added
      s.setElement(2,"000000001");

      //Add an empty segment and then add elements
      s = x.addSegment();
      s.addElement('BPR');
      s.addElement('DATA');
      s.addElement('NOT');
      ...
      ...
      //Convert X12 object to string representation
      String x12 = x.toString();

      //Convert X12 object to XML string representation if that is what you need
      String xml = x.toXML();

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: exampleCreateX12SimpleTwo

