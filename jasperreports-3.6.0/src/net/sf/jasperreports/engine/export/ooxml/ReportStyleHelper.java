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
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperPrint;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: ReportStyleHelper.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class ReportStyleHelper extends BaseHelper
{
	/**
	 * 
	 */
	private ParagraphHelper paragraphHelper = null;
	private RunHelper runHelper = null;
	
	/**
	 * 
	 */
	public ReportStyleHelper(Writer writer, Map fontMap)
	{
		super(writer);
		
		paragraphHelper = new ParagraphHelper(writer, false);
		runHelper = new RunHelper(writer, fontMap);
	}

	/**
	 * 
	 */
	public void export(List jasperPrintList) throws IOException
	{
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.write("<w:styles\n");
		writer.write(" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"\n");
		writer.write(" xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\">\n");
		writer.write(" <w:docDefaults>\n");
		writer.write("  <w:rPrDefault>\n");
		writer.write("   <w:rPr>\n");
		writer.write("    <w:rFonts w:ascii=\"Times New Roman\" w:eastAsia=\"Times New Roman\" w:hAnsi=\"Times New Roman\" w:cs=\"Times New Roman\"/>\n");
		writer.write("   </w:rPr>\n");
		writer.write("  </w:rPrDefault>\n");
		writer.write("  <w:pPrDefault>\n");
		writer.write("  </w:pPrDefault>\n");
		writer.write(" </w:docDefaults>\n");

		for(int reportIndex = 0; reportIndex < jasperPrintList.size(); reportIndex++)
		{
			JasperPrint jasperPrint = (JasperPrint)jasperPrintList.get(reportIndex);
			
			JRStyle[] styles = jasperPrint.getStyles();
			if (styles != null)
			{
				for(int i = 0; i < styles.length; i++)
				{
					JRStyle style = styles[i];
					exportHeader(style);
					paragraphHelper.exportProps(style);
					runHelper.exportProps(style);
					exportFooter();
				}
			}
		}

		writer.write("</w:styles>\n");
	}
	
	/**
	 * 
	 */
	private void exportHeader(JRStyle style) throws IOException
	{
		//writer.write(" <w:style w:type=\"paragraph\" w:default=\"1\" w:styleId=\"" + style.getName() + "\">\n");
		writer.write(" <w:style w:type=\"paragraph\" w:styleId=\"" + style.getName() + "\"");
		if (style.isDefault())
		{
			writer.write(" w:default=\"1\"");
		}
		writer.write(">\n");
		writer.write("  <w:name w:val=\"" + style.getName() + "\" />\n");
		writer.write("  <w:qFormat />\n");
		String styleNameReference = style.getStyle() == null ? null : style.getStyle().getName();//FIXMEDOCX why getStyleNameReference is not working?
		if (styleNameReference != null)
		{
			writer.write("  <w:basedOn w:val=\"" + styleNameReference + "\" />\n");
		}
	}
	
	/**
	 * 
	 */
	private void exportFooter() throws IOException
	{
		writer.write(" </w:style>\n");
	}
	
}
