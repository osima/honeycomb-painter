package org.notehub.ntwo.painter;

/**
 * 六角形ポリゴン計算クラス
 */
public class HexagonMaker implements IHexagonMaker{

	public HexagonMaker(){
	}
	

	public XPolygon getPolygon(XDimension size){
		
		XPolygon pol=createHexagonPolygon(size);
		double radius=Math.min(size.width,size.height)/2f;
		pol.translate(radius,radius);
		return pol;
	}

	private static XPolygon createHexagonPolygon(XDimension size){
		int numsides=6;
		double radius=Math.min(size.width,size.height)/2.0f;
		
		XPolygon p=new XPolygon();
		double angle=2 * Math.PI/numsides;
		for(int i=0; i<numsides; i++){
			p.addPoint( (int)(radius*Math.sin(angle*i)), (int)(radius*-Math.cos(angle*i)) );
		}
		return p;
	}
}
