/* *****************************************************************************
 *  Name: Steven Navarrette
 *   
 *  Hours to complete assignment: 48hrs
 *
 **************************************************************************** */

Programming Assignment: Java Warmup

/* *****************************************************************************
 *  Explain briefly how you implemented the Anagram Solver Problem.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?

 * I used the hash map data structure because the average time complexity for the lookup is O(1) (constant time)
 * The hash map uses a key value pair
 * The key being a sorted version of the word and the value being all the words that match that sorted key
 * This, in my opinion, seems to be the most organized, proficient, and quickest way to retrieve the anagrams
 **************************************************************************** */



/* *****************************************************************************
 *  Known bugs / limitations.

 * If the dictionary file is missing, the code catches that error, but it will still run.
 * The code does not handle punctuation or mixed cases.
 * Sorting approach uses char[] sorting. Other sorting cases could be more efficient
 **************************************************************************** */




/* *****************************************************************************
 *  Explain briefly how you implemented the spell checker problem.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?

 * I chose the hash set data structure to store the dictionary words
 * Adding and checking the words only take an average time complexity of O(1)
 * This provides constant time lookups
 **************************************************************************** */



/* *****************************************************************************
 *  Known bugs / limitations.

 * Not the best data structure to use for large data sets or for range queries
 * The code converts all words to lowercase but does not handle punctuation or other characters
 **************************************************************************** */





/* *****************************************************************************
 *  Explain briefly how you implemented the randomized queue and deque.
 *  Which data structure did you choose (array, linked list, etc.)
 *  and why?

 * Since we're dealing with removing items at random
 * The best data structure for this would be an ArrayList since it operates in FIFO order
 * The average time complexity to access a random element is O(1)
 **************************************************************************** */



/* *****************************************************************************
 *  Known bugs / limitations.

 * Uses ArrayList.remove() repeatedly which is actually takes O(n) time to run
 * Main only runs the code once and could be coded to run multiple times
 **************************************************************************** */





/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do
 *  include any help from people (including the professor, computing helpdesk,
 *  classmates, and friends, and generativeAI) and attribute them by name.

 * My main two sources of help was Jonathan/Brianna and AI (specifically chat)
 **************************************************************************** */



/* *****************************************************************************
 *  Describe any serious problems you encountered.

 * I was not very familiar with hash sets and hash maps
 * When asking for chat's help, it missed many of the specified requirements
 * It also only provided the skeletal structure of the code and not everything that was necessary at once
 **************************************************************************** */



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.

 * After trying to apply for a tech development internship, doing this assignment,
   and taking our first mini quiz, I realize how far behind I am when it comes to
   basic python & java coding, data structures, and algorithm concepts.
 **************************************************************************** */
