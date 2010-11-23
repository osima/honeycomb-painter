package org.notehub.ntwo.painter.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.notehub.ntwo.painter.HexagonShape;
import org.notehub.ntwo.painter.HoneycombOne;
import org.notehub.ntwo.painter.HoneycombTwo;
import org.notehub.ntwo.painter.XDimension;
import org.notehub.ntwo.painter.XPoint;


public class HoneycombTwoImageFactory extends AbstractImageFactory
implements ImageFactory{
	
	
	/*
	static private Color BG_0=new Color(102,102,102);
	static private Color BG_1=new Color(152,152,152);
	static private Color BG_2=new Color(194,194,194);
	*/
	
	static private Color BG=Color.WHITE;

	static private Color BORDER=new Color(0x00,0x00,0x00);	
	
	static private Color BG_0=Color.white;//new Color(0x99,0x99,0x99);
	static private Color BG_1=new Color(0xAA,0xAA,0xAA);
	static private Color BG_2=new Color(0xCC,0xCC,0xCC);


	public void paint(Graphics2D g2){

		Dimension size=getSize();

		// paint background as white
		g2.setColor(BG);
		g2.fill(new Rectangle(new Point(),size));

		
		HoneycombTwo two=new HoneycombTwo(){
			@Override
			public HoneycombOne[] getHoneycombOnes() {

				HoneycombOne[] hos= super.getHoneycombOnes();
				for(int i=0; i<hos.length; i++){
					hos[i].setDistRate(0.9f);
					hos[i].setCellRate(2.8f);
				}
				return hos;
			}
		};
		two.setCellRate(3.1f);
		two.setDistRate(1.1f);
		
		two.setLocation(new XPoint());
		two.setSize(new XDimension(size.width,size.height));
		
		HexagonShape[] list=two.getHexagonShapes();
		for(int i=0; i<list.length; i++){
			HexagonShape shape=list[i];
			
			
			if(i==0){
				g2.setColor(BG_0);
				g2.fill(shape);
			}
			else if(0<i && i<7){
				g2.setColor(BG_1);
				g2.fill(shape);
			}
			else if(i==7*1 || i==7*2 || i==7*3 || i==7*4 || i==7*5 || i==7*6){
				g2.setColor(BG_1);
				g2.fill(shape);
				
			}
			else{
				g2.setColor(BG_2);
				g2.fill(shape);
			}
			
			if(i==0){
				g2.setColor(BORDER);
				g2.draw(shape);
			}

		}
	}
	
	public Image createImage(){

		Dimension size=getSize();
		BufferedImage bimg=new BufferedImage(size.width,size.height,BufferedImage.TYPE_4BYTE_ABGR);
		
		Graphics2D g2=(Graphics2D)bimg.getGraphics();
		GResource.setAntialiasOn(g2);
		paint(g2);
		g2.dispose();
		
		return (bimg);
	}


}
