/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * ShellChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/ShellChainJavaAPI/blob/master/LICENSE
 *
 */
package com.ustb.shellchain.command;

import com.google.gson.internal.LinkedTreeMap;
import com.ustb.shellchain.command.builders.QueryBuilderStream;
import com.ustb.shellchain.object.Address;
import com.ustb.shellchain.object.Stream;
import com.ustb.shellchain.object.StreamKey;
import com.ustb.shellchain.object.StreamKeyItem;
import com.ustb.shellchain.object.formatters.StreamFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class StreamCommand extends QueryBuilderStream {

	public StreamCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}

	/**
	 * create stream "stream-name" open ( custom-fields )
	 * 
	 * Creates stream
	 * 
	 * 
	 * Arguments: 1. entity-type (string, required) The only possible value: stream
	 * 2. "stream-name" (string, required) Stream name, if not "" should be unique.
	 * 3. open (boolean, required) Allow anyone to publish in this stream 4
	 * custom-fields (object, optional) a json object with custom fields {
	 * "param-name": "param-value" (strings, required) The key is the parameter
	 * name, the value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param open
	 * @return TxId
	 * @throws ShellChainException
	 */
	public String create(String streamName, boolean open) throws ShellChainException {
		String stringCreate = "";

		Object objectCreate = executeCreate(streamName, open);
		if (verifyInstance(objectCreate, String.class)) {
			stringCreate = (String) objectCreate;
		}

		return stringCreate;
	}

	/**
	 * create stream "stream-name" close
	 * 
	 * Creates stream
	 * 
	 * 
	 * Arguments: 1. entity-type (string, required) The only possible value: stream
	 * 2. "stream-name" (string, required) Stream name, if not "" should be unique.
	 * 3. open (boolean, required) Allow anyone to publish in this stream 4
	 * custom-fields (object, optional) a json object with custom fields {
	 * "param-name": "param-value" (strings, required) The key is the parameter
	 * name, the value is parameter value ,... }
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param open
	 *            = false
	 * @return TxId
	 * @throws ShellChainException
	 */
	public String create(String streamName) throws ShellChainException {
		return create(streamName, false);
	}

	/**
	 * {@link #create(String, boolean)} with control over the from-address used to
	 * used to create the stream
	 * 
	 * @param addressFrom
	 *            (Address) The from-address used to create the stream
	 * @param streamName
	 *            (String) The name of the stream to create
	 * @param open
	 *            (Boolean) True if the stream is open, else false
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	public String createFrom(Address addressFrom, String streamName, boolean open) throws ShellChainException {
		String stringCreate = "";
		Object objectCreate = executeCreateFrom(addressFrom.getAddress(), streamName, open);
		if (verifyInstance(objectCreate, String.class)) {
			stringCreate = (String) objectCreate;
		}

		return stringCreate;
	}

	/**
	 * {@link #createFrom(Address, String, boolean)} with address in format string
	 * 
	 * @param addressFrom
	 *            (String) The from-address used to create the stream
	 * @param streamName
	 *            (String) The name of the stream to create
	 * @param open
	 *            (Boolean) True if the stream is open, else false
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	public String createFrom(String addressFrom, String streamName, boolean open) throws ShellChainException {
		String stringCreate = "";
		Object objectCreate = executeCreateFrom(addressFrom, streamName, open);
		if (verifyInstance(objectCreate, String.class)) {
			stringCreate = (String) objectCreate;
		}

		return stringCreate;
	}

	/**
	 * {@link #createFrom(Address, String, boolean)} for a close stream
	 * 
	 * @param addressFrom
	 *            (Address) The from-address used to create the stream
	 * @param streamName
	 *            (String) The name of the stream to create
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	public String createFrom(Address addressFrom, String streamName) throws ShellChainException {
		return createFrom(addressFrom.getAddress(), streamName, false);
	}

	/**
	 * {@link #createFrom(Address, String)} with address in format string
	 * 
	 * @param addressFrom
	 *            (String) The from-address used to create the stream
	 * @param streamName
	 *            (String) The name of the stream to create
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	public String createFrom(String addressFrom, String streamName) throws ShellChainException {
		return createFrom(addressFrom, streamName, false);
	}

	/**
	 * liststreams (stream-identifier(s) verbose count start ) 1.
	 * "stream-identifier(s)" (string, optional, default=*, all streams) Stream
	 * identifier - one of the following: issue txid, stream reference, stream name.
	 * or 1. stream-identifier(s) (array, optional) A json array of stream
	 * identifiers 2. verbose (boolean, optional, default=false) If true, returns
	 * stream list of creators 3. count (number, optional, default=INT_MAX - all)
	 * The number of streams to display 4. start (number, optional, default=-count -
	 * last) Start from specific stream, 0 based, if negative - from the end
	 * 
	 * Returns list of defined streams
	 * 
	 * @param streamName
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<Stream> listStreams(String streamName, boolean verbose, int count, int start)
			throws ShellChainException {
		List<Stream> streams = new ArrayList<Stream>();

		Object objectStreams = executeListStreams(streamName, verbose, count, start);
		if (verifyInstance(objectStreams, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreams, Stream.class)) {
			streams = StreamFormatter.formatStreams((ArrayList<Object>) objectStreams);
		}

		return streams;
	}

	/**
	 * {@link #listStreams(String, boolean, int, int)} without start
	 * 
	 * @param streamName
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<Stream> listStreams(String streamName, boolean verbose, int count) throws ShellChainException {
		List<Stream> streams = new ArrayList<Stream>();

		Object objectStreams = executeListStreams(streamName, verbose, count);
		if (verifyInstance(objectStreams, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreams, Stream.class)) {
			streams = StreamFormatter.formatStreams((ArrayList<Object>) objectStreams);
		}

		return streams;

	}

	/**
	 * {@link #listStreams(String, boolean, int, int)} without start and default
	 * count = 10
	 * 
	 * @param streamName
	 * @param verbose
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<Stream> listStreams(String streamName, boolean verbose) throws ShellChainException {
		List<Stream> streams = new ArrayList<Stream>();

		Object objectStreams = executeListStreams(streamName, verbose, 10);
		if (verifyInstance(objectStreams, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreams, Stream.class)) {
			streams = StreamFormatter.formatStreams((ArrayList<Object>) objectStreams);
		}

		return streams;

	}

	/**
	 * {@link #listStreams(String, boolean, int, int)} without start and default
	 * count = 10 and defautl verbose = false
	 * 
	 * @param streamName
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<Stream> listStreams(String streamName) throws ShellChainException {
		List<Stream> streams = new ArrayList<Stream>();

		Object objectStreams = executeListStreams(streamName, false, 10);
		if (verifyInstance(objectStreams, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreams, Stream.class)) {
			streams = StreamFormatter.formatStreams((ArrayList<Object>) objectStreams);
		}

		return streams;

	}

	/**
	 * liststreamkeys "stream-identifier" ( key(s) verbose count start
	 * local-ordering )
	 * 
	 * Returns stream keys.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, optional, default=*) Stream key or 2. key(s) (array, optional) A
	 * json array of stream keys 3. verbose (boolean, optional, default=false) If
	 * true, returns extended information about key 4. count (number, optional,
	 * default=INT_MAX - all) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they apppear in blockchain
	 * 
	 * Result: "stream-keys" (array) List of stream keys.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKey> listStreamKeys(String streamName, String key, boolean verbose, int count, int start)
			throws ShellChainException {
		List<StreamKey> streamKeys = new ArrayList<StreamKey>();

		Object objectStreamKeys = executeListStreamKeys(streamName, key, verbose, count, start);
		if (verifyInstance(objectStreamKeys, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeys, StreamKey.class)) {
			streamKeys = StreamFormatter.formatStreamKeys((ArrayList<Object>) objectStreamKeys);
		}

		return streamKeys;
	}

	/**
	 * {@link listStreamKeys(String streamName, String key, boolean verbose, int
	 * count, int start)} without start
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKey> listStreamKeys(String streamName, String key, boolean verbose, int count)
			throws ShellChainException {
		List<StreamKey> streamKeys = new ArrayList<StreamKey>();

		Object objectStreamKeys = executeListStreamKeys(streamName, key, verbose, count);
		if (verifyInstance(objectStreamKeys, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeys, StreamKey.class)) {
			streamKeys = StreamFormatter.formatStreamKeys((ArrayList<Object>) objectStreamKeys);
		}

		return streamKeys;
	}

	/**
	 * {@link listStreamKeys(String streamName, String key, boolean verbose, int
	 * count, int start)} without start, with count = 10
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	public List<StreamKey> listStreamKeys(String streamName, String key, boolean verbose) throws ShellChainException {
		return listStreamKeys(streamName, key, verbose, 10);
	}

	/**
	 * {@link listStreamKeys(String streamName, String key, boolean verbose, int
	 * count, int start)} without start, with count = 10, verbse = false
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	public List<StreamKey> listStreamKeys(String streamName, String key) throws ShellChainException {
		return listStreamKeys(streamName, key, false, 10);
	}

	/**
	 * {@link listStreamKeys(String streamName, String key, boolean verbose, int
	 * count, int start)} without start, with count = 10, verbse = false, keys = "*"
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @return
	 * @throws ShellChainException
	 */
	public List<StreamKey> listStreamKeys(String streamName) throws ShellChainException {
		return listStreamKeys(streamName, "*", false, 10);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 * @param start
	 * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose, int count, int start)
			throws ShellChainException {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		Object objectStreamKeyItems = executeListStreamKeyItems(streamName, key, verbose, count, start);
		if (verifyInstance(objectStreamKeyItems, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeyItems, StreamKeyItem.class)) {
			streamKeyItems = StreamFormatter.formatStreamKeyItems((ArrayList<Object>) objectStreamKeyItems);
		}

		return streamKeyItems;
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 *            * @return
	 * @throws ShellChainException
	 */
	@SuppressWarnings("unchecked")
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose, int count)
			throws ShellChainException {
		List<StreamKeyItem> streamKeyItems = new ArrayList<StreamKeyItem>();

		Object objectStreamKeyItems = executeListStreamKeyItems(streamName, key, verbose, count);
		if (verifyInstance(objectStreamKeyItems, ArrayList.class)
				&& verifyInstanceofList((ArrayList<Object>) objectStreamKeyItems, StreamKeyItem.class)) {
			streamKeyItems = StreamFormatter.formatStreamKeyItems((ArrayList<Object>) objectStreamKeyItems);
		}

		return streamKeyItems;
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 * @param count
	 *            = 10 * @return
	 * @throws ShellChainException
	 */
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key, boolean verbose)
			throws ShellChainException {
		return listStreamKeyItems(streamName, key, verbose, 10);
	}

	/**
	 * liststreamkeyitems "stream-identifier" "key" ( verbose count start
	 * local-ordering )
	 * 
	 * Returns stream items for specific key.
	 * 
	 * Arguments: 1. "stream-identifier"(string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Stream key 3. verbose (boolean, optional, default=false)
	 * If true, returns information about item transaction 4. count (number,
	 * optional, default=10) The number of items to display 5. start (number,
	 * optional, default=-count - last) Start from specific item, 0 based, if
	 * negative - from the end 6. local-ordering (boolean, optional, default=false)
	 * If true, items appear in the order they were processed by the wallet, if
	 * false - in the order they appear in blockchain
	 * 
	 * Result: "stream-items" (array) List of stream items for specific key.
	 * 
	 * @param streamName
	 * @param key
	 * @param verbose
	 *            = false
	 * @param count
	 *            = 10 * @return
	 * @throws ShellChainException
	 */
	public List<StreamKeyItem> listStreamKeyItems(String streamName, String key) throws ShellChainException {
		return listStreamKeyItems(streamName, key, false, 10);
	}

	/**
	 * publish "stream-identifier" "key" data-hex
	 * 
	 * Publishes stream item
	 * 
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. 2. "key"
	 * (string, required) Item key 3. data-hex (string, required) Item data hex
	 * string
	 * 
	 * Result: "transactionid" (string) The transaction id.
	 * 
	 * @param streamName
	 * @param key
	 * @param dataHex
	 *            : data in hexadecimal in string format
	 * @return
	 * @throws ShellChainException
	 */
	public String publish(String streamName, String key, String dataHex) throws ShellChainException {
		String stringPublish = "";

		Object objectPublish = executePublish(streamName, key, dataHex);
		if (verifyInstance(objectPublish, String.class)) {
			stringPublish = (String) objectPublish;
		}

		return stringPublish;
	}
	
	/**
	 * {@link #publish(String, String, String)} with control over the from-address used to
	 * used to publish
	 * 
	 * @param addressFrom
	 *            (Address) The from-address used to publish
	 * @param streamName
	 *            (String) The name of the stream
	 * @param key
	 *            (String) The key of the item
	 * @param dataHex
	 *            (String) Data in hexadecimal
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	
	public String publishFrom(Address addressFrom, String streamName, String key, String dataHex) throws ShellChainException {
		return publishFrom(addressFrom.getAddress(), streamName, key, dataHex);
	}
	
	/**
	 * {@link #PublishFrom(Address, String, String, String)} with address in format string
	 * 
	 * @param addressFrom
	 *            (String) The from-address used to publish
	 * @param streamName
	 *            (String) The name of the stream
	 * @param key
	 *            (String) The key of the item
	 * @param dataHex
	 *            (String) Data in hexadecimal
	 * @return (String) The transaction id
	 * @throws ShellChainException
	 */
	
	public String publishFrom(String addressFrom, String streamName, String key, String dataHex) throws ShellChainException {
		String stringPublish = "";

		Object objectPublish = executePublishFrom(addressFrom, streamName, key, dataHex);
		if (verifyInstance(objectPublish, String.class)) {
			stringPublish = (String) objectPublish;
		}

		return stringPublish;
	}
	
	/**
	 * subscribe entity-identifier(s) ( rescan )
	 * 
	 * Subscribes to the stream.
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. or 1.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: asset txid, asset reference, asset name. or 1.
	 * entity-identifier(s) (array, optional) A json array of stream or asset
	 * identifiers 2. rescan (boolean, optional, default=true) Rescan the wallet for
	 * transactions
	 * 
	 * Note: This call can take minutes to complete if rescan is true.
	 * 
	 * @param streamName
	 * @throws ShellChainException
	 */
	public void subscribe(String streamName) throws ShellChainException {
		executeSubscribe(streamName);
	}

	/**
	 * unsubscribe entity-identifier(s)
	 * 
	 * Unsubscribes from the stream.
	 * 
	 * Arguments: 1. "stream-identifier" (string, required) Stream identifier - one
	 * of the following: stream txid, stream reference, stream name. or 1.
	 * "asset-identifier" (string, required) Asset identifier - one of the
	 * following: asset txid, asset reference, asset name. or 1.
	 * entity-identifier(s) (array, optional) A json array of stream or asset
	 * identifiers
	 * 
	 * @param streamName
	 * @throws ShellChainException
	 */
	public void unsubscribe(String streamName) throws ShellChainException {
		executeUnsubscribe(streamName);
	}


	public StreamKeyItem getStreamItem(String streamName,String txid,boolean verbose) throws ShellChainException {
		StreamKeyItem streamKeyItem=null;
		Object outdata=executeGetStreamItem(streamName,txid,verbose);
		if (verifyInstance(outdata, LinkedTreeMap.class)) {
			streamKeyItem = StreamFormatter.formatStreamKeyItem(outdata);
		}


		return streamKeyItem;
	}
}