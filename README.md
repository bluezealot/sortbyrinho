# sortbyrinho
Implement a java awt based GUI application that can show sort process.

# usage
Build and run. Click "Generate" button, the black bars represent data shows in the upper text box,
then copy (input) your sort algorithm (with javascript) into the other text box, then click the "Run" button,
the upper textbox then shows you the sorting process of your algorithm.
In this project there are three algorithm is provided for reference, copy it into the text box and try.
Some screen shorts for reference.
1. Generate data and input sort algorithm.
![first step](https://github.com/bluezealot/sortbyrinho/blob/main/images/GeneratedData.png?raw=true)
2. Click run.
![second step](https://github.com/bluezealot/sortbyrinho/blob/main/images/Sorting.png?raw=true)
3. Sort complete.
![third step](https://github.com/bluezealot/sortbyrinho/blob/main/images/SortComplete.png?raw=true)

# programming apis
Sort algorithm is written in javascript, the following apis are provided. 
These apis can be accessed in the context of javascript.
SortData.getDataAt(index) : Get a sort data by its index.
SortData.getDataCount() : Get the sort data count.
SortData.swap(leftIndex, rightIndex) : Swap the left and right data in the sort list.
SortData.setSortComplete(boolean) : Set true if the sort algorithm is completed.