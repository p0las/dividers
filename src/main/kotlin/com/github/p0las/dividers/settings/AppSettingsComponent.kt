// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.p0las.dividers.settings

import javax.swing.JPanel
import com.intellij.ui.components.JBTextField
import com.intellij.ui.components.JBCheckBox
import com.intellij.util.ui.FormBuilder
import com.intellij.ui.components.JBLabel
import java.io.File
import javax.swing.JComponent

/**
 * Supports creating and managing a [JPanel] for the Settings Dialog.
 */
class AppSettingsComponent {
    val panel: JPanel
    private val myCommentText = JBTextField()
    private val myLineLength = JBTextField()
    private val myDividerText = JBTextField()


    init {
        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("comment symbol: "), myCommentText, 1, false)
                .addLabeledComponent(JBLabel("line length: "), myLineLength, 1, false)
                .addLabeledComponent(JBLabel("divider symbol: "), myDividerText, 1, false)
                .addComponentFillVertically(JPanel(), 0)
                .panel
    }

    val preferredFocusedComponent: JComponent
        get() = myCommentText

    var commentText: String
        get() = myCommentText.text
        set(newText) {
            myCommentText.text = newText
        }

    var lineLength: String
        get() = myLineLength.text
        set(newText) {
            myLineLength.text = newText
        }

    var dividerText: String
        get() = myDividerText.text
        set(newText) {
            myDividerText.text = newText
        }

}