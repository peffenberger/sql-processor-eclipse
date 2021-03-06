/*
 * generated by Xtext
 */
package org.sqlproc.meta.formatting

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import com.google.inject.Inject
import org.sqlproc.meta.services.ProcessorMetaGrammarAccess

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class ProcessorMetaFormatter extends AbstractDeclarativeFormatter {

	@Inject extension ProcessorMetaGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
		
		c.setNoSpace().before(SEMICOLONRule);

        c.setLinewrap(1, 1, 2).after(artifactsRule);
        c.setLinewrap(1, 1, 2).after(propertyRule);
        c.setLinewrap(1, 1, 2).after(pojoDefinitionModelRule);
        c.setLinewrap(1, 1, 2).after(tableDefinitionModelRule);
        c.setLinewrap(1, 1, 2).after(procedureDefinitionModelRule);
        c.setLinewrap(1, 1, 2).after(functionDefinitionModelRule);
        c.setLinewrap(1, 1, 2).after(metaStatementRule);
        c.setLinewrap(1, 1, 2).after(mappingRuleRule);
        c.setLinewrap(1, 1, 2).after(optionalFeatureRule);
	}
}
