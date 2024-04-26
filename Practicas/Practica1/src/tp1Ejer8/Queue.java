/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1Ejer8;

import java.util.List;

/**
 *
 * @author joaqu
 * @param <T>
 */
public class Queue<T> extends Sequence{
    private List<T> data;

    private List<T> getData() {
        return data;
    }

    private void setData(List<T> data) {
        this.data = data;
    }
    
    public Queue(){
        
    }
    @Override
    public int size(){
        return this.data.size();
    }
    
    @Override
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    
    public void enqueue(dato:T){
        this.data.add(T);
    }
    
    public 
}
