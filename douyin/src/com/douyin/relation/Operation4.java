package com.wechat.relation;

public class Operation4 extends OperationCommand {
	
	public Operation4(ServerReceiver serverReceiver,String operationName) {
		super(serverReceiver,operationName);
	}
	
	public void executeCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.operating(operationName);
	};
	public void cancelCommand(ServerReceiver serverReceiver,String operationName) {
		serverReceiver.notoperating(operationName);
	};
}
