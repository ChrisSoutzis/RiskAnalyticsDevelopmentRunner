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

    String ulcVersion = "ria-suite-u5"

    plugins {
        runtime ":background-thread:1.3"
        runtime ":hibernate:1.3.7"
        runtime ":joda-time:0.5"
        runtime ":maven-publisher:0.7.5"
        runtime ":quartz:0.4.2"
        runtime ":spring-security-core:1.1.2"
        runtime ":jetty:1.2-SNAPSHOT"

        compile "com.canoo:ulc:${ulcVersion}"
        runtime "org.pillarone:pillar-one-ulc-extensions:0.2"
    }

    dependencies {
        compile group: 'canoo', name: 'ulc-applet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-base-trusted', version: ulcVersion
        compile group: 'canoo', name: 'ulc-jnlp-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-servlet-client', version: ulcVersion
        compile group: 'canoo', name: 'ulc-standalone-client', version: ulcVersion
    }

}

//Change paths to desired risk analytics plugin locations
grails.plugin.location.'risk-analytics-core' = "../risk-analytics-core"
grails.plugin.location.'risk-analytics-application' = "../risk-analytics-application"
grails.plugin.location.'risk-analytics-life' = "../riskanalytics-life"
grails.plugin.location.'risk-analytics-pc' = "../risk-analytics-property-casualty"
grails.plugin.location.'risk-analytics-pc-cashflow' = "../risk-analytics-pc-cashflow"
grails.plugin.location.'risk-analytics-commons' = "../risk-analytics-commons"
grails.plugin.location.'art-models' = "../art-models"
//grails.plugin.location.'risk-analytics-graph-core' = "../RiskAnalyticsGraphCore"
//grails.plugin.location.'risk-analytics-graph-form-editor' = "../RiskAnalyticsGraphFormEditor"
