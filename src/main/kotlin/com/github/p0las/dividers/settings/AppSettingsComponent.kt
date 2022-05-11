// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.p0las.dividers.settings

import javax.swing.JPanel
import com.intellij.ui.components.JBTextField
import com.intellij.ui.components.JBCheckBox
import com.intellij.util.ui.FormBuilder
import com.intellij.ui.components.JBLabel
import javax.swing.JComponent

/**
 * Supports creating and managing a [JPanel] for the Settings Dialog.
 */
class AppSettingsComponent {
    val panel: JPanel
    private val myCommentText = JBTextField()
    private val myLineLength = JBTextField()
    private val myDividerText = JBTextField()
    private val myLineLengthB = JBTextField()
    private val myDividerTextB = JBTextField()
    private val myLineLengthC = JBTextField()
    private val myDividerTextC = JBTextField()


    init {
        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("comment symbol: "), myCommentText, 1, false)
                .addLabeledComponent(JBLabel("line length: "), myLineLength, 1, false)
                .addLabeledComponent(JBLabel("divider symbol: "), myDividerText, 1, false)
                .addLabeledComponent(JBLabel("line length B: "), myLineLengthB, 1, false)
                .addLabeledComponent(JBLabel("divider symbol B: "), myDividerTextB, 1, false)
            .addLabeledComponent(JBLabel("triple line length: "), myLineLengthC, 1, false)
            .addLabeledComponent(JBLabel("triple divider symbol: "), myDividerTextC, 1, false)
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

    var lineLengthB: String
        get() = myLineLengthB.text
        set(newText) {
            myLineLengthB.text = newText
        }

    var dividerTextB: String
        get() = myDividerTextB.text
        set(newText) {
            myDividerTextB.text = newText
        }
    var lineLengthC: String
        get() = myLineLengthC.text
        set(newText) {
            myLineLengthC.text = newText
        }

    var dividerTextC: String
        get() = myDividerTextC.text
        set(newText) {
            myDividerTextC.text = newText
        }
}