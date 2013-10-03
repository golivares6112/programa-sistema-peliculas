package cl.blockbuster.threads;

import javax.swing.SwingWorker;

import cl.blockbuster.database.JPAFactoryConnection;

public class ConsultaThread extends SwingWorker<Void,Void>{

	@Override
	protected Void doInBackground() throws Exception {
		JPAFactoryConnection.createFactoryConnection();
		return null;
	}

}
