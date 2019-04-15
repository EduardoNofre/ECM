package com.br.meta.ecm.painel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Label;
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

import com.br.meta.ecm.view.CheckListFrame;
import com.br.meta.ecm.view.FramePrincipal;

public class CheckListPainelEsquerdo extends JPanel {

	private static final long serialVersionUID = 1L;

	private JViewport viewport = new JViewport();	
	
	JSlider zoomEsquerda = new JSlider(0, 50, 19);

	JSlider rotateEsquerda = new JSlider(0, 360, 0);

	BufferedImage bufferedImage = null;

	JViewport jViewport = null;

	DropTarget dropTargetEsquerdo = null;

	CheckListPainelEsquerdo painelEsquerdo = null;

	CheckListPainelEsquerdo painelEsquerdoAddComponentesZoomRotate = null;

	public static JScrollPane scrollpanelAddControleEsquerdo = new JScrollPane();

	static PropriedadeImagem addImagemPainelEsquerdo, getAddImagemPainelEsquerdo;

	public CheckListPainelEsquerdo() {

	}

	public CheckListPainelEsquerdo(JViewport viewport) {

		setOpaque(false);

		this.viewport = viewport;

	}

	public PropriedadeImagem changeImgEsquerda() throws IOException {

		bufferedImage = ImageIO.read(new File(CheckListFrame.imagem));

		addImagemPainelEsquerdo = new PropriedadeImagem(bufferedImage);
		
		CheckListPainelEsquerdo.addImagemPainelEsquerdo.setName("Esquerda");
		
		dropTargetEsquerdo = new DropTarget(addImagemPainelEsquerdo, DnDConstants.ACTION_MOVE,CheckListFrame.checkListFrame);
		
		addImagemPainelEsquerdo.setScale(19);

		return addImagemPainelEsquerdo;
	}

	public CheckListPainelEsquerdo componentesZoomRotate() throws IOException {	

		CheckListPainelEsquerdo.addImagemPainelEsquerdo.setName("Esquerda");
		
		zoomEsquerda.setBackground(Color.WHITE);
		
		zoomEsquerda.setPaintLabels(true);
		
		zoomEsquerda.getAccessibleContext().setAccessibleName("Major Ticks");
		
		zoomEsquerda.setBounds(10, 10, 50, 50);

		zoomEsquerda.setPaintTicks(true);

		zoomEsquerda.setMajorTickSpacing(10);

		zoomEsquerda.setOrientation(0);
		
		zoomEsquerda.addChangeListener(

		new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				addImagemPainelEsquerdo.setScale(zoomEsquerda.getValue());

				viewport.setView(addImagemPainelEsquerdo);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAutoscrolls(true);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setName("compareEsquerda");

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setBounds(325, 250, 500, 700);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAlignmentX(10);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAlignmentY(10);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAutoscrolls(true);
			}
		});

		rotateEsquerda.setBackground(Color.WHITE);
		
		rotateEsquerda.setPaintLabels(true);
		
		rotateEsquerda.setBounds(10, 10, 50, 50);
		
		rotateEsquerda.setPaintTicks(true);

		rotateEsquerda.setMajorTickSpacing(90);

		rotateEsquerda.setOrientation(0);

		rotateEsquerda.addChangeListener(

		new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {

				JSlider slider = (JSlider) e.getSource();

				addImagemPainelEsquerdo.setAngle(slider.getValue());

				viewport.setView(addImagemPainelEsquerdo);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAutoscrolls(true);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setName("compareImagensPainel01");

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setBounds(325, 250, 500, 700);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAlignmentX(10);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAlignmentY(10);

				CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setAutoscrolls(true);
			}
		});
		
		
		painelEsquerdo.setLayout(new GridLayout(1,1));
		
		painelEsquerdo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.WHITE, Color.WHITE), "                              Zoom               Painel Esquerdo                      rotação"));
		
		painelEsquerdo.add(zoomEsquerda);

		painelEsquerdo.add(rotateEsquerda);

		return painelEsquerdo;
	}

	public CheckListPainelEsquerdo esquerdoPrincipalChk(CheckListFrame checkListFrame) throws IOException {

		getAddImagemPainelEsquerdo = this.changeImgEsquerda();

		CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setViewport(viewport);

		dropTargetEsquerdo = new DropTarget(getAddImagemPainelEsquerdo, DnDConstants.ACTION_MOVE,checkListFrame);

		painelEsquerdo = new CheckListPainelEsquerdo(viewport);

		viewport.setView(dropTargetEsquerdo.getComponent());

		CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo.setBounds(325, 250, 500, 700);

		CheckListPainelEsquerdo.getAddImagemPainelEsquerdo.setName("area1");

		painelEsquerdoAddComponentesZoomRotate = this.componentesZoomRotate();

		getAddImagemPainelEsquerdo.setScale(14);

		return painelEsquerdoAddComponentesZoomRotate;

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
