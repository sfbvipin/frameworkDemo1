Dim objExcel
Dim objWorkbook
Dim objSheet
Dim rowCount
Dim strTestData
Dim intExecutionCount
Dim intTotCount
Dim strRunnerPath
Dim strRegression
Dim strTestSelected
Dim intExelonCount
Dim intEmersonCount
Dim strTestCaseName 

strExcelPath = "E:\eclipse-workspace\frameworkDemo\src\test\resources\CallingModule\RegressionTestSuite.xlsx"
strRunnerPath = "E:\eclipse-workspace\frameworkDemo\src\test\java\com\cucumber\runner\exelonRunner.java"
strbatPath = "E:\eclipse-workspace\frameworkDemo\src\test\resources\CallingModule\mvnCommand.bat"
strSheetName = "TestSuite"
strRegression = "@Regression"
strRunnerCompare = "monochrome=true"
strbatCompare = "mvn clean"
intExecutionCount = 0
intExelonCount = 0
intEmersonCount = 0
strCompareValue = "@Regression"

'-----------------------------------------------Calls------------------------------------------------------------------------


fnMainDriver()



'-----------------------------------------------Functions--------------------------------------------------------------------

'-------------------------------
'Function Name                :               fnMainDriver
'Variables                            :               sPath (Path of excel sheet)
'Description        :               This function is open excel workbook.
'-------------------------------
function fnMainDriver()
                fnOpenExcel strExcelPath,strSheetName
                fnRowCount()

                                intTotCount = rowCount - 1
                                for sloop = 2 to rowCount
                                                fnReadExcelCell sloop,7
                                                if strTestData = "Y" then 
                                                                intExecutionCount = intExecutionCount + 1
                                                                fnReadExcelCell sloop,2
                                                                if strTestData = "Exelon" then 
                                                                                intExelonCount = intExelonCount + 1
                                                                                
                                                                                if intExecutionCount = 1 then 
                                                                                                fnReadExcelCell sloop,6
                                                                                                strTestCaseName = strTestData
                                                                                elseif intExecutionCount = 2 and sloop > 2 then 
                                                                                                fnReadExcelCell sloop,6
                                                                                                strTestCaseName = "Sanity"                                                                        
                                                                                else 
                                                                                                fnReadExcelCell sloop,6
                                                                                                strTestCaseName = "Exelon"
                                                                                end if
                                                                else 
                                                                                intEmersonCount = intEmersonCount + 1
                                                                end if 
                                                end if 

                                next 
                                if intTotCount = intExecutionCount then 
                                                fnMessage "SHARP will run all cases now", 3, 48
                                                fnEditFile strRunnerPath, strCompareValue, strRegression, strRegression
                                                strTestSelected = strRegression
                                elseif intExelonCount <> 0 AND intEmersonCount = 0 then 
                                                fnMessage "SHARP will run only selected cases now", 3, 48
                                                fnEditFile strRunnerPath, strCompareValue, strRegression, "@"&strTestCaseName           
                                                strTestSelected = "@"&strTestCaseName             
                                                strCompareValue = "@"&strTestCaseName         
                                else
                                                msgbox "SHARP will run only selected cases now", 48, "SHARP"
                                                fnEditFile strRunnerPath, strCompareValue, strRegression, "@Sanity"
                                                strTestSelected = "@Sanity"
                                                strCompareValue = "@Sanity"
                                end if

                fnCloseExcel()
                fnKillProcess "EXCEL.EXE"


                fnRunBatchFile strbatPath
                fnEditFile strbatPath, strbatCompare, "clean", "test"
                fnRunBatchFile strbatPath
                fnEditFile strRunnerPath, strCompareValue, strTestSelected, strRegression
                fnEditFile strbatPath, "mvn test", "test", "clean"
                fnMessage "Test Execution Completed, Refer Report !!", 7, 64
end function




'-------------------------------
'Function Name 	:	fnOpenExcel
'Variables		:	sPath (Path of excel sheet)
'Description	:	This function is open excel workbook.
'-------------------------------
function fnOpenExcel(sPath,sSheetName)
	Set objExcel = CreateObject("Excel.Application")
	Set objWorkbook = objExcel.Workbooks.Open(sPath)
	Set objSheet=objWorkbook.Worksheets(strSheetName) 

	objExcel.Visible = True
end function


'-------------------------------
'Function Name 	:	fnCloseExcel
'Variables		:	None
'Description	:	This function is to close Excel and free up memory 
'-------------------------------
function fnCloseExcel()
	objWorkbook.Close
	objExcel.Quit

	Set objSheet = Nothing
	Set objWorkbook = Nothing
	Set objExcel = Nothing
end function


'-------------------------------
'Function Name 	:	fnRowCount
'Variables		:	None
'Description	:	This function is to read row count of the excel 
'-------------------------------
function fnRowCount()
	rowCount = objSheet.usedrange.rows.count 	
end function


'-------------------------------
'Function Name 	:	fnKillProcess
'Variables		:	strProcessName
'Description	:	This function is to kill any process in order to free the memory
'-------------------------------
function fnKillProcess(strProcessName)
	On Error Resume Next
	Dim Process 	
	For Each Process In GetObject("winmgmts:").ExecQuery("Select Name from Win32_Process Where Name = '"&strProcessName&"'") 
		Process.Terminate 
	Next 
end function



'-------------------------------
'Function Name 	:	fnReadExcelCell
'Variables		:	strRow,strColumn  (Row and column number to be provided as input)
'Description	:	This function is read any cell value
'-------------------------------
function fnReadExcelCell(strRow, strColumn)
	strTestData = objSheet.Cells(strRow, strColumn).Value
end function



'-------------------------------
'Function Name 	:	fnWriteRunnerFile
'Variables		:	strFileName,strOldValue, strNewValue
'Description	:	This function is to open and edit runner file 
'-------------------------------
function fnEditFile(strFileName, strCompareValue, strOldValue, strNewValue)
	On Error Resume Next
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set txtStream = fso.OpenTextFile(strFileName)

	Do While Not txtStream.AtEndOfStream
		'msgbox txtStream.ReadLine
		if Instr(1,txtStream.ReadLine, strCompareValue, vbTextCompare) > 0 then 
			'msgbox txtStream.ReadLine
			fnReplaceText strFileName, strOldValue, strNewValue
			Exit Do
		end if		
	Loop
	txtStream.Close
	Set fso = Nothing
	Set txtStream = Nothing  
end function

'-------------------------------
'Function Name 	:	fnReplaceText
'Variables		:	strPath, strFromText, strToText
'Description	:	This function is to open a file and replae any text. 
'-------------------------------
function fnReplaceText(strPath, strFromText, strToText)
	Set objFile = CreateObject("Scripting.FileSystemObject").OpenTextFile(strPath)

	strText = objFile.ReadAll
	objFile.Close
	Set objFile = nothing
	strNewText = Replace(strText, strFromText, strToText)
	
	Set oFile = CreateObject("Scripting.FileSystemObject").OpenTextFile(strPath, 2, true)
	oFile.WriteLine strNewText 
	oFile.Close
	Set oFile = nothing
end function 


'-------------------------------
'Function Name 	:	fnRunBatchFile
'Variables		:	strbatPath
'Description	:	This function is to open a file and replae any text. 
'-------------------------------
function fnRunBatchFile(strbatPath)
	Dim shell
	Set shell = CreateObject("WScript.Shell")
	shell.CurrentDirectory = "E:\eclipse-workspace\frameworkDemo\src\test\resources\CallingModule"
	shell.Run "cmd /k mvnCommand.bat", 1, True
end function 

'-------------------------------
'Function Name 	:	fnMessage
'Variables		:	strMessage, intTimeOut, intWindow
'Description	:	This function is to display message box 
'-------------------------------
function fnMessage(strMessage, intTimeOut, intWindow)
	createobject("wscript.shell").popup strMessage, intTimeOut, "SHARP - Alert !", intWindow
end function 



