package com.github.p0las.dividers.services

import com.intellij.openapi.project.Project
import com.github.p0las.dividers.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
