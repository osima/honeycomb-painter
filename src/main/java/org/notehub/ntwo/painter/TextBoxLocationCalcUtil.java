package org.notehub.ntwo.painter;

import java.awt.Insets;
import java.awt.geom.Rectangle2D;


class TextBoxLocationCalcUtil{
	

	private HexagonCell hexagonCell;
	public TextBoxLocationCalcUtil(HexagonCell hexagonCell){
		this.hexagonCell=hexagonCell;
	}
	
	
	static public Rectangle2D padding(Rectangle2D rect,Insets padding){
		double x=rect.getX()+padding.left;
		double y=rect.getY()+padding.top;
		double w=rect.getWidth()-(padding.left+padding.right);
		double h=rect.getHeight()-(padding.top+padding.bottom);
		return new Rectangle2D.Double(x,y,w,h);
	}

	static private HexagonMaker _hm=new HexagonMaker();
	
	public Rectangle2D getRectangle(){
		XPoint pt0=getUpLeftPoint();
		XPoint pt1=getDownRightPoint();
		
		return new Rectangle2D.Double(
				pt0.x,
				pt0.y,
				(pt1.x-pt0.x),
				(pt1.y-pt0.y)
		);
	}
	
	public XPoint getTopPoint(){
		XPolygon pol=getPolygon();
		return new XPoint( pol.xpoints[0],pol.ypoints[0] );
	}
	
	public XPoint getUpLeftPoint(){
		
		XPolygon pol=getPolygon();
		return new XPoint( pol.xpoints[5],pol.ypoints[5] );
		
	}
	public XPoint getUpRightPoint(){
		
		XPolygon pol=getPolygon();
		return new XPoint( pol.xpoints[1],pol.ypoints[1] );

	}
	public XPoint getDownRightPoint(){
		
		XPolygon pol=getPolygon();
		return new XPoint( pol.xpoints[2],pol.ypoints[2] );
		
	}
	
	private XPolygon xpol;
	protected XPolygon getPolygon(){
		if(xpol==null){
			xpol=_hm.getPolygon( hexagonCell.getSize() );
		}
		return xpol;
	}
	
}


