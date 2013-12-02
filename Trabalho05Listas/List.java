public class List {

	private Node primeiroNode;
	private Node ultimoNode;
	private String index;
	
	private List proximoList;
	private List anteriorList;
	
	public List() {
		this.primeiroNode = null;
		this.ultimoNode = null;
		this.index = null;
		proximoList = anteriorList = null;
	}
	
	public List(String index) {
		this.primeiroNode = null;
		this.ultimoNode = null;
		this.index = index.substring(0,1);
		proximoList = anteriorList = null;
			}
	

	
	public void insere(Object data, String index) {
		Node n;
		if (isEmpty()) {
			n = new Node(data,index);
			primeiroNode = ultimoNode = n;
		} else if (isIndexExists(index)) {
			n = getNodeByIndex(index);
			n.setData(data);
		} else {
			
			insertByIndex(data, index);
		}
	}
	
	private void insertByIndex(Object data, String index) {
		
		
		if ((int)index.charAt(1) < (int)primeiroNode.getIndex().charAt(0)) {
			
			primeiroNode.setprev(new Node(data,index));
			primeiroNode.prev().setnext(primeiroNode);
			primeiroNode = primeiroNode.prev();
			
		} else {
		
			Node current = primeiroNode;
		
			while (current != null && ((int)current.getIndex().charAt(0) < (int)index.charAt(1)))
				current = current.next();
			
			if (current == null) {
			
				ultimoNode.setnext(new Node(data, index));
				
				ultimoNode.next().setprev(ultimoNode);
				ultimoNode = ultimoNode.next();
				
			} else if (current.getIndex().charAt(0) == index.charAt(1)) { 
				
			
				current.setData(data);
			} else {
				current.prev().setnext(new Node(data,index));
				
				current.prev().next().setnext(current);
				
				current.prev().next().setprev(current.prev());
				
				current.setprev(current.prev().next());
			} 
		}
	}
	
	public boolean isIndexExists(String index) {
		Node current = primeiroNode;
		while(current != null) {
			if (current.getIndex() == index) 
				return true;
			current = current.next();
		}
		return false;
	}
	
	public Node getNodeByIndex(String index) {
		
		Node current = primeiroNode;
		while(current != null) {
			if (current.getIndex() == index.substring(0,1))
				return current;
			current = current.next();
		}
		
		return current;
	}
	
	public void printList() {
		Node current = primeiroNode;
		while (current != null) {
			
			System.out.println("Linha "+current.getIndex()+": "+current.getData()+".\n");
			current = current.next();
		}
	}
	
	public boolean isEmpty() {
		if (ultimoNode == null)
			return true;
		return false;
	}
	
	public List next() {
		return proximoList;
	}
	
	public void setNextList(List lista) {
		this.proximoList = lista;
	}
	
	public List prev() {
		return anteriorList;
	}
	
	public void setPrevList(List lista) {
		this.anteriorList = lista;
	}
	
	public String getIndex() {
		return index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
}
