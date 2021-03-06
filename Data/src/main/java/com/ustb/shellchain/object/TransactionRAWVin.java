/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class TransactionRAWVin {
	String txid;
	long vout;
	ScriptSig scriptSig;
	String coinbase;
	long sequence;

	/**
	 *
	 */
	public TransactionRAWVin() {
		super();
		scriptSig = new ScriptSig();
	}

	/**
	 * @return the txid
	 */
	public String getTxid() {
		return txid;
	}

	/**
	 * @param txid the txid to set
	 */
	public void setTxid(String txid) {
		this.txid = txid;
	}

	/**
	 * @return the vout
	 */
	public long getVout() {
		return vout;
	}

	/**
	 * @param vout the vout to set
	 */
	public void setVout(long vout) {
		this.vout = vout;
	}

	/**
	 * @return the scriptSig
	 */
	public ScriptSig getScriptSig() {
		return scriptSig;
	}

	/**
	 * @param scriptSig the scriptSig to set
	 */
	public void setScriptSig(ScriptSig scriptSig) {
		this.scriptSig = scriptSig;
	}

	/**
	 * @return the sequence
	 */
	public long getSequence() {
		return sequence;
	}

	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the coinbase
	 */
	public String getCoinbase() {
		return coinbase;
	}

	/**
	 * @param coinbase the coinbase to set
	 */
	public void setCoinbase(String coinbase) {
		this.coinbase = coinbase;
	}




}
