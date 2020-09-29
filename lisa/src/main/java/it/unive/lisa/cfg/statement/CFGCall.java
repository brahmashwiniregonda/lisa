package it.unive.lisa.cfg.statement;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import it.unive.lisa.cfg.CFG;

/**
 * A call to one of the CFG under analysis.
 * 
 * @author <a href="mailto:luca.negrini@unive.it">Luca Negrini</a>
 */
public class CFGCall extends Call {

	/**
	 * The target of this call
	 */
	private final CFG target;

	/**
	 * Builds the CFG call. The location where this call happens is
	 * unknown (i.e. no source file/line/column is available).
	 * 
	 * @param cfg    the cfg that this expression belongs to
	 * @param target the CFG that is targeted by this CFG call.
	 */
	public CFGCall(CFG cfg, CFG target) {
		this(cfg, null, -1, -1, target);
	}

	/**
	 * Builds the CFG call, happening at the given location in the program.
	 * 
	 * @param cfg        the cfg that this expression belongs to
	 * @param sourceFile the source file where this expression happens. If unknown,
	 *                   use {@code null}
	 * @param line       the line number where this expression happens in the source
	 *                   file. If unknown, use {@code -1}
	 * @param col        the column where this expression happens in the source
	 *                   file. If unknown, use {@code -1}
	 * @param target     the CFG that is targeted by this CFG call
	 */
	public CFGCall(CFG cfg, String sourceFile, int line, int col, CFG target) {
		super(cfg, sourceFile, line, col);
		Objects.requireNonNull(target, "The target of a CFG call cannot be null");
		this.target = target;
	}

	/**
	 * Yields the CFG that is targeted by this CFG call.
	 * 
	 * @return the target CFG
	 */
	public CFG getTarget() {
		return target;
	}

	@Override
	public String toString() {
		return target.getDescriptor().getFullName() + "(" + StringUtils.join(getParameters(), ", ") + ")";
	}
}