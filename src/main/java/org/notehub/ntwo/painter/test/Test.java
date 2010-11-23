package org.notehub.ntwo.painter.test;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Test {
	
	private static void createImage(ImageFactory imgf,Dimension size,File pngfile){
		
		imgf.setSize(size);
		
		try{
			BufferedImage image=(BufferedImage)imgf.createImage();
			ImageIO.write(image, "png", pngfile );
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		
		new HoneycombOneImageFactory();
		
		createImage( 
				new HoneycombOneImageFactory(),
				new Dimension(300,300),
				new File("honeycombAsOne.png")
		);

		createImage( 
				new HoneycombTwoImageFactory(),
				new Dimension(600,600),
				new File("honeycombAsTwo.png")
		);
	}

}
