package it.unive.lisa.symbolic.value;

import it.unive.lisa.analysis.heap.HeapDomain;
import it.unive.lisa.analysis.value.ValueDomain;
import it.unive.lisa.symbolic.SymbolicExpression;
import it.unive.lisa.symbolic.heap.HeapExpression;
import it.unive.lisa.type.Type;
import it.unive.lisa.util.collections.externalSet.ExternalSet;

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
	 * @param types the runtime types of this expression
	 */
	protected ValueExpression(ExternalSet<Type> types) {
		super(types);
	}

}
