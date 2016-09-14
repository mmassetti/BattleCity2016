package TDALista;

public class DNodo<E> implements Position<E> {
	// Atributos
	private E element;
	private DNodo<E> next, prev;

	// Constructor
	public DNodo(E e, DNodo<E> p, DNodo<E> n) {
		element = e;
		prev = p;
		next = n;
	}

	// Getters
	public E element() {
		return element;
	}

	public DNodo<E> getPrev() {
		return prev;
	}

	public DNodo<E> getNext() {
		return next;
	}

	// Setters
	public void setElement(E elem) {
		element = elem;
	}

	public void setPrev(DNodo<E> newPrev) {
		prev = newPrev;
	}

	public void setNext(DNodo<E> newNext) {
		next = newNext;
	}

}
