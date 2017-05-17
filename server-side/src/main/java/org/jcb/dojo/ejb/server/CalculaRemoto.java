package org.jcb.dojo.ejb.server;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CalculaRemoto {

	public String calcula(List<String> operacoes);

}
