package com.trendbrew.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.koinplus.common.GenericKoinPlusService;
import com.trendbrew.dam.RetailerUserDataAccessManager;
import com.trendbrew.dao.RetailerUserDAO;
import com.trendbrew.dto.Retailer;
import com.trendbrew.entity.Message;
import com.trendbrew.entity.RetailerEntity;
import com.trendbrew.exception.TbCloverException;

/**
 * @author Abhijit Patil
 */

@Stateless
public class RetailerService extends GenericKoinPlusService {
	
	private final static Logger logger = Logger.getLogger(RetailerService.class);
	
	private static final String CLIENT_ID = "VG7FFFPSB8GDA";
	private static final String CLIENT_SECRET = "0173602a-ab73-20fc-da30-dabdde792de7";
	
	@EJB private RetailerUserDataAccessManager retailerDAM;
	
	final Gson GSON = new Gson();
	final JsonParser JSON_PARSER = new JsonParser();
	final CloseableHttpClient client = HttpClientBuilder.create().build();
	
	@GET
	@Path("/registerMerchant")
	@Produces(MediaType.APPLICATION_JSON)
	public Message registerMerchant(@QueryParam("retailer_id") String retailerId, @QueryParam("employee_id") String employeeId,
			@QueryParam("code") String code){
		
		logger.info("merchantId: "+retailerId);
		logger.info("employee_id: "+employeeId);
		logger.info("code: "+code);
		RetailerUserDAO retailerUserDAO = new RetailerUserDAO();
		Message message = null;
		if(retailerUserDAO!=null){
			try {
				if(!retailerUserDAO.isRetrailerExist(retailerId)){
					String accessToken = getMerchantAccessToken(code);
					logger.info(accessToken);
					
					RetailerEntity retailerEntity = new RetailerEntity();
					retailerEntity.setSgid(Long.parseLong(retailerId));
					retailerEntity.setAlternateCode(code);
					
					//Create new Retailer entry in Retailer table
					retailerUserDAO.createRetailer(retailerEntity);
					
					message = sendResponse("Retailer created Successfully!!", "success");
				} else {
					message = sendResponse("Retailer already Registerd", "success");
				}
			} catch (TbCloverException e) {
				logger.error("got exception: ", e);
				e.printStackTrace();
				message = sendResponse("Merchant registration fail "+e.getCustomMessage(), "Fail");
			}
		} 
		
		return message;
	}
	
	private String getMerchantAccessToken(String code) throws TbCloverException {
		String BASE_URL = "https://apisandbox.dev.clover.com/oauth/token?";
		List<NameValuePair> params = new LinkedList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id", String.valueOf(CLIENT_ID)));
		params.add(new BasicNameValuePair("client_secret", String.valueOf(CLIENT_SECRET)));
		if(code!=null){
			params.add(new BasicNameValuePair("code", String.valueOf(code)));
		} else {
			throw new TbCloverException("code can not be empty", "can not be process request becuase code param not received");
		}
		String paramString = URLEncodedUtils.format(params, "utf-8");
		BASE_URL += paramString;
		String token = null;
		HttpGet request = new HttpGet(BASE_URL);
		JsonObject accessResponse = null;
		try {
			accessResponse = executeRequest(request);
			token = accessResponse.get("access_token").getAsString();
		} catch (Exception e) {
			logger.error("got exception :", e);
			e.printStackTrace();
			throw new TbCloverException(e.getMessage(), "unable to send request to clover");
		}
		return token;
	}
	
	private Message sendResponse(String contentMsg, String status){
		Message message = new Message();
		message.setMessage(contentMsg);
		message.setStatus(status);
		return message;
	}
//	
	private JsonObject executeRequest(HttpRequestBase request) throws Exception {
		request.addHeader("Content-Type", "application/json");

		System.out.println(request.toString());
		CloseableHttpResponse response = client.execute(request);

		final int statusCode = response.getStatusLine().getStatusCode();
		
		if (statusCode != 200) {
			throw new Exception("EXITING EARLY - INVALID RESPONSE CODE");
		}
		
		System.out.println("Response Code : " + statusCode);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		String line;
		StringBuilder result = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		final String json = result.toString();
		System.out.println(json);
		System.out.println("\n");

		response.close();
		return JSON_PARSER.parse(json).getAsJsonObject();
	}
//	
	public void retailerSignUp(Retailer signUp){
		Retailer retailerSignup = new Retailer();
		
		retailerSignup.setName("Subhash");
		retailerSignup.setCountry("US");
		retailerSignup.setDisplayName("subhash");
		retailerSignup.setAbbreviation("AS");
		retailerSignup.setImageUrl("https://www.example.com");
		retailerSignup.setSocialRank(1500);
		retailerSignup.setHasBrewtique(false);
		retailerSignup.setAlternateCode("12345-568597-abcd");
	
		retailerDAM.retailerSignUp(retailerSignup);
	}
}
