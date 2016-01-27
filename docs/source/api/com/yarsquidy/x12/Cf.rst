.. java:import:: java.util ArrayList

.. java:import:: java.util List

Cf
==

.. java:package:: com.yarsquidy.x12
   :noindex:

.. java:type:: public class Cf

   The \ ``Cf``\  class represents a configuration element. Each Cf instance represents items required to identify a Loop in a X12 transaction. Some Loops can be identified by only the segment id. Others require segment id and additional qualifiers to be able to identify the Loop. \ ``Cf``\  needs to be used in conjunction with X12Parser, to be able to parse a X12 transaction into a loop hierarchy. A X12 Cf can be loaded using many ways: custom code O/X mapping DI or any other way you may find appropriate A Sample 835 hierarchy is shown below. Each row shows a Cf element, in the format

   .. parsed-literal::

      (A) - (B) - (C) - (D)
      (A) - Loop Name
      (B) - Segment id, that identifies the loop
      (C) - Segment qualifiers, that are needed to identify the loop. If there are multiple
            qualifiers they need to be separated by COMMA.
      (D) - Position in the segment where the qualifiers are present

   e.g. In X12 835, Loops 1000A and 1000B have the same segment id (N1), to differentiate them we need additional attributes. The N102 (index 1) element has PR for 1000A loop and PE for 1000B loop.

   .. parsed-literal::

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

   To parse a X12 835 in the above hierarchy, you need to create a Cf object that represent the hierarchy. Here is the sample code to achieve this.

   .. parsed-literal::

      Cf cfX12 = new Cf("X12"); // root node
      Cf cfISA = cfX12.addChild("ISA", "ISA"); // add as child of X12
      Cf cfGS = cfISA.addChild("GS", "GS"); // add as child of ISA
      Cf cfST = cfGS.addChild("ST", "ST", "835", 1); // add as child of GS
      cfST.addChild("1000A", "N1", "PR", 1); // add as child of ST
      cfST.addChild("1000B", "N1", "PE", 1); // add as child of ST
      Cf cf2000 = cfST.addChild("2000", "LX")
      Cf cf2100 = cf2000.addChild("2100", "CLP");
      cf2100.addChild("2110", "SVC");
      cfISA.addChild("GE", "GE");
      cfX12.addChild("IEA", "IEA");

   Alternate hierarchy for the same transaction. On most occasions a simple hierarchy like below would work. Only when there is more that one loop that is identified by the same segment id and additional qualifiers, you need to put them under the appropriate parent Cf.

   .. parsed-literal::

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

   :author: Prasad Balan

Constructors
------------
Cf
^^

.. java:constructor:: public Cf(String name)
   :outertype: Cf

   Constructor for Cf.

   :param name: a \ :java:ref:`java.lang.String`\  object.

Cf
^^

.. java:constructor:: public Cf(String name, String segment)
   :outertype: Cf

   Constructor for Cf.

   :param name: a \ :java:ref:`java.lang.String`\  object.
   :param segment: a \ :java:ref:`java.lang.String`\  object.

Cf
^^

.. java:constructor:: public Cf(String name, String segment, String segmentQual, Integer segmentQualPos)
   :outertype: Cf

   Constructor for Cf.

   :param name: a \ :java:ref:`java.lang.String`\  object.
   :param segment: a \ :java:ref:`java.lang.String`\  object.
   :param segmentQual: a \ :java:ref:`java.lang.String`\  object.
   :param segmentQualPos: a \ :java:ref:`java.lang.Integer`\  object.

Methods
-------
addChild
^^^^^^^^

.. java:method:: public void addChild(Cf cf)
   :outertype: Cf

   addChild.

   :param cf: a \ :java:ref:`Cf`\  object.

addChild
^^^^^^^^

.. java:method:: public Cf addChild(String name, String segment)
   :outertype: Cf

   addChild.

   :param name: a \ :java:ref:`java.lang.String`\  object.
   :param segment: a \ :java:ref:`java.lang.String`\  object.
   :return: a \ :java:ref:`Cf`\  object.

addChild
^^^^^^^^

.. java:method:: public Cf addChild(String name, String segment, String segmentQual, Integer segmentQualPos)
   :outertype: Cf

   addChild.

   :param name: a \ :java:ref:`java.lang.String`\  object.
   :param segment: a \ :java:ref:`java.lang.String`\  object.
   :param segmentQual: a \ :java:ref:`java.lang.String`\  object.
   :param segmentQualPos: a \ :java:ref:`java.lang.Integer`\  object.
   :return: a \ :java:ref:`Cf`\  object.

childList
^^^^^^^^^

.. java:method:: public List<Cf> childList()
   :outertype: Cf

   childList.

   :return: a \ :java:ref:`java.util.List`\  object.

getName
^^^^^^^

.. java:method:: public String getName()
   :outertype: Cf

   Getter for the field \ ``name``\ .

   :return: a \ :java:ref:`java.lang.String`\  object.

getParent
^^^^^^^^^

.. java:method:: public Cf getParent()
   :outertype: Cf

   Getter for the field \ ``parent``\ .

   :return: a \ :java:ref:`Cf`\  object.

getSegment
^^^^^^^^^^

.. java:method:: public String getSegment()
   :outertype: Cf

   Getter for the field \ ``segment``\ .

   :return: a \ :java:ref:`java.lang.String`\  object.

getSegmentQualPos
^^^^^^^^^^^^^^^^^

.. java:method:: public Integer getSegmentQualPos()
   :outertype: Cf

   Getter for the field \ ``segmentQualPos``\ .

   :return: a \ :java:ref:`java.lang.Integer`\  object.

getSegmentQuals
^^^^^^^^^^^^^^^

.. java:method:: public String[] getSegmentQuals()
   :outertype: Cf

   Getter for the field \ ``segmentQuals``\ .

   :return: an array of \ :java:ref:`java.lang.String`\  objects.

hasChildren
^^^^^^^^^^^

.. java:method:: public boolean hasChildren()
   :outertype: Cf

   hasChildren.

   :return: a boolean.

hasParent
^^^^^^^^^

.. java:method:: public boolean hasParent()
   :outertype: Cf

   hasParent.

   :return: a boolean.

setChildren
^^^^^^^^^^^

.. java:method:: public void setChildren(List<Cf> cfList)
   :outertype: Cf

   Setter for the field \ ``children``\ .

   :param cfList: a \ :java:ref:`java.util.List`\  object.

setName
^^^^^^^

.. java:method:: public void setName(String name)
   :outertype: Cf

   Setter for the field \ ``name``\ .

   :param name: a \ :java:ref:`java.lang.String`\  object.

setParent
^^^^^^^^^

.. java:method:: public void setParent(Cf cf)
   :outertype: Cf

   Setter for the field \ ``parent``\ .

   :param cf: a \ :java:ref:`Cf`\  object.

setSegment
^^^^^^^^^^

.. java:method:: public void setSegment(String segment)
   :outertype: Cf

   Setter for the field \ ``segment``\ .

   :param segment: a \ :java:ref:`java.lang.String`\  object.

setSegmentQualPos
^^^^^^^^^^^^^^^^^

.. java:method:: public void setSegmentQualPos(Integer segmentQualPos)
   :outertype: Cf

   Setter for the field \ ``segmentQualPos``\ .

   :param segmentQualPos: a \ :java:ref:`java.lang.Integer`\  object.

setSegmentQuals
^^^^^^^^^^^^^^^

.. java:method:: public void setSegmentQuals(String[] segmentQuals)
   :outertype: Cf

   Setter for the field \ ``segmentQuals``\ .

   :param segmentQuals: an array of \ :java:ref:`java.lang.String`\  objects.

toString
^^^^^^^^

.. java:method:: public String toString()
   :outertype: Cf

   toString.

   :return: a \ :java:ref:`java.lang.String`\  object.

