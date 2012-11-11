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
package net.sf.jasperreports.engine;


/**
 * Groups represent a flexible way to organize data on a report. A report group is represented by sequence
 * of consecutive records in the data source that have something in common, like the value of a certain report
 * field for example.
 * <p>
 * The value of the associated group expression is what makes group records stick together. This value is the
 * thing that they have in common.
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRGroup.java 3033 2009-08-27 11:46:22Z teodord $
 */
public interface JRGroup extends JRCloneable
{


	/**
	 * Gets the group name
	 */
	public String getName();
	
	/**
	 * Gets the flag that signals if the group header should be printed always on a new column.
	 */
	public boolean isStartNewColumn();
		
	/**
	 * Sets the flag that signals if the group header should be printed always on a new column.
	 */
	public void setStartNewColumn(boolean isStart);
		
	/**
	 * Gets the flag that signals if the group header should be printed always on a new page.
	 */
	public boolean isStartNewPage();
		
	/**
	 * Sets the flag that signals if the group header should be printed always on a new page.
	 */
	public void setStartNewPage(boolean isStart);
		
	/**
	 * Gets the flag that signals if the group header should be printed always on a new page, along with the
	 * re-initialization of the page number.
	 */
	public boolean isResetPageNumber();
		
	/**
	 * Sets the flag that signals if the group header should be printed always on a new page, along with the
	 * re-initialization of the page number.
	 */
	public void setResetPageNumber(boolean isReset);
		
	/**
	 * Gets the flag that signals if the group header should be reprinted at the beginning of each page.
	 */
	public boolean isReprintHeaderOnEachPage();
		
	/**
	 * Sets the flag that signals if the group header should be reprinted at the beginning of each page.
	 */
	public void setReprintHeaderOnEachPage(boolean isReprint);
		
	/**
	 * Gets the minimum amount of vertical space needed at the bottom of the column in order to place the
	 * group header on the current column.
	 */
	public int getMinHeightToStartNewPage();

	/**
	 * Gets the minimum amount of vertical space needed at the bottom of the column in order to place the
	 * group header on the current column.
	 */
	public void setMinHeightToStartNewPage(int minHeight);
		
	/**
	 * Gets the expression that defines what records in the group have in common.
	 */
	public JRExpression getExpression();
	
	/**
	 * Gets the header band created for this group.
	 * @deprecated Replaced by {@link #getGroupHeaderSection()}.
	 */
	public JRBand getGroupHeader();
		
	/**
	 * Gets the header section created for this group.
	 */
	public JRSection getGroupHeaderSection();
		
	/**
	 * Gets the footer band created for this group.
	 * @deprecated Replaced by {@link #getGroupFooterSection()}.
	 */
	public JRBand getGroupFooter();

	/**
	 * Gets the footer section created for this group.
	 */
	public JRSection getGroupFooterSection();

	/**
	 *
	 */
	public JRVariable getCountVariable();


}
