package org.notehub.ntwo.painter.test;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;


public class GResource {
	
	private static Key hintKey=RenderingHints.KEY_ANTIALIASING;
	static public Object getRenderingHint(Graphics2D g2){
		return g2.getRenderingHint(hintKey);
	}
	static public void setRenderingHint(Graphics2D g2,Object renderingHintObj){
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,renderingHintObj);
	}
	
	static public void setAntialiasOn(Graphics2D g2){
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	}
	static public void setAntialiasOff(Graphics2D g2){
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
	}

}
