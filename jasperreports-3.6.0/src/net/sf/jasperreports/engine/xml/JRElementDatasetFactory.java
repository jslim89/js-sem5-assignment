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

import java.util.Set;

import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.design.JRDesignElementDataset;
import net.sf.jasperreports.engine.design.JRDesignGroup;

import org.xml.sax.Attributes;


/**
 * @author Ionut Nedelcu (ionutned@users.sourceforge.net)
 * @version $Id: JRElementDatasetFactory.java 3034 2009-08-27 11:58:04Z teodord $
 */
public class JRElementDatasetFactory extends JRBaseFactory
{

	
	public Object createObject(Attributes atts)
	{
		JRDesignElementDataset dataset = (JRDesignElementDataset) digester.peek();

		setDatasetAtts(atts, dataset);

		return dataset;
	}

	protected void setDatasetAtts(Attributes atts, JRDesignElementDataset dataset)
	{
		JRXmlLoader xmlLoader = (JRXmlLoader)digester.peek(digester.getCount() - 1);
		Set groupBoundDatasets = xmlLoader.getGroupBoundDatasets();
		
		Byte resetType = (Byte)JRXmlConstants.getResetTypeMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_resetType));
		if (resetType != null)
		{
			dataset.setResetType(resetType.byteValue());
		}
		if (dataset.getResetType() == JRVariable.RESET_TYPE_GROUP)
		{
			groupBoundDatasets.add(dataset);

			String groupName = atts.getValue(JRXmlConstants.ATTRIBUTE_resetGroup);
			if (groupName != null)
			{
				JRDesignGroup group = new JRDesignGroup();
				group.setName(groupName);
				dataset.setResetGroup(group);
			}
		}

		Byte incrementType = (Byte)JRXmlConstants.getResetTypeMap().get(atts.getValue(JRXmlConstants.ATTRIBUTE_incrementType));
		if (incrementType != null)
		{
			dataset.setIncrementType(incrementType.byteValue());
		}
		if (dataset.getIncrementType() == JRVariable.RESET_TYPE_GROUP)
		{
			groupBoundDatasets.add(dataset);

			String groupName = atts.getValue(JRXmlConstants.ATTRIBUTE_incrementGroup);
			if (groupName != null)
			{
				JRDesignGroup group = new JRDesignGroup();
				group.setName(groupName);
				dataset.setIncrementGroup(group);
			}
		}
	}

}
