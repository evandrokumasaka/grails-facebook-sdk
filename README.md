Facebook SDK Grails Plugin
==========================

[![Build Status](https://travis-ci.org/agorapulse/grails-facebook-sdk.svg)](https://travis-ci.org/agorapulse/grails-facebook-sdk)

# Introduction

The [Facebook Platform](http://developers.facebook.com/) is a set of APIs that make your application more social. Read more about [integrating Facebook with your web site](http://developers.facebook.com/docs/guides/web) on the Facebook developer site.

This project contains the open source **Grails Facebook SDK Plugin** that allows you to integrate the [Facebook Platform](http://developers.facebook.com/) on a website/app powered by [Grails](http://grails.org).

This plugin is a port of the official [Facebook PHP SDK](http://github.com/facebook/facebook-php-sdk) to [Grails 2.0](http://grails.org).

It supports the latest *OAuth2.0 authentication* (required since October 1st 2011).

**Grails Facebook SDK Plugin** provides the following Grails artefacts:

* **FacebookContext** - A Spring bean to get current Facebook context in controllers, when running [apps on Facebook.com](http://developers.facebook.com/docs/guides/canvas/) or [websites with the Facebook Platform](http://developers.facebook.com/docs/guides/web).
* **FacebookGraphClient** - A client to call [Facebook Graph API](http://developers.facebook.com/docs/reference/api/), which is a wrapper around the rock solid [RestFB java library](http://restfb.com/) version 1.6.10 (released September 03, 2012).
* **FacebookJSTagLib** - A collection of tags to easily integrate [Facebook JS SDK](http://developers.facebook.com/docs/reference/javascript/) in your GSPs.

**WARNING**: Facebook API v2.6 is now used by default.

# Installation

Declare the plugin dependency in the BuildConfig.groovvy file, as shown here:

```groovy
grails.project.dependency.resolution = {
		inherits("global") { }
		log "info"
		repositories {
				//your repositories
		}
		dependencies {
				//your regular dependencies
		}
		plugins {
				//here go your plugin dependencies
				runtime ':facebook-sdk:2.6.0'
		}
}
```


# Config

Create a Facebook app on [Facebook Developers](https://developers.facebook.com/apps), in order to get your own app ID and app secret.

Add your Facebook app parameters to your _grails-app/conf/Config.groovy_:

```groovy
grails.plugin.facebooksdk.app.id = {APP_ID}
grails.plugin.facebooksdk.app.permissions = {APP_PERMISSIONS} // Ex. ['email','user_photos']
grails.plugin.facebooksdk.app.secret = {APP_SECRET}
```

By default, latest Graph API v2.5 will be used.
You can override default settings with `apiVersion` setting:

```groovy
grails.plugin.facebooksdk.apiVersion = 'v2.3'
```

Since FacebookContext should be instantiated at each request, you must use `prototype` scope for your Controllers (since Grails 2.3, generated Config.groovy defines `singleton` as default scope).

```groovy
grails.controllers.defaultScope = 'prototype'
```

Default jQuery selector is `$`, if you require another one, you can define it globally in your _grails-app/conf/Config.groovy_:

```groovy
grails.plugin.facebooksdk.customSelector = 'jQuery'
```

# Getting started with a demo app

If you want to quickly run the SDK on a demo app, you can download [Facebook SDK Grails - Demo](https://github.com/agorapulse/grails-facebook-sdk-demo).


# Documentation

Project documentation is located here :

* [Reference Documentation (Page per chapter)](http://agorapulse.github.io/grails-facebook-sdk/guide)
* [Reference Documentation (Single page)](http://agorapulse.github.io/grails-facebook-sdk/guide/single.html)
* [Groovy API docs](http://agorapulse.github.io/grails-facebook-sdk/gapi/)

# Latest releases

WARNING: Since V2.6.0, Facebook Graph API v2.6 will be used. Make sure that your app is compatible with [v2.6 upgrade](https://developers.facebook.com/docs/apps/upgrading).
Use `grails.plugin.facebooksdk.apiVersion = v2.3` to override default behaviour.

* 2016-06-23 **V2.6.0** : v2.6 Facebook Graph API support (from now on, used by default) + RestFB dependency updated to 1.24.0
* 2015-10-30 **V2.5.0** : v2.5 Facebook Graph API support (from now on, used by default) + RestFB dependency updated to 1.16.0
* 2015-05-04 **V2.3.0** : v2.3 Facebook Graph API support (from now on, used by default) + RestFB dependency updated to 1.10.1
* 2015-02-16 **V2.2.2** : bug fix for apiVersion in FacebookGraphClient
* 2015-01-08 **V2.2.1** : minor bug fix for token for business parsing
* 2014-11-16 **V2.2.0** : v2.2 Facebook Graph API support (from now on, used by default) + RestFB dependency updated to 1.7.0
* 2014-10-08 **V2.1.0** : v2.1 Facebook Graph API support + RestFB dependency updated to 1.6.16
* 2014-07-28 **V2.0.0** : v2.0 Facebook Graph API support
* 2014-05-23 **V0.6.4** : _version_ attribute added to initJS tag to choose API version for Facebook JS SDK (v1.0 or v2.0)
* 2014-05-19 **V0.6.3** : customSelector attribute and config param added to tag lib
* 2014-04-28 **V0.6.2** : bug fix in FacebookContext (use @PostConstruct instead of InitializingBean) to solve reloading issue since Grails 2.3.7 (GRAILS-7799)
* 2014-04-04 **V0.6.1** : TagLib update (scripts are only included once in a page even if tags are used more than once)
* 2014-04-02 **V0.6.0** : Resources Grails Plugin dependencies removed (to be compatible with Asset Pipeline Grails Plugin)
* 2014-02-12 **V0.5.0** : RestFB dependency updated to 1.6.14
* 2013-12-21 **V0.4.14** : bug fix init-js link tag (raw encoding directive added for Grails 2.3 compatibility)
* 2013-12-06 **V0.4.13** : bug fix in picture tag (secure mode)
* 2013-06-05 **V0.4.12** : bug fix in sendLink tag (callback attribute)
* 2013-05-28 **V0.4.11** : _tokenRetrievalRetryCount_ config parameter added + doc update
* 2013-04-03 **V0.4.10** : RestFB dependency updated to 1.6.12 + bug fix token exchange
* 2013-03-19 **V0.4.9** : bug fix token exchange from code with concurrent requests (thanks to [elegorod](https://github.com/elegorod))
* 2013-01-03 **V0.4.8** : bug fix token expiration time handling (in Facebook Page tabs)
* 2012-12-20 **V0.4.7** : bug fix resources definition
* 2012-12-07 **V0.4.6** : bug fix in invite/publish/send tags (encode text as HTML in attributes)
* 2012-12-05 **V0.4.5** : bug fix in _FacebookSignedRequest_ appData property
* 2012-11-15 **V0.4.4** : for photo/video publishing, _FacebookGraphClient_ _publish_ method accepts now _InputStream_ argument type (instead of _FileInputStream_ only)
* 2012-10-29 **V0.4.3** : tag lib improvements: channel integration (_initJS_ tag and _FacebookSdkController_ created), resources plugin integration (_FacebookSdkResources_ created)
* 2012-10-10 **V0.4.2** : bug fix in batch responses error handling
* 2012-09-25 **V0.4.1** : bug fix in server side OAuth redirect
* 2012-09-25 **V0.4.0** : complete refactoring to improve SDK architecture ([FacebookContext](http://agorapulse.github.io/grails-facebook-sdk/guide/facebookContext.html) implemented) and [multiple apps support](http://agorapulse.github.io/grails-facebook-sdk/guide/configuration.html) added
* 2012-09-03 **V0.3.6** : RestFB dependency updated to 1.6.10, _proxyHost_ and _proxyPort_ added to config and _signedRequest_ added to filter _facebook_ map
* 2012-08-24 **V0.3.5** : _proxyHost_ and _proxyPort_ parameters added to Graph/Rest client (thanks to Eduard Martini)
* 2012-07-23 **V0.3.4** : bug fix in facebookAppService
* 2012-07-17 **V0.3.3** : readTimeout parameter added to Graph/Rest client + upgrade to Grails 2.1 with wrapper
* 2012-06-12 **V0.3.2** : bug fix in filter and plugin config
* 2012-06-12 **V0.3.1** : package _grails.plugins.facebooksdk_ renamed to _grails.plugin.facebooksdk_
* 2012-06-08 **V0.3.0** : new documentation based on GDoc, FacebookRestClient added + bug fixes


# Bugs

To report any bug, please use the project [Issues](http://github.com/benorama/grails-facebook-sdk/issues) section on GitHub.

# Feedback

The **Grails Facebook SDK** is not an official Facebook SDK such as [Javascript](http://developers.facebook.com/docs/reference/javascript/), [PHP](http://github.com/facebook/facebook-php-sdk), [iOS](http://github.com/facebook/facebook-ios-sdk/) and [Android SDKs](http://github.com/facebook/facebook-android-sdk).

It is developed by [AgoraPulse](http://www.agorapulse.com).

The **Grails Facebook SDK** is licensed under the [Apache Licence, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
