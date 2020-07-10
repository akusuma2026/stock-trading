package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.impl.PriceListenerImpl;
import com.acme.mytrader.price.impl.PriceSourceImpl;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
	public void trading(String security, double price) {
		PriceSource priceSource = new PriceSourceImpl();
		PriceListener ibm = new PriceListenerImpl(security, price);
		priceSource.addPriceListener(ibm);
	}
}
