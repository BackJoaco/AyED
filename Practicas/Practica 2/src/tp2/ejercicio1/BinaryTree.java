package tp2.ejercicio1;




public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;   
    private BinaryTree<T> rightChild; 

    public BinaryTree() {
            super();
    }

    public BinaryTree(T data) {
            this.data = data;
    }

    public T getData() {
            return data;
    }

    public void setData(T data) {
            this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
            return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
            return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
            this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
            this.rightChild = child;
    }

    public void removeLeftChild() {
            this.leftChild = null;
    }

    public void removeRightChild() {
            this.rightChild = null;
    }

    public boolean isEmpty(){
            return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
            return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
            return this.leftChild!=null;
    }

    public boolean hasRightChild() {
            return this.rightChild!=null;
    }
    @Override
    public String toString() {
            return this.getData().toString();
    }

    public int contarHojas() {
        if(!this.isEmpty()){
            if (this.isLeaf()){
                return 1;
            } 
            int countIzq = 0;
            int countDer = 0;
            if (this.hasLeftChild()){
                countIzq = this.getLeftChild().contarHojas();
            }
            if (this.hasRightChild()){
                countDer = this.getRightChild().contarHojas();
            }
            return countIzq + countDer;
        } else {
            return 0;
        }
    }

    public BinaryTree<T> espejo(){
		BinaryTree<T> aux = new BinaryTree<T>();
        if(!this.isEmpty()){
            aux.setData(this.getData());
            if(!this.isLeaf()){
                if(this.hasLeftChild()){
                    aux.addRightChild(this.getLeftChild().espejo());
                }
                if(this.hasRightChild()){
                    aux.addLeftChild(this.getLeftChild().espejo());
                }
            }
        }
        return aux;
    }

    public void porNiveles(){
    	if (!this.isEmpty()) {
	    	Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
	    	cola.enqueue(this);
	    	cola.enqueue(null);
	    	while (!cola.isEmpty()) {
	    		BinaryTree<T> aux = cola.dequeue();
	    		if (aux != null) {
	    			System.out.print(aux.getData() + " ");
		    		if (aux.hasLeftChild()) {
		    			cola.enqueue(aux.getLeftChild());
		    		}
		    		if (aux.hasRightChild()) {
		    			cola.enqueue(aux.getRightChild());
		    		}
	    		} else if (!cola.isEmpty()) {
	    			cola.enqueue(null);
	    			System.out.println();
	    		}
			}
    	}
    }
    public void entreNiveles(int n, int m){
    	if (!this.isEmpty() && n<=m) {
	    	Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
	    	int level = 0;
	    	cola.enqueue(this);
	    	cola.enqueue(null);
	    	while (!cola.isEmpty() && level<=m) {
	    		BinaryTree<T> aux = cola.dequeue();
	    		if (aux != null) {
		    		if (level >= n) {
		    			System.out.print(aux.getData() + " ");
		    		}
		    		if (aux.hasLeftChild()) {
		    			cola.enqueue(aux.getLeftChild());
		    		}
		    		if (aux.hasRightChild()) {
		    			cola.enqueue(aux.getRightChild());
		    		}
	    		} else if (!cola.isEmpty()) {
	    			cola.enqueue(null);
	    			System.out.println();
	    			level ++;
	    		}
			}
    	}
   }
    
}



