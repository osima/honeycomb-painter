package org.notehub.ntwo.painter;

interface IXComponent {
	
	void translate(double diffX,double diffY);
	
	XDimension getSize();
	void setSize(XDimension size);
	
	void setLocation(XPoint loc);
	XPoint getLocation();

}
