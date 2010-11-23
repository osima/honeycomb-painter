package org.notehub.ntwo.painter;

/**
 * 位置計算用クラス
 * 一層
 */
abstract class BaseHoneycombOne extends XComponent implements IHoneycombComponent{
	
	static private double DEFAULT_CELL_RATE=2.8d; 
	static private double DEFAULT_DIST_RATE=0.9d; 

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
		
		XPoint loc=getLocation();
		HexagonCell[] sprites=__getSprites();
		for(int i=0; i<sprites.length; i++){
			sprites[i].translate(loc.x,loc.y);
		}
		return sprites;
	}
	
	private HexagonCell[] __getSprites(){

		XDimension size=getSize();
		
		HexagonCell[] sprites=new HexagonCell[7];
		
		//各セルのサイズを指定のサイズから割り出す（1/3にしているだけだが）
		{
			double cellw=(Math.min(size.width,size.height)/getCellRate());
			XDimension cellSize=new XDimension(cellw,cellw);
			
			for(int i=0; i<sprites.length; i++){
				sprites[i]=new HexagonCell();
				sprites[i].setSize(cellSize);
			}
		}
		
		
		double cellw=sprites[0].getSize().width;
		
		double diffX=size.width/2d-cellw/2d;
		double diffY=size.height/2d-cellw/2d;

		
		//中心と周りの六角形の距離の指定
		double dist=(cellw*getDistRate());
		
		{
			HexagonCell s=sprites[0];
			XPoint loc=new XPoint();
			loc.translate(diffX,diffY);
			s.setLocation(loc);
		}
		
		
		for(int i=1; i<sprites.length; i++){
			int v=0;
			v=60*i-120;
			double radian=v*Math.PI/180;
			
			double x=Math.cos( radian )*dist;
			double y=Math.sin( radian )*dist;
			
			XPoint loc=new XPoint(x,y);
			loc.translate(diffX,diffY);
			sprites[i].setLocation(loc);
		}
		
		return sprites;
	}

}
