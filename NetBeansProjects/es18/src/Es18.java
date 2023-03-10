/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author leona
 */
public class Es18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] array={1,5,2,7,1,5,7,3,5,0,5,0};
        
        
        Map<Integer,Integer> map = new HashMap<>();    
        for (Integer integer : array){
        if (map.containsKey(integer))
            map.put(integer, map.get(integer) + 1);
        else
                map.put(integer, 1);
    }

        
        
        
        List<Integer> list = new ArrayList<>(map.keySet());
        
        System.out.println(list);
        
         Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                if(map.get(num1)>map.get(num2))
                    return -1;
                if(map.get(num1)<map.get(num2))
                    return 1;
                return 0;
            }
        });
           System.out.println(list.get(0));
        
    }
    
}
