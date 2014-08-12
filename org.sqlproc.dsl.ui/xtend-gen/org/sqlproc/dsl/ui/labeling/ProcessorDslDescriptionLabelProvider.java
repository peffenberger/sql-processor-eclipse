/**
 * generated by Xtext
 */
package org.sqlproc.dsl.ui.labeling;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class ProcessorDslDescriptionLabelProvider extends DefaultDescriptionLabelProvider {
  public Object text(final IEObjectDescription ele) {
    QualifiedName _name = ele.getName();
    return ("" + _name);
  }
}
