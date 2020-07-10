package com.acme.mytrader.stockmarket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import com.acme.mytrader.price.PriceListener;

public class StockExchange implements Serializable{

    public static final long serialVersionUID = 123454645454L;

    private static final int STOKC_MIN_VALUE = 0;
    private static final int STOKC_MAX_VALUE = 200;
    
    @SuppressWarnings("serial") 
    private List<String> stockNames = new ArrayList<String> () {{
		add("IBM");
		add("MFST");
		add("GE");
		add("JPM");
		add("TSLA");
	}}; 
    
	private static StockExchange instance;

	/**
	 * Stocks - Map which contains list of stocks and price value
	 */
	@SuppressWarnings("serial") 
	private Map<String, Double> stocks = new ConcurrentHashMap<String, Double>(){{
		//IBM, MFST, GE, JPM, TSLA, AXP;
	    put("IBM", 0.0);
	    put("MFST", 0.0);
	    put("GE", 0.0);
	    put("JPM", 0.0);
	    put("TSLA", 0.0);
	}};
	
	
	private Map<String, PriceListener> listnerMap = new HashMap<String, PriceListener>();
	
	
	
	private StockExchange() {
		
	}
	
	/**
	 * double checking before creating instance
	 * @return
	 */
	public static StockExchange getInstance(){
	    if(instance == null){
	        synchronized (StockExchange.class) {
	            if(instance == null){
	                instance = new StockExchange();
	            }
	        }
	    }
	    return instance;
	}
	
	
	
	public Map<String, Double> getStocks() {
		return stocks;
	}
	
	
	/***
	 * list all stocks
	 */
	
	public void listAllStocksWithPrices(){
		System.out.println("=====================================");
		System.out.println("-- List of all stocks start -- ");
		for(String stockName: stocks.keySet()) {
			System.out.println("Stock name: "+stockName+" price: "+getStockPrice(stockName));
		}
		System.out.println("-- List of all stocks end -- ");
		System.out.println("=====================================");
		
		//return stocks;
	}
	
	public List<String> listAllStocks() {
		return stockNames;
	}
	
	
	public Double getStockPrice(String stock) {
		return stocks.get(stock);
	}
	
	public void updateStockPrice(String stock, Double price) {
		stocks.put(stock, price);
	}
	
	public Map<String, PriceListener> getListenerMap() {
		return listnerMap;
		
	}
	
	
}
