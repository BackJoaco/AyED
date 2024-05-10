package ejercicio1;

import java.util.LinkedList;
import java.util.List;
import ejercicio1.Queue;

@SuppressWarnings("unused")
public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
			
		return 0;
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
	
	private GeneralTree<T> esAncestro(GeneralTree<T> arbol, T dato) {
	    if (arbol.getData() == dato) {
	        return arbol;
	    }

	    if (arbol.hasChildren()) {
	        for (GeneralTree<T> hijo : arbol.getChildren()) {
	            GeneralTree<T> ancestro = esAncestro(hijo, dato);
	            if (ancestro != null) {
	                return ancestro;
	            }
	        }
	    }

	    return null;
	}


	public boolean esAncestro(T a, T b) {
		GeneralTree<T> ancestro = esAncestro(this, a);
		if (ancestro != null) {
			return esAncestro(ancestro, b) != null;
		} else {
			return false;
		}
	    
	}


}