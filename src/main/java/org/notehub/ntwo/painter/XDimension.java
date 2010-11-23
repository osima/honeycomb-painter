package org.notehub.ntwo.painter;

public class XDimension {
	
	public double width,height;
	
	public XDimension(){
		this(100,100);
	}
	public XDimension(XDimension size){
		this(size.width,size.height);
	}
	public XDimension(double w,double h){
		this.width=w;
		this.height=h;
	}
	
	public String toString(){
		return "("+width+","+height+")";
	}

}
