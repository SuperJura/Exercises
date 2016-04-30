/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Jurica
 */
public class Repository {
    private static ItemDatabase database;
    
    public static ItemDatabase getItemsDatabaseInstance()
    {
        if (database == null) {
            //database = new CodeDatabase();
            database = new SQLItemDatabase();
        }
        
        return database;
    }
}
