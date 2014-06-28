div {

    p("Here be an Area, and where are se components?!?")

    components.each {
        cmsComponent(it.getJCRNode())
    }
}
