/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object;

import com.ustb.shellchain.command.ShellChainException;
import com.ustb.shellchain.command.tools.ShellChainTestParameter;

/**
 * @author Ub - H. MARTEAU
 * @version 4.4
 */
public class BalanceAssetBase {
	String name;
	double qty;
	String comment;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BalanceAssetBase [name=" + name + ", qty=" + qty + ", comment=" + comment + "]";
	}

	public void isFilled() throws ShellChainException {
		ShellChainTestParameter.isNotNullOrEmpty("name", getName());
		ShellChainTestParameter.valueIsPositive("qty", getQty());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the qty
	 */
	public double getQty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setQty(double qty) {
		this.qty = qty;
	}

	/**
	 * @return the qty
	 */
	public double getIssueqty() {
		return qty;
	}

	/**
	 * @param qty
	 *            the qty to set
	 */
	public void setIssueqty(double qty) {
		this.qty = qty;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
