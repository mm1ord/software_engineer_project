package com.wechat.relation;

public abstract class OperationCommand {
	protected ServerReceiver serverReceiver;
	protected String operationName;
	
	public OperationCommand(ServerReceiver serverReceiver,String operationName) {
		this.serverReceiver = serverReceiver;
		this.operationName = operationName;
	}
	
	abstract public void executeCommand(ServerReceiver serverReceiver,String operationName);
	abstract public void cancelCommand(ServerReceiver serverReceiver,String operationName);
}
