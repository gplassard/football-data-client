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


tasks.register("codegen") {
    dependsOn("smithyBuildJar")
}


tasks.test {
    useJUnitPlatform()
}
