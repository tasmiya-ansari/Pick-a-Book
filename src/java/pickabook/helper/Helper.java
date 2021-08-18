/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pickabook.helper;

/**
 *
 * @author tasmi
 */
public class Helper {
    
    public static String get150words(String desc)
    {
        String []strs=desc.split("");
        if(strs.length>20)
        {
            String res="";
            for(int i=0;i<150;i++)
            {
                res=res+strs[i];
            }
            return(res+"...");
        }
        else
            return(desc+"...");
        
    }
}
