public class ListLists {
	List primeiroList;
	List ultimoList;

	public ListLists() {
		primeiroList = ultimoList = null;

	}

	public void insere(Object data, String index) {
		List l;
		if (ultimoList == null) {

			l = new List(index);
			l.insere(data, index);
			primeiroList = ultimoList = l;
		} else if (isIndexExists(index)) {
			l = getListByIndex(index);
			l.insere(data, index);
		} else {
			insertListByIndex(index);
			l = getListByIndex(index);
			l.insere(data, index);
		}
	}

	public boolean isIndexExists(String index) {
		List current = primeiroList;
		while (current != null) {
			if (current.getIndex().charAt(0) == index.charAt(0))
				return true;
			current = current.next();
		}
		return false;
	}

	public void insertListByIndex(String index) {
		if ((int) index.charAt(0) < (int) primeiroList.getIndex().charAt(0)) {

			primeiroList.setPrevList(new List(index));

			primeiroList.prev().setNextList(primeiroList);
			primeiroList = primeiroList.prev();

		} else {

			List current = primeiroList;

			while (current != null
					&& ((int) current.getIndex().charAt(0) < (int) index
							.charAt(0)))
				current = current.next();

			if (current == null) {
				ultimoList.setNextList(new List(index));
				ultimoList.next().setPrevList(ultimoList);
				ultimoList = ultimoList.next();

			} else if (!(current.getIndex().charAt(0) == index.charAt(0))) {

				current.prev().setNextList(new List(index));

				current.prev().next().setNextList(current);

				current.prev().next().setPrevList(current.prev());

				current.setPrevList(current.prev().next());
			}
		}
	}

	public List getListByIndex(String index) {

		List current = primeiroList;
		while (current != null) {
			if (current.getIndex().charAt(0) == index.charAt(0))
				return current;
			current = current.next();
		}

		return current;
	}

	public void printAllLists() {

		List current = primeiroList;
		while (current != null) {

			System.out.println("Coluna " + current.getIndex() + ".\n");
			current.printList();
			current = current.next();
		}
	}

	public boolean isEmpty() {
		if (ultimoList == null)
			return true;
		return false;
	}
}
