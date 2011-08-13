package org.xwiki.prettytime.internal;

import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.xwiki.component.annotation.Component;
import org.xwiki.context.Execution;
import org.xwiki.script.service.ScriptService;

import com.ocpsoft.pretty.time.PrettyTime;
import com.xpn.xwiki.XWikiContext;

@Component("prettyTime")
public class PrettyTimeScriptService implements ScriptService
{
    @Inject
    private Execution execution;

    public String format(Date date)
    {
        return this.format(date, this.getContextLanguage());
    }

    public String format(Date date, String language)
    {
        PrettyTime p = new PrettyTime(new Locale(language));
        return p.format(date);
    }

    private String getContextLanguage()
    {
        return ((XWikiContext) this.execution.getContext().getProperty("xwikicontext")).getLanguage();
    }

}
