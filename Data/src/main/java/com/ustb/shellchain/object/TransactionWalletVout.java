/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionWalletVout extends TransactionWalletVInfo {
	long n;
	List<Permission> permissions;



	/**
	 *
	 */
	public TransactionWalletVout() {
		super();
		permissions = new ArrayList<Permission>();
	}
	/**
	 * @param info
	 */
	public TransactionWalletVout(TransactionWalletVInfo info) {
		super(info);
		permissions = new ArrayList<Permission>();
	}
	/**
	 * @return the n
	 */
	public long getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(long n) {
		this.n = n;
	}
	/**
	 * @return the permissions
	 */
	public List<Permission> getPermissions() {
		return permissions;
	}
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}


}
