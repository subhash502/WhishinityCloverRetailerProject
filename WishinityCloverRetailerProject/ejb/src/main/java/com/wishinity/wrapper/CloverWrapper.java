package com.wishinity.wrapper;

import com.koinplus.common.GenericKoinPlusService;
import com.koinplus.common.webservice.GenericRestClient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;

/**
 * @author Abhijit Patil
 */

@Stateless
public class CloverWrapper extends GenericKoinPlusService {

	@EJB private GenericRestClient genericRestClient;

	public void placeholderMethod() {
		StringBuilder url = new StringBuilder();

		String response = null;

		try {
			response = this.genericRestClient.doGet(url.toString());
		} catch (IOException e) {
			//getLogger().error("Error processing response");
		}
	}
}
