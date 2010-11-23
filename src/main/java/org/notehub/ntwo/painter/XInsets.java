package org.notehub.ntwo.painter;

public class XInsets {
	public int top,left,bottom,right;
	public XInsets(){
		this(0,0,0,0);
	}
	public XInsets(int top,int left,int bottom,int right){
		this.top=top;
		this.left=left;
		this.bottom=bottom;
		this.right=right;
	}
}
