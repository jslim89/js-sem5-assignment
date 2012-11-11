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
package net.sf.jasperreports.crosstabs.base;

import java.io.Serializable;

import net.sf.jasperreports.crosstabs.JRCrosstabBucket;
import net.sf.jasperreports.crosstabs.fill.calculation.BucketDefinition;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.util.JRCloneUtils;

/**
 * Base read-only implementation of {@link net.sf.jasperreports.crosstabs.JRCrosstabBucket JRCrosstabBucket}.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRBaseCrosstabBucket.java 3032 2009-08-27 11:32:28Z teodord $
 */
public class JRBaseCrosstabBucket implements JRCrosstabBucket, Serializable
{
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	protected byte order = BucketDefinition.ORDER_ASCENDING;
	protected JRExpression expression;
	protected JRExpression comparatorExpression;

	protected JRBaseCrosstabBucket()
	{
	}
	
	public JRBaseCrosstabBucket(JRCrosstabBucket bucket, JRBaseObjectFactory factory)
	{
		factory.put(bucket, this);
		
		this.order = bucket.getOrder();
		this.expression = factory.getExpression(bucket.getExpression());
		this.comparatorExpression = factory.getExpression(bucket.getComparatorExpression());
	}

	public byte getOrder()
	{
		return order;
	}

	public JRExpression getExpression()
	{
		return expression;
	}

	public JRExpression getComparatorExpression()
	{
		return comparatorExpression;
	}
	
	public Object clone()
	{
		try
		{
			JRBaseCrosstabBucket clone = (JRBaseCrosstabBucket) super.clone();
			clone.expression = (JRExpression) JRCloneUtils.nullSafeClone(expression);
			clone.comparatorExpression = (JRExpression) JRCloneUtils.nullSafeClone(comparatorExpression);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			// never
			throw new JRRuntimeException(e);
		}
	}
}
