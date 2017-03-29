# First find a bible in text form
inFile = open('KJV12.TXT', 'r')

longWord = " "			#Initialize longWord
inLine = inFile.readline()      #Read in a line of text

while (inLine != ''):           #While more lines to read
    lineList = inLine.split(' ')   #Split words into a list
    
    # Look through the list.  If a longer word is found,
    # assign it to be the new longWord
    for i in range (0, len(lineList)):
        if (len(lineList[i]) > len(longWord)):
            longWord = lineList[i]
            
    # Go get another doughnu…line of text  
    inLine = inFile.readline()
    
# Done—just read the entire Bible. Superpower? Not quite..
print('Your longest word: ', longWord)# …but still…
print('End of processing!')
inFile.close()  # Done!
