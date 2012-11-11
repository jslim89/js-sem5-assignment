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
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.JasperPrint;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JasperPrintFactory.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JasperPrintFactory extends JRBaseFactory
{

	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JasperPrint jasperPrint = new JasperPrint();
		
		jasperPrint.setName(atts.getValue(JRXmlConstants.ATTRIBUTE_name));

		String pageWidth = atts.getValue(JRXmlConstants.ATTRIBUTE_pageWidth);
		if (pageWidth != null && pageWidth.length() > 0)
		{
			jasperPrint.setPageWidth(Integer.parseInt(pageWidth));
		}

		String pageHeight = atts.getValue(JRXmlConstants.ATTRIBUTE_pageHeight);
		if (pageHeight != null && pageHeight.length() > 0)
		{
			jasperPrint.setPageHeight(Integer.parseInt(pageHeight));
		}

		Byte orientation = (Byte)JRXmlConstants.getOrientationMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_orientation));
		if (orientation != null)
		{
			jasperPrint.setOrientation(orientation.byteValue());
		}
		
		String formatFactoryClass = atts.getValue(JRXmlConstants.ATTRIBUTE_formatFactoryClass);
		if (formatFactoryClass != null)
		{
			jasperPrint.setFormatFactoryClass(formatFactoryClass);
		}
		
		String locale = atts.getValue(JRXmlConstants.ATTRIBUTE_locale);
		if (locale != null)
		{
			jasperPrint.setLocaleCode(locale);
		}
		
		String timezone = atts.getValue(JRXmlConstants.ATTRIBUTE_timezone);
		if (timezone != null)
		{
			jasperPrint.setTimeZoneId(timezone);
		}

		return jasperPrint;
	}
	

}
