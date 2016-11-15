/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockQuotesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Suguru
 */
public class StockQuoteDAO {
    
    public static int getQuote(String input) {
        int retVal = 0;
        
        //Connecting to the database to retrieve data.
        String query = "SELECT * FROM quote.quotes WHERE comSymbol = ?";
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/quote";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        
        try {
            PreparedStatement pstmt = DBConn.prepareStatement(query);
            pstmt.setString(1, input.toUpperCase());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                retVal = rs.getInt("price");
            }
            DBConn.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Exception caught");
        }
        return retVal;
    }
}