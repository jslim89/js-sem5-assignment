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

import net.sf.jasperreports.engine.design.JRDesignTextElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRTextElementFactory.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRTextElementFactory extends JRBaseFactory
{
	private static final Log log = LogFactory.getLog(JRTextElementFactory.class);

	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		JRDesignTextElement textElement = (JRDesignTextElement)digester.peek();

		Byte horizontalAlignment = (Byte)JRXmlConstants.getHorizontalAlignMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_textAlignment));
		if (horizontalAlignment != null)
		{
			textElement.setHorizontalAlignment(horizontalAlignment);
		}

		Byte verticalAlignment = (Byte)JRXmlConstants.getVerticalAlignMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_verticalAlignment));
		if (verticalAlignment != null)
		{
			textElement.setVerticalAlignment(verticalAlignment);
		}

		Byte rotation = (Byte)JRXmlConstants.getRotationMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_rotation));
		if (rotation != null)
		{
			textElement.setRotation(rotation);
		}

		Byte lineSpacing = (Byte)JRXmlConstants.getLineSpacingMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_lineSpacing));
		if (lineSpacing != null)
		{
			textElement.setLineSpacing(lineSpacing);
		}

		textElement.setMarkup(atts.getValue(JRXmlConstants.ATTRIBUTE_markup));

		String isStyledText = atts.getValue(JRXmlConstants.ATTRIBUTE_isStyledText);
		if (isStyledText != null && isStyledText.length() > 0)
		{
			if (log.isWarnEnabled())
				log.warn("The 'isStyledText' attribute is deprecated. Use the 'markup' attribute instead.");
				
			//OK to use deprecated method here, until it is removed
			textElement.setStyledText(Boolean.valueOf(isStyledText));
		}

		return textElement;
	}
	

}
