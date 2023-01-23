package paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

public class CizimTahtasi extends JComponent{
	Graphics g = getGraphics();
	Graphics2D grafikAyarlari = (Graphics2D) g; 
	int hareket =1;
	float transparantVal=1.0F;
	public static final long serialVersionUID = 1L;

	Color kenarlikRengi=Color.BLACK, dolguRengi = Color.black;
	Color kenarlikRengi1=Color.WHITE, dolguRengi1 = Color.white;
	
	ArrayList<Shape> sekiller = new ArrayList<Shape>();
	ArrayList<Color> dolguSekli = new ArrayList<Color>();
	ArrayList<Color> kenarlikSekli = new ArrayList<Color>();
	ArrayList<Float> transYuzdesi=new ArrayList<Float>();
	
	Point cizimBaslangic,cizimSon;
	
	public CizimTahtasi() {
		
		this.addMouseListener((MouseListener) new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {//mouse týklama
				if(hareket!= 1) {//mouse kordinatlarýný algýlama
				cizimBaslangic = new Point(e.getX(), e.getY());
				cizimSon=cizimBaslangic;
				repaint();
				}
			}
			public void mouseReleased(MouseEvent e) {//mouse sürükleme
				
				if(hareket!= 1) {//mouse sürükleme yapýlýyorsa
					Shape sekil1=null;
				
					if(hareket==2) {//cizgi cizme
						 sekil1 = cizgiCiz(cizimBaslangic.x,cizimBaslangic.y, e.getX(),e.getY());
					}
					else if(hareket==3) {//elips cizme
						 sekil1 = elipsCiz(cizimBaslangic.x,cizimBaslangic.y, e.getX(),e.getY());
					}
					else if(hareket==4) {// dikdörtgen
						 sekil1 = diktortgenCiz(cizimBaslangic.x,cizimBaslangic.y, e.getX(),e.getY());
					}
					else if(hareket==5) {// silgi
						sekil1 = silgiCiz(cizimBaslangic.x,cizimBaslangic.y, e.getX(),e.getY());
					}

				sekiller.add(sekil1);
				dolguSekli.add(kenarlikRengi);
				kenarlikSekli.add(kenarlikRengi);
				
				transYuzdesi.add(transparantVal);
				
				cizimBaslangic=null;//cizimi sýfýrlamak için
				cizimSon=null;
				repaint();
				
				
				}
			}
		});//addmouselistener sonu
		this.addMouseMotionListener(new MouseMotionAdapter() {//mouse býraktýðý aný yakalar

			@Override
			public void mouseDragged(MouseEvent e) {
			//fýrça ile cizim yapma
				if(hareket ==1) {
				int x=e.getX();
				int y=e.getY();
				
				Shape sekil1=null;
				kenarlikRengi=dolguRengi;
				
				sekil1 =fircaCiz(x,y,4,3);//boyut belirleme
				
				sekiller.add(sekil1);
				dolguSekli.add(dolguRengi);
				kenarlikSekli.add(kenarlikRengi);
				transYuzdesi.add(transparantVal);
				}
				cizimSon=new Point(e.getX(),e.getY());
				repaint();
			}

			
		});
		//*******************************************************************************************
		//silgi deneme
		this.addMouseMotionListener(new MouseMotionAdapter() {//mouse býraktýðý aný yakalar

			@Override
			public void mouseDragged(MouseEvent e) {
			//fýrça ile cizim yapma
				if(hareket ==5) {
				int x=e.getX();
				int y=e.getY();
				
				Shape sekil1=null;
				kenarlikRengi1=dolguRengi1;
				
				sekil1 =silgiCiz(x,y,4,3);//boyut belirleme
				
				sekiller.add(sekil1);
				dolguSekli.add(dolguRengi1);
				kenarlikSekli.add(kenarlikRengi1);
				transYuzdesi.add(transparantVal);
				}
				cizimSon=new Point(e.getX(),e.getY());
				repaint();
			}

			
		});
		//***************************************************************************************************
		
	}
	public void paint(Graphics g) {//renk belirleme
		
		 grafikAyarlari=(Graphics2D)g;
		grafikAyarlari.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		grafikAyarlari.setStroke(new BasicStroke(4));
		
		Iterator<Color> kenarlikSay=kenarlikSekli.iterator();
		Iterator<Color> dolguSay=dolguSekli.iterator();
		Iterator<Float> transSay=transYuzdesi.iterator();
		
		
		
		for(Shape s : sekiller) {//sekillere renkleri uygulama
			grafikAyarlari.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,transSay.next()));
			grafikAyarlari.setPaint(kenarlikSay.next());
			grafikAyarlari.draw(s);
			grafikAyarlari.setPaint(dolguSay.next());
			grafikAyarlari.fill(s);
			
		}
		if(cizimBaslangic != null && cizimSon != null) {
			grafikAyarlari.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.40f));
			grafikAyarlari.setPaint(Color.LIGHT_GRAY);
			
			Shape sekil1=null;
			
			if(hareket==2) {//cizgi cizme
				 sekil1 = cizgiCiz(cizimBaslangic.x,cizimBaslangic.y, cizimSon.x,cizimSon.y);
			}
			
			else if(hareket==3) {//elips cizme
				 sekil1 = elipsCiz(cizimBaslangic.x,cizimBaslangic.y, cizimSon.x,cizimSon.y);
			}
			
			else if(hareket==4) {// dikdörtgen cizme
				 sekil1 = diktortgenCiz(cizimBaslangic.x,cizimBaslangic.y,cizimSon.x,cizimSon.y);
			}
			else if(hareket==5) {//silgi cizme
				 sekil1 = silgiCiz(cizimBaslangic.x,cizimBaslangic.y,cizimSon.x,cizimSon.y);
			}
	
			
			grafikAyarlari.draw(sekil1);
			
		
			
		}
	
	}

	

//dikdörgen cizme metodu
 
public Rectangle2D.Float diktortgenCiz(int x1,int y1,int x2,int y2){
	
	int x=Math.min(x1, x2);
	
	int y=Math.min(y1, y2);
	
	int genislik=Math.abs(x1-x2);
	int yukseklik=Math.abs(y1-y2);
	
	return new Rectangle2D.Float(x,y,genislik,yukseklik);
	}


//elips cizme metodu
public Ellipse2D.Float elipsCiz(int x1,int y1,int x2,int y2){
	
	int x=Math.min(x1, x2);
	
	int y=Math.min(y1, y2);
	
	int genislik=Math.abs(x1-x2);
	int yukseklik=Math.abs(y1-y2);
	
	return new Ellipse2D.Float(x,y,genislik,yukseklik);
	}

//cizgi cizme metodo
public Line2D.Float cizgiCiz(int x1,int y1,int x2,int y2){
	
	return new  Line2D.Float(x1,y1,x2,y2);
}

//fýrca cizme metodu

public Ellipse2D.Float fircaCiz(int x1,int y1,int fircaKenarlikGenisligi,int fircaKenarlikYuksekligi){
	
	return new Ellipse2D.Float( x1, y1, fircaKenarlikGenisligi, fircaKenarlikYuksekligi);
}
//silgi metodo
public Ellipse2D.Float silgiCiz(int x1,int y1,int fircaKenarlikGenisligi,int fircaKenarlikYuksekligi){
	
	return new Ellipse2D.Float( x1, y1, 0, 0);
}


}


