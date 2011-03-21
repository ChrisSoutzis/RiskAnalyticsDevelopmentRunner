import org.apache.ivy.plugins.resolver.FileSystemResolver

grails.project.dependency.resolution = {
    inherits "global" // inherit Grails' default dependencies
    log "warn"

    repositories {
        grailsHome()
        grailsCentral()
    }

    def ulcClientJarResolver = new FileSystemResolver()
    String absolutePluginDir = grailsSettings.projectPluginsDir.absolutePath

    ulcClientJarResolver.addArtifactPattern "${absolutePluginDir}/ulc-[revision]/web-app/lib/[artifact].[ext]"
    ulcClientJarResolver.name = "ulc"

    resolver ulcClientJarResolver

    mavenRepo "https://build.intuitive-collaboration.com/maven/plugins/"

    String ulcVersion = "2008-u4-4.1"

    plugins {
        runtime ":background-thread:1.3"
        runtime ":hibernate:1.3.7"
        runtime ":joda-time:0.5"
        runtime ":maven-publisher:0.7.5"
        runtime ":quartz:0.4.1"
        runtime ":spring-security-core:1.0.1"
        runtime ":jetty:1.2-SNAPSHOT"

        runtime "org.pillarone:jasper:0.9.5-riskanalytics"
        compile "com.canoo:ulc:${ulcVersion}"
    }

    dependencies {
        compile group: 'canoo', name: 'ulc-applet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-trusted', version: ulcVersion
        compile group: 'canoo', name: 'ulc-ejb-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-jnlp-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-servlet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-standalone-client', version: ulcVersion
    }

}

//Change paths to desired risk analytics plugin locations
grails.plugin.location.'risk-analytics-core' = "../RiskAnalyticsCore"
grails.plugin.location.'risk-analytics-application' = "../RiskAnalyticsApplication"
grails.plugin.location.'risk-analytics-life' = "../RiskAnalyticsLife"
grails.plugin.location.'risk-analytics-pc' = "../RiskAnalyticsPC"
