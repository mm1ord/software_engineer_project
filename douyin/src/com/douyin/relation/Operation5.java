package com.wechat.relation;

public class Operation5 extends OperationCommand {
	
	public Operation5(ServerReceiver serverReceiver,String operationName) {
		super(serverReceiver,operationName);
	}
	
	public void executeCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.operating(operationName);
	};
	public void cancelCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.notoperating(operationName);
	};
}