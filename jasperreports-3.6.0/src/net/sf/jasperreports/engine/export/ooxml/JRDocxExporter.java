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
package net.sf.jasperreports.engine.export.ooxml;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.export.ExporterFilter;
import net.sf.jasperreports.engine.export.ExporterNature;
import net.sf.jasperreports.engine.util.JRProperties;


/**
 * Exports a JasperReports document to DOCX format. It has character output type and exports the document to a
 * grid-based layout.
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id: JRDocxExporter.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class JRDocxExporter extends JROfficeOpenXmlExporter
{
	protected static final String DOCX_EXPORTER_PROPERTIES_PREFIX = JRProperties.PROPERTY_PREFIX + "export.docx.";

	protected boolean deepGrid;

	/**
	 *
	 */
	protected void setInput() throws JRException
	{
		super.setInput();

		deepGrid = 
			!getBooleanParameter(
				JRDocxExporterParameter.FRAMES_AS_NESTED_TABLES,
				JRDocxExporterParameter.PROPERTY_FRAMES_AS_NESTED_TABLES,
				true
				);
	}

	/**
	 * @see net.sf.jasperreports.engine.export.oasis.JROpenDocumentExporter#getExporterNature(net.sf.jasperreports.engine.export.ExporterFilter)
	 */
	protected ExporterNature getExporterNature(ExporterFilter filter) 
	{
		return new JRDocxExporterNature(filter, deepGrid);
	}

	/**
	 *
	 */
	protected String getExporterPropertiesPrefix()
	{
		return DOCX_EXPORTER_PROPERTIES_PREFIX;
	}

}

