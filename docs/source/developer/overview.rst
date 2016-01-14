x12-Parser Overview
======================================
ASC X12 standards define one of the widely used EDI formats. This library enables easy parsing and creation of X12 transactions.

Parse X12 transactions (With Loop identification introduced with version 0.7). 

**See example** :doc:`ParseWithLoopDetection`

Create X12 transactions.

Convert X12 to XML.

See :doc:`../api/packages` for more details.

Explanation of Object Types
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

* **Cf** - class represents a configuration element. Each Cf instance represents items required to identify a Loop in a X12 
  transaction. Some Loops can be identified by only the segment id. Others require segment id and additional qualifiers 
  to be able to identify the Loop.
* **Context** - The class represents an X12 context. A X12 context consists of a segment separator, element separator and a 
  composite element separator.
* **Loop** - The Loop class is the representation of an Loop in a ANSI X12 transaction. Segments are grouped as loops. And a 
  set of loops form an X12 transaction.
* **Parser**
* **Segment** - An aggregation of elements.
* **Element** - The building block of an X12 transaction is an element. Some elements may be made of sub elements.

Limitations
~~~~~~~~~~~
This library cannot validate a X12 transaction.
When parsing, reads the whole X12 transaction into memory.

Current Version
~~~~~~~~~~~~~~~
* V1.0 - 21st May 2013
* V0.9 - 16th Apr 2011