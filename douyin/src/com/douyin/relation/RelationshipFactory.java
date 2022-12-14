package com.wechat.relation;
import com.wechat.friend.*;

public class RelationshipFactory {
	public Relationship getRelationship(String relationship) {
		if(relationship.equalsIgnoreCase("Friend")) {
			return new Friend();
		}else if(relationship.equalsIgnoreCase("Group")) {
			return new Group();
		}
		return null;
	}
}
