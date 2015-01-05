package org.sqlproc.dsl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.inject.Inject;

public class ProcessorNameProvider extends IQualifiedNameProvider.AbstractImpl {

    @Inject
    private IQualifiedNameConverter qualifiedNameConverter;

    public QualifiedName getFullyQualifiedName(EObject obj) {
        // System.out.println("XXXX " + obj);
        // if (obj instanceof AnnotatedEntity) {
        // obj = ((AnnotatedEntity) obj).getEntity();
        // }
        String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
        // System.out.println("YYYY " + name);
        if (name == null)
            return null;
        QualifiedName result = qualifiedNameConverter.toQualifiedName(name);
        // System.out.println("YYYY " + result);
        return result;
    }
}
