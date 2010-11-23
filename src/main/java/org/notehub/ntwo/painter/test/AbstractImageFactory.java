package org.notehub.ntwo.painter.test;

import java.awt.Dimension;

public class AbstractImageFactory {
	
	private Dimension size;
	public void setSize(Dimension size){
		this.size=size;
	}
	public Dimension getSize(){
		if(size==null)
			size=new Dimension(850,800);
		return size;
	}

}
