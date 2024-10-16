package com.gmmapowell.serial;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.zinutils.xml.XML;

import com.gmmapowell.script.elements.Break;
import com.gmmapowell.script.flow.SpanItem;
import com.gmmapowell.script.sink.epub.EPubAware;
import com.gmmapowell.script.sink.epub.XHTMLCollector;
import com.gmmapowell.script.styles.PageStyle;
import com.gmmapowell.script.styles.StyleCatalog;

public class SectionBreak implements SpanItem, EPubAware, Break {

	@Override
	public void intForm(DataOutputStream os) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public BoundingBox bbox(PDFont font, float sz) throws IOException {
		return new BoundingBox(0, 0, 0, 10);
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

	@Override
	public String boxText() {
		return null;
	}

	@Override
	public float require() {
		return 0;
	}

	@Override
	public float top() {
		return 0;
	}

	@Override
	public float textY() {
		return 0;
	}

	@Override
	public float bottom() {
		return 0;
	}

	@Override
	public boolean box() {
		return false;
	}

	@Override
	public boolean horizLines() {
		return true;
	}

	@Override
	public PDFont textFont(StyleCatalog styles, PageStyle pageStyle) {
		return null;
	}

	@Override
	public float fontSize(PageStyle pageStyle) {
		return 0;
	}

	@Override
	public boolean newPageAfter() {
		return false;
	}

	@Override
	public float total() {
		return 0;
	}
}
