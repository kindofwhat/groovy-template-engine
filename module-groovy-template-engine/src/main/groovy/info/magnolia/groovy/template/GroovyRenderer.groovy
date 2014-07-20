package info.magnolia.groovy.template

import groovy.text.Template
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.text.markup.TemplateResolver
import groovy.transform.CompileStatic
import info.magnolia.commands.MgnlCommand
import info.magnolia.context.MgnlContext
import info.magnolia.rendering.context.RenderingContext
import info.magnolia.rendering.engine.RenderException
import info.magnolia.rendering.renderer.AbstractRenderer
import info.magnolia.rendering.template.RenderableDefinition

/**
 * The renderer itself
 */
@CompileStatic
class GroovyRenderer extends AbstractRenderer  {
    @Override
    protected Map<String, Object> newContext() {
        return new HashMap<String, Object>();
    }

    @Override
    protected void onRender(javax.jcr.Node content, RenderableDefinition definition, RenderingContext renderingCtx, Map<String, Object> ctx, String templateScript) throws RenderException {
        TemplateConfiguration config = new TemplateConfiguration()
        //TODO: make this configurable
        config.cacheTemplates=true
        config.autoIndent=true
        config.autoNewLine=true

        config.baseTemplateClass=MagnoliaBaseTemplate.class

        MarkupTemplateEngine engine = new MarkupTemplateEngine(config)

        Template template = engine.createTemplateByPath(templateScript);

        Map<String, Object> model = ctx
        //TODO: how to prevent overwriting already existing entries?
        model.rm = model.model
        model.c = content
        model.path= MgnlContext.contextPath

        Writable output = template.make(model)
        output.writeTo(renderingCtx.appendable)
    }

}
