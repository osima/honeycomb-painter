package org.notehub.ntwo.painter.test;

//import java.awt.Dimension;
//import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;

public interface ImageFactory {
	
	void paint(Graphics2D g2);
	Image createImage();
	
	void setSize(Dimension size);
	Dimension getSize();

}
