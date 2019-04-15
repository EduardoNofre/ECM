package com.br.meta.ecm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.br.meta.ecm.controle.PainelQuantitativaAtualizarCheckImagemNo;
import com.br.meta.ecm.controle.PainelQuantitativaAtualizarCheckImagemYes;
import com.br.meta.ecm.painel.PainelAnaliseQuantitativa;
import com.br.meta.ecm.painel.PainelComprovanteDeResidencia;
import com.br.meta.ecm.painel.PainelDadosProposta;
import com.br.meta.ecm.painel.PainelDireito;
import com.br.meta.ecm.painel.PainelDocumentos;
import com.br.meta.ecm.painel.PainelEsquerdo;
import com.br.meta.ecm.painel.PainelExames;
import com.br.meta.ecm.painel.PainelPropostas;

public class FramePrincipal implements DragGestureListener, DragSourceListener,DropTargetListener, Transferable {

	static final DataFlavor[] supportedFlavors = { null };

	final JPanel origem = new JPanel();
	final JPanel destinos = new JPanel();
	final JPanel documento = new JPanel();
	final JPanel examesMedicos = new JPanel();
	final JPanel comprovanteDeResidencia = new JPanel();
	final JPanel compareImagen01 = new JPanel();
	final JPanel compareImagen02 = new JPanel();
	final JPanel proposta = new JPanel();
	final static JPanel analiseQuantitativa = new JPanel();
	final JPanel dadosDaProposta = new JPanel();
	
	public static String imagem = "C:\\tifTeste\\page0.png";
	
	PainelEsquerdo esquerdo = new PainelEsquerdo();
	PainelDireito direita = new PainelDireito();
	
	int trocaImage = 0;
	static JLabel labelProposta;
	static JLabel labelDocumento;
	static JLabel labelIconimageIconExames;
	static JLabel labelconComprovante;

	static ImageIcon imageIconProposta;
	static ImageIcon imageIconDocumento;
	static ImageIcon imageIconComprovante;
	static ImageIcon imageIconExames;

	public static FramePrincipal ecmView;

	static {

		try {

			supportedFlavors[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	Object object;

	// Transferable methods.
	public Object getTransferData(DataFlavor flavor) {

		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {

			return object;

		} else {

			return null;
		}
	}

	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}

	// DragGestureListener method.
	public void dragGestureRecognized(DragGestureEvent ev) {
		ev.startDrag(null, this, this);
	}

	// DragSourceListener methods.
	public void dragDropEnd(DragSourceDropEvent ev) {
	}

	public void dragEnter(DragSourceDragEvent ev) {
	}

	public void dragExit(DragSourceEvent ev) {

	}

	public void dragOver(DragSourceDragEvent ev) {
		object = ev.getSource();
	}

	public void dropActionChanged(DragSourceDragEvent ev) {
	}

	// DropTargetListener methods.
	public void dragEnter(DropTargetDragEvent event) {

	}

	public void dragExit(DropTargetEvent event) {
	}

	public void dragOver(DropTargetDragEvent event) {
		dropTargetDrag(event);
	}

	public void dropActionChanged(DropTargetDragEvent event) {
		dropTargetDrag(event);
	}

	void dropTargetDrag(DropTargetDragEvent event) {
		event.acceptDrag(event.getDropAction());
	}

	public void drop(DropTargetDropEvent event) {

		event.acceptDrop(event.getDropAction());//

		try {

			Object target = event.getSource(); //

			Object source = event.getTransferable().getTransferData(supportedFlavors[0]);

			Component component = ((DragSourceContext) source).getComponent();

			Container origemDragAndDrop = component.getParent();

			Container destinoDragAndDrop = (Container) ((DropTarget) target).getComponent();

			if (!(destinoDragAndDrop.getName().equals("Direita") || destinoDragAndDrop.getName().equals("Esquerda"))) {

				destinoDragAndDrop.add(component);

				this.updateImageCheckYes(destinoDragAndDrop.getName());

				this.updateImageCheckNo(origemDragAndDrop.getName(),origemDragAndDrop.getComponentCount());

			} else {

				destinoDragAndDrop.removeAll();

				JLabel imageArwaDeVerificacao = (JLabel) component;

				ImageIcon img = new ImageIcon(imageArwaDeVerificacao.getIcon().toString());

				img.setImage(img.getImage().getScaledInstance(540, 855, 800));

				JLabel adcionaImagem = new JLabel(img);
				
				if (destinoDragAndDrop.getName().equals("Direita")) {

					imagem = img.toString();

					direita.changeImgDireita();

				}
				
				if (destinoDragAndDrop.getName().equals("Esquerda")) {

					imagem = img.toString();

					esquerdo.changeImgEsquerda();

				}

				EventQueue.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub

					}
				});

				destinoDragAndDrop.add(adcionaImagem);

			}

			origemDragAndDrop.revalidate();

			origemDragAndDrop.repaint();

			destinoDragAndDrop.revalidate();

			destinoDragAndDrop.repaint();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		event.dropComplete(true);
	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Este metodo carrega os contrato nos paineis, buscando em um diretorio especificio.
	 * 
	 */
	
	private JScrollPane contrato() {

		origem.setLayout(new GridLayout(0, 1));

		origem.setToolTipText(" Origem ");

		origem.setName("OrigemPainel");

		File imageDiretorio = new File("C:\\tifTeste\\");

		File files[] = imageDiretorio.listFiles();

		DragSource dragSource = new DragSource();

		ecmView = new FramePrincipal();

		int contadorDePaginas = 1;

		for (File arq : files) {

			ImageIcon img = new ImageIcon(arq.getAbsolutePath());

			img.setImage(img.getImage().getScaledInstance(100, 150, 100));

			JLabel adcionaImagem = new JLabel(img);

			DragSource ds1 = new DragSource();

			DragGestureRecognizer dragRecognizer = dragSource.createDefaultDragGestureRecognizer(adcionaImagem,DnDConstants.ACTION_MOVE, ecmView);

			origem.add(adcionaImagem);

			adcionaImagem.setToolTipText(String.valueOf(contadorDePaginas));

			contadorDePaginas++;

		}

		DropTarget dropTargetOrigem = new DropTarget(origem,DnDConstants.ACTION_MOVE, ecmView);

		JScrollPane scrollPaneOrigem = new JScrollPane(origem);

		scrollPaneOrigem.setViewportView(origem);

		LineBorder border = new LineBorder(Color.GRAY);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Contrato", 2, TitledBorder.CENTER);

		scrollPaneOrigem.setBackground(new java.awt.Color(255, 255, 255));

		scrollPaneOrigem.setBorder(titledBorder);

		scrollPaneOrigem.setToolTipText("Image");

		scrollPaneOrigem.setBounds(1510, 120, 125, 820);

		int height = (int) origem.getPreferredSize().getHeight();

		scrollPaneOrigem.getVerticalScrollBar().setValue(2500);

		return scrollPaneOrigem;
	}

	
	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que traz a informa�oes da proposta.
	 */
	private JScrollPane propostasPainel() {

		PainelPropostas propostas = new PainelPropostas();

		return propostas.proposta(ecmView);

	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que representa os documentos do cliente tipo rg - cpf
	 *  
	 */
	private JScrollPane documentosPainel() {

		PainelDocumentos painelDocumentos = new PainelDocumentos();

		return painelDocumentos.documentos(ecmView);
	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que representa os exames medicos do cliente
	 *  
	 */
	private JScrollPane examesMedicosPainel() {

		PainelExames painelExames = new PainelExames();

		return painelExames.examesMedicosPainel(ecmView);

	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que representa o comprovante de endere�o do cliente
	 *  
	 */
	private JScrollPane comprovanteDeResidenciaPainel() {

		PainelComprovanteDeResidencia comprovanteDeResidencia = new PainelComprovanteDeResidencia();

		return comprovanteDeResidencia.comprovante(ecmView);
	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel 01 utilizado para fazer compra��o dos dados do cliente .
	 * @throws IOException 
	 *  
	 */
	private PainelEsquerdo compareImagensPainelEsquerdo() throws IOException {

		return esquerdo.esquerdoPrincipal(ecmView);
	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que indica quais os documento que o analista identificou ate o presente momento.
	 *  
	 */
	private static JScrollPane analiseQuantitativaPainel() {

		PainelAnaliseQuantitativa quantitativa = new PainelAnaliseQuantitativa();

		return quantitativa.analiseQuantitativa();

	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que traz as informa�oes da proposta.
	 *  
	 */
	private JScrollPane dadosDaPropostaPainel() {

		PainelDadosProposta dadosDaProposta = new PainelDadosProposta();

		return dadosDaProposta.dadosDaProposta();
	}

	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel 02 utilizado para fazer compra��o dos dados do cliente .
	 * @throws IOException 
	 *  
	 */
	private PainelDireito compareImagensPainelDireita() throws IOException {

		return direita.direitaPrincipal(ecmView);
	}

	
	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel Analise Quantitativa faz a troca de das imagens Yes ou NO de acordo com o drag drop.
	 *  
	 */
	
	public void updateImageCheckYes(String panelUpdateImage) {

		PainelQuantitativaAtualizarCheckImagemYes imagem = new PainelQuantitativaAtualizarCheckImagemYes();

		imagem.atualizaImgYes(panelUpdateImage);

	}

	
	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel Analise Quantitativa carrega as imagem no painel NO assim que o sistema � aberto.
	 *  
	 */
	public void updateImageCheckNo(String panelUpdateImage,int quantidadeDeComponentes) {

		PainelQuantitativaAtualizarCheckImagemNo painelQuantitativaAtualizarCheckImagemNo = new PainelQuantitativaAtualizarCheckImagemNo();

		painelQuantitativaAtualizarCheckImagemNo.atualizaImgNo(panelUpdateImage,quantidadeDeComponentes);
	}

	/**
	 * 
	 * @return JPanel
	 * 
	 * Painel de fundo
	 */
	private static JPanel fundoPainel() {

		JPanel pss = new JPanel();
		
		pss.setBackground(new java.awt.Color(255, 255, 255));

		return pss;
	}

	public static JFrame criarFrame() throws IOException {

		JFrame frame = new JFrame();		
		JPanel addComponentesZoomRotateDireita = new JPanel();
		JPanel addComponentesZoomRotateEsquerdo = new JPanel();
		
		// logo
		JPanel LogoMetaJpanel = new JPanel();
		
		LineBorder border = new LineBorder(Color.GRAY);
		
		ImageIcon img = new ImageIcon("C:\\logo\\logo.gif");		
		JLabel logoMeta = new JLabel(img);
	
		LogoMetaJpanel.add(logoMeta);		
		LogoMetaJpanel.setBackground(new java.awt.Color(255, 255, 255));

		LogoMetaJpanel.setBounds(10, 10, 300, 100);

		FramePrincipal andDrop = new FramePrincipal();

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// titulo
		frame.setTitle("Sistema ECM ");

		JScrollPane origemJsp = andDrop.contrato();
		JScrollPane propostasPainelJsp = andDrop.propostasPainel();
		JScrollPane documentoJsp = andDrop.documentosPainel();
		JScrollPane examesJsp = andDrop.examesMedicosPainel();
		JScrollPane comprovanteJsp = andDrop.comprovanteDeResidenciaPainel();
		
		PainelEsquerdo esquerda = andDrop.compareImagensPainelEsquerdo();		
		PainelDireito direita = andDrop.compareImagensPainelDireita();
	
		//addComponentesZoomRotateDireita.setBorder(border);
		addComponentesZoomRotateDireita.setBounds(840, 50, 500, 68);		
		addComponentesZoomRotateDireita.setBackground(new java.awt.Color(255, 255, 255));		
		addComponentesZoomRotateDireita.add(direita);
		
		
		//addComponentesZoomRotateEsquerdo.setBorder(border);
		addComponentesZoomRotateEsquerdo.setBounds(335, 0, 500, 68);		
		addComponentesZoomRotateEsquerdo.setBackground(new java.awt.Color(255, 255, 255));
		addComponentesZoomRotateEsquerdo.add(esquerda);
		
		
		JScrollPane analiseQuantitativaJsp = andDrop.analiseQuantitativaPainel();
		
		JScrollPane dadosDaPropostaJsp = andDrop.dadosDaPropostaPainel();
		
		JPanel fundoJsp = andDrop.fundoPainel();	

		frame.add(addComponentesZoomRotateDireita);
		
		frame.add(addComponentesZoomRotateEsquerdo);
		
		frame.add(LogoMetaJpanel);	
		
		frame.add(analiseQuantitativaJsp);
		
		frame.add(dadosDaPropostaJsp);
	
		
		frame.add(origemJsp);
		frame.add(propostasPainelJsp);
		frame.add(documentoJsp);
		frame.add(examesJsp);
		frame.add(comprovanteJsp);
		frame.add(comprovanteJsp);
					
		frame.getContentPane().add(PainelDireito.scrollpanelAddControleDireito);
		frame.getContentPane().add(PainelEsquerdo.scrollpanelAddControleEsquerdo);
		
		esquerda.setVisible(true);
		direita.setVisible(true);	
	
		frame.add(fundoJsp);

		return frame;

	}

	public void ecmIni() throws IOException {

		JFrame frame = criarFrame();
		frame.setSize(1665, 1000);
		frame.setVisible(true);
	}
}
