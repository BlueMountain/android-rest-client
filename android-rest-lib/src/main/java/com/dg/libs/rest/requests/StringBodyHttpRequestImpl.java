package com.dg.libs.rest.requests;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;

import android.content.Context;

import com.dg.libs.android.logger.ALog;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.BaseRestClient.RequestMethod;
import com.dg.libs.rest.parsers.HttpResponseParser;

public abstract class StringBodyHttpRequestImpl<T> extends EntityHttpRequestImpl<T> {

	public static final String TAG = StringBodyHttpRequestImpl.class.getSimpleName();

	public StringBodyHttpRequestImpl(final Context context, RequestMethod requestMethod,
			final HttpResponseParser<T> parser, final HttpCallback<T> callback) {
		super(context, requestMethod, parser, callback);
	}

	public abstract String bodyContents();

	@Override
	public HttpEntity getEntity() {
		try {
			return new StringEntity(bodyContents(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			ALog.e(e);
		}
		return null;
	}
}
