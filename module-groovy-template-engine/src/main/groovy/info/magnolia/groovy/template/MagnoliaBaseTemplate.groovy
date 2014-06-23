package info.magnolia.groovy.template

import com.google.inject.Inject
import groovy.text.markup.BaseTemplate
import groovy.text.markup.MarkupTemplateEngine
import groovy.text.markup.TemplateConfiguration
import groovy.transform.CompileStatic
import info.magnolia.cms.beans.config.ServerConfiguration
import info.magnolia.objectfactory.Components
import info.magnolia.rendering.engine.RenderingEngine
import info.magnolia.templating.elements.AreaElement
import info.magnolia.templating.elements.ComponentElement
import info.magnolia.templating.elements.InitElement

/**
 * Created by christian on 22.06.14.
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
     * equivalent to a @cms:init call
     */
    public BaseTemplate cmsInit() throws IOException {
        InitElement element = Components.getComponentProvider().newInstance(InitElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.begin(out)
        element.end(out)
        return this
    }

    /**
     * equivalent to a @cms:area call
     */
    public void cmsArea(String name) throws IOException {
        AreaElement element = Components.getComponentProvider().newInstance(AreaElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.name=name
        element.begin(out)
        element.end(out)
//        return this
    }


    public void cmsComponent(String name) throws IOException {
        ComponentElement element = Components.getComponentProvider().newInstance(ComponentElement.class,
                Components.getComponent(RenderingEngine.class).renderingContext)
        element.begin(out)
        element.end(out)
//        return this
    }



}
