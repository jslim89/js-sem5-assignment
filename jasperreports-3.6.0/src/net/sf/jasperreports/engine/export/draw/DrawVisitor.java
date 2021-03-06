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

/*
 * Contributors:
 * Eugene D - eugenedruy@users.sourceforge.net 
 * Adrian Jackson - iapetus@users.sourceforge.net
 * David Taylor - exodussystems@users.sourceforge.net
 * Lars Kristensen - llk@users.sourceforge.net
 */
package net.sf.jasperreports.engine.export.draw;

import java.awt.Graphics2D;

import net.sf.jasperreports.crosstabs.JRCrosstab;
import net.sf.jasperreports.engine.JRBreak;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRComponentElement;
import net.sf.jasperreports.engine.JRElementGroup;
import net.sf.jasperreports.engine.JREllipse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRFrame;
import net.sf.jasperreports.engine.JRGenericElement;
import net.sf.jasperreports.engine.JRImage;
import net.sf.jasperreports.engine.JRLine;
import net.sf.jasperreports.engine.JRRectangle;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JRStaticText;
import net.sf.jasperreports.engine.JRSubreport;
import net.sf.jasperreports.engine.JRTextField;
import net.sf.jasperreports.engine.JRVisitor;
import net.sf.jasperreports.engine.convert.ConvertVisitor;
import net.sf.jasperreports.engine.convert.ReportConverter;
import net.sf.jasperreports.engine.export.TextRenderer;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: DrawVisitor.java 3033 2009-08-27 11:46:22Z teodord $
 */
public class DrawVisitor implements JRVisitor
{
	
	private TextRenderer textRenderer = new TextRenderer(false);

	private ConvertVisitor convertVisitor = null;
	private Graphics2D grx = null;

	private LineDrawer lineDrawer = new LineDrawer();
	private RectangleDrawer rectangleDrawer = new RectangleDrawer();
	private EllipseDrawer ellipseDrawer = new EllipseDrawer();
	private ImageDrawer imageDrawer = new ImageDrawer();
	private TextDrawer textDrawer = new TextDrawer(textRenderer);
	private FrameDrawer frameDrawer = new FrameDrawer(null, textRenderer);
	
	/**
	 *
	 */
	public DrawVisitor(JRReport report, Graphics2D grx)
	{
		this(new ReportConverter(report, true, true), grx);
	}

	/**
	 *
	 */
	public DrawVisitor(ReportConverter reportConverter, Graphics2D grx)
	{
		this.convertVisitor = new ConvertVisitor(reportConverter);
		setGraphics2D(grx);
		frameDrawer.setClip(true);
	}

	/**
	 *
	 */
	public void setGraphics2D(Graphics2D grx)
	{
		this.grx = grx;
	}

	/**
	 *
	 */
	public void visitBreak(JRBreak breakElement)
	{
		//FIXMEDRAW
	}

	/**
	 *
	 */
	public void visitChart(JRChart chart)
	{
		try
		{
			imageDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(chart), 
				-chart.getX(), 
				-chart.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	/**
	 *
	 */
	public void visitCrosstab(JRCrosstab crosstab)
	{
		try
		{
			frameDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(crosstab), 
				-crosstab.getX(), 
				-crosstab.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	/**
	 *
	 */
	public void visitElementGroup(JRElementGroup elementGroup)
	{
		//nothing to draw. elements are drawn individually.
	}

	/**
	 *
	 */
	public void visitEllipse(JREllipse ellipse)
	{
		ellipseDrawer.draw(
			grx,
			convertVisitor.getVisitPrintElement(ellipse), 
			-ellipse.getX(), 
			-ellipse.getY()
			);
	}

	/**
	 *
	 */
	public void visitFrame(JRFrame frame)
	{
		try
		{
			frameDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(frame), 
				-frame.getX(), 
				-frame.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	/**
	 *
	 */
	public void visitImage(JRImage image)
	{
		try
		{
			imageDrawer.draw(
					grx,
					convertVisitor.getVisitPrintElement(image), 
					-image.getX(), 
					-image.getY()
					);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	/**
	 *
	 */
	public void visitLine(JRLine line)
	{
		lineDrawer.draw(
			grx,
			convertVisitor.getVisitPrintElement(line), 
			-line.getX(), 
			-line.getY()
			);
	}

	/**
	 *
	 */
	public void visitRectangle(JRRectangle rectangle)
	{
		rectangleDrawer.draw(
			grx,
			convertVisitor.getVisitPrintElement(rectangle), 
			-rectangle.getX(), 
			-rectangle.getY()
			);
	}

	/**
	 *
	 */
	public void visitStaticText(JRStaticText staticText)
	{
		textDrawer.draw(
			grx,
			convertVisitor.getVisitPrintElement(staticText), 
			-staticText.getX(), 
			-staticText.getY()
			);
	}

	/**
	 *
	 */
	public void visitSubreport(JRSubreport subreport)
	{
		try
		{
			imageDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(subreport), 
				-subreport.getX(), 
				-subreport.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	/**
	 *
	 */
	public void visitTextField(JRTextField textField)
	{
		textDrawer.draw(
			grx,
			convertVisitor.getVisitPrintElement(textField), 
			-textField.getX(), 
			-textField.getY()
			);
	}

	public void visitComponentElement(JRComponentElement componentElement)
	{
		try
		{
			imageDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(componentElement), 
				-componentElement.getX(), 
				-componentElement.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

	public void visitGenericElement(JRGenericElement element)
	{
		try
		{
			imageDrawer.draw(
				grx,
				convertVisitor.getVisitPrintElement(element), 
				-element.getX(), 
				-element.getY()
				);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}

}
