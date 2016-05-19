package messages;


import java.io.Serializable;

import entities.Driver;

public class DriverMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Operation MessageOperation;
	private enum Operation{None,Register, Message_To_Server, Message_To_Client,
		Deny_Request, End_Night, Report_Error};
		
		private Driver owner;
		private String message;

	/**
	 * Constructor of the {@link StudentMessage} class
	 *
	 * @author Felipe Izepe
	 * @version 2.0
	 * @since 2016-04-30
	 * @param  owner of the message
	 * @param  message that will be sent and read
	 */
	public DriverMessage(Driver owner, String message) {
		this.owner = owner;
		this.message = message;
		this.MessageOperation = Operation.None;
	}
	
	/**
	 * Gets the owner of the message, null if sent by the server
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-25
	 */
	public Driver getOwner() {
		return owner;
	}
	
	/**
	 * Sets the type of operation that the message will perform
	 *
	 *@param type - <b>0</b> send a message to the coordinator | <b>1</b> Register for the night  |<b>2</b> send a message to client |
 	 * <b>3</b> deny a ride request | <b>4</b> end the night | <b>5</b> report that an error occurred
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public void setType(int type)
	{
		switch(type){
		case 0:
			this.MessageOperation = Operation.Message_To_Server;
			break;
		case 1:
				this.MessageOperation = Operation.Register;
				break;
		case 2:
			this.MessageOperation = Operation.Message_To_Client;
			break;
		case 3:
			this.MessageOperation = Operation.Deny_Request;
			break;
		case 4:
				this.MessageOperation = Operation.End_Night;
				break;
		case 5:
				this.MessageOperation = Operation.Report_Error;
				break;
		default:
			return;
		}
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMessageToServer()
	{
		if(MessageOperation == Operation.Message_To_Server)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the Driver
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMessageToDriver()
	{
		if(MessageOperation == Operation.Message_To_Client)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator as a request for a ride
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isMakeRequest()
	{
		if(MessageOperation == Operation.Deny_Request)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator to cancel a request
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isCancelRequest()
	{
		if(MessageOperation == Operation.End_Night)
			return true;
		return false;
	}
	
	/**
	 * Checks if the message is to be sent to the coordinator to report an error
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public boolean isError()
	{
		if(MessageOperation == Operation.Report_Error)
			return true;
		return false;
	}

	/**
	 * Checks if the message is to be sent to the coordinator to report a registration as driver for the night
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-05-09
	 */
	public boolean isRegister()
	{
		if(MessageOperation == Operation.Register)
			return true;
		return false;
	}
	
	/**
	 * Returns The message given to the class
	 *
	 * @author Felipe Izepe
	 * @version 1.0
	 * @since 2016-04-30
	 */
	public String getMessage() {
		return message;
	}


	
}
