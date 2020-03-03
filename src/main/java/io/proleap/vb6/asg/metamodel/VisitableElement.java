package io.proleap.vb6.asg.metamodel;

import io.proleap.vb6.asg.visitor.VBASGVisitor;

public interface VisitableElement {
	void acceptVisitor (VBASGVisitor visitor);
}
