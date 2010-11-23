package org.notehub.ntwo.painter;

public class XPoint {
	public double x;
	public double y;
	
	public XPoint(){
		this(0,0);
	}
	public XPoint(double x,double y){
		this.x=x;
		this.y=y;
	}
	public void translate(double diffX,double diffY){
		x=x+diffX;
		y=y+diffY;
	}

}
