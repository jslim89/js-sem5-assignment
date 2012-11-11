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
package net.sf.jasperreports.crosstabs;

/**
 * Crosstab column group interface.
 * 
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: JRCrosstabColumnGroup.java 3032 2009-08-27 11:32:28Z teodord $
 */
public interface JRCrosstabColumnGroup extends JRCrosstabGroup
{
	/**
	 * Returns the height of the group headers.
	 * 
	 * @return the height of the group headers
	 * @see JRCrosstabGroup#getHeader()
	 * @see JRCrosstabGroup#getTotalHeader()
	 */
	public int getHeight();
	
	
	/**
	 * Returns the position of the header contents for header stretching.
	 * <p>
	 * The column group headers stretch horizontally when there are multiple sub group entries.
	 * The header contents will be adjusted to the new width depending on this attribute:
	 * <ul>
	 * 	<li>{@link JRCellContents#POSITION_X_LEFT JRCellContents.POSITION_X_LEFT} - the contents will be rendered on the left side of the header</li>
	 * 	<li>{@link JRCellContents#POSITION_X_CENTER JRCellContents.POSITION_X_CENTER} - the contents will be rendered on the center of the header</li>
	 * 	<li>{@link JRCellContents#POSITION_X_RIGHT JRCellContents.POSITION_X_RIGHT} - the contents will be rendered on the right side of the header</li>
	 * 	<li>{@link JRCellContents#POSITION_X_STRETCH JRCellContents.POSITION_X_STRETCH} - the contents will be proportionally stretched to the new header size</li>
	 * </ul>
	 * 
	 * @return the position of the header contents for header stretching
	 */
	public byte getPosition();
}
