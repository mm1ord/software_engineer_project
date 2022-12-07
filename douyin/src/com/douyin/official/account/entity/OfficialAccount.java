package com.douyin.official.account.entity;

import java.util.concurrent.atomic.AtomicInteger;

import com.douyin.database.DataBaseAware;
import com.douyin.official.account.context.OfficialAccountContext;

public class OfficialAccount implements DataBaseAware<Integer, OfficialAccount> {

	private String accountName;
	private Integer accountId;
	private OfficialAccountContext context;

	private static AtomicInteger autoIncrement = new AtomicInteger(0);

	public OfficialAccount(String accountName) {
		this.accountId = autoIncrement.getAndIncrement();
		this.context = new OfficialAccountContext(this);
	}

	// === Getter ===

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public OfficialAccountContext getContext() {
		return context;
	}

	// === Setter ===

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public Integer getKey() {
		return this.accountId;
	}

}
