public class Node {
	
	private Object data;
	private Node anteriorNode;
	private Node proximoNode;
	private String index;
	
	public Node() {
		data = null;
		anteriorNode = null;
		proximoNode = null;
		index = null;
	}
	
	public Node(Object data, String index) {
		this.data = data;
		anteriorNode = null;
		proximoNode = null;
		this.index = index.substring(1,2);
	}

	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node prev() {
		return this.anteriorNode;
	}
	
	public void setprev(Node prev) {
		this.anteriorNode = prev;
	}
	
	public Node next() {
		return this.proximoNode;
	}
	
	public void setnext(Node next) {
		this.proximoNode = next;
	}
	
	public String getIndex() {
		return this.index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
}
