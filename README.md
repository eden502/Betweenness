# Betweenness
Betweenness centrality testing program for the following graph:

<img src="https://user-images.githubusercontent.com/62388816/155898227-dc79e44c-251e-4f9c-9bf0-e5d4c94014af.png" width="90%"></img> 

This graph is being represented by a matrix in the program's main function:

      { 0, 1, 0, 0, 0, 0 }, 
			{ 1, 0, 1, 0, 0, 0 }, 
			{ 0, 1, 0, 1, 1, 0 },
			{ 0, 0, 1, 0, 1, 1 },
			{ 0, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 1, 1, 0 }
      
      
The purpose of the program is to test whether a shortest path between two verteces *must* travel through a specific vertex.
For example, the main function tests if the shortest path between vertex #1 to #6 *must* go through vertex #3 - for which the program will return true.

For this case, there are 2 shortest possible routes:
<img src="https://user-images.githubusercontent.com/62388816/155898587-d142a5f8-92a9-4ece-a066-044f18553a7d.png" width="45%"></img> <img src="https://user-images.githubusercontent.com/62388816/155898641-42855398-e3df-433a-912d-c70ada89d3b4.png" width="45%"></img> 

We can clearly see that both routes *must* go thorugh vertex #3 - therefore the function should return a true statement.

The algorithm works by raising the original graph matrix by a power of 1 for each iteration - and storing the result matrix in an arraylist.
The power of the matrix represents the length of the route we are looking for - if we want to search for routes by the length of 3 - the power will be 3.
In our main function, we are testing routes up to the length of 6.

The next step is to check each of the matrices for changes from a -0 value to another positive number.
When we find such a change, we must note two things:
  1: What is the power of the matrix that had a value changed.
  2: What is the number it was changed to.
  
  The power (1) represents the length of the path, while the number (2) represents the number of routes by that length.
  For example:
  
  <img src="https://user-images.githubusercontent.com/62388816/155898972-2e5a2478-7e62-4d1e-b47e-6d2b4a1098c9.png" width="45%"></img> <img src="https://user-images.githubusercontent.com/62388816/155898959-d87a6090-16a8-44b9-afd4-bc83eb8481f1.png" width="45%"></img> 
  
  In this case, we can tell that the shortest possible paths between verteces #1 and #6 are at a length of 4, with two of them existing.
  
Our next step is to store the information we collected above in two different matrices - 
  1: Stores the length of the shortest paths
  2: Stores the number of shortest paths between two vertices

The final step of the program is the actual test - the input is as follows: 1) shortest paths matrix, 2)Origin vertex, 3)Destination vertex, 4)Test vertex
the test function (checkPath in the program) will simply check the following: if the shortest path between the test vertex and the origin vertex is equal
to the shortest path between the test vertex and the destination vertex, 
then the shortest path between the origin vertex to the destination *must* go through the test vertex.





*important note: This algorithm was NOT implemented with efficiency in mind - the matrix power function follows an iterative approach with a time complexity of O(n^3),
    while this will work for small matrices, i do not advice to use it with large inputs.




This algorithm was presented to me by Dr Michael Mann - this is just my implementation for it - all credit for developing the algorigthm goes to him.




  
  
  
  

