package org.sqlproc.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;

public class ProcesorModelResourceDescriptionStrategy extends XbaseResourceDescriptionStrategy {

    @Override
    protected boolean isResolvedAndExternal(EObject from, EObject to) {
        return super.isResolvedAndExternal(from, to);
        // if (to == null)
        // return false;
        // if (!to.eIsProxy()) {
        // if (to.eResource() == null) {
        // // TODO
        // // JvmGenericType: cz.isvs.ais3.audit.model.Agenda (visibility: PUBLIC, simpleName: Agenda, identifier:
        // // cz.isvs.ais3.audit.model.Agenda, deprecated: <unset>) (abstract: false, static: false, final: false,
        // // packageName: cz.isvs.ais3.audit.model) (interface: false, strictFloatingPoint: false, anonymous:
        // // false)
        // // JvmParameterizedTypeReference: cz.isvs.ais3.audit.model.Agenda
        //
        // return false;
        // }
        // return from.eResource() != to.eResource();
        // }
        // return !getLazyURIEncoder()
        // .isCrossLinkFragment(from.eResource(), ((InternalEObject) to).eProxyURI().fragment());
    }

}
