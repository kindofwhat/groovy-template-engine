package info.magnolia.groovy.blog.model

import groovy.transform.CompileStatic
import info.magnolia.jcr.util.NodeTypes
import info.magnolia.rendering.model.RenderingModel
import info.magnolia.rendering.model.RenderingModelImpl
import info.magnolia.rendering.template.RenderableDefinition

import javax.inject.Inject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

/**
 * model class for blog entry
 */
class BlogEntryModel
        extends RenderingModelImpl
{


    public BlogEntryModel(javax.jcr.Node content, RenderableDefinition definition, RenderingModel<?> parent) {
        super(content, definition, parent)
    }

    public String getLastChanged() {
        //return 'lala123'
        return new SimpleDateFormat("dd-MM-yyyy").format(NodeTypes.LastModified.getLastModified(node).time)
    }
}
