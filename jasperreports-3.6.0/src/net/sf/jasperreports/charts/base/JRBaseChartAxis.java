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
package net.sf.jasperreports.charts.base;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import net.sf.jasperreports.charts.JRChartAxis;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;

/**
 * Base read-only implementation of {@link JRChartAxis JRChartAxis}.
 *
 * @author Barry Klawans (barry@users.sourceforge.net)
 * @version $Id: JRBaseChartAxis.java 3032 2009-08-27 11:32:28Z teodord $
 */
public class JRBaseChartAxis implements JRChartAxis, Serializable
{

	/**
	 * Where to position the axis.
	 */
	protected Byte positionByte = null;

	/**
	 * The Chart object containing the dataset and plot to use with this axis.
	 */
	protected JRChart chart = null;

	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 * Construct a new axis that will be added to the specified chart.
	 */
	public JRBaseChartAxis()
	{
	}

	public JRBaseChartAxis(JRChartAxis axis, JRBaseObjectFactory factory)
	{
		factory.put(axis, this);

		this.positionByte = axis.getPositionByte();
		this.chart = (JRChart)factory.getVisitResult(axis.getChart());
	}

	/**
	 * @deprecated Replaced by {@link #getPositionByte()}
	 */
	public byte getPosition()
	{
		return positionByte == null ? POSITION_LEFT_OR_TOP : positionByte.byteValue();
	}

	/**
	 * Returns the position of this axis.
	 *
	 * @return the position of this axis
	 */
	public Byte getPositionByte()
	{
		return positionByte;
	}

	/**
	 * Returns the chart that contains the dataset and plot to use for this
	 * axis.  The plot is used to figure out how to render the dataset when
	 * adding to the multiple axis chart.
	 *
	 * @return the chart that contains the dataset and plot for this axis
	 */
	public JRChart getChart()
	{
		return chart;
	}
	
	/**
	 * 
	 */
	public Object clone() 
	{
		JRBaseChartAxis clone = null;

		try
		{
			clone = (JRBaseChartAxis)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new JRRuntimeException(e);
		}
		
		return clone;
	}
	
	/**
	 * These fields are only for serialization backward compatibility.
	 */
	private int PSEUDO_SERIAL_VERSION_UID = JRConstants.PSEUDO_SERIAL_VERSION_UID_3_1_3;
	private byte position = POSITION_LEFT_OR_TOP;
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.defaultReadObject();
		if (PSEUDO_SERIAL_VERSION_UID < JRConstants.PSEUDO_SERIAL_VERSION_UID_3_1_3)
		{
			positionByte = new Byte(position);
		}
	}
	
}
