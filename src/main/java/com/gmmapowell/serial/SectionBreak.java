package com.gmmapowell.serial;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.zinutils.xml.XML;

import com.gmmapowell.script.flow.SpanItem;
import com.gmmapowell.script.sink.epub.EPubAware;
import com.gmmapowell.script.sink.epub.XHTMLCollector;

public class SectionBreak implements SpanItem, EPubAware {

	@Override
	public void intForm(DataOutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public BoundingBox bbox(PDFont font, float sz) throws IOException {
		return new BoundingBox(0, 0, 0, 20);
	}
	
	@Override
	public void handle(XHTMLCollector coll) {
		XML xml = XML.create("1.0", "hr");
		coll.insert(xml.top());
	}

	@Override
	public String toString() {
		return "SectionBreak";
	}
}
