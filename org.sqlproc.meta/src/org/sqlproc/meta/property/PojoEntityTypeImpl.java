package org.sqlproc.meta.property;

import org.sqlproc.meta.processorMeta.PojoType;
import org.sqlproc.plugin.lib.property.PojoEntityType;

public class PojoEntityTypeImpl implements PojoEntityType {

	PojoType type;

	public PojoEntityTypeImpl(PojoType type) {
		super();
		this.type = type;
	}

	@Override
	public String getSimpleName() {
		// TODO Auto-generated method stub
		return null;
	}
}
