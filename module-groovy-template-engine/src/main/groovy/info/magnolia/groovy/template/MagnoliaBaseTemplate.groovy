package info.magnolia.groovy.template

import groovy.text.markup.BaseTemplate
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic
import info.magnolia.objectfactory.Components
import info.magnolia.rendering.engine.RenderingEngine
import info.magnolia.templating.elements.AreaElement
import info.magnolia.templating.elements.ComponentElement
import info.magnolia.templating.elements.InitElement
import info.magnolia.templating.functions.TemplatingFunctions
import info.magnolia.util.EscapeUtil

import javax.jcr.Node as JcrNode

/**
 * Adds some Magnolia specific methods
 */
@CompileStatic
class MagnoliaBaseTemplate extends BaseTemplate {
    MagnoliaBaseTemplate(MarkupTemplateEngine templateEngine, Map model, Map<String, String> modelTypes, TemplateConfiguration configuration) {
        super(templateEngine, model, modelTypes, configuration)
    }

    @Override
    Object run() {
        return null
    }

    /**
     * equivalent to a @cms.init call
     */
    public BaseTemplate cmsInit() throws IOException {
        InitElement element = Components.getComponentProvider().newInstance(InitElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.begin(out)
        element.end(out)
        return this
    }

    /**
     * equivalent to a @cms.area call
     */
    public void cmsArea(String name) throws IOException {
        AreaElement element = Components.getComponentProvider().newInstance(AreaElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.name=name
        element.begin(out)
        element.end(out)
    }


    /**
     * equivalent to a @cms.component call
     */
    public void cmsComponent(Object content, Map<String, Object> contextAttributes=null) throws IOException {
        ComponentElement element = Components.getComponentProvider().newInstance(ComponentElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.content = content as JcrNode
        if(contextAttributes) element.contextAttributes = contextAttributes
        element.begin(out)
        element.end(out)
    }

    @Override
    public Object methodMissing(String tagName, Object args) throws IOException {
        return super.methodMissing(tagName,args)
    }


    /**
     * decodes this string
     * @param obj the object to be rendered unescaped
     * @return this template instance
     * @throws IOException
     */
    public BaseTemplate decode(Object obj) throws IOException {
        return yieldUnescaped(EscapeUtil.unescapeXss(obj.toString()));
    }


}
