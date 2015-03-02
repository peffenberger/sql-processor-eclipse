package org.sqlproc.meta.ui.syntaxcoloring;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.sqlproc.meta.parser.antlr.internal.InternalProcessorMetaLexer;

public class TokenToIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

    private static final Set<Integer> punctations = new HashSet<Integer>();
    static {
        punctations.add(InternalProcessorMetaLexer.RULE_IDENT_DOT);
        punctations.add(InternalProcessorMetaLexer.RULE_IDENT);
        punctations.add(InternalProcessorMetaLexer.RULE_NUMBER);
        punctations.add(InternalProcessorMetaLexer.RULE_ESC_CHAR);
        punctations.add(InternalProcessorMetaLexer.RULE_AND);
        punctations.add(InternalProcessorMetaLexer.RULE_OR);
        punctations.add(InternalProcessorMetaLexer.RULE_COLON);
        punctations.add(InternalProcessorMetaLexer.RULE_SEMICOLON);
        punctations.add(InternalProcessorMetaLexer.RULE_STRING);
        punctations.add(InternalProcessorMetaLexer.RULE_COMMA);
        punctations.add(InternalProcessorMetaLexer.RULE_MINUS);
        punctations.add(InternalProcessorMetaLexer.RULE_PLUS);
        punctations.add(InternalProcessorMetaLexer.RULE_LPAREN);
        punctations.add(InternalProcessorMetaLexer.RULE_RPAREN);
        punctations.add(InternalProcessorMetaLexer.RULE_LBRACE);
        punctations.add(InternalProcessorMetaLexer.RULE_RBRACE);
        punctations.add(InternalProcessorMetaLexer.RULE_QUESTI);
        punctations.add(InternalProcessorMetaLexer.RULE_NOT);
        punctations.add(InternalProcessorMetaLexer.RULE_BAND);
        punctations.add(InternalProcessorMetaLexer.RULE_BOR);
        punctations.add(InternalProcessorMetaLexer.RULE_HASH);
        punctations.add(InternalProcessorMetaLexer.RULE_AT);
        punctations.add(InternalProcessorMetaLexer.RULE_CARET);
        punctations.add(InternalProcessorMetaLexer.RULE_EQUALS);
        punctations.add(InternalProcessorMetaLexer.RULE_LESS_THAN);
        punctations.add(InternalProcessorMetaLexer.RULE_MORE_THAN);
        punctations.add(InternalProcessorMetaLexer.RULE_PERCENT);
        punctations.add(InternalProcessorMetaLexer.RULE_DOT);

        punctations.add(InternalProcessorMetaLexer.RULE_REST);
    }

    private static final Set<String> types = new HashSet<String>();
    static {
        types.add("'QRY'");
        types.add("'CRUD'");
        types.add("'CALL'");
        types.add("'OUT'");
        types.add("'OPT'");
        types.add("'LOPT'");
        types.add("'IOPT'");
        types.add("'SOPT'");
        types.add("'BOPT'");
        types.add("'MOPT'");
    }

    private static final Set<String> keywords = new HashSet<String>();
    static {
        keywords.add("'pojo'");
        keywords.add("'table'");
        keywords.add("'procedure'");
        keywords.add("'function'");
        keywords.add("'package'");
        keywords.add("'import'");
        keywords.add("'implements'");
        keywords.add("'extends'");
        keywords.add("'onlyPojos'");
        keywords.add("'onlyDaos'");
        keywords.add("'exceptPojos'");
        keywords.add("'exceptDaos'");
        keywords.add("'final'");
        keywords.add("'abstract'");
        keywords.add("'enum'");
        keywords.add("'dao'");
    }

    @Override
    protected String calculateId(String tokenName, int tokenType) {
        if (punctations.contains(tokenType))
            return HighlightingConfiguration.PUNCTATION;

        if (tokenType == InternalProcessorMetaLexer.RULE_ML_COMMENT
                || tokenType == InternalProcessorMetaLexer.RULE_SL_COMMENT)
            return HighlightingConfiguration.COMMENT;

        if (types.contains(tokenName))
            return HighlightingConfiguration.TYPE;

        if (keywords.contains(tokenName))
            return HighlightingConfiguration.KEYWORD;

        return HighlightingConfiguration.DEFAULT;
    }
}
