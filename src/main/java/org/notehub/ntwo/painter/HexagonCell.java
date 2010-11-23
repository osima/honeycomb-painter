package org.notehub.ntwo.painter;

import java.awt.Point;
import java.awt.Polygon;


public class HexagonCell extends XComponent{
	
	
	public boolean contains(Point p){
		
		Polygon pol=DrawingUtils.toAwtPolygon(this);
		return pol.contains(p);
		
	}
	
	public boolean contains(XPoint p){
		
		Polygon pol=DrawingUtils.toAwtPolygon(this);
		return pol.contains(p.x,p.y);
		
	}

}


