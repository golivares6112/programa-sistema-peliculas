package cl.blockbuster.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jdesktop.layout.GroupLayout;
import cl.blockbuster.objetos.DefObjetos;

public class FormConexionSistema extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JLabel titulo, lbusuario, lbpassword;
	private JButton salir, aceptar;
	private JTextField usuario;
	private JPasswordField password;
	private JPanel paneTitulo, paneDatos, paneControles;
	
	public FormConexionSistema()
	{
		super(".:: Formulario de Conexi—n ::.");
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefObjetos.estableceLookAndFeel();
		this.setLayout(new BorderLayout());
		paneTitulo = this.panelTitulo();
		paneDatos = this.panelDatosConexion();
		paneControles = this.panelControles();
		this.add(paneTitulo, BorderLayout.NORTH);
		this.add(paneDatos, BorderLayout.CENTER);
		this.add(paneControles, BorderLayout.SOUTH);
		this.centrarVentana();
		this.pack();
	}
	
	
	private JPanel panelTitulo()
	{
		JPanel panelTitulo = new JPanel();
		FlowLayout layoutPanelTitulo = new FlowLayout();
		TitledBorder bordePanelTitulo = 
				DefObjetos.constructorBorderPanel("", "Serif", 1, 11);
		panelTitulo.setBorder(bordePanelTitulo);
		layoutPanelTitulo.setAlignment(FlowLayout.CENTER);
		titulo = DefObjetos.constructorLabel("Conexi—n Al Sistema", "Serif", 1, 13);
		panelTitulo.add(titulo);
		return panelTitulo;
	}
	
	private JPanel panelDatosConexion()
	{
		JPanel panelDatos = new JPanel();
		TitledBorder bordePanelConexion = 
				DefObjetos.constructorBorderPanel("", "Serif", 1, 11);
		panelDatos.setBorder(bordePanelConexion);
		
		GroupLayout jPanegroupLayout = new GroupLayout(panelDatos);
		panelDatos.setLayout(jPanegroupLayout);
		lbusuario = DefObjetos.constructorLabel("UserName : ", "Serif", 1, 11);
		usuario = DefObjetos.constructorJTextField(" ", "Serif", 1, 11);
		lbpassword = DefObjetos.constructorLabel("Password : ", "Serif", 1, 11);
		password = DefObjetos.constructorPasswordField("Serif", 1, 11);
			
		jPanegroupLayout.setHorizontalGroup(
				jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanegroupLayout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(lbpassword)
                    .add(lbusuario))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(password)
                    .add(usuario))
                .addContainerGap(23, Short.MAX_VALUE))
        );
		jPanegroupLayout.setVerticalGroup(
				jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanegroupLayout.createSequentialGroup()
                .add(34, 34, 34)
                .add(jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbusuario)
                    .add(usuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanegroupLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lbpassword)
                    .add(password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        
		return panelDatos;
	}
	
	private JPanel panelControles()
	{
		JPanel panelControles = new JPanel();
		FlowLayout layoutPanelControles = new FlowLayout();
		TitledBorder bordePanelControles = 
				DefObjetos.constructorBorderPanel("", "Serif", 1, 11);
		panelControles.setBorder(bordePanelControles);		
		layoutPanelControles.setAlignment(FlowLayout.CENTER);
		panelControles.setLayout(layoutPanelControles);
		salir = DefObjetos.constructorButton("Aceptar", "Serif", 1, 11);
		aceptar = DefObjetos.constructorButton("Salir", "Serif", 1, 11);
		panelControles.add(salir);
		panelControles.add(aceptar);
		return panelControles;
	}
	
	private void centrarVentana()
	{
		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
	}
}
