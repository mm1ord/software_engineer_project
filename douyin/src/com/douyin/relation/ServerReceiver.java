package com.wechat.relation;
import com.wechat.friend.*;

public class ServerReceiver {
	private String serverName;
	
	public ServerReceiver(String serverName) {
		this.serverName = serverName;
	}
	
	public void operating(String operationName) {
		System.out.println("服务器执行"+operationName+"操作");
		if(operationName.equalsIgnoreCase("AddFriend")) {
			RelationshipFactory relationship_factory = new RelationshipFactory();
			Relationship relation = null;
			relation = relationship_factory.getRelationship("friend");
			relation.add();
		}
		else if(operationName.equalsIgnoreCase("AddGroup")||operationName.equalsIgnoreCase("CreateGroup")) {
			RelationshipFactory relationship_factory = new RelationshipFactory();
			Relationship relation = null;
			relation = relationship_factory.getRelationship("group");
			relation.add();
		}
	}
	
	public void notoperating(String operationName) {
		System.out.println("服务器取消"+operationName+"操作");
	}
}
