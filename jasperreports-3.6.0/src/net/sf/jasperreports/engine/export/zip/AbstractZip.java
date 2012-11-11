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
package net.sf.jasperreports.engine.export.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: AbstractZip.java 3033 2009-08-27 11:46:22Z teodord $
 */
public abstract class AbstractZip
{

	/**
	 * 
	 */
	protected List exportZipEntries = null;

	/**
	 *
	 */
	public abstract ExportZipEntry createEntry(String name);
	
	/**
	 *
	 */
	public void addEntry(ExportZipEntry entry)
	{
		exportZipEntries.add(entry);
	}
	
	/**
	 *
	 */
	public void zipEntries(OutputStream os) throws IOException
	{
		ZipOutputStream zipos = new ZipOutputStream(os);
		zipos.setMethod(ZipOutputStream.DEFLATED);
		
		for (int i = 0; i < exportZipEntries.size(); i++) 
		{
			ExportZipEntry oasisZipEntry = (ExportZipEntry)exportZipEntries.get(i);
			ZipEntry zipEntry = new ZipEntry(oasisZipEntry.getName());
			zipos.putNextEntry(zipEntry);
			oasisZipEntry.writeData(zipos);
		}
		
		zipos.flush();
		zipos.finish();
	}
	
	/**
	 *
	 */
	public void dispose()
	{
		for (int i = 0; i < exportZipEntries.size(); i++) 
		{
			ExportZipEntry oasisZipEntry = (ExportZipEntry)exportZipEntries.get(i);
			oasisZipEntry.dispose();
		}
	}
	
}
