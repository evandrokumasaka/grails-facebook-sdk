// configuration for plugin testing - will not be included in the plugin zip

log4j = {
		error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
					 'org.codehaus.groovy.grails.web.pages', //  GSP
					 'org.codehaus.groovy.grails.web.sitemesh', //  layouts
					 'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
					 'org.codehaus.groovy.grails.web.mapping', // URL mapping
					 'org.codehaus.groovy.grails.commons', // core / classloading
					 'org.codehaus.groovy.grails.plugins', // plugins
					 'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
					 'org.springframework',
					 'org.hibernate',
					 'net.sf.ehcache.hibernate'

		warn   'org.mortbay.log'
}

// Disable SVN for plugin release
grails.release.scm.enabled = false

grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"