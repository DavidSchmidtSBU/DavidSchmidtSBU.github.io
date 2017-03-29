# First find a bible in text form
inFile = open('KJV12.TXT', 'r')

MyWord = 'God'                  #Initialize MyWord
count = 0                       #Initialize count
inLine = inFile.readline()      #Read in a line of text

while (inLine != ''):            #While more lines to read
    lineList = inLine.split(' ')   #Split words into a list
    # Look through the list.  If the word God is found,
    # add 1 to count
    for i in range (0, len(lineList)):
        if (lineList[i] == MyWord):
            count = count + 1 
            
    # Go get another doughnu…line of text  
    inLine = inFile.readline()
    
# Done—just read the entire Bible. Superpower? Not quite..
print("The word God was used: ", count)# …but still…
print("End of processing!")
inFile.close()  # Done!
