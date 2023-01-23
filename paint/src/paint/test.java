package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JApplet;

public class test {
	static boolean pnpoly(double[] vertx, double[] verty, double testx, double testy)
	{
	    int nvert = vertx.length;
	    int i, j;
	    boolean c = false;
	    for (i = 0, j = nvert-1; i < nvert; j = i++) {
	        if ( ((verty[i]>testy) != (verty[j]>testy)) &&
	                (testx < (vertx[j]-vertx[i]) * (testy-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
	            c = !c;
	    }
	    return c;
	} 
}
	
/*	private  Polygon ucgenCiz(int xn, int yn, int xy)
		{
		int x[]={10,(int)(10+100*Math.cos(Math.PI/3.0)),110,10};
		int y[]={100,(int)(100-100*Math.sin(Math.PI/3.0)),100,100};
		int x1[]={130,(int)(130+100*Math.cos(Math.PI/3.0)),230,130};
		int y1[];
		y1=y;
		grafikAyarlari.drawPolygon(x,y,4);
		grafikAyarlari.fillPolygon(x1,y1,4);
		return new Polygon(); 
		
		}*/


