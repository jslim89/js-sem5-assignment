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
package net.sf.jasperreports.engine.util;

import java.awt.Color;

import net.sf.jasperreports.engine.xml.JRXmlConstants;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRColorUtil.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRColorUtil
{

	/**
	 *
	 */
	public static final int COLOR_MASK = Integer.parseInt("FFFFFF", 16);

	/**
	 *
	 */
	public static String getColorHexa(Color color)
	{
		String hexa = Integer.toHexString(color.getRGB() & COLOR_MASK).toUpperCase();
		return ("000000" + hexa).substring(hexa.length());
	}

	/**
	 *
	 */
	public static Color getColor(String strColor, Color defaultColor)
	{
		Color color = null;

		if (strColor != null && strColor.length() > 0)
		{
			char firstChar = strColor.charAt(0);
			if (firstChar == '#')
			{
				color = new Color(Integer.parseInt(strColor.substring(1), 16));
			}
			else if ('0' <= firstChar && firstChar <= '9')
			{
				color = new Color(Integer.parseInt(strColor));
			}
			else
			{
				if (JRXmlConstants.getColorMap().containsKey(strColor))
				{
					color = (Color)JRXmlConstants.getColorMap().get(strColor);
				}
				else
				{
					color = defaultColor;
				}
			}
		}

		return color;
	}

}
