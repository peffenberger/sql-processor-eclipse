/*
 * generated by Xtext
 */
package org.sqlproc.meta.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.sqlproc.meta.services.ProcessorMetaGrammarAccess;

public class ProcessorMetaParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private ProcessorMetaGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.sqlproc.meta.parser.antlr.internal.InternalProcessorMetaParser createParser(XtextTokenStream stream) {
		return new org.sqlproc.meta.parser.antlr.internal.InternalProcessorMetaParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Artifacts";
	}
	
	public ProcessorMetaGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(ProcessorMetaGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
