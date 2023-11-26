plugins {
    kotlin("jvm") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.testng:testng:7.4.0")
    implementation("junit:junit:4.13.1")
    testImplementation("io.cucumber:cucumber-java:7.14.0")
    implementation("org.python:jython-standalone:2.7.2")
    testImplementation("org.testng:testng:7.4.0")
}

tasks.register<JavaExec>("runCucumber") {
    classpath = sourceSets.getByName("test").runtimeClasspath
    main = "io.cucumber.core.cli.Main"
    args = listOf(
        "--glue", "cucumberStepDefinitions",
        "--plugin", "html:$buildDir/reports/tests/runCucumber/index.html",
        "src/test/resources/cucumber/SimpleCalcScenarios.feature"
    )
}

tasks.test {
    useTestNG()
    reports {
        html.destination = file("$buildDir/reports/test")
        html.isEnabled = true // Enable HTML report generation
    }
}

tasks.register<Test>("runTestNG") {
    useTestNG() // Configure this task to use TestNG
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath
}

