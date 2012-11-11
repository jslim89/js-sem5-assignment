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
package net.sf.jasperreports.engine.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import net.sf.jasperreports.engine.JRRuntimeException;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: FileBufferedZipEntry.java 2899 2009-07-21 10:02:32Z teodord $
 */
public class FileBufferedWriter extends Writer 
{
	private FileBufferedOutputStream fbos = null;
	private Writer osw = null;

	/**
	 * 
	 */
	public FileBufferedWriter()
	{
		fbos = new FileBufferedOutputStream();
		try
		{
			osw = new BufferedWriter(new OutputStreamWriter(fbos, "UTF-8"));
		}
		catch (UnsupportedEncodingException e)
		{
			throw new JRRuntimeException(e);
		}
	}
	
	/**
	 * 
	 */
	public void writeData(Writer writer) throws IOException
	{
		Reader reader = null;

		try
		{
			reader = new InputStreamReader(fbos.getDataInputStream(), "UTF-8");

			char[] chars = new char[10000];
			int ln = 0;
			while ((ln = reader.read(chars)) > 0)
			{
				writer.write(chars, 0, ln);
			}

			writer.flush();
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch(IOException e)
				{
				}
			}
		}
	}

	public void dispose()
	{
		fbos.dispose();
	}
	
	public void close() throws IOException 
	{
		osw.close();
	}

	public void flush() throws IOException 
	{
		osw.flush();
	}

	public void write(char[] cbuf, int off, int len) throws IOException 
	{
		osw.write(cbuf, off, len);
	}
	
}
