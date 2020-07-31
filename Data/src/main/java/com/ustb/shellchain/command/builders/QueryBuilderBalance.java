/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command.builders;

import com.ustb.shellchain.command.ShellChainException;

/**
 * @author Ub - H. MARTEAU
 * @version 3.0
 */
public class QueryBuilderBalance extends QueryBuilderCommon {

	/**
	 * 
	 * gettotalbalances ( minconf includeWatchonly includeLocked)
	 * 
	 * If account is not specified, returns the server's total available asset balances.
	 * If account is specified, returns the balances in the account.
	 * Note that the account "" is not the same as leaving the parameter out.
	 * The server total may be different to the balance in the default "" account.
	 * 
	 * Arguments:
	 * 1. minconf (numeric, optional, default=1) Only include transactions confirmed at least this many times.
	 * 2. includeWatchonly (bool, optional, default=false) Also include balance in watchonly addresses (see
	 * 'importaddress')
	 * 3. includeLocked (bool, optional, default=false) Also take locked outputs into account
	 * Results are an array of Objects with totals and details for each asset.
	 * 
	 * @return a list of all the asset balances in this node’s wallet
	 * @throws ShellChainException
	 */
	protected Object executeGetTotalBalances() throws ShellChainException {
		return execute(CommandEnum.GETTOTALBALANCES);
	}

	/**
	 * 
	 * getunconfirmedbalance
	 * Returns the server's total unconfirmed balance
	 * 
	 * @return a list of all the asset balances in this node’s wallet
	 * @throws ShellChainException
	 */
	protected Object executeGetUnconfirmedBalance() throws ShellChainException {
		return execute(CommandEnum.GETTOTALBALANCES);
	}

}
