/**
 * 
 */
package com.br.meta.ecm.view;

import java.awt.Color;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

/**
 * @author eduardo
 *
 */
public class FrameLogin {

	public static JFrame criarJPanelLogin() throws IOException {

		// views

		JFrame frameLogin = new JFrame();
		JPanel fundoJPanel = new JPanel();
		JPanel jPanelLogins = new JPanel();

		// Button action

		JButton loginBtn = new JButton("Entrar");
		
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				FramePrincipal ecmView = new FramePrincipal();

				try {
					
					ecmView.ecmIni();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// logo

		ImageIcon img = new ImageIcon("C:\\logo\\logo.gif");
		JLabel logoMeta = new JLabel(img);

		// borda

		LineBorder border = new LineBorder(Color.BLACK);

		// labels

		Label titulo = new Label("informe o E-mail e a Senha");
		Label usuario = new Label("Usuario");
		Label senha = new Label("Senha");

		TextField tituloTxt = new TextField("", 20);
		TextField usuarioTxt = new TextField("", 20);
		JPasswordField senhaPass = new JPasswordField(15);

		fundoJPanel.add(logoMeta);

		fundoJPanel.add(titulo);
		fundoJPanel.setBackground(new java.awt.Color(255, 255, 255));

		jPanelLogins.setBackground(new java.awt.Color(100, 149, 237));
		jPanelLogins.setBorder(border);
		jPanelLogins.setBounds(80, 100, 200, 150);

		jPanelLogins.add(usuario);
		jPanelLogins.add(usuarioTxt);

		jPanelLogins.add(senha);
		jPanelLogins.add(senhaPass);

		jPanelLogins.add(loginBtn);

		frameLogin.add(jPanelLogins);
		frameLogin.add(fundoJPanel);

		return frameLogin;

	}

	public static void main(String[] args) throws IOException {

		JFrame frame = criarJPanelLogin();
		frame.setTitle("Sistema ECM - Meta Solutions");
		frame.setLocationRelativeTo(null);
		frame.setSize(390, 320);
		frame.setVisible(true);

	}

}
