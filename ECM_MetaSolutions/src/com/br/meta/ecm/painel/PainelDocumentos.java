package com.br.meta.ecm.painel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.br.meta.ecm.view.FramePrincipal;

public class PainelDocumentos {
	
	JPanel documento = new JPanel();	

	public JScrollPane documentos(FramePrincipal dndListener) {

		documento.setLayout(new GridLayout(0, 1));

		documento.setAutoscrolls(true);

		documento.setName("documentosPainel");

		documento.setToolTipText("documentos");

		documento.setBackground(new java.awt.Color(255, 255, 255));

		DropTarget dropTarget1 = new DropTarget(documento, DnDConstants.ACTION_MOVE,dndListener);

		JScrollPane scrollPaneDocumentos = new JScrollPane(documento);

		scrollPaneDocumentos.setViewportView(documento);

		scrollPaneDocumentos.setAutoscrolls(true);

		LineBorder border = new LineBorder(Color.GRAY);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, " Documentos RG-CPF ",2,TitledBorder.CENTER);

		scrollPaneDocumentos.setBorder(titledBorder);

		scrollPaneDocumentos.setBounds(1350, 330, 150, 190);

		scrollPaneDocumentos.setAlignmentX(10);

		scrollPaneDocumentos.setAlignmentY(10);

		return scrollPaneDocumentos;
	}

}
