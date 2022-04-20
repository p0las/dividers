package com.github.p0las.dividers.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
import java.io.File
import javax.swing.JComponent


/**
 * Provides controller functionality for application settings.
 */
class ApplicationSettingsConfigurable : Configurable {
    private var mySettingsComponent: AppSettingsComponent? = null

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP
    override fun getDisplayName(): @Nls(capitalization = Nls.Capitalization.Title) String? {
        return "Dividers Settings"
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return mySettingsComponent!!.preferredFocusedComponent
    }

    override fun createComponent(): JComponent? {
        mySettingsComponent = AppSettingsComponent()
        return mySettingsComponent!!.panel
    }

    override fun isModified(): Boolean {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        var modified = mySettingsComponent!!.commentText != settings.commentSymbol
        modified = modified or (mySettingsComponent!!.lineLength != settings.lineLength)
        modified = modified or (mySettingsComponent!!.dividerText != settings.dividerSymbol)
        File("c:/temp/divider.log").appendText("isModified\n")
        File("c:/temp/divider.log").appendText(modified.toString())
        File("c:/temp/divider.log").appendText("\n")
        return modified
    }

    override fun apply() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        settings.commentSymbol = mySettingsComponent!!.commentText
        settings.lineLength = mySettingsComponent!!.lineLength
        settings.dividerSymbol = mySettingsComponent!!.dividerText
        File("c:/temp/divider.log").appendText("apply\n")
        File("c:/temp/divider.log").appendText(settings.commentSymbol)
        File("c:/temp/divider.log").appendText("\n")
    }

    override fun reset() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        mySettingsComponent!!.commentText = settings.commentSymbol
        mySettingsComponent!!.lineLength = settings.lineLength
        mySettingsComponent!!.dividerText = settings.dividerSymbol
        File("c:/temp/divider.log").appendText("reset\n")
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}