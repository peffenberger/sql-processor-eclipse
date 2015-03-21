package org.sqlproc.model.property;

import org.sqlproc.model.processorModel.PojoType;
import org.sqlproc.plugin.lib.property.PojoEntityType;

public class PojoEntityTypeImpl implements PojoEntityType {

	PojoType type;

	public PojoEntityTypeImpl(PojoType type) {
		super();
		this.type = type;
	}
}
