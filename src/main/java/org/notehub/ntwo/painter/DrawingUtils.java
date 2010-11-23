package org.notehub.ntwo.painter;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;

public class DrawingUtils {
	
	static public int[] toIntArray(double[] array){
		
		int[] r=new int[array.length];
		for(int i=0; i<r.length; i++){
			r[i]=(int)array[i];
		}
		return r;
	}


	static private HexagonMaker hm=new HexagonMaker();
	static public Polygon toAwtPolygon(HexagonCell cell){
		XDimension CellSize=cell.getSize();
		XPolygon pol=hm.getPolygon(CellSize);
		pol.translate(cell.getLocation());

		Polygon awtPol=new Polygon(toIntArray(pol.xpoints),toIntArray(pol.ypoints),pol.npoints);
		
		return awtPol;
	}
	
	static public Point toPoint(XPoint pt){
		return new Point((int)pt.x,(int)pt.y);
	}
	static public XPoint toXPoint(Point pt){
		return new XPoint(pt.x,pt.y);
	}
	static public XDimension toXDimension(Dimension size){
		return new XDimension(size.width,size.height);
	}


}
