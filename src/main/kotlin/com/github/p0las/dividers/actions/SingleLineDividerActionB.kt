package com.github.p0las.dividers.actions

import com.github.p0las.dividers.settings.AppSettingsState
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.util.TextRange


class SingleLineDividerActionB : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        // Get all the required data from data keys
        // Editor and Project were verified in update(), so they are not null.
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val document = editor.document

        val primaryCaret = editor.caretModel.primaryCaret
        primaryCaret.selectLineAtCaret()
        val start = primaryCaret.selectionStart
        val end = primaryCaret.selectionEnd

        val range = TextRange(start,end)
        val text = editor.document.getText(range)
        val textTrimmed = text.trim()

        val settings: AppSettingsState = AppSettingsState.getInstance()

        val lineLength:Int = settings.lineLengthB.toInt()
        val dividerPattern = settings.dividerSymbolB
        val comment = settings.commentSymbol

        var margin:Int = 0
        for (i in text) {
            if (i == ' '){
                margin++
            }
            else{
                break
            }
        }
        val marginOffset = " ".repeat(margin)

        val length = (lineLength - textTrimmed.length - margin - 4)/2
        val line = dividerPattern.repeat(length/dividerPattern.length)
        val lineWithText = "$marginOffset$comment$line<  $textTrimmed  >$line$line".take(lineLength)

        WriteCommandAction.runWriteCommandAction(project
        ) { document.replaceString(start, end, "$lineWithText\n") }
        // De-select the text range that was just replaced
        primaryCaret.removeSelection()
    }

    /**
     * Sets visibility and enables this action menu item if:
     *
     *  * a project is open
     *  * an editor is active
     *  * some characters are selected
     *
     *
     * @param e Event related to this action
     */
    override fun update(e: AnActionEvent) {
        // Get required data keys
        val project = e.project
        val editor = e.getData(CommonDataKeys.EDITOR)
        // Set visibility and enable only in case of existing project and editor

        e.presentation.isEnabledAndVisible = project != null && editor != null // && editor.selectionModel.hasSelection()
    }
}