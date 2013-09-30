package cl.blockbuster.sistema;

import javax.swing.SwingUtilities;

import cl.blockbuster.paneles.FormConexionSistema;

public class MainSistema {

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new FormConexionSistema().setVisible(true);
			}
		});
	}
}
