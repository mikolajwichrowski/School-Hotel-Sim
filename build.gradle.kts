/*
 * Build gradle file
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Maven
    maven

    // Apply the application plugin to add support for building a CLI application
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
    mavenLocal()
}

dependencies {
    // This dependencies are used by the application.
    implementation("com.googlecode.json-simple:json-simple:1.1.1")

    // Use JUnit test framework
    testImplementation("junit:junit:4.12")
}

application {
    // Define the main class for the application
    mainClassName = "HHS_PROJGR6.App"
}