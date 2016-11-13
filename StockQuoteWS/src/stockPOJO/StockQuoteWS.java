/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockPOJO;

import javax.jws.WebService;
import stockquotews.StockQuoteDAO;

/**
 *
 * @author Suguru
 */
@WebService
public class StockQuoteWS {
    
    public static void main(String[] args) {
        StockQuoteWS stockQuoteWS = new StockQuoteWS();
        stockQuoteWS.getQuote("APPL");
    }
    
    

    public int getQuote(String comSymbol) {
        int retVal = 0;
        retVal = StockQuoteDAO.getQuote(comSymbol);
        return retVal;
    }

       
    
}