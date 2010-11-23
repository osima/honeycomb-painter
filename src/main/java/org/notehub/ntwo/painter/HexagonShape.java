package org.notehub.ntwo.painter;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class HexagonShape implements Shape{
	
	private Shape s;
	private HexagonCell cell;
	public HexagonCell getHexagonCell(){ return cell; }
	
	public HexagonShape(Shape s,HexagonCell cell){
		this.s=s;
		this.cell = cell;
	}
	@Override
	public boolean contains(double x, double y) {
		return s.contains(x,y);
	}
	@Override
	public boolean contains(double x, double y, double w, double h) {
		return s.contains(x,y,w,h);
	}
	@Override
	public boolean contains(Point2D p) {
		return s.contains(p);
	}
	@Override
	public boolean contains(Rectangle2D r) {
		return s.contains(r);
	}
	@Override
	public Rectangle getBounds() {
		return s.getBounds();
	}
	@Override
	public Rectangle2D getBounds2D() {
		return s.getBounds2D();
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		return s.getPathIterator(at);
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return s.getPathIterator(at, flatness);
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		return s.intersects(x,y,w,h);
	}
	@Override
	public boolean intersects(Rectangle2D r) {
		return s.intersects(r);
	}
	
}
