/**
 * generated by Xtext
 */
package org.sqlproc.dsl.formatting;

import com.google.inject.Inject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.xbase.lib.Extension;
import org.sqlproc.dsl.services.ProcessorDslGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class ProcessorDslFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private ProcessorDslGrammarAccess _processorDslGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    FormattingConfig.LinewrapLocator _setLinewrap = c.setLinewrap(0, 1, 2);
    TerminalRule _sL_COMMENTRule = this._processorDslGrammarAccess.getSL_COMMENTRule();
    _setLinewrap.before(_sL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_1 = c.setLinewrap(0, 1, 2);
    TerminalRule _mL_COMMENTRule = this._processorDslGrammarAccess.getML_COMMENTRule();
    _setLinewrap_1.before(_mL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_2 = c.setLinewrap(0, 1, 1);
    TerminalRule _mL_COMMENTRule_1 = this._processorDslGrammarAccess.getML_COMMENTRule();
    _setLinewrap_2.after(_mL_COMMENTRule_1);
    FormattingConfig.NoSpaceLocator _setNoSpace = c.setNoSpace();
    TerminalRule _sEMICOLONRule = this._processorDslGrammarAccess.getSEMICOLONRule();
    _setNoSpace.before(_sEMICOLONRule);
    FormattingConfig.LinewrapLocator _setLinewrap_3 = c.setLinewrap(1, 1, 2);
    ParserRule _artifactsRule = this._processorDslGrammarAccess.getArtifactsRule();
    _setLinewrap_3.after(_artifactsRule);
    FormattingConfig.LinewrapLocator _setLinewrap_4 = c.setLinewrap(1, 1, 2);
    ParserRule _propertyRule = this._processorDslGrammarAccess.getPropertyRule();
    _setLinewrap_4.after(_propertyRule);
    FormattingConfig.LinewrapLocator _setLinewrap_5 = c.setLinewrap(1, 1, 2);
    ParserRule _pojoDefinitionRule = this._processorDslGrammarAccess.getPojoDefinitionRule();
    _setLinewrap_5.after(_pojoDefinitionRule);
    FormattingConfig.LinewrapLocator _setLinewrap_6 = c.setLinewrap(1, 1, 2);
    ParserRule _tableDefinitionRule = this._processorDslGrammarAccess.getTableDefinitionRule();
    _setLinewrap_6.after(_tableDefinitionRule);
    FormattingConfig.LinewrapLocator _setLinewrap_7 = c.setLinewrap(1, 1, 2);
    ParserRule _procedureDefinitionRule = this._processorDslGrammarAccess.getProcedureDefinitionRule();
    _setLinewrap_7.after(_procedureDefinitionRule);
    FormattingConfig.LinewrapLocator _setLinewrap_8 = c.setLinewrap(1, 1, 2);
    ParserRule _functionDefinitionRule = this._processorDslGrammarAccess.getFunctionDefinitionRule();
    _setLinewrap_8.after(_functionDefinitionRule);
    FormattingConfig.LinewrapLocator _setLinewrap_9 = c.setLinewrap(1, 1, 2);
    ParserRule _metaStatementRule = this._processorDslGrammarAccess.getMetaStatementRule();
    _setLinewrap_9.after(_metaStatementRule);
    FormattingConfig.LinewrapLocator _setLinewrap_10 = c.setLinewrap(1, 1, 2);
    ParserRule _mappingRuleRule = this._processorDslGrammarAccess.getMappingRuleRule();
    _setLinewrap_10.after(_mappingRuleRule);
    FormattingConfig.LinewrapLocator _setLinewrap_11 = c.setLinewrap(1, 1, 2);
    ParserRule _optionalFeatureRule = this._processorDslGrammarAccess.getOptionalFeatureRule();
    _setLinewrap_11.after(_optionalFeatureRule);
    FormattingConfig.LinewrapLocator _setLinewrap_12 = c.setLinewrap(1, 1, 2);
    ParserRule _packageRule = this._processorDslGrammarAccess.getPackageRule();
    _setLinewrap_12.after(_packageRule);
  }
}
