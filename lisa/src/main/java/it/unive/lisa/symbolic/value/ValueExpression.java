package it.unive.lisa.symbolic.value;

import it.unive.lisa.analysis.HeapDomain;
import it.unive.lisa.analysis.ValueDomain;
import it.unive.lisa.cfg.type.Type;
import it.unive.lisa.symbolic.SymbolicExpression;
import it.unive.lisa.symbolic.heap.HeapExpression;

/**
 * A symbolic expression that represents an operation on the program's state.
 * For this expression to be evaluated from a {@link ValueDomain}, all nested
 * {@link HeapExpression} must be rewritten by a {@link HeapDomain}.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public abstract class ValueExpression extends SymbolicExpression {

	/**
	 * Builds the heap expression.
	 * 
	 * @param type the runtime type of this expression
	 */
	protected ValueExpression(Type type) {
		super(type);
	}

}
