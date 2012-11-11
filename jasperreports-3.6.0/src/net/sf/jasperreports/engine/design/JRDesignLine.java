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
package net.sf.jasperreports.engine.design;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRDefaultStyleProvider;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRLine;
import net.sf.jasperreports.engine.JRVisitor;
import net.sf.jasperreports.engine.base.JRBaseLine;


/**
 * The actual implementation of a graphic element representing a straight line, used at design time.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRDesignLine.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class JRDesignLine extends JRDesignGraphicElement implements JRLine
{


	/**
	 *
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	protected byte direction = DIRECTION_TOP_DOWN;


	/**
	 *
	 */
	public JRDesignLine()
	{
		super(null);
	}
		
	/**
	 *
	 */
	public JRDesignLine(JRDefaultStyleProvider defaultStyleProvider)
	{
		super(defaultStyleProvider);
	}
		

	/**
	 *
	 */
	public void setWidth(int width)
	{
		if (width == 0)
		{
			width = 1;
		}
		
		super.setWidth(width);
	}

	/**
	 *
	 */
	public void setHeight(int height)
	{
		if (height == 0)
		{
			height = 1;
		}
		
		super.setHeight(height);
	}

	/**
	 *
	 */
	public byte getDirection()
	{
		return direction;
	}

	/**
	 *
	 */
	public void setDirection(byte direction)
	{
		byte old = this.direction;
		this.direction = direction;
		getEventSupport().firePropertyChange(JRBaseLine.PROPERTY_DIRECTION, old, this.direction);
	}

	/**
	 *
	 */
	public void collectExpressions(JRExpressionCollector collector)
	{
		collector.collect(this);
	}

	/**
	 *
	 */
	public void visit(JRVisitor visitor)
	{
		visitor.visitLine(this);
	}


}
