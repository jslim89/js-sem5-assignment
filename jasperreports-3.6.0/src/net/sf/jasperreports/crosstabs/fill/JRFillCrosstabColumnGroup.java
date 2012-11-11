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
package net.sf.jasperreports.crosstabs.fill;

import net.sf.jasperreports.crosstabs.JRCellContents;
import net.sf.jasperreports.crosstabs.JRCrosstabColumnGroup;

/**
 * Crosstab column group implementation used at fill time.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRFillCrosstabColumnGroup.java 3032 2009-08-27 11:32:28Z teodord $
 */
public class JRFillCrosstabColumnGroup extends JRFillCrosstabGroup implements JRCrosstabColumnGroup
{
	
	public JRFillCrosstabColumnGroup(JRCrosstabColumnGroup group, JRFillCrosstabObjectFactory factory)
	{
		super(group, JRCellContents.TYPE_COLUMN_HEADER, factory);
	}


	public byte getPosition()
	{
		return ((JRCrosstabColumnGroup) parentGroup).getPosition();
	}


	public int getHeight()
	{
		return ((JRCrosstabColumnGroup) parentGroup).getHeight();
	}

}
