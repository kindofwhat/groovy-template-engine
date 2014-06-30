div(class:"col-sm-8 blog-main") {
    components.each {
        cmsComponent(it.getJCRNode())
    }
}
