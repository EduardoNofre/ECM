package com.br.meta.ecm.painel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JViewport;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.br.meta.ecm.view.FramePrincipal;

public class PainelDireito extends JPanel{	

	private JViewport viewport = new JViewport();	
	
	JSlider zoomDireta = new JSlider(0, 50, 19);

	JSlider rotateDireta = new JSlider(0, 360, 0);

	BufferedImage bufferedImage = null;

	JViewport jViewport = null;

	DropTarget dropTargetDireito = null;

	PainelDireito painelDireito = null;

	PainelDireito painelDireitaAddComponentesZoomRotate = null;

	public static JScrollPane scrollpanelAddControleDireito = new JScrollPane();

	static PropriedadeImagem addImagemPainelDireito, getAddImagemPainelDireito;

	public PainelDireito() {

	}

	public PainelDireito(JViewport viewport) {

		setOpaque(false);		

		this.viewport = viewport;

	}
	
	public PropriedadeImagem changeImgDireita() throws IOException {

		bufferedImage = ImageIO.read(new File(FramePrincipal.imagem));

		addImagemPainelDireito = new PropriedadeImagem(bufferedImage);
		
		PainelDireito.addImagemPainelDireito.setName("Direita");
		
		dropTargetDireito = new DropTarget(addImagemPainelDireito, DnDConstants.ACTION_MOVE,FramePrincipal.ecmView);
		
		addImagemPainelDireito.setScale(19);

		return addImagemPainelDireito;
	}
	
	public PainelDireito componentesZoomRotate() throws IOException {

		PainelDireito.addImagemPainelDireito.setName("Direita");

		zoomDireta.setPaintTicks(true);
		
		zoomDireta.setPaintLabels(true);
		
		zoomDireta.setBackground(Color.WHITE);

		zoomDireta.setMajorTickSpacing(10);

		zoomDireta.setOrientation(0);

		zoomDireta.addChangeListener(

		new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				addImagemPainelDireito.setScale(zoomDireta.getValue());
				
				viewport.setView(addImagemPainelDireito);

				PainelDireito.scrollpanelAddControleDireito.setAutoscrolls(true);

				PainelDireito.scrollpanelAddControleDireito.setName("compareDireita");

				PainelDireito.scrollpanelAddControleDireito.setBounds(840, 125, 500, 815);

				PainelDireito.scrollpanelAddControleDireito.setAlignmentX(-1000);

				PainelDireito.scrollpanelAddControleDireito.setAlignmentY(-1500);

				PainelDireito.scrollpanelAddControleDireito.setAutoscrolls(true);
			}
		});

		rotateDireta.setPaintTicks(true);
		
		rotateDireta.setPaintLabels(true);
		
		rotateDireta.setBackground(Color.WHITE);
		
		rotateDireta.setBounds(-10000, 10, 100, 150);

		rotateDireta.setMajorTickSpacing(90);

		rotateDireta.setOrientation(0);

		rotateDireta.addChangeListener(

		new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				JSlider slider = (JSlider) e.getSource();

				addImagemPainelDireito.setAngle(slider.getValue());

				viewport.setView(addImagemPainelDireito);

				PainelDireito.scrollpanelAddControleDireito.setAutoscrolls(true);

				PainelDireito.scrollpanelAddControleDireito.setName("compareImagensPainel01");

				PainelDireito.scrollpanelAddControleDireito.setBounds(840, 125, 500, 815);

				PainelDireito.scrollpanelAddControleDireito.setAlignmentX(10);

				PainelDireito.scrollpanelAddControleDireito.setAlignmentY(10);

				PainelDireito.scrollpanelAddControleDireito.setAutoscrolls(true);
			}
		});

		painelDireito.setLayout(new GridLayout(1,1));
		
		painelDireito.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE), "                              Zoom               Painel Direito                       rota��o"));
		
		painelDireito.add(zoomDireta);

		painelDireito.add(rotateDireta);

		return painelDireito;
	}
	
	public PainelDireito direitaPrincipal(FramePrincipal ecmView) throws IOException {

		getAddImagemPainelDireito = this.changeImgDireita();

		PainelDireito.scrollpanelAddControleDireito.setViewport(viewport);

		dropTargetDireito = new DropTarget(getAddImagemPainelDireito, DnDConstants.ACTION_MOVE,ecmView);

		painelDireito= new PainelDireito(viewport);

		viewport.setView(dropTargetDireito.getComponent());

		PainelDireito.scrollpanelAddControleDireito.setBounds(840, 125, 500, 815);

		PainelDireito.getAddImagemPainelDireito.setName("Direita");

		painelDireitaAddComponentesZoomRotate = this.componentesZoomRotate();

		getAddImagemPainelDireito.setScale(19);

		return painelDireitaAddComponentesZoomRotate;

	}
	
	public class PropriedadeImagem extends JPanel {

		private boolean carregaImage;

		private double scale = 1;

		private double angle = 0;

		int widthZoom;

		int heightZoom;

		BufferedImage imgBuff;

		public PropriedadeImagem(BufferedImage img) {

			imgBuff = img;

		}

		@Override
		protected void paintComponent(Graphics g)// paints obj on the screen
		{
			super.paintComponent(g); // prepares graphic object for drawing

			int originX = getWidth() / 2;

			int originY = getHeight() / 2;

			int xOffset = -(imgBuff.getWidth() / 2);

			int yOffset = -(imgBuff.getHeight() / 2);

			Graphics2D g2d = (Graphics2D) g.create();

			g2d.translate(originX, originY);

			g2d.scale(scale, scale);

			g2d.rotate(Math.toRadians(angle), 0, 0);

			g2d.drawImage(imgBuff, xOffset, yOffset, null);

			setBackground(Color.gray);

			g2d.dispose();

		}

		public void setAngle(double angle) {

			this.angle = angle;

			if (angle == 90.0 || angle == 91.0 || angle == 92.0
					|| angle == 93.0 || angle == 94.0 || angle == 95.0
					|| angle == 96.0 || angle == 97.0 || angle == 98.0
					|| angle == 269.0 || angle == 270.0 || angle == 271.0
					|| angle == 272.0 || angle == 273.0 || angle == 274.0
					|| angle == 275.0 || angle == 276.0 || angle == 277.0
					|| angle == 278.0) {

				setPreferredSize(new Dimension(heightZoom, widthZoom));

				revalidate();

				repaint();

			} else {

				setPreferredSize(new Dimension(widthZoom, heightZoom));

				revalidate();

				repaint();
			}

			repaint();
		}

		public void setScale(int scale) {

			widthZoom = ((imgBuff.getWidth() / 100) * scale);
			heightZoom = ((imgBuff.getHeight() / 100) * scale);

			setPreferredSize(new Dimension(widthZoom, heightZoom));

			revalidate();
			repaint();

			this.scale = (scale / 100d);
			repaint();
		}

		public double getScale() {
			return scale;
		}

		@Override
		public void setAutoscrolls(boolean autoscrolls) {
			// TODO Auto-generated method stub
			super.setAutoscrolls(true);
		}

		@Override
		public boolean getAutoscrolls() {
			// TODO Auto-generated method stub
			return super.getAutoscrolls();
		}
	}
	
}
