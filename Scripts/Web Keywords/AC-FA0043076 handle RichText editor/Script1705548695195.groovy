import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.charset.Charset

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.FileUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

def normalText = 'This is a normal text !!!'
def basicHTML = var_basicHTML

//WebUI.openBrowser(GlobalVariable.sampleAUTRichTextEditorReact)
WebUI.openBrowser('https://prosemirror.net')
//
//TestObject richTextEditor = findTestObject('Page_Rich Text Editor TinyMCE/txt_RichText_textbox')
TestObject richTextEditor = findTestObject('Object Repository/Page_ProseMirror/div__ProseMirror ProseMirror-example-setup-_4bc0b4')
//
//Set a normal text to Rich Text editor
WebUI.setText(richTextEditor, normalText)

String getNormalText = WebUI.getText(richTextEditor)

WebUI.verifyMatch(getNormalText, normalText, false)

//Set a basic HTML content to Rich Text editor
WebUI.setText(richTextEditor, var_basicHTML_proemirror)

//Get the innerHTML of the content exists in the editor after input text
getBasicHTML = CustomKeywords.'katalon.helper.ObjectHelper.getFrameOjectAttributeValue'(richTextEditor, var_attributeName)

//Verify that the output text is the expected one
WebUI.verifyMatch(getBasicHTML, var_basicHTML_proemirror, false)

//Navigate to a different Website to continue testing
WebUI.navigateToUrl(GlobalVariable.sampleAUTRichTextEditorReact)

WebUI.waitForPageLoad(5)

TestObject bodyTinyEditor = findTestObject('Page_Best WYSIWYG React Rich Text Editor TinyMCE/bodytinymce')

//assign a paragraph to set to the editor from a file
def multipleHTML = CustomKeywords.'katalon.helper.FileHelper.getFileValue'('Data Files/aParagraph.txt')

WebUI.setText(bodyTinyEditor, multipleHTML)

//Get the innerHTML of the paragraph exists in the editor after input text
def getMultipleHTML = CustomKeywords.'katalon.helper.ObjectHelper.getFrameOjectAttributeValue'(bodyTinyEditor, var_attributeName)

WebUI.verifyMatch(getMultipleHTML, multipleHTML, false)

//Define an HTML tag for input an image link
def anImageLink = var_anImageLinkValue

WebUI.refresh()

WebUI.waitForPageLoad(5)

WebUI.setText(bodyTinyEditor, anImageLink)

//Get the innerHTML of the image exists in the editor after input
def getAnImageLink = CustomKeywords.'katalon.helper.ObjectHelper.getFrameOjectAttributeValue'(bodyTinyEditor, var_attributeName)

//Verify that the HTML value of the output is the same with the input HTML
WebUI.verifyMatch(getAnImageLink, anImageLink, false)

//Define an HTML tag for input a base64 image
def aBase64Image = '<p><img src="data:image/png;base64, iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAYAAACNbyblAAAAHElEQVQI12P4//8/w38GIAXDIBKE0DHxgljNBAAO9TXL0Y4OHwAAAABJRU5ErkJggg==" alt="Red dot"></p>'

WebUI.refresh()

WebUI.waitForPageLoad(5)

WebUI.setText(bodyTinyEditor, aBase64Image)

//Get the innerHTML of the image exists in the editor after input
def getABase64Image = CustomKeywords.'katalon.helper.ObjectHelper.getFrameOjectAttributeValue'(bodyTinyEditor, var_attributeName)

//Verify that the HTML value of the output is the same with the input HTML
WebUI.verifyMatch(getABase64Image, aBase64Image, false)
