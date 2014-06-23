yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        meta('http-equiv':'"Content-Type" content="text/html; charset=utf-8"')
        cmsInit()
        title('My page')
    }
    body {
        p("The title is ${content.title}")
        p("content: ${c.name}")
        cmsArea('area1')
    }
}

