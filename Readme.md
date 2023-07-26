# Football data client

Generate api clients for https://www.football-data.org/

# Usage

Gradle

```kotlin
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/gplassard/football-data-client")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("GITHUB_ACTOR")
            password = project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation('fr.gplassard.footballdata:java-client:0.1.4')
}
```

```
// ~/.gradle/gradle.properties   
gpr.user=<github_username>
gpr.key=<github_registry_token>
```

# Commands

```bash
./gradlew release
./gradlew release -Prelease.useAutomaticVersion=true
./gradlew build
./gradlew clean java-web-client:publishToMavenLocal
./gradlew clean smithy:codegenJavaWebClient
```
