package com.acme.mytrader.execution.impl;

import java.io.Serializable;

import com.acme.mytrader.execution.ExecutionService;

public class ExecutionServiceImpl implements ExecutionService, Serializable{

    private static final long serialVersionUID = -123454645451L;
    
    
    private static ExecutionService instance;
    
    private ExecutionServiceImpl() {
    	
    }
    
    
    /**
	 * double checking before creating instance
	 * @return
	 */
	public static ExecutionService getInstance(){
	    if(instance == null){
	        synchronized (ExecutionServiceImpl.class) {
	            if(instance == null){
	                instance = new ExecutionServiceImpl();
	            }
	        }
	    }
	    return instance;
	}
	

	@Override
	public void buy(String security, double price, int volume) {
		System.out.println();
		System.out.println();
		System.out.println("*********** Buy You successfully bought stock: "+security+" Price: "+price+" volume: "+volume+"    ***********************");
		System.out.println();
		System.out.println();
		
	}

	@Override
	public void sell(String security, double price, int volume) {
		System.out.println();
		System.out.println();
		System.out.println("Sell You successfully sold stock: "+security+" Price: "+price+" volume: "+volume);
		System.out.println();
		System.out.println();
	}

}
