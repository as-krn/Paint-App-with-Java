package paint;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Demo extends JFrame{
	JButton fırcaBut,cizgiBut,elipsBut,dikBut,kenarlikBut,dolguBut,silgiBut;
	JSlider transSlider;
	JLabel transLabel;
	DecimalFormat dec = new DecimalFormat("#.##");
	BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_BGR);
	Graphics gs = image.getGraphics();
	Graphics2D grafikAyarlari = (Graphics2D) gs; 
	int hareket=1;
	float transparantVal=1.0F;
	

	
	
	Color kenarlikRengi=Color.BLACK,dolguRengi=Color.black;
	
	public static void main(String[] args) {
	new Demo();
	}
	public Demo() {
		this.setSize(1000,750);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Paint Uygulamas\u0131");
		JPanel butonPanel =new JPanel();
	
		Box kutu = Box.createHorizontalBox();
		
		fırcaBut=beniButonYap(" ",1);
		cizgiBut=beniButonYap(" ",2);
		elipsBut=beniButonYap(" ",3);
		dikBut=beniButonYap(" ",4);
		silgiBut=beniButonYap(" ",5);
	
		
		kenarlikBut=beniRenkliButonYap("kenarlık",6,true);
		dolguBut=beniRenkliButonYap("dolgu",7,false);
		
		kutu.add(fırcaBut);
		kutu.add(cizgiBut);
		kutu.add(elipsBut);
		kutu.add(dikBut);
		kutu.add(kenarlikBut);
		kutu.add(dolguBut);
		kutu.add(silgiBut);
		
		fırcaBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\kalem.png"));
		fırcaBut.setToolTipText("Kalem");
		cizgiBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\çizgi.png"));
		cizgiBut.setToolTipText("Çizgi");
		elipsBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\elips.png"));
		elipsBut.setToolTipText("Elips");
		dikBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\dikdörtgen.png"));
		dikBut.setToolTipText("Dikdörtgen");
		silgiBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\silgi.png"));
		silgiBut.setToolTipText("Silgi");
		kenarlikBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\dolgu.png"));
		kenarlikBut.setToolTipText("Renk Seçimi");
		dolguBut.setIcon(new ImageIcon("E:\\\u0130ND\u0130R\u0130LENLER\\kenar.png"));
		dolguBut.setToolTipText("Fırça Rengi");
		
		
		
		transLabel=new JLabel("Transparan: 1");
		transSlider = new JSlider(1,99,99);
		ListenForSlider sliderL= new ListenForSlider();
		
		transSlider.addChangeListener(sliderL);
		kutu.add(transLabel);
		kutu.add(transSlider);
		butonPanel.add(kutu);
		
		this.add(butonPanel,BorderLayout.NORTH);
		this.add(new CizimTahtasi(), BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}//constructer sonu
	public JButton beniButonYap(String iconDosyası,final int hareketSayisi) {
		JButton but =new JButton();
		Icon butIcon= new ImageIcon();
		but.setIcon(butIcon);
		
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hareket=hareketSayisi;
			}
			
		});
		return but;
	}//beni buton yap sonu
	public JButton beniRenkliButonYap(String iconDosyası,final int hareketSayisi,final boolean kenarlik) {
		JButton but =new JButton();
		Icon butIcon= new ImageIcon();
		but.setIcon(butIcon);


		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kenarlik) {
					kenarlikRengi=JColorChooser.showDialog(null,"Kenarlık Rengi Seç", Color.BLACK);
				}else {
					dolguRengi=JColorChooser.showDialog(null,"Dolgu Rengi Seç", Color.BLACK);
				}
			}
		});
		return but;
	}//renkli buton sonu
	
	public class CizimTahtasi extends JComponent{
		
		
		public static final long serialVersionUID = 1L;
		
		Color kenarlikRengi1=new Color(240,240,240), dolguRengi1 =new Color(240,240,240);
		
		ArrayList<Shape> sekiller = new ArrayList<Shape>();
		ArrayList<Color> dolguSekli = new ArrayList<Color>();
		ArrayList<Color> kenarlikSekli = new ArrayList<Color>();
		ArrayList<Float> transYuzdesi=new ArrayList<Float>();
		
		Point cizimBaslangic,cizimSon;
		
		public CizimTahtasi() {
			
			this.setBackground(Color.WHITE);
			
			this.addMouseListener((MouseListener) new MouseAdapter() {
		
				public void mousePressed(MouseEvent e) {//mouse tıklama
					if(hareket!= 1) {//mouse kordinatlarını algılama
					cizimBaslangic = new Point(e.getX(), e.getY());
					cizimSon=cizimBaslangic;
					repaint();
					}
				}
				public void mouseReleased(MouseEvent e) {//mouse sürükleme
					
					if(hareket!= 1) {//mouse sürükleme yapılıyorsa
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
							sekil1 = silgiCiz(cizimBaslangic.x,cizimBaslangic.y, 0,0);
						}
		
					sekiller.add(sekil1);
					dolguSekli.add(kenarlikRengi);
					kenarlikSekli.add(kenarlikRengi);
					
					transYuzdesi.add(transparantVal);
					
					cizimBaslangic=null;//cizimi sıfırlamak için
					cizimSon=null;
					repaint();
					
					
					}
				}
			});//addmouselistener sonu
			this.addMouseMotionListener(new MouseMotionAdapter() {//mouse bıraktığı anı yakalar

				@Override
				public void mouseDragged(MouseEvent e) {
					
				//fırça ile cizim yapma
					
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
			this.addMouseMotionListener(new MouseMotionAdapter() {//mouse bıraktığı anı yakalar

				@Override
				public void mouseDragged(MouseEvent e) {
					
				//silgi ile cizim yapma
					
					if(hareket ==5) {
					int x=e.getX();
					int y=e.getY();
					
					Shape sekil1=null;
					kenarlikRengi1=dolguRengi1;
					
					sekil1 =silgiCiz(x,y,6,4);//boyut belirleme
					
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
					 sekil1 = silgiCiz(cizimBaslangic.x,0,cizimSon.x,0);
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
	
	//fırca cizme metodu
	
	public Ellipse2D.Float fircaCiz(int x1,int y1,int fircaKenarlikGenisligi,int fircaKenarlikYuksekligi){
		
		return new Ellipse2D.Float( x1, y1, fircaKenarlikGenisligi, fircaKenarlikYuksekligi);
	}
	//silgi metodo
	
	public Ellipse2D.Float silgiCiz(int x1,int y1,int fircaKenarlikGenisligi,int fircaKenarlikYuksekligi){
		
		return new Ellipse2D.Float( x1, y1, fircaKenarlikGenisligi, fircaKenarlikYuksekligi);
	}
	
	
	}//cizim tahtatı sonu
	
	public class ListenForSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
		
			if(e.getSource()==transSlider) {
				transLabel.setText("Transparan"+dec.format(transSlider.getValue()*.01));
			}
			transparantVal=(float)(transSlider.getValue()*.01);
			
			}
		
		}
}
