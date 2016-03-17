package katse.valuuta.exception;

/**
 * 
 * @author kasutaja5y
 *
 */
public class ValuutaXMLHandlerException extends Exception{
	
	private static final long serialVersionUID = 5649201005032059090L;
	private String msg;
	private String handler;
	
	public ValuutaXMLHandlerException(String msg, String handler){
		this.msg = msg;
		this.handler = handler;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public String getHandler(){
		return this.handler;
	}


}
