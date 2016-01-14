X12 Configuration for Loop Detection
===

# Introduction #

To enable the X12 parser to detect loops, a configuration object (Cf) needs to be created with the Loop details. Configuration object is created based on the X12 transaction to be parsed. Different variations of the configuration object can be created allowing Parser to parse the X12 file to meet the specific needs.

# Simple/Flattened Hierarchy #

Here is a sample 835 hierarchy which is flattened. Some may not be interested in the hierarchy of the loops.

```
  +--X12
  |  +--ISA   - ISA
  |  +--GS    - GS
  |  +--ST    - ST  - 835, - 1
  |  +--1000A - N1  - PR,  - 1
  |  +--1000B - N1  - PE,  - 1
  |  +--2000  - LX
  |  +--2100  - CLP
  |  +--2110  - SVC
  |  +--SE    - SE  
  |  +--GE    - GE  
  |  +--IEA   - IEA

Format: LoopName - SegmentId - SegmentQualifier - SegmentQualifierPosition
Note: Separate multiple qualifiers with a COMMA.
```

```
Cf cfX12 = new Cf("X12");

cfX12.addChild("ISA", "ISA");
cfX12.addChild("GS", "GS");
cfX12.addChild("ST", "ST", "835", 1);
cfX12.addChild("1000A", "N1", "PR", 1);
cfX12.addChild("1000B", "N1", "PE", 1);
cfX12.addChild("2000", "LX");
cfX12.addChild("2100", "CLP");
cfX12.addChild("2110", "SVC");
cfX12.addChild("GE", "GE");
cfX12.addChild("IEA", "IEA");

System.out.println(cfX12);

```

# Actual Hierarchy #

Here is a sample 835 hierarchy with the actual loop hierarchy.

```
 +--X12
 |  +--ISA                 - ISA
 |  |  +--GS               - GS
 |  |  |  +--ST            - ST   - 835, - 1
 |  |  |  |  +--1000A      - N1   - PR,  - 1
 |  |  |  |  +--1000B      - N1   - PE,  - 1
 |  |  |  |  +--2000       - LX
 |  |  |  |  |  +--2100    - CLP
 |  |  |  |  |  |  +--2110 - SVC
 |  |  |  +--SE            - SE
 |  |  +--GE               - GE
 |  +--IEA                 - IEA

Format: LoopName - SegmentId - SegmentQualifier - SegmentQualifierPosition
Note: Separate multiple qualifiers with a COMMA.
```

Example of how to create a configuration object for the above hierarchy.

```
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

System.out.println(cfX12);
```