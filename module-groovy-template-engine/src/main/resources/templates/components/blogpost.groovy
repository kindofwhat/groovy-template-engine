div(class:'blog-post') {
    h3(class: 'blog-post-title', 'lala')
    p(class:'blog-post-meta', "${rm.lastChanged}")
    decode content.text
}