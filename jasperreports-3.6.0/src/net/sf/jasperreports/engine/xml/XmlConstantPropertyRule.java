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

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: XmlConstantPropertyRule.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class XmlConstantPropertyRule extends TransformedPropertyRule
{

	private static final Log log = LogFactory.getLog(XmlConstantPropertyRule.class);
	
	private final Map constantsMap;

	public XmlConstantPropertyRule(String attributeName, Map constantsMap)
	{
		super(attributeName);
		this.constantsMap = constantsMap;
	}

	public XmlConstantPropertyRule(String attributeName, String propertyName, 
			Map constantsMap)
	{
		super(attributeName, propertyName);
		this.constantsMap = constantsMap;
	}

	protected Object toPropertyValue(String attributeValue)
	{
		Object value = constantsMap.get(attributeValue);
		if (value == null)
		{
			log.warn("Unrecognized attribute value \"" 
					+ attributeValue + "\" for " + attributeName);
		}
		return value;
	}
	
}