rootProject.name = "springboot-gradle-"

fun defineSubProject(name: String, path: String) {
    include(name)
    project(":$name").projectDir = file(path)
}

defineSubProject("app", "app")