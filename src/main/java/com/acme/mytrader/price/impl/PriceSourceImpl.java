package com.acme.mytrader.price.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.stockmarket.StockExchange;

public class PriceSourceImpl implements PriceSource {
	
	//public static Map<String, PriceListener> listnerMap = new HashMap<String, PriceListener>();
	
	private StockExchange stockExchange = StockExchange.getInstance();

	@Override
	public void addPriceListener(PriceListener listener) {
		System.out.println("addPriceListener start");
		
		PriceListenerImpl _listener = (PriceListenerImpl)listener;
		String stock = _listener.getStock();
		PriceObserver observer = new PriceObserver(stock);
		_listener.addObserver(observer);
		stockExchange.getListenerMap().put(stock, _listener);
		
		PriceListenerImpl _listener2 = (PriceListenerImpl)stockExchange.getListenerMap().get(stock);
		if(_listener2 == null) {
			System.out.println("lisetener "+stock+" not added");
		}
		
		//((PriceListenerImpl)listener).addObserver(new PriceObserver(((PriceListenerImpl)listener).getStock()));
		//listnerMap.put(((PriceListenerImpl)listener).getStock(), listener);
		System.out.println("addPriceListener end");

	}

	@Override
	public void removePriceListener(PriceListener listener) {
		System.out.println("removePriceListener start");
		
		PriceListenerImpl _listener = (PriceListenerImpl)listener;
		String stock = _listener.getStock();
		PriceObserver observer = new PriceObserver(stock);
		_listener.deleteObserver(observer);
		stockExchange.getListenerMap().remove(stock);
		
		//listnerMap.remove(((PriceListenerImpl)listener).getStock());
		//((PriceListenerImpl)listener).deleteObserver(new PriceObserver(((PriceListenerImpl)listener).getStock()));
		System.out.println("removePriceListener end");

	}

}
