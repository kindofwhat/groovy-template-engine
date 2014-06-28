yieldUnescaped '<!DOCTYPE html>'
html(lang:'en') {
    head {
        cmsInit()
        meta('http-equiv':'Content-Type', 'content':'text/html; charset=utf-8')
        meta('charset':'utf-8')
        meta('http-equiv':'X-UA-Compatible', 'content': 'IE=edge')
        meta('name':'viewport', 'content': 'width=device-width, initial-scale=1')
        link('rel': 'stylesheet', 'type':'text/css', 'href':"${ctx.contextPath?:''}/.resources/groovy-template-engine/css/bootstrap.min.css");
        link('rel': 'stylesheet', 'type':'text/css', 'href':"${ctx.contextPath?:''}/.resources/groovy-template-engine/css/blog.css");
        title("${content.title}")
    }
    body {
//write out html if you feel like it ...
        yieldUnescaped """
    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="#m">Home</a>
          <a class="blog-nav-item" href="#m">Menu 1</a>
          <a class="blog-nav-item" href="#m">Menu 2</a>
        </nav>
      </div>
    </div>
"""
        div('class':'container') {
            div('class':'blog-header') {
                h1('class':'blog-title', "${content.title}")
            }
            div('class': 'row') {
                cmsArea('area1')
            }
        }
    }
}

