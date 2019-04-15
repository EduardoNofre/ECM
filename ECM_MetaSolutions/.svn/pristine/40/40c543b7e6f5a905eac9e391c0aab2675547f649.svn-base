package com.br.meta.ecm.painel;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.w3c.dom.Text;

import com.br.meta.model.PropostaInformacao;

public class CheckListPainelDadosProposta {

	final JPanel dadosDaProposta = new JPanel();
	

	public JScrollPane checkListdadosDaProposta(PropostaInformacao propostaInformacao) {

				
		// Label
		Label numeroProposta = new Label("Numero proposta: ");		
		Label cpf = new Label("CPF/CNPJ: ");		
		Label Beneficiario = new Label("Beneficiario: ");		
		Label dataIinicioVigencia = new Label("Inicio Vigencia: ");		
		Label dataFimVigencia = new Label("Fim Vigencia: ");
		Label reap = new Label("Reapresentação: ");
		Label sim = new Label("Sim");
		Label nao = new Label("Não");
		
		Label vazio = new Label("");		
		
		// TextField
		TextField numeroPropostaText = new TextField();		
		TextField CPFCNPJ = new TextField();		
		TextField BeneficiarioText = new TextField();		
		TextField dataIinicioVigenciaText = new TextField();		
		TextField dataFimVigenciaText = new TextField();
		
		// Radio
		Checkbox chkSim = new Checkbox();
		Checkbox chknao= new Checkbox();

		dadosDaProposta.setLayout(new GridLayout(9, 10));
		dadosDaProposta.setAutoscrolls(true);
		dadosDaProposta.setName("dadosDaProposta");
		dadosDaProposta.setToolTipText(" Informação da Proposta ");
		
		dadosDaProposta.add(Beneficiario);
		dadosDaProposta.add(BeneficiarioText);
		BeneficiarioText.setText(propostaInformacao.getBeneficiario());
		BeneficiarioText.setEditable(false);
		
		dadosDaProposta.add(numeroProposta);
		dadosDaProposta.add(numeroPropostaText);
		numeroPropostaText.setText(propostaInformacao.getNumeroProposta());
		numeroPropostaText.setEditable(false);
		
		dadosDaProposta.add(cpf);
		dadosDaProposta.add(CPFCNPJ);
		CPFCNPJ.setText(propostaInformacao.getCpfCnpf());
		CPFCNPJ.setEditable(false);
		
		dadosDaProposta.add(dataIinicioVigencia);
		dadosDaProposta.add(dataIinicioVigenciaText);
		dataIinicioVigenciaText.setText(propostaInformacao.getInicioVigencia());
		dataIinicioVigenciaText.setEditable(false);
		
		dadosDaProposta.add(dataFimVigencia);
		dadosDaProposta.add(dataFimVigenciaText);
		dataFimVigenciaText.setText(propostaInformacao.getFimVigencia());
		dataFimVigenciaText.setEditable(false);
		
		dadosDaProposta.add(reap);
		dadosDaProposta.add(vazio);
		dadosDaProposta.add(chkSim);
		dadosDaProposta.add(sim);
		dadosDaProposta.add(chknao);
		dadosDaProposta.add(nao);		

		LineBorder border = new LineBorder(Color.GRAY);

		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, " Informação da Proposta ",2,TitledBorder.CENTER);	

		JScrollPane scrollDadosDaProposta = new JScrollPane(dadosDaProposta);

		scrollDadosDaProposta.setBorder(titledBorder);

		scrollDadosDaProposta.setViewportView(dadosDaProposta);

		scrollDadosDaProposta.setAutoscrolls(true);

		scrollDadosDaProposta.setName("dadosDaProposta");

		scrollDadosDaProposta.setBounds(9, 245, 310, 340);

		scrollDadosDaProposta.setAlignmentX(10);

		scrollDadosDaProposta.setAlignmentY(10);

		return scrollDadosDaProposta;
	}

}
