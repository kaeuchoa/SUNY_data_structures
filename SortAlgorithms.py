def selection_sort(array,n):
    for i in range(0,(n-1)):
        min_index = i
        for j in range((i+1),n):
            if array[j] < array[min_index]:
                min_index = j
        if min_index != i:
            temp = array[i]
            array[i] = array[min_index]
            array[min_index] = temp

def insertion_sort(array,length):
    for i in range(0,len(array)):
        j=i
        while((j> 0) and (array[j-1]>array[j])):
            tmp = array[j]
            array[j]= array[j-1]
            array[j-1]=tmp
            j-=1

def bubble_sort(array,length):
    swapped = True
    j=0
    while(swapped):
        swapped = False
        j+=1
        for i in range(0,(length-j)):
            if array[i]>array[i+1]:
                tmp = array[i]
                array[i] = array[i+1]
                array[i+1] = tmp
                swapped = True



if __name__ == "__main__":
        array = [5,4,3,32,4,23,1]
        array2 = [53,21,3,4,1,0,2]
        array3 = [34,24,356,342,35,223,111]
        selection_sort(array,len(array))
        print ('selection sort: ' + str(array))
        selection_sort(array2,len(array2))
        print ('selection sort: ' + str(array2))
        selection_sort(array3,len(array3))
        print ('selection sort: ' + str(array3))
    
    
        print ('\n')
    
        array = [3,2,45,42,24,33,10]
        array2 = [15,24,333,52,21,30,60]
        array3 = [-6,2,35,42,39,273,12]
        insertion_sort(array,len(array))
        insertion_sort(array2,len(array2))
        insertion_sort(array3,len(array3))
        print ('insertion sort: ' + str(array))
        print ('insertion sort: ' + str(array2))
        print ('insertion sort: ' + str(array3))
        print ('\n')
    
    
        array = [53,44,63,32,48,23,17]
        array2 = [2,243,3,1,28,0,340]
        array3 = [-63,211,3,22,9,73,10]
        bubble_sort(array,len(array))
        bubble_sort(array2,len(array2))
        bubble_sort(array3,len(array3))
        print ('bubble sort: ' + str(array))
        print ('bubble sort: ' + str(array2))
        print ('bubble sort: ' + str(array3))