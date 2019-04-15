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

public class PainelPropostas {

	JPanel proposta = new JPanel();
	
	public JScrollPane proposta(FramePrincipal dndListener){

		proposta.setLayout(new GridLayout(0, 1));

		proposta.setToolTipText("Propostas");

		proposta.setName("propostasPainel");

		proposta.setBackground(new java.awt.Color(255, 255, 255));

		DropTarget dropTarget1 = new DropTarget(proposta, DnDConstants.ACTION_MOVE,dndListener);	

		JScrollPane scrollPaneProposta = new JScrollPane();

		scrollPaneProposta.setViewportView(proposta);

		scrollPaneProposta.setAutoscrolls(true);

		LineBorder border = new LineBorder(Color.GRAY);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Proposta",2,TitledBorder.CENTER);

		scrollPaneProposta.setBorder(titledBorder);

		scrollPaneProposta.setBounds(1350, 122, 150, 190);

		scrollPaneProposta.setAlignmentX(10);

		scrollPaneProposta.setAlignmentY(10);

		return scrollPaneProposta;
	}

}
