/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author joaqu
 * @param <T>
 */
public class Queue<T> extends Sequence{
    private List<T> data;

    public Queue() {
		data = new LinkedList<T>();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	@Override
	public int size() {
		return data.size();
	}
	
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(T d: data)
			str = str + d +", ";
		str = str.substring(0, str.length()-2)+"]";
		return str;
		}
}
