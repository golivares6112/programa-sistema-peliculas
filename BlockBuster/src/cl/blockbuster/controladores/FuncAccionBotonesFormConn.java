package cl.blockbuster.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cl.blockbuster.database.JPAFactoryConnection;

public class FuncAccionBotonesFormConn implements ActionListener{

	private JTextField usuario;
	private JPasswordField password;
	
	public FuncAccionBotonesFormConn(JTextField user, JPasswordField pass)
	{
		this.usuario = user;
		this.password = pass;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String action = event.getActionCommand();
		
		if(action.equalsIgnoreCase("Aceptar"))
		{
			String idVendedor = this.usuario.getText();
			char[] password = this.password.getPassword();
			String passVend = new String(password);
			if(JPAFactoryConnection.validarEntrada(Integer.parseInt(passVend), idVendedor) == true)
			{
				JOptionPane.showMessageDialog(null,
	     			       "Usuario Encontrado", //Mensaje
	     			       "Usuario Existe", //T’tulo
	     			       JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,
	     			       "No se encontro el username", //Mensaje
	     			       "Mensaje de Error", //T’tulo
	     			       JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(action.equalsIgnoreCase("Salir"))
		{
			System.exit(0);
		}
		
	}

}
