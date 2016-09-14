package TDALista;

import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E> {
	// Atributos
	protected int cant;
	protected DNodo<E> header, trailer;

	// Constructor
	public ListaDoblementeEnlazada() {
		cant = 0;
		header = new DNodo<E>(null, null, null);
		trailer = new DNodo<E>(null, header, null);
		header.setNext(trailer);
	}

	public int size() {
		return cant;
	}

	public boolean isEmpty() {
		return cant == 0;
	}

	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("La lista esta vacia");
		return header.getNext();
	}

	public Position<E> last() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException("La lista esta vacia");
		return trailer.getPrev();
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> anterior = n.getPrev();
		if (anterior == header)
			throw new BoundaryViolationException("ListaDoblementeEnlazada: next: el primer elemento no tiene anterior");
		return anterior;
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> n = checkPosition(p);
		DNodo<E> siguiente = n.getNext();
		if (siguiente == trailer)
			throw new BoundaryViolationException(
					"ListaDoblementeEnlazada: next: el ultimo elemento no tiene siguiente");
		return siguiente;
	}

	public void addFirst(E elem) {
		DNodo<E> nuevo = new DNodo<E>(elem, header, header.getNext());
		(header.getNext()).setPrev(nuevo);
		header.setNext(nuevo);
		cant++;
	}

	public void addLast(E elem) {
		DNodo<E> nuevo = new DNodo<E>(elem, trailer.getPrev(), trailer);
		(trailer.getPrev()).setNext(nuevo);
		trailer.setPrev(nuevo);
		cant++;
	}

	public void addBefore(Position<E> p, E elem) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		try {
			if (n == first())
				addFirst(elem);
			else {
				DNodo<E> nuevo = new DNodo<E>(elem, n.getPrev(), n);
				(n.getPrev()).setNext(nuevo);
				n.setPrev(nuevo);
				cant++;
			}
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
	}

	public void addAfter(Position<E> p, E elem) throws InvalidPositionException {
		DNodo<E> n = checkPosition(p);
		try {
			if (n == last())
				addLast(elem);
			else {
				DNodo<E> nuevo = new DNodo<E>(elem, n, n.getNext());
				(n.getNext()).setPrev(nuevo);
				n.setNext(nuevo);
				cant++;
			}
		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}

	}

	public E remove(Position<E> p) throws InvalidPositionException {
		if (cant == 0)
			throw new InvalidPositionException("Lista vacia");
		DNodo<E> n = checkPosition(p);
		(n.getNext()).setPrev(n.getPrev());
		(n.getPrev()).setNext(n.getNext());
		n.setNext(null);
		n.setPrev(null);
		E element = n.element();
		cant--;
		return element;
	}

	public E set(Position<E> p, E elem) throws InvalidPositionException {
		if (cant == 0)
			throw new InvalidPositionException("Lista vacia");
		DNodo<E> n = checkPosition(p);
		E aux = n.element();
		n.setElement(elem);
		return aux;
	}

	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		try {
			if (p == null)
				throw new InvalidPositionException("CheckPosition: posición invalida, nula.");
			if (p == header)
				throw new InvalidPositionException("CheckPosition: la posicion es header");
			if (p == trailer)
				throw new InvalidPositionException("CheckPosition: la posicion es trailer");
			return (DNodo<E>) p;
		} catch (ClassCastException e) {
			throw new InvalidPositionException("CheckPosition: casting imposible.");
		}
	}

	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	public Iterable<Position<E>> positions() {
		try {
			PositionList<Position<E>> l = new ListaDoblementeEnlazada<Position<E>>();
			if (cant != 0) {
				Position<E> p = first();
				while (p != null) {
					l.addLast(p);
					p = p == last() ? null : next(p);
				}
			}
			return l;
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}
}
