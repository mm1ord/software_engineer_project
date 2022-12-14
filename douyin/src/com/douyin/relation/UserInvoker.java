package com.wechat.relation;
import java.util.ArrayList;

public class UserInvoker {
	private ArrayList<OperationCommand> operations = new ArrayList<OperationCommand>();
	private ArrayList<OperationCommand> cancelOperations = new ArrayList<OperationCommand>();
	
	public void addOperation(OperationCommand operation) {
		operations.add(operation);
		System.out.println("用户新增操作:"+operation.operationName);
	}
	
	public void delOperation(OperationCommand operation) {
		if(operations.remove(operation)) {
			cancelOperations.add(operation);
			System.out.println("用户取消操作:"+operation.operationName);
		}else {
			System.out.println("用户未请求过此操作!");
		}
	}
	
	public void notifyServer() {
		for (OperationCommand operation : operations) {
			operation.executeCommand(operation.serverReceiver,operation.operationName);
		}
	}
	
	public void notifyNotServer() {
		for (OperationCommand operation : cancelOperations) {
			operation.cancelCommand(operation.serverReceiver,operation.operationName);
		}
	}
}
