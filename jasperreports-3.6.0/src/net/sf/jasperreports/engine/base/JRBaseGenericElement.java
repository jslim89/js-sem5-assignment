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

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRGenericElement;
import net.sf.jasperreports.engine.JRGenericElementParameter;
import net.sf.jasperreports.engine.JRGenericElementType;
import net.sf.jasperreports.engine.JRVisitor;

/**
 * A read-only implementation of {@link JRGenericElement}
 * that is included in compiled reports.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRBaseGenericElement.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class JRBaseGenericElement extends JRBaseElement implements
		JRGenericElement
{

	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;
	
	private JRGenericElementType genericType;
	private List parameters;
	private byte evaluationTime = JRExpression.EVALUATION_TIME_NOW;
	private String evaluationGroupName;
	
	/**
	 * Creates a generic element by copying an existing element.
	 * 
	 * @param element the element to copy
	 * @param factory the object factory to be used for creating sub objects
	 */
	public JRBaseGenericElement(JRGenericElement element,
			JRBaseObjectFactory factory)
	{
		super(element, factory);

		this.genericType = element.getGenericType();
		this.evaluationTime = element.getEvaluationTime();
		this.evaluationGroupName = element.getEvaluationGroupName();
		
		JRGenericElementParameter[] elementParameters = element.getParameters();
		this.parameters = new ArrayList(elementParameters.length);
		for (int i = 0; i < elementParameters.length; i++)
		{
			JRGenericElementParameter elementParameter = elementParameters[i];
			JRGenericElementParameter parameter = factory.getGenericElementParameter(
					elementParameter);
			this.parameters.add(parameter);
		}
	}

	public JRGenericElementType getGenericType()
	{
		return genericType;
	}

	public JRGenericElementParameter[] getParameters()
	{
		return (JRGenericElementParameter[]) parameters.toArray(
				new JRGenericElementParameter[parameters.size()]);
	}

	public void collectExpressions(JRExpressionCollector collector)
	{
		collector.collect(this);
	}

	public void visit(JRVisitor visitor)
	{
		visitor.visitGenericElement(this);
	}

	public String getEvaluationGroupName()
	{
		return evaluationGroupName;
	}

	public byte getEvaluationTime()
	{
		return evaluationTime;
	}

}
