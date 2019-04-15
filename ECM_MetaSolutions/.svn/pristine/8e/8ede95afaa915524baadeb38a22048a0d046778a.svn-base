package com.br.meta.ecm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
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

import com.br.meta.ecm.painel.CheckListPainel;
import com.br.meta.ecm.painel.CheckListPainelDadosProposta;
import com.br.meta.ecm.painel.CheckListPainelDireito;
import com.br.meta.ecm.painel.CheckListPainelEsquerdo;
import com.br.meta.model.PropostaInformacao;

public class CheckListFrame implements DragGestureListener, DragSourceListener,DropTargetListener, Transferable {
	

	Object object;
	
	JPanel origem = new JPanel();
	
	public static String imagem = "C:\\DesenhoRetangulo\\page0.png";
	
	CheckListPainelEsquerdo esquerdo = new CheckListPainelEsquerdo();
	
	CheckListPainelDireito direita = new CheckListPainelDireito();
	
	public static CheckListFrame checkListFrame;
	
	static final DataFlavor[] supportedFlavors = { null };
	
	static {

		try {

			supportedFlavors[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	@Override
	public Object getTransferData(DataFlavor flavor)throws UnsupportedFlavorException, IOException {

		if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {

			return object;

		} else {

			return null;
		}
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType);
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DropTargetDragEvent ev) {
		object = ev.getSource();
		
	}

	@Override
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

//				this.updateImageCheckYes(destinoDragAndDrop.getName());
//
//				this.updateImageCheckNo(origemDragAndDrop.getName(),origemDragAndDrop.getComponentCount());

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

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		object = dsde.getSource();
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		dge.startDrag(null, this, this);
		
	}
	
	
	private CheckListPainelEsquerdo compareImagensPainelEsquerdo() throws IOException {

		return esquerdo.esquerdoPrincipalChk(checkListFrame);
	}
	
	
	private CheckListPainelDireito compareImagensPainelDireita() throws IOException {

		return direita.direitaPrincipalChk(checkListFrame);
	}
	
	
	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel que traz as informaçoes da proposta.
	 *  
	 */
	private JScrollPane checkListdadosDaPropostaPainel(PropostaInformacao propostaInformacao) {

		CheckListPainelDadosProposta checkListdadosDaProposta = new CheckListPainelDadosProposta();

		return checkListdadosDaProposta.checkListdadosDaProposta(propostaInformacao);
	}
	
	
	/**
	 * 
	 * @return JScrollPane
	 * 
	 * Painel checkList.
	 *  
	 */
	private static JScrollPane checkListPainel() {

		CheckListPainel checkList = new CheckListPainel();

		return checkList.checkListQuestions();

	}
		
	/**
	 * 
	 * @return JScrollPane
	 * 
	 *         Este metodo carrega os contrato nos paineis, buscando em um
	 *         diretorio especificio.
	 * 
	 */

	private JScrollPane contrato() {

		origem.setLayout(new GridLayout(1, 0));

		origem.setToolTipText(" Origem ");

		origem.setName("OrigemPainel");

		File imageDiretorio = new File("C:\\DesenhoRetangulo\\");

		File files[] = imageDiretorio.listFiles();

		DragSource dragSource = new DragSource();

		checkListFrame = new CheckListFrame();

		int contadorDePaginas = 1;

		for (File arq : files) {

			ImageIcon img = new ImageIcon(arq.getAbsolutePath());

			img.setImage(img.getImage().getScaledInstance(30, 50, 70));

			JLabel adcionaImagem = new JLabel(img);

			DragSource ds1 = new DragSource();

			DragGestureRecognizer dragRecognizer = dragSource.createDefaultDragGestureRecognizer(adcionaImagem,DnDConstants.ACTION_MOVE, checkListFrame);

			origem.add(adcionaImagem);

			adcionaImagem.setToolTipText(String.valueOf(contadorDePaginas));

			contadorDePaginas++;

		}

		DropTarget dropTargetOrigem = new DropTarget(origem,DnDConstants.ACTION_MOVE, checkListFrame);

		JScrollPane scrollPaneOrigem = new JScrollPane(origem);

		scrollPaneOrigem.setViewportView(origem);

		LineBorder border = new LineBorder(Color.GRAY);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"Contrato", 2, TitledBorder.CENTER);

		scrollPaneOrigem.setBackground(new java.awt.Color(255, 255, 255));

		scrollPaneOrigem.setBorder(titledBorder);

		scrollPaneOrigem.setToolTipText("Image");

		scrollPaneOrigem.setBounds(10, 60, 1630, 80);

		int height = (int) origem.getPreferredSize().getHeight();

		scrollPaneOrigem.getVerticalScrollBar().setValue(2500);

		return scrollPaneOrigem;
	}
	
	private static JPanel fundoPainelChk() {

		JPanel pss = new JPanel();

		pss.setBackground(new java.awt.Color(255, 255, 255));

		return pss;
	}
	
	
	public static JFrame principalFrameCheckList(PropostaInformacao propostaInformacao) throws IOException {

		JFrame frame = new JFrame();
		CheckListFrame checkListFrames = new CheckListFrame();
		JPanel addComponentesZoomRotateDireitaChk = new JPanel();
		JPanel addComponentesZoomRotateEsquerdoChk = new JPanel();

		// logo
//		JPanel LogoMetaJpanel = new JPanel();
//		ImageIcon img = new ImageIcon("C:\\Ambiente\\SideEffect\\ECM_MetaSolutions\\src\\com\\br\\meta\\ecm\\img\\logo.gif");
//		JLabel logoMeta = new JLabel(img);
//		LogoMetaJpanel.add(logoMeta);
//		LogoMetaJpanel.setBackground(new java.awt.Color(255, 255, 255));
//		LogoMetaJpanel.setBounds(5, 10, 300, 100);

		JScrollPane origemJsp = checkListFrames.contrato();
		JPanel fundoChk = checkListFrames.fundoPainelChk();
		
		CheckListPainelEsquerdo esquerdaChk = checkListFrames.compareImagensPainelEsquerdo();		
		CheckListPainelDireito direitaChk = checkListFrames.compareImagensPainelDireita();
		
		JScrollPane checkLists = checkListFrames.checkListPainel();
		JScrollPane checkListDadosDaPropostaJsp = checkListFrames.checkListdadosDaPropostaPainel(propostaInformacao);
		
		
		//addComponentesZoomRotateDireita.setBorder(border);
		addComponentesZoomRotateDireitaChk.setBounds(840, 150, 500, 68);		
		addComponentesZoomRotateDireitaChk.setBackground(new java.awt.Color(255, 255, 255));		
		addComponentesZoomRotateDireitaChk.add(direitaChk);
		
		
		//addComponentesZoomRotateEsquerdo.setBorder(border);
		addComponentesZoomRotateEsquerdoChk.setBounds(335, 150, 500, 68);		
		addComponentesZoomRotateEsquerdoChk.setBackground(new java.awt.Color(255, 255, 255));
		addComponentesZoomRotateEsquerdoChk.add(esquerdaChk);

		frame.add(addComponentesZoomRotateDireitaChk);		
		frame.add(addComponentesZoomRotateEsquerdoChk);
		
		frame.add(checkListDadosDaPropostaJsp);
		frame.add(checkLists);
		frame.add(origemJsp);
		//frame.add(LogoMetaJpanel);
		
		
		frame.getContentPane().add(CheckListPainelDireito.scrollpanelAddControleDireito);
		frame.getContentPane().add(CheckListPainelEsquerdo.scrollpanelAddControleEsquerdo);
		
		direitaChk.setVisible(true);
		esquerdaChk.setVisible(true);
		
		frame.add(fundoChk);
		

		return frame;
	}
	
	
	public void iniChk(PropostaInformacao propostaInformacao) throws IOException {

		JFrame frame = principalFrameCheckList(propostaInformacao);
		frame.setSize(1665, 1000);
		frame.setVisible(true);

	}
	
	
	
	
}
