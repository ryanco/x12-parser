Parse X12 file and loop over segments. (without loop identification)
====================================================================

Introduction 
------------

Example showing Parser reading a X12 file and looping over the segments.

Details 
-------
.. sourcecode:: java

	X12Simple x12 = (X12Simple) new X12SimpleParser().parse(new File("C:\\test\\835.txt"));
	for (Segment s : x12) 
	{
		if (s.getElement(0).equals("CLP")) {
			System.out.println("Total Change Amount " + s.getElement(3));
		}
	}