package org.pb.x12;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.junit.Test;

public class X12SimpleParserSpecialCharsTest {

	@Test
	public void testParseFile() throws FormatException, IOException {
		Parser parser = new X12SimpleParser();
		URL url = this.getClass().getResource(
				"/example835SpecialCharsOne.txt");
		File f1 = new File(url.getFile());

		X12Simple x12 = (X12Simple) parser.parse(f1);

		assertEquals(
				"ISA*00*          *00*          *ZZ*SENDERID       *ZZ*RECEIVERID    *030409*0701*U*00401*0000000001*0*T*:^"
						+ "GS*1212*SENDERID*RECEIVERID*0701*000000001*X*00401^"
						+ "ST*835*000000001^"
						+ "BPR*DATA*NOT*VALID*RANDOM*TEXT^"
						+ "TRN*1*0000000000*1999999999^"
						+ "DTM*111*20090915^"
						+ "N1*PR*ALWAYS INSURANCE COMPANY^"
						+ "N7*AROUND THE CORNER^"
						+ "N4*SHINE CITY*GREEN STATE*ZIP^"
						+ "REF*DT*435864864^"
						+ "N1*PE*FI*888888888*P.O.BOX 456*SHINE CITY*GREEN STATE*ZIP*EARTH^"
						+ "LX*1^"
						+ "CLP*PCN123456789**5555.55**CCN987654321^"
						+ "CAS*PR*909099*100.00^"
						+ "NM1*QC*1*PATIENT*TREATED*ONE***34*333333333^"
						+ "DTM*273*20020824^"
						+ "AMT*A1*10.10^"
						+ "AMT*A2*20.20^"
						+ "LX*2^"
						+ "CLP*PCN123456789**4444.44**CCN987654321^"
						+ "CAS*PR*909099*200.00^"
						+ "NM1*QC*1*PATIENT*TREATED*TWO***34*444444444^"
						+ "DTM*273*20020824^"
						+ "AMT*A1*30.30^"
						+ "AMT*A2*40.40^"
						+ "SE*24*000000001^"
						+ "GE*1*000000001^" + "IEA*1*000000001^", x12
						.toString());
	}

	@Test
	public void testParseInputStream() throws FormatException, IOException {
		Parser parser = new X12SimpleParser();
		InputStream is = this.getClass()
				.getResourceAsStream("/example835SpecialCharsOne.txt");

		X12Simple x12 = (X12Simple) parser.parse(is);

		assertEquals(
				"ISA*00*          *00*          *ZZ*SENDERID       *ZZ*RECEIVERID    *030409*0701*U*00401*0000000001*0*T*:^"
						+ "GS*1212*SENDERID*RECEIVERID*0701*000000001*X*00401^"
						+ "ST*835*000000001^"
						+ "BPR*DATA*NOT*VALID*RANDOM*TEXT^"
						+ "TRN*1*0000000000*1999999999^"
						+ "DTM*111*20090915^"
						+ "N1*PR*ALWAYS INSURANCE COMPANY^"
						+ "N7*AROUND THE CORNER^"
						+ "N4*SHINE CITY*GREEN STATE*ZIP^"
						+ "REF*DT*435864864^"
						+ "N1*PE*FI*888888888*P.O.BOX 456*SHINE CITY*GREEN STATE*ZIP*EARTH^"
						+ "LX*1^"
						+ "CLP*PCN123456789**5555.55**CCN987654321^"
						+ "CAS*PR*909099*100.00^"
						+ "NM1*QC*1*PATIENT*TREATED*ONE***34*333333333^"
						+ "DTM*273*20020824^"
						+ "AMT*A1*10.10^"
						+ "AMT*A2*20.20^"
						+ "LX*2^"
						+ "CLP*PCN123456789**4444.44**CCN987654321^"
						+ "CAS*PR*909099*200.00^"
						+ "NM1*QC*1*PATIENT*TREATED*TWO***34*444444444^"
						+ "DTM*273*20020824^"
						+ "AMT*A1*30.30^"
						+ "AMT*A2*40.40^"
						+ "SE*24*000000001^"
						+ "GE*1*000000001^" + "IEA*1*000000001^", x12
						.toString());
	}

	@Test
	public void testParseString() throws FormatException {
		String inputString = "ISA*00*          *00*          *ZZ*SENDERID       *ZZ*RECEIVERID    *030409*0701*U*00401*0000000001*0*T*:^"
				+ "GS*1212*SENDERID*RECEIVERID*0701*000000001*X*00401^"
				+ "ST*835*000000001^"
				+ "BPR*DATA*NOT*VALID*RANDOM*TEXT^"
				+ "TRN*1*0000000000*1999999999^"
				+ "DTM*111*20090915^"
				+ "N1*PR*ALWAYS INSURANCE COMPANY^"
				+ "N7*AROUND THE CORNER^"
				+ "N4*SHINE CITY*GREEN STATE*ZIP^"
				+ "REF*DT*435864864^"
				+ "N1*PE*FI*888888888*P.O.BOX 456*SHINE CITY*GREEN STATE*ZIP*EARTH^"
				+ "LX*1^"
				+ "CLP*PCN123456789**5555.55**CCN987654321^"
				+ "CAS*PR*909099*100.00^"
				+ "NM1*QC*1*PATIENT*TREATED*ONE***34*333333333^"
				+ "DTM*273*20020824^"
				+ "AMT*A1*10.10^"
				+ "AMT*A2*20.20^"
				+ "LX*2^"
				+ "CLP*PCN123456789**4444.44**CCN987654321^"
				+ "CAS*PR*909099*200.00^"
				+ "NM1*QC*1*PATIENT*TREATED*TWO***34*444444444^"
				+ "DTM*273*20020824^"
				+ "AMT*A1*30.30^"
				+ "AMT*A2*40.40^"
				+ "SE*24*000000001^" + "GE*1*000000001^" + "IEA*1*000000001^";

		Parser parser = new X12SimpleParser();
		X12Simple x12 = (X12Simple) parser.parse(inputString);

		assertEquals(inputString, x12.toString());
	}

	@Test
	public void testParseNonAsciiElementSeparator() throws IOException, FormatException {
		Parser parser = new X12SimpleParser();
		URL url = this.getClass().getResource(
				"/example835nonasciielemsep.txt");
		File f1 = new File(url.getFile());

		X12Simple x12 = (X12Simple) parser.parse(f1);
		Segment st = x12.getSegment(2);
		String start_st = st.getElement(0);
		String type_st = st.getElement(1);

		List<Segment> geSegments = x12.findSegment("GE");
		Segment ge = geSegments.get(0);
		String start_gs = ge.getElement(0);
		String count_gs = ge.getElement(1);

		assertEquals("ST", start_st);
		assertEquals("835", type_st);
		assertEquals(1, geSegments.size());
		assertEquals("GE", start_gs);
		assertEquals("1", count_gs);
	}

	@Test
	public void testParseNonAsciiSegmentSeparator() throws IOException, FormatException {
		Parser parser = new X12SimpleParser();
		URL url = this.getClass().getResource(
				"/example852nonasciisegsep.txt");
		File f1 = new File(url.getFile());

		X12Simple x12 = (X12Simple) parser.parse(f1);
		Segment st = x12.getSegment(2);
		String start_st = st.getElement(0);
		String type_st = st.getElement(1);

		List<Segment> geSegments = x12.findSegment("GE");
		Segment ge = geSegments.get(0);
		String start_gs = ge.getElement(0);
		String count_gs = ge.getElement(1);

		assertEquals("ST", start_st);
		assertEquals("852", type_st);
		assertEquals(1, geSegments.size());
		assertEquals("GE", start_gs);
		assertEquals("2", count_gs);
	}
}
