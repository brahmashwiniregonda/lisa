package it.unive.lisa.cfg.edge;

import it.unive.lisa.analysis.AnalysisState;
import it.unive.lisa.analysis.HeapDomain;
import it.unive.lisa.analysis.SemanticException;
import it.unive.lisa.analysis.ValueDomain;
import it.unive.lisa.cfg.statement.Statement;
import it.unive.lisa.symbolic.value.UnaryOperator;
import it.unive.lisa.symbolic.SymbolicExpression;
import it.unive.lisa.symbolic.value.UnaryExpression;

/**
 * A sequential edge connecting two statements. The abstract analysis state gets
 * modified by assuming that the statement where this edge originates does not
 * hold.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class FalseEdge extends Edge {

	/**
	 * Builds the edge.
	 * 
	 * @param source      the source statement
	 * @param destination the destination statement
	 */
	public FalseEdge(Statement source, Statement destination) {
		super(source, destination);
	}

	@Override
	public String toString() {
		return "[ " + getSource() + " ] -F-> [ " + getDestination() + " ]";
	}

	@Override
	public <H extends HeapDomain<H>, V extends ValueDomain<V>> AnalysisState<H, V> traverse(
			AnalysisState<H, V> sourceState) throws SemanticException {
		SymbolicExpression expr = sourceState.getLastComputedExpression();
		return sourceState.assume(new UnaryExpression(expr.getType(), expr, UnaryOperator.LOGICAL_NOT));
	}
}
