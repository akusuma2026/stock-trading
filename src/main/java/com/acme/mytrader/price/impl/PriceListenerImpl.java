package com.acme.mytrader.price.impl;

import java.util.Observable;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.stockmarket.StockExchange;

public class PriceListenerImpl extends Observable implements PriceListener{
	
	private StockExchange stockExchange = StockExchange.getInstance();
	
	private String stock;
	private Double listenerPrice;

	public PriceListenerImpl() {
		
	}
	
	
	public PriceListenerImpl(String stock, Double listenerPrice) {
		this.stock = stock;
		this.listenerPrice = listenerPrice;
	}
	
	
	public String getStock() {
		return stock;
	}
	
	public Double getListenerPrice() {
		return listenerPrice;
	}
	
	
	@Override
	public void priceUpdate(String security, double price) {
		System.out.println("PriceListenerImpl priceupdate stock = "+security+" price = "+price);
		stockExchange.updateStockPrice(security, price);
		PriceListenerImpl _listener = (PriceListenerImpl)stockExchange.getListenerMap().get(security);
		_listener.setChanged();
		_listener.notifyObservers(security);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceListenerImpl other = (PriceListenerImpl) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}

	
	
	
	
	
	
	

}
