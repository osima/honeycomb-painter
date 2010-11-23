package org.notehub.ntwo.painter;

import java.awt.Polygon;
import java.util.ArrayList;


/**
 * 位置計算用クラス
 * 二層
 */
public class HoneycombTwo extends BaseHoneycombTwo{
	
	public HoneycombTwo(){
		super();
	}
	
	@Override
	public HexagonShape[] getHexagonShapes(){
		
		ArrayList<HexagonShape> list=new ArrayList<HexagonShape>();
		
		HexagonCell[] cells=getHexagonCells();
		for(HexagonCell hc:cells){
			Polygon pol=DrawingUtils.toAwtPolygon(hc);
			
			list.add( new HexagonShape(pol,hc) );
		}
		return list.toArray(new HexagonShape[0]);
	}
}
