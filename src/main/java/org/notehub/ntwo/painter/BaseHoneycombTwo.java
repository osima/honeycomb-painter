package org.notehub.ntwo.painter;

import java.util.ArrayList;

/**
 * 位置計算用クラス
 * 二層
 */
abstract public class BaseHoneycombTwo extends XComponent implements IHoneycombComponent{
	
//	static private double DEFAULT_CELL_RATE=3.0d;//2.8f; 
//	
//	
//	public BaseHoneycombTwo(){
//		super();
//		setCellRate( DEFAULT_CELL_RATE );
//	}
//	
//	
//	
//	private double cellRate;
//	public void setCellRate(double cellRate){
//		this.cellRate=cellRate;
//	}
//	public double getCellRate(){
//		return cellRate;
//	}
	
	
	
	static private double DEFAULT_CELL_RATE=3.0d;//2.8f; 
	static private double DEFAULT_DIST_RATE=1.1d; 

	private double cellRate=DEFAULT_CELL_RATE;
	public void setCellRate(float cellRate){
		this.cellRate=cellRate;
	}
	public double getCellRate(){
		return cellRate;
	}
	private double distRate=DEFAULT_DIST_RATE;
	public void setDistRate(float distRate){
		this.distRate=distRate;
	}
	public double getDistRate(){
		return distRate;
	}


	public HexagonCell[] getHexagonCells(){
		ArrayList<HexagonCell> list=new ArrayList<HexagonCell>();
		HoneycombOne[] hOnes=getHoneycombOnes();
		for(int i=0; i<hOnes.length; i++){
			HexagonCell[] sprites=hOnes[i].getHexagonCells();
			for( HexagonCell cell:sprites){
				list.add(cell);
			}
		}
		return list.toArray(new HexagonCell[0]);
	}
	
	public HoneycombOne[] getHoneycombOnes(){
		XPoint loc=getLocation();
		HoneycombOne[] hOnes=__getHoneycombOnes();
		for(int i=0; i<hOnes.length; i++){
			hOnes[i].translate(loc.x,loc.y);
		}
		return hOnes;
	}
	
	private HoneycombOne[] __getHoneycombOnes(){

		XDimension size=getSize();

		HoneycombOne[] hOnes=new HoneycombOne[7];
		
		//各セルのサイズを指定のサイズから割り出す（1/3にしているだけだが）
		{
			double cellw=(Math.min(size.width,size.height)/getCellRate());
			XDimension cellSize=new XDimension(cellw,cellw);
			
			for(int i=0; i<hOnes.length; i++){
				hOnes[i]=new HoneycombOne();
				hOnes[i].setSize(cellSize);
			}
		}
		
		
		double cellw=hOnes[0].getSize().width;
		
		double diffX=size.width/2f-cellw/2f;
		double diffY=size.height/2f-cellw/2f;

		
		//中心と周りの六角形の距離の指定
		//double dist=(cellw*1.1f);//二層目の場合は距離をたくさん取る.
		double dist=cellw*getDistRate();
		
		{
			HoneycombOne s=hOnes[0];
			XPoint loc=new XPoint();
			loc.translate(diffX,diffY);
			s.setLocation(loc);
		}
		
		
		for(int i=1; i<hOnes.length; i++){
			int v=0;
			v=60*i-120;
			double radian=v*Math.PI/180;
			
			double x=Math.cos( radian )*dist;
			double y=Math.sin( radian )*dist;
			
			XPoint loc=new XPoint(x,y);
			loc.translate(diffX,diffY);
			hOnes[i].setLocation(loc);
		}
		
		return hOnes;
	}

}
