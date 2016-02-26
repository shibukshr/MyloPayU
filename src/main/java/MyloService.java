

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Payumouney
 */
//@WebServlet("/MyloService")
@WebServlet(urlPatterns = {"/myloServlet"})
public class MyloService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private static final String stripeApiKey =
	// "sk_test_nJuUbk18ljWm8IseXIS0mXzK";
	// private static final String stripeKeyVersion = "2015-01-26";

	//Pay U Response Code
	public enum PayUResponse {
		NOT_STARTED("Not Started", "The transaction has not been started yet."),
		INITIATED("Initiated","The transaction has been started but not completed."),
		MONEY_WITH_PAYUMONEY("Money With PayUMoney","The transaction was successful and the transaction amount is with PayUMoney."),
		UNDER_DISPUTE("Under Dispute","A dispute for the transaction has been raised."),
		REFUNDED("Refunded","The entire amount of the transaction has been refunded."),
		PARTIALLY_REFUNDED("Partially Refunded","A part of the amount of the transaction has been refunded."),
		BOUNCED("Bounced","Incomplete or no details provided at PayUMoney payment page."),			
		FAILED("Failed","The transaction didn’t complete due to a failure."),
		SETTLEMENT_IN_PROCESS("Settlement in Process","Settlement for the transaction is in process."),
//		COMPLETED("Completed","The transaction is settled and complete.");
		COMPLETED("success","The transaction is settled and complete.");  //for Test
			

			private String responseCode;
			private String responseMsg;

			PayUResponse(final String responseCode, final String responseMsg) {
				this.responseCode = responseCode;
				this.responseMsg = responseMsg;
			}

			public String getResponseCode() {
				return responseCode;
			}

			public String getResponseMsg() {
				return responseMsg;
			}

		}

	 
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyloService() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("\from PayU doPost "+req.getParameterMap());
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		StringBuffer br = new StringBuffer();
		br.append(" <br>Mylo PayU Response..!<br> status "+req.getParameter("status"));
		System.out.println("\n doPost "+req.getParameterNames());
		System.out.println("\n status "+req.getParameter("status"));
	
		System.out.println("\n mode "+req.getParameter("mode"));
		br.append("<br/> mode "+req.getParameter("mode"));
		System.out.println("txnid "+req.getParameter("txnid"));
		br.append("<br/> txnid "+req.getParameter("txnid"));
		System.out.println("\n key "+req.getParameter("key"));
		br.append("<br/> key "+req.getParameter("key"));
		System.out.println("\n amount "+req.getParameter("amount"));
		br.append("<br/> amount "+req.getParameter("amount"));
		System.out.println("\n bankcode "+req.getParameter("bankcode"));
		br.append("<br/> bankcode "+req.getParameter("bankcode"));
		System.out.println("\n bank_ref_num "+req.getParameter("bank_ref_num"));
		br.append("<br/> bank_ref_num "+req.getParameter("bank_ref_num"));
		
		System.out.println("\n unmappedstatus "+req.getParameter("unmappedstatus"));
		br.append("<br/> unmappedstatus "+req.getParameter("unmappedstatus"));
 
		if(PayUResponse.COMPLETED.getResponseCode().equals(req.getParameter("status")) )
           pw.println("Transaction Success...!"); 
        else
        	pw.println("Transaction Failed...!"); 	
		 pw.println("-----------Mylo  Response..............!"+br);
		 pw.close();
		 
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("\nin doGet "+req.getParameterMap());
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
	
			 pw.println("GET rESponse..!");
			 pw.close();
			 
		}

}
