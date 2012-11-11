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
package net.sf.jasperreports.engine.base;

import java.awt.Color;
import java.io.Serializable;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRDefaultStyleProvider;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JROrigin;
import net.sf.jasperreports.engine.JRPropertiesHolder;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.util.JRStyleResolver;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRBasePrintElement.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class JRBasePrintElement implements JRPrintElement, Serializable
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected JROrigin origin;
	protected String key;
	
	/**
	 *
	 */
	protected Byte mode = null;
	protected int x = 0;
	protected int y = 0;
	protected int width = 0;
	protected int height = 0;
	protected Color forecolor = null;
	protected Color backcolor = null;

	protected JRDefaultStyleProvider defaultStyleProvider;
	protected JRStyle style = null;
	
	private JRPropertiesMap propertiesMap;

	
	/**
	 *
	 */
	public JRBasePrintElement(JRDefaultStyleProvider defaultStyleProvider)
	{
		this.defaultStyleProvider = defaultStyleProvider;
	}
	

	/**
	 *
	 */
	public JRDefaultStyleProvider getDefaultStyleProvider()
	{
		return defaultStyleProvider;
	}
	
	/**
	 *
	 */
	public JROrigin getOrigin()
	{
		return origin;
	}
	
	/**
	 *
	 */
	public void setOrigin(JROrigin origin)
	{
		this.origin = origin;
	}

	/**
	 *
	 */
	public JRStyle getStyle()
	{
		return style;
	}
	
	/**
	 *
	 */
	public void setStyle(JRStyle style)
	{
		this.style = style;
	}

	/**
	 *
	 */
	public byte getMode()
	{
		return JRStyleResolver.getMode(this, JRElement.MODE_OPAQUE);
	}
	
	/**
	 *
	 */
	public Byte getOwnMode()
	{
		return mode;
	}
	
	/**
	 *
	 */
	public void setMode(byte mode)
	{
		this.mode = new Byte(mode);
	}
	
	/**
	 *
	 */
	public void setMode(Byte mode)
	{
		this.mode = mode;
	}
	
	/**
	 *
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 *
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 *
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 *
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 *
	 */
	public int getWidth()
	{
		return this.width;
	}
	
	/**
	 *
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 *
	 */
	public int getHeight()
	{
		return this.height;
	}
	
	/**
	 *
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 *
	 */
	public Color getForecolor()
	{
		return JRStyleResolver.getForecolor(this);
	}
	
	/**
	 *
	 */
	public Color getOwnForecolor()
	{
		return forecolor;
	}
	
	/**
	 *
	 */
	public void setForecolor(Color forecolor)
	{
		this.forecolor = forecolor;
	}
	
	/**
	 *
	 */
	public Color getBackcolor()
	{
		return JRStyleResolver.getBackcolor(this);
	}

	/**
	 *
	 */
	public Color getOwnBackcolor()
	{
		return backcolor;
	}

	/**
	 *
	 */
	public void setBackcolor(Color backcolor)
	{
		this.backcolor = backcolor;
	}


	
	public String getKey()
	{
		return key;
	}


	/**
	 * Sets the print element key.
	 * 
	 * @param key the element key
	 * @see #getKey()
	 */
	public void setKey(String key)
	{
		this.key = key;
	}


	/**
	 * Returns null as external style references are not allowed for print objects.
	 */
	public String getStyleNameReference()
	{
		return null;
	}
	

	public synchronized boolean hasProperties()
	{
		return propertiesMap != null && propertiesMap.hasProperties();
	}

	public synchronized JRPropertiesMap getPropertiesMap()
	{
		if (propertiesMap == null)
		{
			propertiesMap = new JRPropertiesMap();
		}
		return propertiesMap;
	}

	public JRPropertiesHolder getParentProperties()
	{
		return null;
	}

}
