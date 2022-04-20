package com.github.p0las.dividers.settings

import com.intellij.openapi.options.Configurable
import org.jetbrains.annotations.Nls
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
        return modified
    }

    override fun apply() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        settings.commentSymbol = mySettingsComponent!!.commentText
        settings.lineLength = mySettingsComponent!!.lineLength
        settings.dividerSymbol = mySettingsComponent!!.dividerText
    }

    override fun reset() {
        val settings: AppSettingsState = AppSettingsState.getInstance()
        mySettingsComponent!!.commentText = settings.commentSymbol
        mySettingsComponent!!.lineLength = settings.lineLength
        mySettingsComponent!!.dividerText = settings.dividerSymbol
    }

    override fun disposeUIResources() {
        mySettingsComponent = null
    }
}