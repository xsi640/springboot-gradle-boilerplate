import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
}

val bootJar: BootJar by tasks
bootJar.enabled = true