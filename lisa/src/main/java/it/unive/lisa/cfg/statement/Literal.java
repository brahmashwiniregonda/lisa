package it.unive.lisa.cfg.statement;

import java.util.Objects;

import it.unive.lisa.cfg.CFG;

/**
 * A literal, representing a constant value.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class Literal extends Expression {

	/**
	 * The value of this literal
	 */
	private final Object value;

	/**
	 * Builds the literal, consisting of a constant value. The location where this
	 * literal happens is unknown (i.e. no source file/line/column is available).
	 * 
	 * @param cfg   the cfg that this expression belongs to
	 * @param value the value of this literal
	 */
	public Literal(CFG cfg, Object value) {
		this(cfg, null, -1, -1, value);
	}

	/**
	 * Builds the literal, consisting of a constant value, happening at the given
	 * location in the program.
	 * 
	 * @param cfg        the cfg that this expression belongs to
	 * @param sourceFile the source file where this expression happens. If unknown,
	 *                   use {@code null}
	 * @param line       the line number where this expression happens in the source
	 *                   file. If unknown, use {@code -1}
	 * @param col        the column where this expression happens in the source
	 *                   file. If unknown, use {@code -1}
	 * @param value      the value of this literal
	 */
	public Literal(CFG cfg, String sourceFile, int line, int col, Object value) {
		super(cfg, sourceFile, line, col);
		Objects.requireNonNull(value, "The value of a literal cannot be null");
		this.value = value;
	}

	/**
	 * Yields the value of this literal.
	 * 
	 * @return the value of this literal
	 */
	public Object getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Literal other = (Literal) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}
