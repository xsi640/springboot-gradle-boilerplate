rootProject.name = "springboot-gradle-"

pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    val springBootVersion: String by settings
    val springBootManagementVersion: String by settings

    plugins {
        id("java")
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springBootManagementVersion
        id("com.google.devtools.ksp") version kspVersion

        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("plugin.noarg") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
    }

    val user = System.getProperty("repoUser")
    val pwd = System.getProperty("repoPassword")

    repositories {
        mavenLocal()
        maven {
            credentials {
                username = user
                password = pwd
                isAllowInsecureProtocol = true
            }
            url = uri("http://172.16.11.231:8081/nexus/repository/maven2-group/")
        }
    }
}

fun defineSubProject(name: String, path: String) {
    include(name)
    project(":$name").projectDir = file(path)
}

defineSubProject("app", "app")