package org.notehub.ntwo.painter;

import java.awt.Polygon;

/**
 * 多角形の各頂点のポイントを保持するクラス
 */

public class XPolygon {
	
	public int npoints=0;
	public double[] xpoints=new double[0];
	public double[] ypoints=new double[0];
	
	public XPolygon(){
	    super();
	}
	
	
	public XPolygon(double[] xpoints,double[] ypoints,int npoints){
		this.xpoints=xpoints;
		this.ypoints=ypoints;
		this.npoints=npoints;
	}
	public boolean contains(double x,double y){
		
		Polygon pol=new Polygon(
				DrawingUtils.toIntArray(xpoints),
				DrawingUtils.toIntArray(ypoints),
				npoints
		);
		return pol.contains(x,y);
	}
	
//	static private int[] toIntArray(double[] array){
//		
//		int[] r=new int[array.length];
//		for(int i=0; i<r.length; i++){
//			r[i]=(int)array[i];
//		}
//		return r;
//	}
	
	public void translate(XPoint p){
		translate(p.x,p.y);
	}
	public void translate(double x,double y){
		for(int i=0; i<xpoints.length; i++){
			xpoints[i]=xpoints[i]+x;
			ypoints[i]=ypoints[i]+y;
		}
		
	}
	
	/*
	public int[] getIntArray(){
		int size=xpoints.length;
		int[] retVal=new int[size*2];
		for(int i=0; i<size; i++){
			retVal[i*2]=xpoints[i];
			retVal[i*2+1]=ypoints[i];
		}
		return retVal;
	}
	*/
	
	public void addPoint(double x,double y){
		double[] xtmp=new double[xpoints.length+1];
		double[] ytmp=new double[xpoints.length+1];
		for(int i=0; i<xpoints.length; i++){
			xtmp[i]=xpoints[i];
			ytmp[i]=ypoints[i];
		}
		xtmp[xpoints.length]=x;
		ytmp[xpoints.length]=y;
		
		xpoints=xtmp;
		ypoints=ytmp;
		npoints=xpoints.length;
	}
	public void addPoint(XPoint p){
		addPoint(p.x,p.y);
	}
}
