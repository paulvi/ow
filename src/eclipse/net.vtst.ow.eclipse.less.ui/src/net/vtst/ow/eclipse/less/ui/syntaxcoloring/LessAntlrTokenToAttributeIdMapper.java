// net.vtst.ow.eclipse.less: An Eclipse module for LESS (http://lesscss.org)
// (c) Vincent Simonet, 2011.  All rights reserved.

package net.vtst.ow.eclipse.less.ui.syntaxcoloring;

import net.vtst.eclipse.easyxtext.ui.syntaxcoloring.EasyAntlrTokenToAttributeIdMapper;
import net.vtst.ow.eclipse.less.services.LessGrammarAccess;

import com.google.inject.Inject;

public class LessAntlrTokenToAttributeIdMapper extends EasyAntlrTokenToAttributeIdMapper {
  
  @Inject
  private LessGrammarAccess grammar;

  @Inject
  protected LessHighlightingConfiguration highlightingConfig;
  
  @Override
  public void configure() {
    setDefaultAttribute(highlightingConfig.DEFAULT);
    bindTerminalRule(grammar.getSTRINGRule(), highlightingConfig.STRING);
    bindTerminalRule(grammar.getML_COMMENTRule(), highlightingConfig.COMMENT);
    bindTerminalRule(grammar.getSL_COMMENTRule(), highlightingConfig.COMMENT);
    bindKeyword("@import", highlightingConfig.AT_KEYWORD);
    bindKeyword("@media", highlightingConfig.AT_KEYWORD);
    bindKeyword("@page", highlightingConfig.AT_KEYWORD);
    bindKeyword("@font-face", highlightingConfig.AT_KEYWORD);
    bindKeyword("@charset", highlightingConfig.AT_KEYWORD);
    bindKeyword("and", highlightingConfig.MEDIA_QUERY_KEYWORD);
    bindKeyword("only", highlightingConfig.MEDIA_QUERY_KEYWORD);
  }
}
