package com.wechat.relation;

public class Operation6 extends OperationCommand {
	
	public Operation6(ServerReceiver serverReceiver,String operationName) {
		super(serverReceiver,operationName);
	}
	
	public void executeCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.operating(operationName);
	};
	public void cancelCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.notoperating(operationName);
	};
}