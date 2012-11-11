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

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;

import net.sf.jasperreports.engine.JRAlignment;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.JRTextElement;
import net.sf.jasperreports.engine.export.JRExporterGridCell;
import net.sf.jasperreports.engine.util.JRColorUtil;


/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id: CellHelper.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class CellHelper extends BaseHelper
{
	/**
	 *
	 */
	private static final String VERTICAL_ALIGN_TOP = "top";
	private static final String VERTICAL_ALIGN_MIDDLE = "center";
	private static final String VERTICAL_ALIGN_BOTTOM = "bottom";
	
	/**
	 *
	 */
	private BorderHelper borderHelper = null;
	
	/**
	 *
	 */
	public CellHelper(Writer writer)
	{
		super(writer);
		
		borderHelper = new BorderHelper(writer);
	}
		
	/**
	 * 
	 */
	public BorderHelper getBorderHelper() 
	{
		return borderHelper;
	}

	/**
	 *
	 */
	public void exportHeader(JRPrintElement element, JRExporterGridCell gridCell) throws IOException 
	{
		writer.write("    <w:tc>\n");
		
		exportPropsHeader();

		if (gridCell.getColSpan() > 1)
		{
			writer.write("      <w:gridSpan w:val=\"" + gridCell.getColSpan() +"\" />\n");
		}
		if (gridCell.getRowSpan() > 1)
		{
			writer.write("      <w:vMerge w:val=\"restart\" />\n");
		}
		
		exportProps(element, gridCell);
		
		exportPropsFooter();
	}

	/**
	 *
	 */
	public void exportFooter() throws IOException 
	{
		writer.write("    </w:tc>\n");
	}


	/**
	 *
	 */
	public void exportProps(JRPrintElement element, JRExporterGridCell gridCell) throws IOException
	{
		exportBackcolor(element.getMode(), element.getBackcolor());
		
		borderHelper.export(gridCell.getBox());

//		if (element instanceof JRCommonGraphicElement)
//			borderHelper.export(((JRCommonGraphicElement)element).getLinePen());
		
		JRAlignment align = element instanceof JRAlignment ? (JRAlignment)element : null;
		if (align != null)
		{
			JRPrintText text = element instanceof JRPrintText ? (JRPrintText)element : null;
			Byte ownRotation = text == null ? null : text.getOwnRotation();
			
			String verticalAlignment = 
				getVerticalAlignment(
					align.getOwnVerticalAlignment() 
					);
			String textRotation = getTextDirection(ownRotation);

			exportAlignmentAndRotation(verticalAlignment, textRotation);
		}
	}


	/**
	 *
	 */
	public void exportProps(JRExporterGridCell gridCell) throws IOException
	{
		exportBackcolor(JRElement.MODE_OPAQUE, gridCell.getBackcolor());//FIXMEDOCX check this
		
		borderHelper.export(gridCell.getBox());
	}

	
	/**
	 *
	 */
	private void exportBackcolor(byte mode, Color backcolor) throws IOException
	{
		if (mode == JRElement.MODE_OPAQUE && backcolor != null)
		{
			writer.write("      <w:shd w:val=\"clear\" w:color=\"auto\"	w:fill=\"" + JRColorUtil.getColorHexa(backcolor) + "\" />\n");
		}
	}

	/**
	 *
	 */
	private void exportPropsHeader() throws IOException
	{
		writer.write("      <w:tcPr>\n");
	}
	
	/**
	 *
	 */
	private void exportAlignmentAndRotation(String verticalAlignment, String textRotation) throws IOException
	{
		if (verticalAlignment != null)
		{
			writer.write("      <w:vAlign w:val=\"" + verticalAlignment +"\" />\n");
		}
		if (textRotation != null)
		{
			writer.write("   <w:textDirection w:val=\"" + textRotation + "\" />\n");
		}
	}
	
	/**
	 *
	 */
	private void exportPropsFooter() throws IOException
	{
		writer.write("      </w:tcPr>\n");
	}
	
	/**
	 *
	 */
	private static String getTextDirection(Byte rotation)
	{
		String textDirection = null;
		
		if (rotation != null)
		{
			switch(rotation.byteValue())
			{
				case JRTextElement.ROTATION_LEFT:
				{
					textDirection = "btLr";
					break;
				}
				case JRTextElement.ROTATION_RIGHT:
				{
					textDirection = "tbRl";
					break;
				}
				case JRTextElement.ROTATION_UPSIDE_DOWN://FIXMEDOCX possible?
				case JRTextElement.ROTATION_NONE:
				default:
				{
				}
			}
		}

		return textDirection;
	}

	/**
	 *
	 */
	public static String getVerticalAlignment(Byte verticalAlignment)
	{
		if (verticalAlignment != null)
		{
			switch (verticalAlignment.byteValue())
			{
				case JRAlignment.VERTICAL_ALIGN_BOTTOM :
					return VERTICAL_ALIGN_BOTTOM;
				case JRAlignment.VERTICAL_ALIGN_MIDDLE :
					return VERTICAL_ALIGN_MIDDLE;
				case JRAlignment.VERTICAL_ALIGN_TOP :
				default :
					return VERTICAL_ALIGN_TOP;
			}
		}
		return null;
	}
}