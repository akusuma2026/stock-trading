package com.acme.mytrader.price.impl;

import java.util.Observable;
import java.util.Observer;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.execution.impl.ExecutionServiceImpl;
import com.acme.mytrader.stockmarket.StockExchange;

public class PriceObserver implements Observer {
	private static final Integer NO_OF_STOCKS =  100;
	private ExecutionService executionService = ExecutionServiceImpl.getInstance();
	
	private StockExchange stockExchange = StockExchange.getInstance();
	
	private String stock;

	public PriceObserver(String stock) {
		this.stock = stock;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("PriceObserver update");
		if(arg instanceof String) {
			stock = (String) arg;
			Double stockPrice = stockExchange.getStockPrice(stock);
			PriceListenerImpl _listener = (PriceListenerImpl)stockExchange.getListenerMap().get(stock);
			if(stockPrice <= _listener.getListenerPrice()) {
				executionService.buy(_listener.getStock(), stockPrice, NO_OF_STOCKS);
			}
		}
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
		PriceObserver other = (PriceObserver) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	
	

}
