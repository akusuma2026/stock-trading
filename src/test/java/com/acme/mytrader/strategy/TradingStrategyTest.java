package com.acme.mytrader.strategy;

import org.junit.Before;
import org.junit.Test;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.impl.PriceListenerImpl;
import com.acme.mytrader.stockmarket.StockExchange;

public class TradingStrategyTest {
    
	StockExchange stockExchange;
	TradingStrategy tradingStrategy;
	PriceListener priceListener;
	
	String stock = null;
	
	@Before
	public void setUp() {
		priceListener = new PriceListenerImpl();
		stockExchange = StockExchange.getInstance();
		tradingStrategy = new TradingStrategy();
		
		stock = "IBM";
		double priceCheck = 55.0;
		
		tradingStrategy.trading(stock, priceCheck);
	}
	
	@Test
    public void testDontBuyStock() {
		double stockPrice1  = 100.0;
		priceListener.priceUpdate(stock, stockPrice1);
		
		System.out.println("testDontBuyStock complete ");
    }
	
	@Test
    public void testBuyStockWhenExactPriceMatch() {
		double stockPrice2  = 55.0;
		priceListener.priceUpdate(stock, stockPrice2);
		
		System.out.println("testBuyStockWhenExactPriceMatch complete ");
    }
	
	@Test
    public void testBuyStockWhenPriceDropMatch() {
		double stockPrice3  = 50.0;
		priceListener.priceUpdate(stock, stockPrice3);
		
		System.out.println("testBuyStockWhenPriceDropMatch complete ");
    }
}
