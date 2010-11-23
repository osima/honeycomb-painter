package org.notehub.ntwo.painter;

abstract class XComponent implements IXComponent {
	
	public void translate(double diffX,double diffY){
		XPoint loc=getLocation();
		setLocation(new XPoint(loc.x+diffX,loc.y+diffY));
	}
	
	private XDimension size;
	public XDimension getSize(){
		if(size==null){
			size=new XDimension();
		}
		return new XDimension(size);
	}
	public void setSize(XDimension size){
		this.size=new XDimension(size);
	}
	
	private XPoint location;
	public void setLocation(XPoint loc){
		this.location=loc;
	}
	public XPoint getLocation(){
		if(location==null){
			location=new XPoint();
		}
		return location;
	}


}
