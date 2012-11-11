/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.export.ooxml;

import java.io.IOException;
import java.io.Writer;

import net.sf.jasperreports.engine.JRAlignment;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JRStyle;


/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id: ParagraphHelper.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class ParagraphHelper extends BaseHelper
{
	/**
	 *
	 */
	private static final String HORIZONTAL_ALIGN_LEFT = "left";
	private static final String HORIZONTAL_ALIGN_RIGHT = "right";
	private static final String HORIZONTAL_ALIGN_CENTER = "center";
	private static final String HORIZONTAL_ALIGN_BOTH = "both";

	/**
	 *
	 */
	private boolean pageBreak = false;

	/**
	 *
	 */
	public ParagraphHelper(Writer writer, boolean pageBreak)
	{
		super(writer);
		
		this.pageBreak = pageBreak;
	}
	
	/**
	 *
	 */
	public void exportProps(JRStyle style) throws IOException
	{
		exportPropsHeader(null);

		exportAlignment(
			getHorizontalAlignment(
				style.getOwnHorizontalAlignment() 
				)
			);

		exportPropsFooter();
	}
	
	/**
	 *
	 */
	public void exportProps(JRPrintText text) throws IOException
	{
		exportPropsHeader(text.getStyle() == null ? null : text.getStyle().getName());//FIXMEDOCX why getStyleNameReference is not working?

		exportAlignment(
			getHorizontalAlignment(
				text.getOwnHorizontalAlignment()
				)
			);
		
//		exportRunDirection(text.getRunDirection() == JRPrintText.RUN_DIRECTION_RTL ? "rl" : null);

		exportPropsFooter();
	}
	
	
	/**
	 *
	 */
	private void exportPropsHeader(String styleNameReference) throws IOException
	{
		writer.write("      <w:pPr>\n");
		if (styleNameReference != null)
		{
			writer.write("        <w:pStyle w:val=\"" + styleNameReference + "\"/>\n");
		}
		if (pageBreak)
		{
			writer.write("        <w:pageBreakBefore/>\n");
			pageBreak = false;
		}
	}
	
	/**
	 *
	 */
	private void exportAlignment(String horizontalAlignment) throws IOException
	{
		if (horizontalAlignment != null)
		{
			writer.write("   <w:jc w:val=\"" + horizontalAlignment + "\" />\n");
		}
		//FIXMEDOCX line spacing?
	}
	
	/**
	 *
	 */
	private void exportPropsFooter() throws IOException
	{
		writer.write("      </w:pPr>\n");
	}
	
	/**
	 *
	 */
	public void exportEmptyParagraph() throws IOException
	{
		writer.write("     <w:p><w:pPr>\n");
		if (pageBreak)
		{
			writer.write("        <w:pageBreakBefore/>\n");
			pageBreak = false;
		}
		writer.write("     </w:pPr></w:p>\n");
	}

	/**
	 *
	 */
	public static String getHorizontalAlignment(Byte horizontalAlignment)
	{
		if (horizontalAlignment != null)
		{
			switch (horizontalAlignment.byteValue())
			{
				case JRAlignment.HORIZONTAL_ALIGN_RIGHT :
					return HORIZONTAL_ALIGN_RIGHT;
				case JRAlignment.HORIZONTAL_ALIGN_CENTER :
					return HORIZONTAL_ALIGN_CENTER;
				case JRAlignment.HORIZONTAL_ALIGN_JUSTIFIED :
					return HORIZONTAL_ALIGN_BOTH;
				case JRAlignment.HORIZONTAL_ALIGN_LEFT :
				default :
					return HORIZONTAL_ALIGN_LEFT;
			}
		}
		return null;
	}
}
