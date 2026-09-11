import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.openapi.generator)
}

val generatedProjectDirectory = layout.buildDirectory.dir("openapi/generated")
val generatedSourceDirectory = generatedProjectDirectory.map { it.dir("src/main/kotlin") }
val schemaFile = layout.file(
    providers.gradleProperty("authentikSchemaPath")
        .map { path -> file(path) }
        .orElse(
            layout.buildDirectory.file("openapi/schema/authentik-2026.8.1.yml")
                .map { it.asFile },
        ),
)

openApiGenerate {
    generatorName.set("kotlin")
    library.set("jvm-retrofit2")
    inputSpec.set(schemaFile)
    outputDir.set(generatedProjectDirectory)
    cleanupOutput.set(true)
    packageName.set("dev.greyfoundry.authentik.generated")
    apiPackage.set("dev.greyfoundry.authentik.generated.api")
    modelPackage.set("dev.greyfoundry.authentik.generated.model")
    configOptions.set(
        mapOf(
            "dateLibrary" to "java8",
            "enumPropertyNaming" to "UPPERCASE",
            "enumUnknownDefaultCase" to "true",
            "generateOneOfAnyOfWrappers" to "true",
            "hideGenerationTimestamp" to "true",
            "serializationLibrary" to "kotlinx_serialization",
            "sourceFolder" to "src/main/kotlin",
            "useCoroutines" to "true",
            "useResponseAsReturnType" to "true",
        ),
    )
    globalProperties.set(
        mapOf(
            "apiDocs" to "false",
            "apiTests" to "false",
            "modelDocs" to "false",
            "modelTests" to "false",
        ),
    )
    typeMappings.set(
        mapOf(
            "AnyType" to "JsonElement",
            "object" to "JsonElement",
        ),
    )
    importMappings.set(
        mapOf("JsonElement" to "kotlinx.serialization.json.JsonElement"),
    )
}

tasks.register<Sync>("generateAuthentikApi") {
    group = "openapi tools"
    description = "Regenerates the committed authentik transport sources."
    dependsOn(tasks.named("openApiGenerate"))
    from(generatedSourceDirectory)
    exclude("**/auth/**", "**/infrastructure/ApiClient.kt")
    filter { line: String -> line.replace(">()()", ">()").trimEnd() }
    into(layout.projectDirectory.dir("src/main/kotlin"))
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.kotlinx.serialization)
    implementation(libs.retrofit.converter.scalars)
}
