import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("java")
    id("software.amazon.smithy").version("0.7.0")
    id("org.openapi.generator").version("6.6.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

sourceSets {
    main {
        java {
            include("src/main/smithy")
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("software.amazon.smithy:smithy-cli:1.32.0")
    implementation("software.amazon.smithy:smithy-model:1.32.0")
    implementation("software.amazon.smithy:smithy-openapi:1.32.0")
    implementation("software.amazon.smithy:smithy-aws-traits:1.32.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.register<GenerateTask>("codegenJavaClient") {
    dependsOn("smithyBuildJar")
    generatorName.set("java")
    inputSpec.set("$buildDir/smithyprojections/smithy/source/openapi/FootballData.openapi.json")
    outputDir.set("$rootDir/java-client")
    configOptions.putAll(mapOf(
            "library" to "native",
            "groupId" to "fr.gplassard.footballdata",
            "artifactId" to "javaclient",
            "invokerPackage" to "fr.gplassard.footballdata.javaclient",
            "apiPackage" to "fr.gplassard.footballdata.javaclient.api",
            "modelPackage" to "fr.gplassard.footballdata.javaclient.model",
    ))
}


tasks.register("codegen") {
    dependsOn("codegenJavaClient")
}


tasks.test {
    useJUnitPlatform()
}
